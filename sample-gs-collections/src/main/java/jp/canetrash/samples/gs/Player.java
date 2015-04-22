package jp.canetrash.samples.gs;

public class Player {

	public Player(String name, Integer birthYear) {
		super();
		this.name = name;
		this.birthYear = birthYear;
	}

	private String name;
	private Integer birthYear;

	public Integer getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
