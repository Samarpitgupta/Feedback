package dto;

public class FeedbackReceiverPatronMapDto {

	private Long id;
	private Long feedbackReceiverId;
	private Long feedbackPatronId;
	private boolean responseStatus;
	private Long templateId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFeedbackReceiverId() {
		return feedbackReceiverId;
	}
	public void setFeedbackReceiverId(Long feedbackReceiverId) {
		this.feedbackReceiverId = feedbackReceiverId;
	}
	public Long getFeedbackPatronId() {
		return feedbackPatronId;
	}
	public void setFeedbackPatronId(Long feedbackPatronId) {
		this.feedbackPatronId = feedbackPatronId;
	}
	public boolean getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(boolean responseStatus) {
		this.responseStatus = responseStatus;
	}
	public Long getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

}
