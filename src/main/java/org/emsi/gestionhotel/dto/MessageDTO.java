package org.emsi.gestionhotel.dto;

import java.util.Date;

public class MessageDTO {
	private String emailfrom;
    private String emailto;
    private String selectedOption;
    private String messageBody;
    private Date date;
	public String getEmailfrom() {
		return emailfrom;
	}
	public void setEmailfrom(String emailfrom) {
		this.emailfrom = emailfrom;
	}
	public String getEmailto() {
		return emailto;
	}
	public void setEmailto(String emailto) {
		this.emailto = emailto;
	}
	public String getSelectedOption() {
		return selectedOption;
	}
	public void setSelectedOption(String selectedOption) {
		this.selectedOption = selectedOption;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public MessageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MessageDTO(String emailfrom, String emailto, String selectedOption, String messageBody, Date date) {
		super();
		this.emailfrom = emailfrom;
		this.emailto = emailto;
		this.selectedOption = selectedOption;
		this.messageBody = messageBody;
		this.date = date;
	}
    
    
}
