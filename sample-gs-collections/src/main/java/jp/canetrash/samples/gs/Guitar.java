package jp.canetrash.samples.gs;

import com.gs.collections.api.list.MutableList;
import com.gs.collections.impl.list.mutable.FastList;

/**
 * @author tfunato
 *
 */
public class Guitar {

	public Guitar(String name, double scale) {
		super();
		this.scale = scale;
		this.name = name;
	}

	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

	private double scale;
	private String name;

	private final MutableList<Player> players = FastList.newList();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MutableList<Player> getPlayers() {
		return players;
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}

	public boolean isShortScale() {
		if (getScale() < 25) {
			return true;
		} else {
			return false;
		}
	}
}
