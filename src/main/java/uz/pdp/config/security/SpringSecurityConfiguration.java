package uz.pdp.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable()) // CSRF ni o'chirish (faqat test uchun)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                "/auth/login", // auth ichidagi barcha api larni ruxsat berish
                                "/homeModel",
                                "/css/**",
                                "/js/**"
                        ).permitAll()

                        .anyRequest().authenticated() // barcha api larni autentifikatsiyadan otqazish kerak
                );

        http.formLogin()
                .loginPage("/auth/login")
                .usernameParameter("uname")
                .passwordParameter("pswd")
                .defaultSuccessUrl("/homeModel", false); // true bulsa har doim shu

        http.logout()
                .logoutUrl("/auth/logout")
                .deleteCookies("JSESSIONID")
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
        ;
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withDefaultPasswordEncoder() // faqat test uchun ishlatilsin
                .username("user")
                .password("123")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
