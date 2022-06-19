package utils;

public interface SQL {

	final String INSERT_TEMPLATE_QUERY = "INSERT INTO template(name, questions) values(?,?)";
	final String GET_ALL_TEMPLATE_QUERY = "SELECT * FROM template";
	final String UPDATE_TEMPLATE_QUERY = "UPDATE template SET name=?, questions=? WHERE id=?";
	final String DELETE_TEMPLATE_QUERY = "DELETE FROM template WHERE id=?";
	final String GET_TEMPLATE_BY_ID = "SELECT * FROM template where id=?";
	final String INSERT_TEMPLATE_QUESTIONS_QUERY = "INSERT INTO template_questions(question, type_id, template_id,is_template_question) values(?,?,?,?)";
	final String INSERT_QUESTION_QUERY = "INSERT INTO template_questions(question, type_id, is_template_question ) values(?,?,?)";
	final String INSERT_QUESTION_RESPONSE_WITHOUT_TEMPLATE = "INSERT INTO template_question_response(receiver_id, patron_id,template_question_id) values(?,?,?)";

	final String UPDATE_TEMPLATE_QUESTIONS_QUERY = "UPDATE TABLE template_questions SET question=?, type_id=?";
	final String GET_QUESTIONS_BY_TEMPLATE_ID = "SELECT * from template_questions where template_id=?";
	final String INSERT_TEMPLATE_QUESTION_RESPONSE_QUERY = "INSERT INTO template_question_response"
			+ "(template_questions_id,response_message,feedback_receiver_patron_map_id) values(?,?,?)";
	final String MAP_FEEDBACK_RECEIVER_PATRON_QUERY = "INSERT INTO feedback_receiver_patron_map(feedback_receiver_id,feedback_patron_id,response_status,template_id) values(?,?,?,?)"
			+ "(feedback_receiver_id, feedback_patron_id, template_id) values(?,?,?)";
	final String GET_TEMPLATE_QUESTION_RESPONSE_BY_RECEIVER_PATRON_ID = "select * from template_question_response where receiver_id=? AND patron_id=?;";
	final String GET_TEMPLATE_QUESTION_BY_RECEIVER_PATRON_ID = "select * from template_questions where id IN (select template_question_id from template_question_response where receiver_id=? AND patron_id=?)";
	final String UPDATE_TEMPLATE_QUESTION_RESPONSE = "update template_question_response set response_message=?, is_response_submitted=1 where id=?";
	final String GET_QUESTIONS_RESPONSES_BY_USER_ID = "select * from template_question_response tqr "
			+ "where feedback_receiver_patron_map_id IN "
			+ "(select id from feedback_receiver_patron_map where feedback_patron_id=?)";
	final String GET_ALL_SUBMITTED_RESPONSES_BY_PATRON = "";
	final String GET_ALL_QUESTION_AND_RESPONSE = "select tqr.id as template_question_response_id, tqr.receiver_id,tqr.patron_id,tqr.template_question_id,tqr.response_message,tqr.is_response_submitted, tq.id as template_question_id, tq.question,tq.type_id,tq.template_id,tq.is_template_question  from template_question_response tqr inner join template_questions tq on tq.id=tqr.template_question_id where tqr.receiver_id=? AND tqr.patron_id=?";
	final String UPDATE_TEMPLATE_RESPONE_BY_TEMPLATE_QUESTION_ID = "update template_question_response set response_message=?, is_response_submitted=1 where template_question_id=? AND receiver_id=? AND patron_id=?";
}
