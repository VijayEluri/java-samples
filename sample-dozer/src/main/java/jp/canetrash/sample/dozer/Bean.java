package jp.canetrash.sample.dozer;

import java.util.List;

public class Bean {

	private String strangeStr;
	private List<Embeded> embededList;

	public String getStrangeStr() {
		return strangeStr;
	}

	public void setStrangeStr(String strangeStr) {
		this.strangeStr = strangeStr;
	}

	public List<Embeded> getEmbededList() {
		return embededList;
	}

	public void setEmbededList(List<Embeded> embededList) {
		this.embededList = embededList;
	}

}
