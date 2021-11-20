package com.alkemy.disney.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    
    @Autowired
    private JavaMailSender jms;
    
    public void enviarMail(String destinatario, String asunto, String contenido){
        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setTo(destinatario);
        smm.setSubject(asunto);
        smm.setText(contenido);
        jms.send(smm);
    }
}
