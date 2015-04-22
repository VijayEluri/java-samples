package jp.canetrash.samples.gs;

import org.junit.Before;

public abstract class AbstractManufacturerDomain {

	protected Manufacturer manufacturer = new Manufacturer("Fender",
			"Scottsdale");

	@Before
	public void setUp() {
		setUpGuitarAndPlayer();
	}

	private void setUpGuitarAndPlayer() {

		Guitar mustang = new Guitar("Mustang", 24.0);
		mustang.addPlayer(new Player("Kurt Cobain", 1967));
		mustang.addPlayer(new Player("Patti Smith", 1946));
		mustang.addPlayer(new Player("Johnny Winter", 1944));

		this.manufacturer.addGuitar(mustang);

		Guitar jazzmaster = new Guitar("Jazzmaster", 25.5);
		jazzmaster.addPlayer(new Player("Thurston Moore", 1958));
		jazzmaster.addPlayer(new Player("J Mascis", 1965));
		jazzmaster.addPlayer(new Player("Thomas Yorke", 1968));
		jazzmaster.addPlayer(new Player("Stephen Malkmus", 1966));

		this.manufacturer.addGuitar(jazzmaster);

		Guitar stratocaster = new Guitar("Stratocaster", 25.5);
		stratocaster.addPlayer(new Player("James Hendrix", 1942));
		stratocaster.addPlayer(new Player("Eric Clapton", 1945));
		stratocaster.addPlayer(new Player("Jeff Beck", 1944));
		stratocaster.addPlayer(new Player("Ritchie Blackmore", 1945));
		stratocaster.addPlayer(new Player("Stevie Ray Vaughan", 1954));
		stratocaster.addPlayer(new Player("Yngwie Malmsteen", 1963));

		this.manufacturer.addGuitar(stratocaster);
	}
}
