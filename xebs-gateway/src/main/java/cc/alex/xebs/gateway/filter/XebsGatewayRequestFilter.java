package cc.alex.xebs.gateway.filter;

import cc.alex.xebs.common.entity.XebsConstant;
import cc.alex.xebs.common.entity.XebsResponse;
import cc.alex.xebs.common.utils.XebsUtil;
import cc.alex.xebs.gateway.properties.XebsGatewayProperties;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Base64Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class XebsGatewayRequestFilter extends ZuulFilter {

    @Autowired
    private XebsGatewayProperties properties;
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 6;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);
        HttpServletRequest request = ctx.getRequest();
        String host = request.getRemoteHost();
        String method = request.getMethod();
        String uri = request.getRequestURI();

        log.info("请求URI：{}，HTTP Method：{}，请求IP：{}，ServerId：{}", uri, method, host, serviceId);


        /**
         * 从配置文件里读取到禁止外部访问资源的链接，并以逗号分隔转换为数组。遍历这些数组，
         * 逐一判断客户端请求URI是否在禁止外部访问的范围内，如果是的话则返回“该URI不允许外部访问”响应，
         * 状态码为403，不是的话放行。
         */
        // 禁止外部访问资源实现
        boolean shouldForward = true;
        String forbidRequestUri = properties.getForbidRequestUri();
        String[] forbidRequestUris = StringUtils.splitByWholeSeparatorPreserveAllTokens(forbidRequestUri, ",");
        if (forbidRequestUris != null && ArrayUtils.isNotEmpty(forbidRequestUris)) {
            for (String u : forbidRequestUris) {
                if (pathMatcher.match(u, uri)) {
                    shouldForward = false;
                }
            }
        }
        if (!shouldForward) {
            HttpServletResponse response = ctx.getResponse();
            XebsResponse febsResponse = new XebsResponse().message("该URI不允许外部访问");
            try {

                XebsUtil.makeResponse(
                        response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                        HttpServletResponse.SC_FORBIDDEN, febsResponse
                );
                ctx.setSendZuulResponse(false);
                ctx.setResponse(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        byte[] token = Base64Utils.encode((XebsConstant.ZUUL_TOKEN_VALUE).getBytes());
        ctx.addZuulRequestHeader(XebsConstant.ZUUL_TOKEN_HEADER, new String(token));
        return null;
    }
}
