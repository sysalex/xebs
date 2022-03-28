package cc.alex.xebs.common.selector;

import cc.alex.xebs.common.configure.XebsOAuth2FeignConfigure;
import cc.alex.xebs.common.configure.XebsServerProtectConfigure;
import cc.alex.xebs.common.handler.XebsAuthExceptionConfigure;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 多个类进行注册
 */
public class XebsCloudApplicationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                XebsAuthExceptionConfigure.class.getName(),  // 认证类型异常翻译
                XebsOAuth2FeignConfigure.class.getName(),  //开启带令牌的Feign请求，避免微服务内部调用出现401异常
                XebsServerProtectConfigure.class.getName()   //开启微服务防护，避免客户端绕过网关直接请求微服务
        };
    }
}
