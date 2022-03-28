package cc.alex.xebs.common.handler;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

public class XebsAuthExceptionConfigure {

    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")  //当IOC容器中没有指定名称或类型的Bean的时候，就注册
    public XebsAccessDeniedHandler accessDeniedHandler() {
        return new XebsAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public XebsAuthExceptionEntryPoint authenticationEntryPoint() {
        return new XebsAuthExceptionEntryPoint();
    }
}
