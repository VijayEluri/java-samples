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
		Guitar jazzmaster = new Guitar("Jazzmaster", 25.5);
		Guitar stratocaster = new Guitar("Stratocaster", 25.5);
		Guitar telecaster = new Guitar("Telecaster", 25.5);

		this.manufacturer.addGuitar(mustang);
		this.manufacturer.addGuitar(jazzmaster);
		this.manufacturer.addGuitar(stratocaster);
		this.manufacturer.addGuitar(telecaster);

		Player kurt = new Player("Kurt Cobain", 1967);
		Player patti = new Player("Patti Smith", 1946);
		Player johnny = new Player("Johnny Winter", 1944);
		Player thurston = new Player("Thurston Moore", 1958);
		Player mascis = new Player("J Mascis", 1965);
		Player tom = new Player("Thomas Yorke", 1968);
		Player steph = new Player("Stephen Malkmus", 1966);
		Player jim = new Player("James Hendrix", 1942);
		Player clapton = new Player("Eric Clapton", 1945);
		Player jeff = new Player("Jeff Beck", 1944);
		Player ritch = new Player("Ritchie Blackmore", 1945);
		Player srv = new Player("Stevie Ray Vaughan", 1954);
		Player yngwie = new Player("Yngwie Malmsteen", 1963);
		Player james  = new Player("James Burton", 1939);
		Player jimmy = new Player("Jimmy Page", 1944);
		Player keith = new Player("Keith Richards", 1943); 

		mustang.addPlayer(kurt);
		mustang.addPlayer(patti);
		mustang.addPlayer(johnny);
		mustang.addPlayer(thurston);

		jazzmaster.addPlayer(thurston);
		jazzmaster.addPlayer(mascis);
		jazzmaster.addPlayer(tom);
		jazzmaster.addPlayer(steph);
		jazzmaster.addPlayer(kurt);

		stratocaster.addPlayer(jim);
		stratocaster.addPlayer(clapton);
		stratocaster.addPlayer(jeff);
		stratocaster.addPlayer(ritch);
		stratocaster.addPlayer(srv);
		stratocaster.addPlayer(yngwie);
		
		telecaster.addPlayer(james);
		telecaster.addPlayer(clapton);
		telecaster.addPlayer(jeff);
		telecaster.addPlayer(srv);
		telecaster.addPlayer(thurston);
		telecaster.addPlayer(jimmy);
		telecaster.addPlayer(keith);
	}
}
