package com.colo.config;

import com.colo.mail.MailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.mail.Session;
import java.util.Properties;

@Configuration
public class MailConfig {

    private static final String USER_NAME = "colo21welcome";
    private static final String PASSWORD = "646131Cl"; // GMail password - security level master degree student xD

    @Bean
    public MailSender mailSender() {
        MailSender ms = new MailSender();
//        Properties props = new Properties();
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.user", from);
//        props.put("mail.smtp.password", pass);
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.auth", "true");
//        Session session = Session.getDefaultInstance(props);
//        ms.setSession(session);
        return ms;
    }
}
