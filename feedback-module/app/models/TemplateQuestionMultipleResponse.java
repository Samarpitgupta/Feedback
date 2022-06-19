package models;

import java.util.List;

public class TemplateQuestionMultipleResponse {

	private Long id;
	private Long receiverId;
	private List<Long> patronList;
	private Long templateQuestionId;
	private List<String> responseMessage;
	private boolean isResponseSubmitted;

	public List<Long> getPatronList() {
		return patronList;
	}

	public void setPatronList(List<Long> patronList) {
		this.patronList = patronList;
	}

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

	public Long getTemplateQuestionId() {
		return templateQuestionId;
	}

	public void setTemplateQuestionId(Long templateQuestionId) {
		this.templateQuestionId = templateQuestionId;
	}

	public List<String> getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(List<String> responseMessage) {
		this.responseMessage = responseMessage;
	}

	public boolean isResponseSubmitted() {
		return isResponseSubmitted;
	}

	public void setResponseSubmitted(boolean isResponseSubmitted) {
		this.isResponseSubmitted = isResponseSubmitted;
	}

}
