package jp.canetrash.samples.gs;

import com.gs.collections.api.list.MutableList;
import com.gs.collections.impl.list.mutable.FastList;

/**
 * @author tfunato
 *
 */
public class Manufacturer {

	private String name;
	private String city;

	private final MutableList<Guitar> guitars = FastList.newList();

	public Manufacturer(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public MutableList<Guitar> getGuitars() {
		return guitars;
	}

	public void addGuitar(Guitar guitar) {
		this.guitars.add(guitar);
	}
}
