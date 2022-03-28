package cc.alex.xebs.common.handler;

import cc.alex.xebs.common.entity.XebsResponse;
import cc.alex.xebs.common.utils.XebsUtil;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理资源服务器异常
 * 令牌不正确返回401
 */
public class XebsAuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        XebsResponse Response = new XebsResponse();
        XebsUtil.makeResponse(
                response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                HttpServletResponse.SC_UNAUTHORIZED, Response.message("token无效")
        );
    }
}
