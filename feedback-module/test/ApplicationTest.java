import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import dto.MultipleUserFeedbackRequest;
import dto.QuestionAndResponse;
import dto.UserFeedbackRequestDto;
import models.Template;
import models.TemplateQuestionResponse;

import org.junit.*;
import services.FeedbackService;
import services.imple.FeedbackServiceImple;

import static org.junit.Assert.assertEquals;

/**
 *
 * Simple (JUnit) tests that can call all parts of a play app. If you are
 * interested in mocking a whole application, see the wiki for more details.
 *
 */
public class ApplicationTest {

	private FeedbackService feedbackService = null;

	@BeforeClass
	public void init() {
		feedbackService = new FeedbackServiceImple();
	}

	@Test
	public void testGetAllTemplate() throws JsonProcessingException {
		List<Template> templateList = new ArrayList<Template>();
		Template template = new Template();
		template.setId((long) (int) 1);
		template.setName("Retro template");
		template.setQuestions("What went well; What did not go well;What can be improved");
		templateList.add(template);
		assertEquals(template.getId(), feedbackService.getAllTemplate().get(0).getId());
		assertEquals(template.getName(), feedbackService.getAllTemplate().get(0).getName());
		assertEquals(template.getQuestions(), feedbackService.getAllTemplate().get(0).getQuestions());
	}

	@Test
	public void testUpdateTemplate() {
		Template template = new Template();
		template.setId((long) (int) 1);
		template.setName("My Retro template");
		template.setQuestions("What went well; What did not go well;What can be improved");
		assertEquals(template.getId(), feedbackService.updateTemplate(template).getId());
		assertEquals(template.getName(), feedbackService.updateTemplate(template).getName());
		assertEquals(template.getQuestions(), feedbackService.updateTemplate(template).getQuestions());
	}

	@Test
	public void getTemplateById() {
		Template template = new Template();
		template.setId((long) (int) 1);
		template.setName("Retro template");
		template.setQuestions("What went well; What did not go well;What can be improved");
		assertEquals(template.getId(), feedbackService.getTemplateById(1).getId());
		assertEquals(template.getName(), feedbackService.getTemplateById(1).getName());
		assertEquals(template.getQuestions(), feedbackService.getTemplateById(1).getQuestions());
	}

	@Test
	public void testUserFeedbackRequestToPatron() {
		UserFeedbackRequestDto dto = new UserFeedbackRequestDto();
		dto.setQuestion("Test: I would like to know my performance during Lockdown days.");
		dto.setTypeId((long) (int) 1);
		dto.setReceiverId((long) (int) 1);
		dto.setPatronId((long) (int) 2);
		assertEquals(dto.getQuestion(), feedbackService.userFeedbackRequestToPatron(dto));
	}

	@Test
	public void testUserFeedbackRequestToMultiplePatron() {
		MultipleUserFeedbackRequest request = new MultipleUserFeedbackRequest();
		request.setQuestion("I would like to know my performance during March days.");
		request.setTypeId((long) (int) 1);
		request.setReceiverId((long) (int) 1);
		List<Long> patronList = new ArrayList<Long>();
		patronList.add((long) (int) 2);
		patronList.add((long) (int) 3);
		patronList.add((long) (int) 4);
		request.setPatronList(patronList);
		assertEquals(true, feedbackService.userFeedbackRequestToMultiplePatron(request));
	}

	@Test
	public void testGetAllQuestionAndResponses() {
		UserFeedbackRequestDto dto = new UserFeedbackRequestDto();
		dto.setPatronId((long) (int) 4);
		dto.setReceiverId((long) (int) 1);
		List<QuestionAndResponse> qarList = new ArrayList<QuestionAndResponse>();
		QuestionAndResponse qar = new QuestionAndResponse();
		qar.setTemplateQuestionId((long) (int) 5);
		qarList.add(qar);
		assertEquals(qarList.get(0).getTemplateQuestionId(),
				feedbackService.getAllQuestionAndResponses(dto).get(0).getTemplateQuestionId());

	}

	@Test
	public void testSaveResponse() {
		TemplateQuestionResponse tqr = new TemplateQuestionResponse();
		tqr.setReceiverId((long) (int) 1);
		tqr.setPatronId((long) (int) 2);
		tqr.setTemplateQuestionId((long) (int) 4);
		tqr.setResponseMessage("I would give you 5 out of 5");
		tqr.setResponseSubmitted(true);
		assertEquals(false, feedbackService.saveResponse(tqr).isResponseSubmitted());
	}

	@Test
	public void testCreateNewTemplate() {
		Template template = new Template();
		template.setName("Free Form Template");
		template.setQuestions("Please rate my skills on Java");
		assertEquals(2, feedbackService.createNewTemplate(template));
	}

//	FeedbackService serviceMock = mock(FeedbackServiceImple.class);
//	FeedbackDao daoMock=mock(FeedbackDaoImple.class);
//	FeedbackService feedbackService = new FeedbackServiceImple();
//	when(feedbackService.getAllTemplate()).thenReturn(templateList);
//	daoMock.getAllTemplate();
//	verify(daoMock).getAllTemplate();
}
