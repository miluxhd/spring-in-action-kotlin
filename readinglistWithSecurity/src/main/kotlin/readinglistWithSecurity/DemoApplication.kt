package readinglistWithSecurity

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@SpringBootApplication
class DemoApplication : ApplicationContextAware{
    companion object {
        var context : ApplicationContext? = null
    }

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        context = applicationContext
    }

    @Bean
    fun getPasswordEncoder() : PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

