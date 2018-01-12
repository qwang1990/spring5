package com.spring5;

import com.spring5.api.MessageService;
import com.spring5.service.MessagePrinter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 * Created by wangqi on 18/1/11.
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
    }
}