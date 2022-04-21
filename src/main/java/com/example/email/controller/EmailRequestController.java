package com.example.email.controller;

import com.example.email.entity.UserEmailRequest;
import com.example.email.service.EmailService;
import com.example.email.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailRequestController {

    @Autowired
    RequestService requestService;


    @Autowired
    EmailService emailService;

    /*
       * End point to send a request for sending emails
     */
    @PostMapping("/initiateEmail")
    UserEmailRequest registerEmailRequest(@RequestBody UserEmailRequest newRequest) {
        return requestService.saveUserRequest(newRequest);
    }

    /*
     * Sample end point to demonstrate triggering an email release
     */
    @PostMapping("/triggerEmail")
    void triggerEmailRequest() {
        emailService.sendEmail();
    }
}
