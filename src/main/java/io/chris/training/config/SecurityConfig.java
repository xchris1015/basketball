package io.chris.training.config;

import io.chris.training.extension.security.RestAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.Serializable;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig implements Serializable {
    //            @Autowired
//            private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
//    step1
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.inMemoryAuthentication().withUser("user1")
//                .password("{noop}password").roles("REGISTERED_USER");
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin();
//    }
    //step2
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user")
//                .password("{noop}password").roles("USER");
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests().antMatchers("/api/users/login","/api/user/login","/api/users/signup").permitAll()
//                .and()
//                    .authorizeRequests().antMatchers("/api/**").hasAnyRole("REGISTERED_USER","ADMIN")
////                .and()
//                .and()
//                  .formLogin();;
//    }

    @Configuration
//    @Order(1)
    public static class RestWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Autowired
        private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
        //curl -i -X POST -d username=user -d password=password -c ./cookies.txt http://localhost:8080/login
        @Autowired
        private UserDetailsService userDetailsService;

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            PasswordEncoder encoder = new BCryptPasswordEncoder();
//            auth.inMemoryAuthentication().withUser("user")
//                .password("{noop}password").roles("REGISTERED_USER");
            auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
        }

        @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring()
                    .antMatchers("/resources/**");
        }

        protected void configure(HttpSecurity http) throws Exception {
            //http://www.baeldung.com/securing-a-restful-web-service-with-spring-security
            http.csrf().disable().authorizeRequests().antMatchers("/api/user/login","/api/user/signup").permitAll()
                    .and()
                    .authorizeRequests().antMatchers("/api/player/**","/api/team/**").hasAnyRole("REGISTERED_USER")
                    .and()
                    .authorizeRequests().antMatchers("/api/player/**","/api/playerstatistics/**","/api/team/**").hasAnyRole("COACH","PLAYER")
                    .and()
                    .authorizeRequests().antMatchers("/api/**").hasAnyRole("ADMIN")
//                    .and()
//                    .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint)
//                    .and()
//                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .formLogin();

        }
    }

//    @Configuration
//    public static class ResourcesWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//        @Override
//        public void configure(WebSecurity web) throws Exception {
//            web.ignoring()
//                    .antMatchers("/resources/**","/swagger-ui.html","/webjars/**");
//        }
//    }

}
