package com.cruxBank.www.Messaging;

import com.cruxBank.www.Messaging.api.MailRequest;

public interface MessagingImplementation {
	
	public void sendMail(MailRequest request);
	
	public void sendMailWithAttachment(MailRequest request);
	

}
