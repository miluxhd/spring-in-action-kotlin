package readinglistWithSecurity

import org.springframework.core.MethodParameter
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer


@Component
class ReaderHandlerMethodArgumentResolver : HandlerMethodArgumentResolver {
    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return Reader::class.java.isAssignableFrom(parameter.parameterType)
    }

    override fun resolveArgument(parameter: MethodParameter,
                                 mavContainer: ModelAndViewContainer?, webRequest: NativeWebRequest,
                                 binderFactory: WebDataBinderFactory?): Any? {
        val auth = webRequest.userPrincipal as Authentication?
        return if (auth != null && auth.principal is Reader) auth.principal else null
    }
}
