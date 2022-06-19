package dao.imple;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import utils.SQL;
import utils.SqlDataMapper;
import dao.FeedbackDao;
import dto.QuestionAndResponse;
import dto.ReceiverPatronDto;
import dto.TemplateAllQuestionResponseDto;
import dto.UserFeedbackRequestDto;
import models.Template;
import models.TemplateQuestion;
import models.TemplateQuestionMultipleResponse;
import models.TemplateQuestionResponse;

public class FeedbackDaoImple extends utils.BaseDao implements FeedbackDao {

	public static final Logger LOGGER = LoggerFactory.getLogger(FeedbackDaoImple.class);

	@Override
	public Template createNewTemplate(final Template template) {
		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			getJdbcTemplate().update(new PreparedStatementCreator() {
				public java.sql.PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					String[] returnValColumn = new String[] { "id" };
					java.sql.PreparedStatement statement = con.prepareStatement(SQL.INSERT_TEMPLATE_QUERY,
							returnValColumn);
					statement.setString(1, template.getName());
					statement.setString(2, template.getQuestions());
					return statement;
				}
			}, keyHolder);
			Long id = keyHolder.getKey().longValue();
			template.setId(id);
		} catch (Exception ex) {
			LOGGER.info("Encountered an exception while saving the template Details : " + ex);
		}
		return template;
	}

	@Override
	public TemplateQuestion insertQuestion(TemplateQuestion question) {
		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			getJdbcTemplate().update(new PreparedStatementCreator() {
				public java.sql.PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					String[] returnValColumn = new String[] { "id" };
					java.sql.PreparedStatement statement = con.prepareStatement(SQL.INSERT_QUESTION_QUERY,
							returnValColumn);
					statement.setString(1, question.getQuestion());
					statement.setLong(2, question.getTypeId());
					statement.setBoolean(3, question.getIsTemplateQuestion());
					return statement;
				}
			}, keyHolder);
			Long id = keyHolder.getKey().longValue();
			question.setId(id);
		} catch (Exception ex) {
			LOGGER.info("Encountered an exception while saving the question : " + ex);
		}
		return question;
	}

	@Override
	public boolean insertTemplateQuestions(List<TemplateQuestion> templateList) {
		int[] values = null;
		try {
			values = getJdbcTemplate().batchUpdate(SQL.INSERT_TEMPLATE_QUESTIONS_QUERY,
					new BatchPreparedStatementSetter() {
						@Override
						public void setValues(java.sql.PreparedStatement statement, int i) throws SQLException {
							statement.setString(1, templateList.get(i).getQuestion());
							statement.setLong(2, templateList.get(i).getTypeId());
							statement.setLong(3, templateList.get(i).getTemplateId());
							statement.setBoolean(4, templateList.get(i).getIsTemplateQuestion());
						}

						public int getBatchSize() {
							return templateList.size();
						}
					});
		} catch (Exception ex) {
			LOGGER.error("Exception Occured while inserting all questions : " + ex);
		}
		if (values != null && values.length > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Template updateTemplate(final Template template) {
		try {
			getJdbcTemplate().update(SQL.UPDATE_TEMPLATE_QUERY,
					new Object[] { template.getName(), template.getQuestions(), template.getId() });
		} catch (Exception ex) {
			LOGGER.error("Encountered an exception while updating the template details : " + ex);
		}
		return template;
	}

	@Override
	public List<Template> getAllTemplate() {
		List<Template> templateList = new ArrayList<>();
		try {
			templateList = getJdbcTemplate().query(SQL.GET_ALL_TEMPLATE_QUERY, new Object[] {},
					new SqlDataMapper().new TemplateMapper());
		} catch (Exception e) {
			LOGGER.info("Encountered an Exception while fetching");
		}
		return templateList;
	}

	@Override
	public Template getTemplateById(Integer intId) {
		List<Template> template = new ArrayList<>();
		try {
			Long id = (long) (int) intId;
			template = getJdbcTemplate().query(SQL.GET_TEMPLATE_BY_ID, new Object[] { id },
					new SqlDataMapper().new TemplateMapper());
		} catch (Exception e) {
			LOGGER.info("Encountered an Exception while fetching");
		}
		return template.get(0);
	}

	//
	@Override
	public TemplateQuestionResponse userFeedbackRequestToPatron(TemplateQuestionResponse receiverPatron) {
		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			getJdbcTemplate().update(new PreparedStatementCreator() {
				public java.sql.PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					String[] returnValColumn = new String[] { "id" };
					java.sql.PreparedStatement statement = con
							.prepareStatement(SQL.INSERT_QUESTION_RESPONSE_WITHOUT_TEMPLATE, returnValColumn);
					statement.setLong(1, receiverPatron.getReceiverId());
					statement.setLong(2, receiverPatron.getPatronId());
					statement.setLong(3, receiverPatron.getTemplateQuestionId());
					return statement;
				}
			}, keyHolder);
			Long id = keyHolder.getKey().longValue();
			receiverPatron.setId(id);
		} catch (Exception ex) {
			LOGGER.info("Encountered an exception while saving the receiver and patron id " + ex);
		}
		return receiverPatron;
	}

	@Override
	public Boolean userFeedbackRequestToMultiplePatron(TemplateQuestionMultipleResponse receiverPatron) {
		int[] values = null;
		try {
			values = getJdbcTemplate().batchUpdate(SQL.INSERT_QUESTION_RESPONSE_WITHOUT_TEMPLATE,
					new BatchPreparedStatementSetter() {
						@Override
						public void setValues(java.sql.PreparedStatement statement, int i) throws SQLException {
							statement.setLong(1, receiverPatron.getReceiverId());
							statement.setLong(2, receiverPatron.getPatronList().get(i));
							statement.setLong(3, receiverPatron.getTemplateQuestionId());
						}

						public int getBatchSize() {
							return receiverPatron.getPatronList().size();
						}
					});
		} catch (Exception ex) {
			LOGGER.error("Exception Occured while requeting feedback to multiple patron : " + ex);
		}
		if (values != null && values.length > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public List<TemplateQuestionResponse> getTemplateResponseByReceiverPatronId(ReceiverPatronDto dto) {
		List<TemplateQuestionResponse> response = new ArrayList<>();
		try {
			response = getJdbcTemplate().query(SQL.GET_TEMPLATE_QUESTION_RESPONSE_BY_RECEIVER_PATRON_ID,
					new Object[] { dto.getReceiverId(), dto.getPatronId() },
					new SqlDataMapper().new TemplateQuestionResponseMapper());
		} catch (Exception e) {
			LOGGER.info("Encountered an Exception while fetching questions responses by receiver and patron id");
		}
		return response;
	}

	@Override
	public List<TemplateQuestion> getAllQuestionsByReceiverPatronId(ReceiverPatronDto dto) {
		List<TemplateQuestion> response = new ArrayList<>();
		try {
			response = getJdbcTemplate().query(SQL.GET_TEMPLATE_QUESTION_BY_RECEIVER_PATRON_ID,
					new Object[] { dto.getReceiverId(), dto.getPatronId() },
					new SqlDataMapper().new TemplateQuestionMapper());
		} catch (Exception e) {
			LOGGER.info("Encountered an Exception while fetching questions by receiver and patron id");
		}
		return response;
	}

	@Override
	public TemplateQuestionResponse saveResponse(TemplateQuestionResponse response) {
		try {
			getJdbcTemplate().update(SQL.UPDATE_TEMPLATE_QUESTION_RESPONSE,
					new Object[] { response.getResponseMessage(), response.getTemplateQuestionId() });
			response.setResponseSubmitted(true);
		} catch (Exception e) {
			LOGGER.error("Encountered an error while adding feedback response : " + e);
		}
		return response;
	}

	@Override
	public List<QuestionAndResponse> getAllQuestionAndResponses(UserFeedbackRequestDto dto) {
		List<QuestionAndResponse> list = new ArrayList<>();
		try {
			list = getJdbcTemplate().query(SQL.GET_ALL_QUESTION_AND_RESPONSE,
					new Object[] { dto.getReceiverId(), dto.getPatronId() },
					new SqlDataMapper().new QuestionAndResponseMapper());
		} catch (Exception e) {
			LOGGER.info("Encountered an Exception while fetching questions by receiver and patron id");
		}
		return list;
	}

	@Override
	public Boolean saveAllTemplateQuestionResponse(TemplateAllQuestionResponseDto dto) {
		int[] values = null;
		try {
			values = getJdbcTemplate().batchUpdate(SQL.UPDATE_TEMPLATE_RESPONE_BY_TEMPLATE_QUESTION_ID,
					new BatchPreparedStatementSetter() {
						@Override
						public void setValues(java.sql.PreparedStatement statement, int i) throws SQLException {
							statement.setString(1, dto.getQuestionAndResponseList().get(i).getResponseMessage());
							statement.setLong(2, dto.getQuestionAndResponseList().get(i).getTemplateQuestionId());
							statement.setLong(3, dto.getReceiverId());
							statement.setLong(4, dto.getPatronId());
						}

						public int getBatchSize() {
							return dto.getQuestionAndResponseList().size();
						}
					});
		} catch (Exception ex) {
			LOGGER.error("Exception Occured while inserting template responses : " + ex);
		}
		if (values != null && values.length > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

}
