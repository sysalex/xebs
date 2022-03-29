package cc.alex.xebs.auth.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = {"classpath:xebs-auth.properties"})
@ConfigurationProperties(prefix = "xebs.auth")
public class XebsAuthProperties {

    private XebsClientsProperties[] clients = {};
    private int accessTokenValiditySeconds = 60 * 60 * 24;
    private int refreshTokenValiditySeconds = 60 * 60 * 24 * 7;
    // 免认证路径
    private String anonUrl;
    //验证码配置类
    private XebsValidateCodeProperties code = new XebsValidateCodeProperties();
}
