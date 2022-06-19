package controllers;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import dto.MultipleUserFeedbackRequest;
import dto.QuestionAndResponse;
import dto.TemplateAllQuestionResponseDto;
import dto.UserFeedbackRequestDto;
import models.Template;
import models.TemplateQuestionResponse;
import play.mvc.Controller;
import play.mvc.Result;
import services.FeedbackService;
import services.imple.FeedbackServiceImple;
import utils.ControllerRequestMapper;
import utils.ResponseGenerator;

@org.springframework.stereotype.Controller
public class FeedbackController extends Controller {

	private FeedbackService feedbackService = new FeedbackServiceImple();
	private ControllerRequestMapper mapper = new ControllerRequestMapper();

	public Result createNewTemplate() throws JsonProcessingException {
		Template template = new Template();
		try {
			if (request().body().asJson().size() != 0) {
				template = (Template) mapper.mapRequest(request().body().asJson(), Template.class);
			}
		} catch (Exception e) {
			return ok(ResponseGenerator.failureResponse(utils.Constants.JSON_FORMAT_REQUIRED));
		}
		if (template != null) {
			template = feedbackService.createNewTemplate(template);
		}
		return ok(ResponseGenerator.successResponse(template));
	}

	public Result updateTemplate() throws JsonProcessingException {
		Template template = new Template();

		try {
			if (request().body().asJson().size() != 0) {
				template = (Template) mapper.mapRequest(request().body().asJson(), Template.class);
			}
		} catch (Exception e) {
			return ok(ResponseGenerator.failureResponse(utils.Constants.JSON_FORMAT_REQUIRED));
		}
		if (template != null) {
			template = feedbackService.updateTemplate(template);
		}
		return ok(ResponseGenerator.successResponse(template));
	}

	public Result getAllTemplate() throws JsonProcessingException {
		List<Template> list;
		list = feedbackService.getAllTemplate();
		return ok(ResponseGenerator.successResponse(list));
	}

	public Result getTemplateById(Integer id) throws JsonProcessingException {
		Template template = new Template();
		if (id != null) {
			template = feedbackService.getTemplateById(id);
		}
		return ok(ResponseGenerator.successResponse(template));
	}

	public Result userFeedbackRequestToPatron() throws JsonProcessingException {
		UserFeedbackRequestDto dto = new UserFeedbackRequestDto();
		try {
			if (request().body().asJson().size() != 0) {
				dto = (UserFeedbackRequestDto) mapper.mapRequest(request().body().asJson(),
						UserFeedbackRequestDto.class);
			}
		} catch (Exception e) {
			return ok(ResponseGenerator.failureResponse(utils.Constants.JSON_FORMAT_REQUIRED));
		}
		if (dto != null) {
			dto = feedbackService.userFeedbackRequestToPatron(dto);
		}
		return ok(ResponseGenerator.successResponse(dto));
	}

	public Result userFeedbackRequestToMultiplePatron() throws JsonProcessingException {
		MultipleUserFeedbackRequest dto = new MultipleUserFeedbackRequest();
		try {
			if (request().body().asJson().size() != 0) {
				dto = (MultipleUserFeedbackRequest) mapper.mapRequest(request().body().asJson(),
						MultipleUserFeedbackRequest.class);
			}
		} catch (Exception e) {
			return ok(ResponseGenerator.failureResponse(utils.Constants.JSON_FORMAT_REQUIRED));
		}
		boolean value = false;
		if (dto != null) {
			value = feedbackService.userFeedbackRequestToMultiplePatron(dto);
		}
		return ok(ResponseGenerator.successResponse(value));
	}

	public Result saveResponse() throws JsonProcessingException {
		TemplateQuestionResponse dto = new TemplateQuestionResponse();
		try {
			if (request().body().asJson().size() != 0) {
				dto = (TemplateQuestionResponse) mapper.mapRequest(request().body().asJson(),
						TemplateQuestionResponse.class);
			}
		} catch (Exception e) {
			return ok(ResponseGenerator.failureResponse(utils.Constants.JSON_FORMAT_REQUIRED));
		}
		if (dto != null) {
			dto = feedbackService.saveResponse(dto);
		}
		return ok(ResponseGenerator.successResponse(dto));
	}

	public Result getAllQuestionAndResponses() throws JsonProcessingException {
		UserFeedbackRequestDto dto = new UserFeedbackRequestDto();
		try {
			if (request().body().asJson().size() != 0) {
				dto = (UserFeedbackRequestDto) mapper.mapRequest(request().body().asJson(),
						UserFeedbackRequestDto.class);
			}
		} catch (Exception e) {
			return ok(ResponseGenerator.failureResponse(utils.Constants.JSON_FORMAT_REQUIRED));
		}
		List<QuestionAndResponse> list = new ArrayList<>();
		if (dto != null) {
			list = feedbackService.getAllQuestionAndResponses(dto);
		}
		return ok(ResponseGenerator.successResponse(list));
	}

	public Result saveAllTemplateQuestionResponse() throws JsonProcessingException {
		TemplateAllQuestionResponseDto dto = new TemplateAllQuestionResponseDto();
		try {
			if (request().body().asJson().size() != 0) {
				dto = (TemplateAllQuestionResponseDto) mapper.mapRequest(request().body().asJson(),
						TemplateAllQuestionResponseDto.class);
			}
		} catch (Exception e) {
			return ok(ResponseGenerator.failureResponse(utils.Constants.JSON_FORMAT_REQUIRED));
		}
		boolean value = false;
		if (dto != null) {
			value = feedbackService.saveAllTemplateQuestionResponse(dto);
		}
		return ok(ResponseGenerator.successResponse(value));
	}

}
