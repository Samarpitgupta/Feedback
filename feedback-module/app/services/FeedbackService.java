package services;

import java.util.List;

import dto.MultipleUserFeedbackRequest;
import dto.QuestionAndResponse;
import dto.ReceiverPatronDto;
import dto.TemplateAllQuestionResponseDto;
import dto.UserFeedbackRequestDto;
import models.Template;
import models.TemplateQuestion;
import models.TemplateQuestionResponse;

public interface FeedbackService {

	/*
	 * This method receives the request with details related to a new template and
	 * create a new template
	 */
	public Template createNewTemplate(Template template);

	/*
	 * This method takes template details and update details
	 */
	public Template updateTemplate(Template template);

	/*
	 * This method returns list of templates
	 */
	public List<Template> getAllTemplate();

	/*
	 * this method takes template id as argument and returns the template details by
	 * template id
	 */
	public Template getTemplateById(Integer id);

	/*
	 * this method is used to store the requested feedback questions with receiver
	 * and patron id
	 */
	public UserFeedbackRequestDto userFeedbackRequestToPatron(UserFeedbackRequestDto dto);

	/*
	 * saves the response that is submitted by patron
	 */
	public TemplateQuestionResponse saveResponse(TemplateQuestionResponse response);

	/*
	 * this method gives complete information of question and responses submitted by
	 * a User
	 */
	public List<QuestionAndResponse> getAllQuestionAndResponses(UserFeedbackRequestDto dto);

	/*
	 * this method allows user to request feedback to multiple users
	 */
	public Boolean userFeedbackRequestToMultiplePatron(MultipleUserFeedbackRequest dto);

	/*
	 * Return all the questions
	 */
	public List<TemplateQuestion> getAllQuestionsDetailsByReceiverAndPatronId(ReceiverPatronDto dto);

	/*
	 * Save template response submitted by patron
	*/	
	public Boolean saveAllTemplateQuestionResponse(TemplateAllQuestionResponseDto dto);

}
