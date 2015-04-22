package jp.canetrash.samples.gs;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.Test;

import com.gs.collections.api.block.function.Function;
import com.gs.collections.api.block.function.primitive.IntFunction;
import com.gs.collections.api.block.predicate.Predicate;
import com.gs.collections.api.list.MutableList;

public class SimpleTest extends AbstractManufacturerDomain {

	/**
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
	 * @see RichIterable
	 */
	@Test
	@SuppressWarnings("serial")
	public void getPlayerNumber() {
		MutableList<Guitar> guitars = this.manufacturer.getGuitars();
		long playerCount = guitars.sumOfInt(new IntFunction<Guitar>() {
			@Override
			public int intValueOf(Guitar guitar) {
				return guitar.getPlayers().size();
			}
		});
		assertThat(playerCount, is(13L));
	}

	/**
	 * @see RichIterable
	 */
	@Test
	@SuppressWarnings("serial")
	public void get50thBirthPlayer() {
		MutableList<Guitar> guitars = this.manufacturer.getGuitars();
		MutableList<Player> players = guitars
				.flatCollect(new Function<Guitar, List<Player>>() {
					@Override
					public List<Player> valueOf(Guitar guitar) {
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
		assertThat(players.size(), is(2));

	}

}
