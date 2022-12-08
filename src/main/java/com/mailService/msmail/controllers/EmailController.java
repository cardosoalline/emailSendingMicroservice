package com.mailService.msmail.controllers;

import com.mailService.msmail.dtos.EmailDto;
import com.mailService.msmail.models.EmailModel;
import com.mailService.msmail.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto){
        EmailModel emailModel = new EmailModel();

        //tranforma dto em entity
        BeanUtils.copyProperties(emailDto, emailModel);
        //

        emailService.sendEmail(emailModel);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);

    }
}
