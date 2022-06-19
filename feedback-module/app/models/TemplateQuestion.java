package models;

public class TemplateQuestion {

	private Long id;
	private String question;
	private Long typeId;
	private Long templateId;
	private boolean isTemplateQuestion;
	
	public boolean getIsTemplateQuestion() {
		return isTemplateQuestion;
	}
	public void setIsTemplateQuestion(boolean isTemplateQuestion) {
		this.isTemplateQuestion = isTemplateQuestion;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public Long getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}
	
}
