package utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dto.FeedbackReceiverPatronMapDto;
import dto.QuestionAndResponse;
import dto.TemplateQuestionResponseDto;
import models.Template;
import models.TemplateQuestion;
import models.TemplateQuestionResponse;

public class SqlDataMapper {
	public class TemplateQuestionResponseMapper implements RowMapper<TemplateQuestionResponse> {
		public TemplateQuestionResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
			TemplateQuestionResponse response = new TemplateQuestionResponse();
			response.setId(rs.getLong("id"));
			response.setReceiverId(rs.getLong("receiver_id"));
			response.setPatronId(rs.getLong("patron_id"));
			response.setTemplateQuestionId(rs.getLong("template_question_id"));
			response.setResponseMessage(rs.getString("response_message"));
			response.setResponseSubmitted(rs.getBoolean("is_response_submitted"));
			return response;
		}
	}

	public class TemplateQuestionMapper implements RowMapper<TemplateQuestion> {
		public TemplateQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
			TemplateQuestion response = new TemplateQuestion();
			response.setId(rs.getLong("id"));
			response.setQuestion(rs.getString("question"));
			response.setTypeId(rs.getLong("type_id"));
			response.setTemplateId(rs.getLong("template_id"));
			response.setIsTemplateQuestion(rs.getBoolean("is_template_question"));
			return response;
		}
	}

	public class QuestionAndResponseMapper implements RowMapper<QuestionAndResponse> {
		public QuestionAndResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
			QuestionAndResponse response = new QuestionAndResponse();
			response.setTemplateQuestionResponseId(rs.getLong("template_question_response_id"));
			response.setReceiverId(rs.getLong("receiver_id"));
			response.setPatronId(rs.getLong("patron_id"));
			response.setResponseMessage(rs.getString("response_message"));
			response.setIsResponseSubmitted(rs.getBoolean("is_response_submitted"));
			response.setTemplateQuestionId(rs.getLong("template_question_id"));
			response.setQuestion(rs.getString("question"));
			response.setTypeId(rs.getLong("type_id"));
			response.setTemplateId(rs.getLong("template_id"));
			response.setTemplateQuestion(rs.getBoolean("is_template_question"));
			return response;
		}
	}

	public class TemplateMapper implements RowMapper<Template> {
		public Template mapRow(ResultSet rs, int rowNum) throws SQLException {
			Template response = new Template();
			response.setId(rs.getLong("id"));
			response.setName(rs.getString("name"));
			response.setQuestions(rs.getString("questions"));
			return response;
		}
	}

	public class TemplateQuestionResponseDtoMapper implements RowMapper<TemplateQuestionResponseDto> {
		public TemplateQuestionResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			TemplateQuestionResponseDto response = new TemplateQuestionResponseDto();
			FeedbackReceiverPatronMapDto mapDto = new FeedbackReceiverPatronMapDto();
			response.setId(rs.getLong("id"));
			mapDto.setFeedbackReceiverId(rs.getLong("feedback_receiver_patron_map_id"));
			response.setFeedbackReceiverPatronMapDto(mapDto);
			response.setTemplateQuestionId(rs.getLong("template_questions_id"));
			response.setResponseMessage(rs.getString("response_message"));
			return response;
		}
	}
}
