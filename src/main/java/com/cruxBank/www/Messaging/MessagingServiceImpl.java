package com.cruxBank.www.Messaging;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
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
		mailMessage.setFrom("cruxbank2021@gmail.com");
		System.out.println("Sending email : "+mailMessage.toString());
		mailSender.send(mailMessage);	
		
	}

	@Override
	public void sendMailWithAttachment(MailRequest request) {
		// TODO Auto-generated method stub
		 System.out.println("the mail request received is "+request);
		try {
			mailSender.send(  mimeMessage ->{
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(request.getMailTo()));
				mimeMessage.setFrom("cruxbank2021@gmail.com");
				mimeMessage.setSubject(request.getSubject());
				mimeMessage.setText(request.getBody());
				MimeBodyPart messageBodypart = new MimeBodyPart();
				messageBodypart.setText(request.getBody());				
				FileSystemResource fileSource = new FileSystemResource(request.getFileToAttach());				
				MimeBodyPart attachmentBodypart = new MimeBodyPart();
				attachmentBodypart.attachFile(fileSource.getFile());
				Multipart multiPart = new MimeMultipart(messageBodypart,attachmentBodypart);
				mimeMessage.setContent(multiPart);				
				System.out.println("file in mail impl "+fileSource.getFilename()+"    path is "+fileSource.getPath());			
			});
		}catch(MailException e) {
			System.out.println("error occured while sending email");
			e.printStackTrace();			
		}catch(Exception e) {
			System.out.println("error occured while sending email");
			e.printStackTrace();
		}
		
	}

}
