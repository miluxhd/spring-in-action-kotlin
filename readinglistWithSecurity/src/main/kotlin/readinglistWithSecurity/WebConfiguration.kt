package readinglistWithSecurity

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfiguration : WebMvcConfigurer {
    @Autowired
    private val userDetailsService: UserDetailsService? = null

    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("/login").setViewName("login")
    }

    override fun addArgumentResolvers(
            argumentResolvers: MutableList<HandlerMethodArgumentResolver>) {
        argumentResolvers.add(ReaderHandlerMethodArgumentResolver())
    }

    @Bean
    fun authProvider(): AuthenticationProvider? {
        val provider = DaoAuthenticationProvider()
        provider.setUserDetailsService(userDetailsService)
        provider.setPasswordEncoder(BCryptPasswordEncoder())
        return provider
    }
}
