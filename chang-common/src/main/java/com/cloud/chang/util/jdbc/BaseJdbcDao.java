package com.cloud.chang.util.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class BaseJdbcDao extends JdbcDaoSupport {

	public int count(String sql, Object... values) {

		int result = 0;
		try {
			if (values.length == 0) {
				result = this.getJdbcTemplate().queryForObject(sql,
						Integer.class);
			} else {
				result = this.getJdbcTemplate().queryForObject(sql, values,
						Integer.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Map<String, Object>> find(String sql, Object... values) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		try {
			resultList = this.getJdbcTemplate().queryForList(sql, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

	public int update(String sql, Object... values) {
		try {
			return this.getJdbcTemplate().update(sql, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int[] updateAll(String[] sql) {
		return this.getJdbcTemplate().batchUpdate(sql);
	}

	public int[] updateAll(String sql, List<Object[]> values) {
		return this.getJdbcTemplate().batchUpdate(sql, values);
	}

}
