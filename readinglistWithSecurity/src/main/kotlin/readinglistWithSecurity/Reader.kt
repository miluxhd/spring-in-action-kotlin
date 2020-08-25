package readinglistWithSecurity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id


@Entity
class Reader : UserDetails {
    @Id
    private var username: String? = null
    var fullname: String? = null
    private var password: String? = null
    override fun getUsername(): String {
        return username!!
    }

    fun setUsername(username: String?) {
        this.username = username
    }

    override fun getPassword(): String {
        return password!!
    }

    fun setPassword(password: String?) {
        this.password = password
    }

    override fun getAuthorities(): Collection<GrantedAuthority?> {
        return Arrays.asList(SimpleGrantedAuthority("ROLE_READER"))
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}
