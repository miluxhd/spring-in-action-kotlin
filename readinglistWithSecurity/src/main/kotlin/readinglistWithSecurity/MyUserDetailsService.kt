package readinglistWithSecurity

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class MyUserDetailsService : UserDetailsService {
    @Autowired
    val readerRepository: ReaderRepository? = null
    override fun loadUserByUsername(username: String): UserDetails {
        val optinalReader = readerRepository!!.findById(username)
        return optinalReader.get()
    }
}
