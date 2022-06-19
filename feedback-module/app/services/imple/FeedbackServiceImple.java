package services.imple;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import dao.FeedbackDao;
import dao.imple.FeedbackDaoImple;
import dto.MultipleUserFeedbackRequest;
import dto.QuestionAndResponse;
import dto.ReceiverPatronDto;
import dto.TemplateAllQuestionResponseDto;
import dto.UserFeedbackRequestDto;
import models.Template;
import models.TemplateQuestion;
import models.TemplateQuestionMultipleResponse;
import models.TemplateQuestionResponse;
import services.FeedbackService;

@Service(value = "feedbackService")
public class FeedbackServiceImple implements FeedbackService {

	private FeedbackDao feedbackDao = new FeedbackDaoImple();

	@SuppressWarnings("null")
	@Override
	public Template createNewTemplate(final Template template) {
		Template temp;
		temp = feedbackDao.createNewTemplate(template);
		List<TemplateQuestion> templateQuestionList = new ArrayList<>();

		String[] questionList = template.getQuestions().split(";");
		for (int i = 0; i < questionList.length; i++) {
			TemplateQuestion templateQuestion = new TemplateQuestion();
			templateQuestion.setQuestion(questionList[i]);
			templateQuestion.setTemplateId(temp.getId());
			// take TypeId from request
			// need to update while setting the type id
			templateQuestion.setTypeId((long) 1);
			templateQuestion.setIsTemplateQuestion(true);
			templateQuestionList.add(templateQuestion);
		}
		boolean value = false;
		// Inserting all questions in different rows in template_question template
		if (!templateQuestionList.isEmpty()) {
			value = feedbackDao.insertTemplateQuestions(templateQuestionList);
		}
		if (value) {
			return temp;
		}
		return temp;
	}

	// Needs to update template_question table also
	@Override
	public Template updateTemplate(Template template) {
		return feedbackDao.updateTemplate(template);
	}

	@Override
	public List<Template> getAllTemplate() {
		return feedbackDao.getAllTemplate();
	}

	@Override
	public Template getTemplateById(Integer id) {
		return feedbackDao.getTemplateById(id);
	}

	//
	@Override
	public UserFeedbackRequestDto userFeedbackRequestToPatron(UserFeedbackRequestDto dto) {
		TemplateQuestion question = new TemplateQuestion();
		question.setQuestion(dto.getQuestion());
		// question template id will be null
		// question is not template question
		question.setIsTemplateQuestion(false);
		question.setTypeId(dto.getTypeId());
		question = feedbackDao.insertQuestion(question);

		TemplateQuestionResponse receiverResponse = new TemplateQuestionResponse();
		if (question.getId() != null) {
			dto.setQuestionId(question.getId());
			receiverResponse.setPatronId(dto.getPatronId());
			receiverResponse.setReceiverId(dto.getReceiverId());
			receiverResponse.setTemplateQuestionId(question.getId());
			receiverResponse = feedbackDao.userFeedbackRequestToPatron(receiverResponse);
			dto.setTemplateQuestionResponseId(receiverResponse.getId());
		}
		return dto;
	}

	@Override
	public Boolean userFeedbackRequestToMultiplePatron(MultipleUserFeedbackRequest dto) {
		TemplateQuestion question = new TemplateQuestion();
		question.setQuestion(dto.getQuestion());
		// question template id will be null
		// question is not template question
		question.setIsTemplateQuestion(false);
		question.setTypeId(dto.getTypeId());
		question = feedbackDao.insertQuestion(question);

		TemplateQuestionMultipleResponse receiverResponse = new TemplateQuestionMultipleResponse();
		boolean value = false;
		if (question.getId() != null) {
			dto.setQuestionId(question.getId());
			receiverResponse.setPatronList(dto.getPatronList());
			receiverResponse.setReceiverId(dto.getReceiverId());
			receiverResponse.setTemplateQuestionId(question.getId());
			dto.setTemplateQuestionResponseId(receiverResponse.getId());
			value = feedbackDao.userFeedbackRequestToMultiplePatron(receiverResponse);
		}
		return value;
	}

	@Override
	public List<TemplateQuestion> getAllQuestionsDetailsByReceiverAndPatronId(ReceiverPatronDto dto) {
		return feedbackDao.getAllQuestionsByReceiverPatronId(dto);
	}

	@Override
	public TemplateQuestionResponse saveResponse(TemplateQuestionResponse response) {
		return feedbackDao.saveResponse(response);
	}

	@Override
	public List<QuestionAndResponse> getAllQuestionAndResponses(UserFeedbackRequestDto dto) {
		return feedbackDao.getAllQuestionAndResponses(dto);
	}

	@Override
	public Boolean saveAllTemplateQuestionResponse(TemplateAllQuestionResponseDto dto) {
		return feedbackDao.saveAllTemplateQuestionResponse(dto);
	}

}
