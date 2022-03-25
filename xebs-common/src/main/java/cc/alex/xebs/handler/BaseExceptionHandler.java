package cc.alex.xebs.handler;

import cc.alex.xebs.entity.XebsResponse;
import cc.alex.xebs.exception.XebsAuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public XebsResponse handleException(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return new XebsResponse().message("系统内部异常");
    }

    @ExceptionHandler(value = XebsAuthException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public XebsResponse handleXebsAuthException(XebsAuthException e) {
        log.error("系统错误", e);
        return new XebsResponse().message(e.getMessage());
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public XebsResponse handleAccessDeniedException(){
        return new XebsResponse().message("没有权限访问该资源");
    }
}
