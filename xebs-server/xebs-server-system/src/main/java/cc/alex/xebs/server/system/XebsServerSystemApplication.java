package cc.alex.xebs.server.system;

import cc.alex.xebs.common.annotation.XebsCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)  //注解，表示开启Spring Cloud Security权限注解
@XebsCloudApplication
public class XebsServerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(XebsServerSystemApplication.class, args);
    }
}
