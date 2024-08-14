package api.helpdesk.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

      @Bean
      public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder(); 
      }


      private static final String[] SWAGGER_WHITELIST = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
      };


      @Override
      protected void configure(HttpSecurity http) throws Exception {
            http.headers().frameOptions().disable();
            http.cors().and().csrf().disable()
                        .addFilterAfter(new JWTFilter(), UsernamePasswordAuthenticationFilter.class)
                        .authorizeRequests()
                        .antMatchers(SWAGGER_WHITELIST).permitAll()
                        .antMatchers("/api/users/**").permitAll()
                        .antMatchers(HttpMethod.POST,"/auth/login").permitAll()
                        .antMatchers(HttpMethod.GET, "/users").hasRole("USER")
                        .antMatchers(HttpMethod.GET, "/admins").hasAnyRole("ADMIN")
                        .anyRequest().authenticated() 
                        .and()
                        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            
      }

}
