package dto;

// This dto is used in feedbackRequest api
public class UserFeedbackRequestDto {

	private Long receiverId;
	private Long patronId;
	private Long questionId;
	private boolean isTemplateQuestion;
	private Long typeId;
	private String question;
	private Integer templateId;

	private boolean isResponseSubmitted;
	private Long templateQuestionResponseId;
	private String responseMessage;

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public boolean isTemplateQuestion() {
		return isTemplateQuestion;
	}

	public void setTemplateQuestion(boolean isTemplateQuestion) {
		this.isTemplateQuestion = isTemplateQuestion;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

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

	public boolean isResponseSubmitted() {
		return isResponseSubmitted;
	}

	public void setResponseSubmitted(boolean isResponseSubmitted) {
		this.isResponseSubmitted = isResponseSubmitted;
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

	public Long getTemplateQuestionResponseId() {
		return templateQuestionResponseId;
	}

	public void setTemplateQuestionResponseId(Long templateQuestionResponseId) {
		this.templateQuestionResponseId = templateQuestionResponseId;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
