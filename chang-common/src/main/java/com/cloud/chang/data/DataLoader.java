package com.cloud.chang.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloud.chang.util.Util;

public abstract class DataLoader {

	private static Logger log = LoggerFactory.getLogger(DataLoader.class);

	public <T> Set<T> loadDataByCondition(String dataCondition, Class<T> clazz) {
		DataCondition dc = Util.json2Object(dataCondition, DataCondition.class);
		return buildData(dc.getDataNodeList(), clazz);
	}

	public <T> Set<T> buildData(List<DataNode> dataNodeList, Class<T> clazz) {
		Set<T> resultSet = new HashSet<>();
		for (int i = 0; i < dataNodeList.size(); i++) {
			DataNode dataNode = dataNodeList.get(i);
			if ("none".equals(dataNode.getMethed())) {
				String sql = dataNode.getSql();
				Set<T> results = querySingleColumnSet(sql, clazz);
				log.debug("sql=" + sql + ", results szie=" + results.size());
				resultSet.addAll(results);
			} else {
				String sql = dataNode.getSql();
				String method = dataNode.getMethed();
				if (!StringUtils.isBlank(sql)) {
					Set<T> results = querySingleColumnSet(sql, clazz);
					log.debug("sql=" + sql + ", results szie=" + results.size());
					if ("addAll".equals(method)) {
						resultSet.addAll(results);
					} else if ("removeAll".equals(method)) {
						resultSet.removeAll(results);
					} else if ("retainAll".equals(method)) {
						resultSet.retainAll(results);
					} else {
						log.error("methed=" + method + " not recognized");
					}
					log.debug("after method=" + method + ", results szie=" + resultSet.size());
				} else {
					List<DataNode> subDataNodes = dataNode.getSubDataNodes();
					Set<T> results = buildData(subDataNodes, clazz);
					if ("addAll".equals(method)) {
						resultSet.addAll(results);
					} else if ("removeAll".equals(method)) {
						resultSet.removeAll(results);
					} else if ("retainAll".equals(method)) {
						resultSet.retainAll(results);
					} else {
						log.error("methed=" + method + " not recognized");
					}
				}
			}
		}
		return resultSet;
	}

	public abstract <T> Set<T> querySingleColumnSet(String sql, Class<T> clazz);

	public static void main(String[] args) {
		String dataCondition = "{ \"dataNodeList\": [ { \"methed\": \"none\", \"sql\": \"select 18018609133 from dual\"}]}";
		DataCondition dc = Util.json2Object(dataCondition, DataCondition.class);
		System.out.println(dc.getDataNodeList());
	}
}
