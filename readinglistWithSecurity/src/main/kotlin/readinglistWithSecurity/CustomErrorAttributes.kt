package readinglistWithSecurity

import org.springframework.boot.web.error.ErrorAttributeOptions
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes
import org.springframework.stereotype.Component
import org.springframework.web.context.request.WebRequest


@Component
class CustomErrorAttributes : DefaultErrorAttributes() {
    override fun getErrorAttributes(webRequest: WebRequest?,options: ErrorAttributeOptions ): Map<String?, Any?>? {
        val attr = super.getErrorAttributes(webRequest, options)
        attr["foo"] = "bar"
        return attr
    }
}
