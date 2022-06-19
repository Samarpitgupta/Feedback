/**
 * 
 */
package models;

public class QuestionResponse {

	private Long templateQuestionId;
	private String question;
	private Long responseMessage;

	public Long getTemplateQuestionId() {
		return templateQuestionId;
	}

	public void setTemplateQuestionId(Long templateQuestionId) {
		this.templateQuestionId = templateQuestionId;
	}

	public Long getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(Long responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
