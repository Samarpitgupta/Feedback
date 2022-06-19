package dao;

import java.util.List;

import dto.QuestionAndResponse;
import dto.ReceiverPatronDto;
import dto.TemplateAllQuestionResponseDto;
import dto.UserFeedbackRequestDto;
import models.Template;
import models.TemplateQuestion;
import models.TemplateQuestionMultipleResponse;
import models.TemplateQuestionResponse;

public interface FeedbackDao {

	/*
	 * This method receives the request with details related to a new template and
	 * create it
	 */
	public Template createNewTemplate(Template template);

	/*
	 * This method stores a template question or a feedback question
	 */
	public TemplateQuestion insertQuestion(TemplateQuestion question);

	/*
	 * This method takes list of template question and store it in once
	 */
	public boolean insertTemplateQuestions(List<TemplateQuestion> templateList);

	/*
	 * This method takes template details and update details in db
	 */
	public Template updateTemplate(Template template);

	/*
	 * This method fetch all the templates and returns as ArrayList of templates
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
	public TemplateQuestionResponse userFeedbackRequestToPatron(TemplateQuestionResponse receiverPatron);

	/*
	 * this method allows user to request feedback to multiple users
	 */
	public Boolean userFeedbackRequestToMultiplePatron(TemplateQuestionMultipleResponse receiverPatron);

	/*
	 * saves the response that is submitted by patron
	 */
	public TemplateQuestionResponse saveResponse(TemplateQuestionResponse response);

	/*
	 * this method gives complete information of question and responses submitted by
	 * a User
	 */
	public List<QuestionAndResponse> getAllQuestionAndResponses(UserFeedbackRequestDto dto);

	// this will return all the template_question_id list by receiver and patron id
	public List<TemplateQuestionResponse> getTemplateResponseByReceiverPatronId(ReceiverPatronDto dto);

	// get list of questions by template_question_id
	public List<TemplateQuestion> getAllQuestionsByReceiverPatronId(ReceiverPatronDto dto);

	/*
	 * Save template response submitted by patron
	*/	
	public Boolean saveAllTemplateQuestionResponse(TemplateAllQuestionResponseDto dto);

}
