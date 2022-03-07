package com.cloud.chang.data;

import java.util.List;

public class DataNode {

	private String methed;
	private String sql;
	private List<DataNode> subDataNodes;

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getMethed() {
		return methed;
	}

	public void setMethed(String methed) {
		this.methed = methed;
	}

	public List<DataNode> getSubDataNodes() {
		return subDataNodes;
	}

	public void setSubDataNodes(List<DataNode> subDataNodes) {
		this.subDataNodes = subDataNodes;
	}

	@Override
	public String toString() {
		return "DataNode [methed=" + methed + ", sql=" + sql + ", subDataNodes=" + subDataNodes + "]";
	}

}
