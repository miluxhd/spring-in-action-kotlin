package readinglistWithSecurity

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder


@Configuration
class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Autowired
    private val readerRepository: ReaderRepository? = null

    @Autowired
    private val encoder : PasswordEncoder? = null

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
                .authorizeRequests()
                .antMatchers("/").access("hasRole('READER')")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
    }

    @Throws(Exception::class)
    override fun configure(
            auth: AuthenticationManagerBuilder) {
        auth
                .userDetailsService(userDetailsService()).passwordEncoder(encoder)
    }

    @Bean
    public override fun userDetailsService(): UserDetailsService {
        return UserDetailsService { username ->
            val userDetails = readerRepository!!.findById(username)
            if (userDetails.isPresent) {
                return@UserDetailsService userDetails.get()
            }
            throw UsernameNotFoundException("User '$username' not found.")
        }
    }
}
