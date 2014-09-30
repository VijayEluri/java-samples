package jp.canetrash.sample.dozer.dest;

import java.math.BigDecimal;
import java.util.List;

public class EmbededDest {

	private String id;
	private Integer num;
	private BigDecimal bd;
	private List<NestedEmbedeDest> nestedEmbedes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public BigDecimal getBd() {
		return bd;
	}

	public void setBd(BigDecimal bd) {
		this.bd = bd;
	}

	public List<NestedEmbedeDest> getNestedEmbedes() {
		return nestedEmbedes;
	}

	public void setNestedEmbedes(List<NestedEmbedeDest> nestedEmbedes) {
		this.nestedEmbedes = nestedEmbedes;
	}
}
