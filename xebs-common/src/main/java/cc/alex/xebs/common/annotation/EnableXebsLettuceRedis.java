package cc.alex.xebs.common.annotation;

import cc.alex.xebs.common.configure.XebsLettuceRedisConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(XebsLettuceRedisConfigure.class)
public @interface EnableXebsLettuceRedis {

}
