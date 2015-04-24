package jp.canetrash.samples.gs;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import com.gs.collections.api.RichIterable;
import com.gs.collections.api.block.function.Function;
import com.gs.collections.api.block.function.primitive.IntFunction;
import com.gs.collections.api.block.predicate.Predicate;
import com.gs.collections.api.list.MutableList;
import com.gs.collections.api.set.MutableSet;

/**
 * @author tfunato
 *
 */
public class SimpleTest extends AbstractManufacturerDomain {

	/**
	 * あるギータメーカのショートスケールのギターを抽出
	 * 
	 * @see RichIterable
	 */
	@Test
	@SuppressWarnings("serial")
	public void getShotScaleGuitar() {
		MutableList<Guitar> guitars = this.manufacturer.getGuitars();
		MutableList<Guitar> shortScaleGuitaars = guitars
				.select(new Predicate<Guitar>() {

					@Override
					public boolean accept(Guitar guitar) {
						return guitar.isShortScale();
					}
				});
		assertThat(shortScaleGuitaars.size(), is(1));
		assertThat(shortScaleGuitaars.getFirst().getName(), is("Mustang"));
	}

	/**
	 * あるギターメーカのギターをプレイしている人数を取得
	 * 
	 * @see RichIterable
	 */
	@Test
	@SuppressWarnings("serial")
	public void getPlayerNumber() {
		// のべ人数
		MutableList<Guitar> guitars = this.manufacturer.getGuitars();
		long playerCount = guitars.sumOfInt(new IntFunction<Guitar>() {
			@Override
			public int intValueOf(Guitar guitar) {
				return guitar.getPlayers().size();
			}
		});
		assertThat(playerCount, is(22L));

		// ユニーク
		MutableSet<Player> players = guitars.toSet().flatCollect(new Function<Guitar, MutableSet<Player>>() {
			@Override
			public MutableSet<Player> valueOf(Guitar guitar) {
				return guitar.getPlayers();
			}
		});
		assertThat(players.size(), is(16));
	}
	/**
	 * あるギターメーカのギターをプレイしている1950年代生まれのプレイヤーを取得
	 * 
	 * @see RichIterable
	 */
	@Test
	@SuppressWarnings("serial")
	public void get50thBirthPlayer() {
		MutableList<Guitar> guitars = this.manufacturer.getGuitars();
		// のべ人数
		MutableList<Player> players = guitars
				.flatCollect(new Function<Guitar, MutableSet<Player>>() {
					@Override
					public MutableSet<Player> valueOf(Guitar guitar) {
						return guitar.getPlayers().select(
								new Predicate<Player>() {
									@Override
									public boolean accept(Player player) {
										return player.getBirthYear() >= 1950
												&& player.getBirthYear() < 1960;
									}
								});
					}
				});
		assertThat(players.size(), is(5));

		//ユニーク
		MutableSet<Player> playerSet = guitars.toSet()
				.flatCollect(new Function<Guitar, MutableSet<Player>>() {
					@Override
					public MutableSet<Player> valueOf(Guitar guitar) {
						return guitar.getPlayers().select(
								new Predicate<Player>() {
									@Override
									public boolean accept(Player player) {
										return player.getBirthYear() >= 1950
												&& player.getBirthYear() < 1960;
									}
								});
					}
				});
		assertThat(playerSet.size(), is(2));
	}

}
