package dto;

import java.util.List;

public class TemplateAllQuestionResponseDto {

	// * - required field
	private Long patronId; // *
	private Long receiverId; // *
	private Long templateId;
	private Long templateQuestioResponseId; // not necessary
	private List<QuestionAndResponse> questionAndResponseList; // *

	public Long getPatronId() {
		return patronId;
	}

	public void setPatronId(Long patronId) {
		this.patronId = patronId;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public List<QuestionAndResponse> getQuestionAndResponseList() {
		return questionAndResponseList;
	}

	public void setQuestionAndResponseList(List<QuestionAndResponse> questionAndResponseList) {
		this.questionAndResponseList = questionAndResponseList;
	}

	public Long getTemplateQuestioResponsId() {
		return templateQuestioResponseId;
	}

	public void setTemplateQuestioResponseId(Long templateQuestioResponseId) {
		this.templateQuestioResponseId = templateQuestioResponseId;
	}

}
