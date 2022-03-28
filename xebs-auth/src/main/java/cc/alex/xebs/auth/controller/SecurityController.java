package cc.alex.xebs.auth.controller;

import cc.alex.xebs.common.entity.XebsResponse;
import cc.alex.xebs.common.exception.XebsAuthException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
public class SecurityController {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("oauth/test")
    public String testOauth() {
        return "oauth";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @DeleteMapping("signout")
    public XebsResponse signout(HttpServletRequest request) throws XebsAuthException {
        String authorization = request.getHeader("Authorization");
        String token = StringUtils.replace(authorization, "bearer ", "");
        XebsResponse febsResponse = new XebsResponse();
        if (!consumerTokenServices.revokeToken(token)) {
            throw new XebsAuthException("退出登录失败");
        }
        return febsResponse.message("退出登录成功");
    }
}
