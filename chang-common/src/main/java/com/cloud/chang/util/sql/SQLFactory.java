package com.cloud.chang.util.sql;

import java.util.HashMap;
import java.util.Map;

public class SQLFactory {

	private static SQLParser parser = new SQLParser();

	private static HashMap<String, String> sqlContainer = parser.getSQLs();

	private static Map<String, Long> sqlStat = new HashMap<String, Long>();

	public static String getSql(String sqlName) {
		if (sqlName == null || sqlName.equals("")) {
			return "";
		}

		String sqlString = sqlContainer.get(sqlName);

		if (sqlStat.containsKey(sqlName)) {
			sqlStat.put(sqlName, sqlStat.get(sqlName) + 1);
		} else {
			sqlStat.put(sqlName, 1L);
		}

		if (sqlString == null || sqlString.equals("")) {
			return "";
		}

		return sqlString;
	}

	public static long getSqlCallCount(String sqlName) {
		if (sqlStat.containsKey(sqlName)) {
			sqlStat.get(sqlName);
		}

		return 0;
	}

	private SQLFactory() {
	}

	public static SQLParser getParser() {
		return parser;
	}

	public static void setParser(SQLParser parser) {
		SQLFactory.parser = parser;
		sqlContainer = parser.getSQLs();
	}

	public static HashMap<String, String> getSqlContainer() {
		return sqlContainer;
	}

	public static void setSqlContainer(HashMap<String, String> sqlContainer) {
		SQLFactory.sqlContainer = sqlContainer;
	}

}
