package cc.alex.xebs.common.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO 暂时不用
 */
@Component
public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate){
        Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (details instanceof OAuth2AuthenticationDetails) {
            String authorizationToken = ((OAuth2AuthenticationDetails) details).getTokenValue();
            requestTemplate.header(HttpHeaders.AUTHORIZATION, "bearer " + authorizationToken);
        }
    }

}
