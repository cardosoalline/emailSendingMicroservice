package com.mailService.msmail.models;


import com.mailService.msmail.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_MAIL")
public class EmailModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID emailId;
    private String ownerRef; //dono q envia o email
    private String emailFrom; //quem envia
    private String emailTo;//quem recebe
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;

}
