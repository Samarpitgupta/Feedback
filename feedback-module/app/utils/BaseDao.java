package utils;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public abstract class BaseDao {

//	@Autowired
	private JdbcTemplate jdbcTemplate = null;
	private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/feedback";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASS = "root";
	private static DataSource dataSource ;

	public static DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DRIVER_CLASS_NAME);
		dataSource.setUrl(URL);
		dataSource.setUsername(DB_USERNAME);
		dataSource.setPassword(DB_PASS);
		return dataSource;
	}

	/**
	 * This method is responsible to provide jdbc templete object
	 * 
	 * @return JdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		dataSource = getDataSource();
		if (jdbcTemplate == null) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
		return this.jdbcTemplate;
	}

}