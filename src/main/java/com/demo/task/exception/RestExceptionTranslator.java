package com.demo.task.exception;

import com.demo.task.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;

@Order
@Configuration
@ConditionalOnWebApplication(
        type = ConditionalOnWebApplication.Type.SERVLET
)
@ConditionalOnClass({Servlet.class, DispatcherServlet.class})
@RestControllerAdvice
public class RestExceptionTranslator {
    private static final Logger log = LoggerFactory.getLogger(RestExceptionTranslator.class);

    @ExceptionHandler({ServiceException.class})
    @ResponseStatus(HttpStatus.OK)
    public R handleError(ServiceException e) {
        log.error(e.getMessage());
        return R.error(-1,e.getMessage());
    }


    @ExceptionHandler({Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R handleError(Throwable e) {
        log.error("服务未知异常", e);
        return R.error(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
    }

}