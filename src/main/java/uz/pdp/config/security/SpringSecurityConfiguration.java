package uz.pdp.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity
@EnableMethodSecurity(
    prePostEnabled = true,
    securedEnabled = true,
    jsr250Enabled = true
)
public class SpringSecurityConfiguration {

    private final CustomUserDetailsService customUserDetailsService;
    private final CustomAuthenticatedFailerHandler customAuthenticatedFailerHandler;

    private final String[] PUBLIC_URLS = {
            "/auth/register",
            "/auth/login",
            "/auth/logout",
            "/auth/homeModel",
            "/home",
            "/css/**",
            "/js/**"
    };

    public SpringSecurityConfiguration(CustomUserDetailsService customUserDetailsService, CustomAuthenticatedFailerHandler customAuthenticatedFailerHandler) {
        this.customUserDetailsService = customUserDetailsService;
        this.customAuthenticatedFailerHandler = customAuthenticatedFailerHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable()) // CSRF ni o'chirish (faqat test uchun)
                .userDetailsService(customUserDetailsService)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(PUBLIC_URLS).permitAll()
//                        .requestMatchers("/admin/**").hasRole("ADMIN") // faqat adminlarga ruxsat
//                        .requestMatchers("/user/**").hasAnyRole("USER") // faqat user lar uchun ruxsat
                        .anyRequest().authenticated() // barcha api larni autentifikatsiyadan otqazish kerak
                );

        http.formLogin()
                .loginPage("/auth/login")
                .usernameParameter("uname")
                .passwordParameter("pswd")
                .defaultSuccessUrl("/homeModel", false)
                .failureHandler(customAuthenticatedFailerHandler)
        ; // true bulsa har doim shu

        http.logout()
                .logoutUrl("/auth/logout")
                .deleteCookies("JSESSIONID")
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
        ;

        http.rememberMe()
                .rememberMeParameter("rememberMe")
                .rememberMeCookieName("remmeber-me-cookie")
                .tokenValiditySeconds(24 * 60 * 60)
                .key("secret_key")
                .userDetailsService(customUserDetailsService);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance(); // faqat test uchun ishlatilsin
        return new BCryptPasswordEncoder();
    }

   /* @Bean
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
    }*/
}

/*
   USER ROLE
   1. create_user
   2. update_profile
   3. view_profile

   MANAGER ROLE
   1. see_all_users
   2. block_user
   3. generate_reports

   ADMIN ROLE
    1. block_user
    2. delete_user
    3. block_manager
    4. delete_manager
* */