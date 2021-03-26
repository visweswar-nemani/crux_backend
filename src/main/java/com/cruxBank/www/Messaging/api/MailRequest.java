package com.cruxBank.www.Messaging.api;

public class MailRequest {
	
	private String mailTo;
	private String subject;
	private String body;
	
	
	
	
	
	public String getMailTo() {
		return mailTo;
	}





	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}





	public String getSubject() {
		return subject;
	}





	public void setSubject(String subject) {
		this.subject = subject;
	}





	public String getBody() {
		return body;
	}





	public void setBody(String body) {
		this.body = body;
	}





	@Override
	public String toString() {
		return "MailRequest [mailTo=" + mailTo + ", subject=" + subject + ", body=" + body + "]";
	}
	
	
	

}
