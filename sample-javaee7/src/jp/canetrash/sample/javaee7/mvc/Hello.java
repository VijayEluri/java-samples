package jp.canetrash.sample.javaee7.mvc;

import java.util.concurrent.atomic.AtomicLong;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Hello {

	private Long id;
	@NotNull
	@Size(min = 1, max = 25)
	private String where;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

    Long assignId() {
        this.id = idSequence.incrementAndGet();
        return id;
    }

    private static final AtomicLong idSequence = new AtomicLong();
}
