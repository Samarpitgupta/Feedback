package models;

public class TemplateQuestionResponse {
	private Long id;
	private Long receiverId;
	private Long patronId;
	private Long templateQuestionId;
	private String responseMessage;
	private boolean isResponseSubmitted;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}
	public Long getPatronId() {
		return patronId;
	}
	public void setPatronId(Long patronId) {
		this.patronId = patronId;
	}
	public Long getTemplateQuestionId() {
		return templateQuestionId;
	}
	public void setTemplateQuestionId(Long templateQuestionId) {
		this.templateQuestionId = templateQuestionId;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public boolean isResponseSubmitted() {
		return isResponseSubmitted;
	}
	public void setResponseSubmitted(boolean isResponseSubmitted) {
		this.isResponseSubmitted = isResponseSubmitted;
	}

}
