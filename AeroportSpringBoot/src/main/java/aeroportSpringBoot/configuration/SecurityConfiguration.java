package aeroportSpringBoot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import aeroportSpringBoot.services.CustomUserDetailsService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private DataSource dataSource;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	// definir les pages securisees
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/personne/").permitAll();// antMatchers défini les url sur lesquelles on
		http.authorizeRequests().antMatchers("/personne/**").authenticated().and().formLogin().loginPage("/login")
				.failureUrl("/login?error=erreur").permitAll().and().logout().permitAll()
				.logoutSuccessUrl("/personne/"); // veut mettre une règle
		http.authorizeRequests().antMatchers("/rest/**").authenticated().and().httpBasic();
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}

//	// definition de la methode d'authentification
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("nemo").password("{noop}nemo").roles("ADMIN");// noop indique qu'il n'y a
//																								// pas
//		// d'encodage du mot de passe ==> premiere maniere d'authentifier
//	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().dataSource(dataSource)
//				.usersByUsernameQuery("select username,password,enable from users where username=?")
//				.authoritiesByUsernameQuery("select username,role from user_role where username=?");
//	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
	}

	@Bean(name = "passwordEncoder")
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
