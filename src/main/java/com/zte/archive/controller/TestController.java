package com.zte.archive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author:helloboy
 * Date:2019-06-24 15:57
 * Description:<描述>
 */

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/f1")
    public String f1(){
        return "test";
    }
}
