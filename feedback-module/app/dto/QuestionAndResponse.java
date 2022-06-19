package dto;

public class QuestionAndResponse {

	private Long templateQuestionId;
	private boolean isTemplateQuestion;
	private String question;
	private Long receiverId;
	private String responseMessage;
	private Long templateId;
	private Long typeId;
	private Long patronId;
	private Long templateQuestionResponseId;
	private Boolean isResponseSubmitted;

	public Long getTemplateQuestionId() {
		return templateQuestionId;
	}

	public void setTemplateQuestionId(Long templateQuestionId) {
		this.templateQuestionId = templateQuestionId;
	}

	public boolean isTemplateQuestion() {
		return isTemplateQuestion;
	}

	public void setTemplateQuestion(boolean isTemplateQuestion) {
		this.isTemplateQuestion = isTemplateQuestion;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getPatronId() {
		return patronId;
	}

	public void setPatronId(Long patronId) {
		this.patronId = patronId;
	}

	public Long getTemplateQuestionResponseId() {
		return templateQuestionResponseId;
	}

	public void setTemplateQuestionResponseId(Long templateQuestionResponseId) {
		this.templateQuestionResponseId = templateQuestionResponseId;
	}

	public Boolean getIsResponseSubmitted() {
		return isResponseSubmitted;
	}

	public void setIsResponseSubmitted(Boolean isResponseSubmitted) {
		this.isResponseSubmitted = isResponseSubmitted;
	}

}
