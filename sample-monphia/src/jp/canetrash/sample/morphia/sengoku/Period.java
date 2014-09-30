package jp.canetrash.sample.morphia.sengoku;

import java.util.Date;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Period {
	private Date start;
	private Date end;

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}
}
