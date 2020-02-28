package com.foreknow.dao.impl;






import java.sql.Connection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.foreknow.db.JdbcTemplate;
import com.foreknow.mapping.MappingFactory;

public class BaseDAO {

	protected JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();// JDBC模板
	protected MappingFactory mappingFactory = MappingFactory.getInstance();// mapping工厂实例
	protected Log logger = LogFactory.getLog("DAOLogger");

	/**
	 * 注入数据库连接类
	 *
	 * @param connection
	 */
	public void setConnection(Connection connection) {
		jdbcTemplate.setConnection(connection);
	}
}
