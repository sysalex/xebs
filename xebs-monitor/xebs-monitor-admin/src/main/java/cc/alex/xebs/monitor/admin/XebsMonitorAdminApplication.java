package cc.alex.xebs.monitor.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class XebsMonitorAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(XebsMonitorAdminApplication.class, args);
    }
}
