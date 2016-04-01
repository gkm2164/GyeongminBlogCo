package co.gyeongmin.config;

import co.gyeongmin.controller.web.exception.LackOfPermissionException;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * Created by USER on 2016-03-29.
 */
@Configuration
public class ErrorPageConfig {

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            ErrorPage err401 = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/401.html");
            ErrorPage err404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.html");
            ErrorPage err500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500.html");
            ErrorPage errLOP = new ErrorPage(LackOfPermissionException.class, "/error/lop.html");
            container.addErrorPages(err401, err404, err500);
        });
    }
}
