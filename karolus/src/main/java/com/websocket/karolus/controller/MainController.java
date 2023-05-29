package com.websocket.karolus.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/main")
@Slf4j
public class MainController {

    @GetMapping("")
    public String index(HttpServletRequest request, HttpServletResponse response){
        log.debug("========== main ============");


        return "/views/index";
    }

}
