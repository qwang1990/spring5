package com.spring5.service1;

import com.spring5.api.MessageService;
import org.springframework.stereotype.Component;

/**
 * Created by wangqi on 18/1/21.
 */
@Component("message1")
public class MessageServiceImp1 implements MessageService {
    public String getMessage() {
        return "from service1:messageServiceImp1";
    }
}
