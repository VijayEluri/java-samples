package jp.canetrash.samples.gs;

import com.gs.collections.api.set.MutableSet;
import com.gs.collections.impl.set.mutable.UnifiedSet;

/**
 * @author tfunato
 *
 */
public class Guitar {

	private double scale;
	private String name;

	private final MutableSet<Player> players = UnifiedSet.newSet();

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MutableSet<Player> getPlayers() {
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
