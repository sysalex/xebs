package cc.alex;

import cc.alex.xebs.annotation.EnableXebsAuthExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableXebsAuthExceptionHandler
public class XebsAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(XebsAuthApplication.class, args);
    }
}
