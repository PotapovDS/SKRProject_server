package com.project.SKRProject_server.controllers;

import com.project.SKRProject_server.kafka.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public BaseResponse showStatus(){
        return new BaseResponse("SUCCESS_STATUS", 1);
    }

    @PostMapping("/login")
    public BaseResponse UserLogin(@RequestParam(value = "login") String login,
                                  @RequestParam(value = "password") String password){

        if (login.equals("ADMIN")){
            BaseResponse response = new BaseResponse("SUCCESS", 100);
            logger.info("пользователь {} авторизован : {}", login, response);
            MessageSender kafkaSendMessage = new MessageSender();
            kafkaSendMessage.sendMessage("пользователь " + login + " авторизован " + response, "SKRProject_server");

            return response;

        }

        return new BaseResponse("FAILURE", 102);
    }
}
