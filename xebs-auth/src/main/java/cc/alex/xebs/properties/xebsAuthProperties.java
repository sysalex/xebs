package cc.alex.xebs.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource(value = {"classpath:xebs-auth.properties"})
@ConfigurationProperties(prefix = "xebs.auth")
public class xebsAuthProperties {

    private XebsClientsProperties[] clients = {};
    private int accessTokenValiditySeconds = 60 * 60 * 24;
    private int refreshTokenValiditySeconds = 60 * 60 * 24 * 7;
}
