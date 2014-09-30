package jp.canetrash.sample.dozer.dest;

import java.util.List;

public class BeanDest {

	private String id;

	private List<EmbededDest> embededList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<EmbededDest> getEmbededList() {
		return embededList;
	}

	public void setEmbededList(List<EmbededDest> embededList) {
		this.embededList = embededList;
	}
}
