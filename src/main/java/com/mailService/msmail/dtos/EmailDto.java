package com.mailService.msmail.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDto {

    @NotBlank
    private String ownerRef; //dono da mensagem
    @NotBlank
    private String emailFrom; //quem envia
    @NotBlank
    private String emailTo;//quem recebe
    @NotBlank
    private String subject;
    @NotBlank
    private String text;
}
