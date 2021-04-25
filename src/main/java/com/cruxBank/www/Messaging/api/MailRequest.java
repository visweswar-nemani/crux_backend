package com.cruxBank.www.Messaging.api;

public class MailRequest {
	
	private String mailTo;
	private String subject;
	private String body;
	private String fileToAttach;
	
	
	
	
	
	
	
	public MailRequest() {
		super();
		// TODO Auto-generated constructor stub
	}





	public MailRequest(String mailTo, String subject, String body, String fileToAttach) {
		super();
		this.mailTo = mailTo;
		this.subject = subject;
		this.body = body;
		this.fileToAttach = fileToAttach;
	}





	public String getFileToAttach() {
		return fileToAttach;
	}





	public void setFileToAttach(String fileToAttach) {
		this.fileToAttach = fileToAttach;
	}





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
		return "MailRequest [mailTo=" + mailTo + ", subject=" + subject + ", body=" + body + ", fileToAttach="
				+ fileToAttach + "]";
	}
	
	
	

}
