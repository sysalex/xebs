package cc.alex.xebs.server.system.configure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = {"classpath:xebs-server-system.properties"})
@ConfigurationProperties(prefix = "xebs.server.system")
public class XebsServerSystemProperties {

    /**
     * 免认证 URI，多个值的话以逗号分隔
     */
    private String anonUrl;

    private XebsSwaggerProperties swagger = new XebsSwaggerProperties();
}
