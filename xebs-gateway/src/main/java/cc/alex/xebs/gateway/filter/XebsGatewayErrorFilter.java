package cc.alex.xebs.gateway.filter;

import cc.alex.xebs.common.entity.XebsResponse;
import cc.alex.xebs.common.utils.XebsUtil;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class XebsGatewayErrorFilter extends SendErrorFilter {

    @Override
    public Object run() {
        try {
            /*通过RequestContext获取到当前请求上下文，通过请求上下文可以获取到当前请求的服务名称serviceId和当前请求的异常对象ExceptionHolder等信息**/
            XebsResponse Response = new XebsResponse();
            RequestContext ctx = RequestContext.getCurrentContext();
            String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);

            ExceptionHolder exception = findZuulException(ctx.getThrowable());
            String errorCause = exception.getErrorCause();
            Throwable throwable = exception.getThrowable();
            String message = throwable.getMessage();
            message = StringUtils.isBlank(message) ? errorCause : message;
            Response = resolveExceptionMessage(message, serviceId, Response);

            HttpServletResponse response = ctx.getResponse();
            XebsUtil.makeResponse(
                    response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR, Response
            );
            log.error("Zull sendError：{}", Response.getMessage());
        } catch (Exception ex) {
            log.error("Zuul sendError", ex);
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }

    private XebsResponse resolveExceptionMessage(String message, String serviceId, XebsResponse Response) {
        if (StringUtils.containsIgnoreCase(message, "time out")) {
            return Response.message("请求" + serviceId + "服务超时");
        }
        if (StringUtils.containsIgnoreCase(message, "forwarding error")) {
            return Response.message(serviceId + "服务不可用");
        }
        return Response.message("Zuul请求" + serviceId + "服务异常");
    }
}
