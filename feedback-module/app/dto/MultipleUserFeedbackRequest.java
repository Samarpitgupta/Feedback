package dto;

import java.util.List;

public class MultipleUserFeedbackRequest {

	private String question;
	private Integer templateId;
	private boolean isTemplateQuestion;
	private Long questionId;
	private Long typeId;

	private Long receiverId;
	private List<Long> patronList;
	private List<String> responseMessage;
	private boolean isResponseSubmitted;
	private Long templateQuestionResponseId;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public boolean isTemplateQuestion() {
		return isTemplateQuestion;
	}

	public void setTemplateQuestion(boolean isTemplateQuestion) {
		this.isTemplateQuestion = isTemplateQuestion;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public List<Long> getPatronList() {
		return patronList;
	}

	public void setPatronList(List<Long> patronList) {
		this.patronList = patronList;
	}

	public boolean isResponseSubmitted() {
		return isResponseSubmitted;
	}

	public void setResponseSubmitted(boolean isResponseSubmitted) {
		this.isResponseSubmitted = isResponseSubmitted;
	}

	public Long getTemplateQuestionResponseId() {
		return templateQuestionResponseId;
	}

	public void setTemplateQuestionResponseId(Long templateQuestionResponseId) {
		this.templateQuestionResponseId = templateQuestionResponseId;
	}

	public List<String> getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(List<String> responseMessage) {
		this.responseMessage = responseMessage;
	}

}
