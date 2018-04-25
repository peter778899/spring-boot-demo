package com.tx.stu;

import com.tx.stu.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by peter.
 */
@Controller
public class HelloSprintBoot {
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/hello")
    String exception() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    String jsonException() throws MyException {
        throw new MyException("发生json错误");
    }
}
