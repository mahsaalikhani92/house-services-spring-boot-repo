/*
package ir.maktab.houseservicesspringboot.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.ServletContext;

*/
/**
 * @author Mahsa Alikhani m-58
 *//*

*/
/*@Configuration
@EnableWebSecurity*//*

public class SecurityConfig {

    */
/*@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Configuration
    @Order(1)
    public static class AdminSecurityAdapter extends WebSecurityConfigurerAdapter{
        private static final String[] AUTH_WHITELIST = {
                // -- Swagger UI v2
                "/v2/api-docs",
                "/swagger-resources",
                "/swagger-resources/**",
                "/configuration/ui",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**",
                // -- Swagger UI v3 (OpenAPI)
                "/v3/api-docs/**",
                "/swagger-ui/**"
                // other public endpoints of your API may be appended to this array
        };

        private final PasswordEncoder passwordEncoder;

        public AdminSecurityAdapter(PasswordEncoder passwordEncoder) {
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/", "/home", "/showLoginPage", "signIn", "/showClientForm", "/clientSignUp",
                            "/verifyClient", "/resources/**", "/rest/**", "/showExpertForm",
                            "/expertSignUp", "/verifyExpert").permitAll()
                    .antMatchers(AUTH_WHITELIST).permitAll()
                    *//*
*/
/*.antMatchers("/admin/**")
                    .hasRole("admin")*//*
*/
/*
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .failureHandler(new CustomAuthenticationFailureHandler())
                    .defaultSuccessUrl("/adminPanelHome")
                    .and()
                    .logout()
                    .logoutSuccessUrl("/");
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().passwordEncoder(passwordEncoder)
                    .withUser("admin")
                    .password(passwordEncoder.encode("admin"))
                    .roles("admin");
        }
    }

    @Configuration
    @Order(2)
    public static class UserSecurityAdapter extends WebSecurityConfigurerAdapter{
        private static final String[] AUTH_WHITELIST = {
                // -- Swagger UI v2
                "/v2/api-docs",
                "/swagger-resources",
                "/swagger-resources/**",
                "/configuration/ui",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**",
                // -- Swagger UI v3 (OpenAPI)
                "/v3/api-docs/**",
                "/swagger-ui/**"
                // other public endpoints of your API may be appended to this array
        };

        private final UserDetailsService userDetailsService;
        private final ServletContext context;
        private final PasswordEncoder passwordEncoder;

        public UserSecurityAdapter(@Qualifier("userServiceImpl") UserDetailsService userDetailsService, ServletContext context, PasswordEncoder passwordEncoder) {
            this.userDetailsService = userDetailsService;
            this.context = context;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/", "/home", "/showLoginPage", "signIn", "/showClientForm", "/clientSignUp",
                            "/verifyClient", "/resources/**", "/rest/**", "/showExpertForm",
                            "/expertSignUp", "/verifyExpert").permitAll()
                    .antMatchers(AUTH_WHITELIST).permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .failureHandler(new CustomAuthenticationFailureHandler())
                    .loginPage("/showLoginPage").usernameParameter("email").passwordParameter("password")
                    .successHandler(new CustomAuthenticationSuccessHandler(context))
                    .and()
                    .logout()
                    .logoutSuccessUrl("/");
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        }

        @Bean
        public AuthenticationManager customAuthenticationManager() throws Exception {
            return authenticationManager();
        }
    }*//*

}
*/
