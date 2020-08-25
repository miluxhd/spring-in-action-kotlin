package readinglistWithSecurity

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component


@Component
@ConfigurationProperties("amazon")
class AmazonProperties {
    var associateId: String? = null

}
