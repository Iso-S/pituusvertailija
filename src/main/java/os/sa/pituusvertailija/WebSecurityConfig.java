package os.sa.pituusvertailija;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import os.sa.pituusvertailija.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/delete/{id}").hasAuthority("ADMIN")
                .requestMatchers("/edit/{id}").hasAuthority("ADMIN")
                .requestMatchers("/uusiesine").hasAuthority("ADMIN")
                .requestMatchers("/uusikategoria").hasAuthority("ADMIN")
                .requestMatchers("/css/**").permitAll()
                .anyRequest().authenticated()
            )

            .formLogin(formLogin -> formLogin
                .defaultSuccessUrl("/" , true)
                .permitAll()
            )

            .logout(logout -> logout
                .logoutUrl("/logout")
                .permitAll()
            );

        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }



}