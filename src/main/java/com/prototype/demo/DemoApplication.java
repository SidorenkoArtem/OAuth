package com.prototype.demo;

import com.prototype.demo.configuration.AuthTokenConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

@EnableWebMvcSecurity
@EnableWebSecurity(debug = false)
@Configuration
@Order
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		String[] restEndpointsToSecure = {"news"};
		for (String endpoint : restEndpointsToSecure) {
			http.authorizeRequests().antMatchers("/" + endpoint + "/**").hasRole(CustomUserDetailsService.ROLE_USER);
		}

		SecurityConfigurer<DefaultSecurityFilterChain, HttpSecurity> securityConfigurerAdapter = new AuthTokenConfigurer(userDetailsServiceBean());
		http.apply(securityConfigurerAdapter);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
		authManagerBuilder.userDetailsService(new CustomUserDetailsService());
	}

	@Bean
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsServiceBean();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}

class CustomUserDetailsService implements UserDetailsService {

	public static final String ROLE_ADMIN = "ADMIN";
	public static final String ROLE_USER = "USER";

	@SuppressWarnings("serial")
	static class SimpleUserDetails implements UserDetails {

		private String username;
		private String password;
		private boolean enabled = true;
		private Set<GrantedAuthority> authorities = new HashSet<>();

		public SimpleUserDetails(String username, String pw, String... extraRoles) {
			this.username = username;
			this.password = pw;

			// setup roles
			Set<String> roles = new HashSet<>();
			roles.addAll(Arrays.asList(null == extraRoles ? new String[0] : extraRoles));

			// export them as part of authorities
			for (String r : roles) {
				authorities.add(new SimpleGrantedAuthority(role(r)));
			}

		}

		public String toString() {
			return "{enabled:" + isEnabled() + ", username:'" + getUsername() + "', password:'" + getPassword() + "'}";
		}

		@Override
		public boolean isEnabled() {
			return this.enabled;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return this.enabled;
		}

		@Override
		public boolean isAccountNonLocked() {
			return this.enabled;
		}

		@Override
		public boolean isAccountNonExpired() {
			return this.enabled;
		}

		@Override
		public String getUsername() {
			return this.username;
		}

		@Override
		public String getPassword() {
			return this.password;
		}

		private String role(String i) {
			return "ROLE_" + i;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return this.authorities;
		}
	}

	List<UserDetails> details = Arrays.asList(new SimpleUserDetails("user", "user", ROLE_USER), new SimpleUserDetails("admin", "admin", ROLE_USER, ROLE_ADMIN));

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		for (UserDetails details : this.details)
			if (details.getUsername().equalsIgnoreCase(username))
				return details;

		return null;
	}
}

@RestController
class NewsController {

	Map<Long, NewsEntry> entries = new ConcurrentHashMap<>();

	@RequestMapping("/news")
	Collection<NewsEntry> entriess() {
		return this.entries.values();
	}

	@RequestMapping(value = "/news/{id}", method = RequestMethod.DELETE)
	NewsEntry remove(@PathVariable Long id) {
		return this.entries.remove(id);
	}

	@RequestMapping(value = "/news/{id}", method = RequestMethod.GET)
	NewsEntry entry(@PathVariable Long id) {
		return this.entries.get(id);
	}

	@RequestMapping(value = "/news/{id}", method = RequestMethod.POST)
	NewsEntry update(@RequestBody NewsEntry news) {
		this.entries.put(news.getId(), news);
		return news;
	}

	@RequestMapping(value = "/news", method = RequestMethod.POST)
	NewsEntry add(@RequestBody NewsEntry news) {
		long id = 10 + new Random().nextInt(99);
		news.setId(id);
		this.entries.put(id, news);
		return news;
	}

	NewsController() {
		for (long i = 0; i < 5; i++)
			this.entries.put(i, new NewsEntry(i, "Title #" + i));
	}

	public static class NewsEntry {
		private long id;
		private String content;

		public NewsEntry() {
		}

		public NewsEntry(long id, String b) {
			this.id = id;
			this.content = b;
		}

		public long getId() {
			return this.id;
		}

		public String getContent() {
			return this.content;
		}

		public void setId(long id) {
			this.id = id;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}
}