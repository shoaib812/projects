package com.file_hiding_system.service;

import org.apache.logging.log4j.message.Message;
import org.springframework.boot.web.servlet.server.Session;

import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.Random;

public class OTPService {
    private static String from = "your-email@gmailcom";
    private static String password = "your-app-password";

    public static String generateOPT() {
        //Random random = new Random();
        return String.format("%06d", new Random().nextInt(999999));
    }

    public static void sendEmail (String to, String otp) {
//        String from = "your-email@gmailcom";
//        String password = "your-app-password";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password.toCharArray());
            }
        });

        try {
            Message message = new MimeMessage(session);
            ((MimeMessage) message).setFrom(new InternetAddress(from));
            ((MimeMessage) message).setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            ((MimeMessage) message).setSubject("Your OTP Code");
            ((MimeMessage) message).setText("Your OTP is : " + otp);

            Transport.send((javax.mail.Message) message);
            System.out.println("OTP Sent Successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
