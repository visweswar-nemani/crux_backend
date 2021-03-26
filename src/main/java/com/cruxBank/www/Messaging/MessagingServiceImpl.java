package com.cruxBank.www.Messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cruxBank.www.Messaging.api.MailRequest;

@Service
public class MessagingServiceImpl implements MessagingImplementation {
	
	@Autowired
	public JavaMailSender mailSender;

	public void sendMail(MailRequest request) {
		// TODO Auto-generated method stud
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(request.getMailTo());
		mailMessage.setSubject(request.getSubject());
		mailMessage.setText(request.getBody());
		mailMessage.setFrom("crux2021@outlook.com");
		System.out.println("Sending email : "+mailMessage.toString());
		mailSender.send(mailMessage);
		
		
	}

}
