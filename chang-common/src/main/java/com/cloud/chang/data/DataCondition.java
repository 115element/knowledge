package com.cloud.chang.data;

import java.util.List;

public class DataCondition {

	private List<DataNode> dataNodeList;

	public List<DataNode> getDataNodeList() {
		return dataNodeList;
	}

	public void setDataNodeList(List<DataNode> dataNodeList) {
		this.dataNodeList = dataNodeList;
	}

	@Override
	public String toString() {
		return "DataCondition [dataNodeList=" + dataNodeList + "]";
	}

}
