package cc.alex.xebs.common.annotation;

import cc.alex.xebs.common.configure.XebsServerProtectConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(XebsServerProtectConfigure.class)
public @interface EnableXebsServerProtect {

}
