package com.example.email.service;


import com.example.email.repository.EmailLogRepository;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;


@Service
public class EmailService {

    @Autowired
    Configuration configuration;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    EmailLogRepository emailLogRepository;

    public void sendEmail() {
        emailLogRepository.findByStatus("INITIATED").forEach(emailRequest ->{
            final String emailToRecepient= emailRequest.getUserEmail();
            /*Can be configure with Freemarker template*/
            final String emailSubject = "Canned subject";
            MimeMessage message = javaMailSender.createMimeMessage();
            try {
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED);
                /* Add any attachments using helper*/
                Template template =  configuration.getTemplate("template.ftl");
                String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, new HashMap<String, Object>());
                mimeMessageHelper.setTo(emailToRecepient);
                mimeMessageHelper.setText(html);
                mimeMessageHelper.setSubject(emailSubject);
                javaMailSender.send(message);
            } catch (MessagingException e) {
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            } catch (TemplateException e) {
                e.printStackTrace();
            }
            emailRequest.setStatus("SENT");
            emailLogRepository.save(emailRequest);
        });

    }
}