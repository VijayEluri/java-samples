package jp.canetrash.sample.json;

import java.util.Map;

public class Hoge {

	private String name;
	private Map<Integer, Data> data;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Integer, Data> getData() {
		return data;
	}

	public void setData(Map<Integer, Data> data) {
		this.data = data;
	}
}
