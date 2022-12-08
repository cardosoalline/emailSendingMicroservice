package com.mailService.msmail.consumers;

import com.mailService.msmail.dtos.EmailDto;
import com.mailService.msmail.models.EmailModel;
import com.mailService.msmail.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component //bean gerenciado pelo spring
public class EmailConsumer {

    @Autowired //injeção
    EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")  //método ouvinte da fila do properties
    public void listen(@Payload EmailDto emailDto){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);
        System.out.println("Email Status" + emailModel.getStatusEmail().toString());
    }
}
