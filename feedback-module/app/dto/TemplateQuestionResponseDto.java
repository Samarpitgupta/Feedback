package dto;

public class TemplateQuestionResponseDto {

	private Long id;
	private Long templateQuestionId;
	private String responseMessage;
	private FeedbackReceiverPatronMapDto feedbackReceiverPatronMapDto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public FeedbackReceiverPatronMapDto getFeedbackReceiverPatronMapDto() {
		return feedbackReceiverPatronMapDto;
	}

	public void setFeedbackReceiverPatronMapDto(FeedbackReceiverPatronMapDto feedbackReceiverPatronMapDto) {
		this.feedbackReceiverPatronMapDto = feedbackReceiverPatronMapDto;
	}

}
