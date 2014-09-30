package jp.canetrash.sample.mybatis;

import static com.google.inject.Guice.createInjector;
import static org.apache.ibatis.io.Resources.getResourceAsReader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.sql.DataSource;

import jp.canetrash.sample.mybatis.model.Guitar;
import jp.canetrash.sample.mybatis.module.MyModule;
import jp.canetrash.sample.mybatis.service.GuitarService;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Injector;

/**
 * Unit test for simple App.
 */
public class SampleTest {
	private Injector injector;

	private GuitarService guitarService;

	@Before
	public void setupMyBatisGuice() throws Exception {

		// bindings
		this.injector = createInjector(new MyModule());

		// prepare the test db
		Environment environment = this.injector
				.getInstance(SqlSessionFactory.class).getConfiguration()
				.getEnvironment();
		DataSource dataSource = environment.getDataSource();
		ScriptRunner runner = new ScriptRunner(dataSource.getConnection());
		runner.setAutoCommit(true);
		runner.setStopOnError(true);
		runner.runScript(getResourceAsReader("database-schema.sql"));
		runner.runScript(getResourceAsReader("database-test-data.sql"));
		runner.closeConnection();

		this.guitarService = this.injector.getInstance(GuitarService.class);
	}

	@Test
	public void testSimple() throws Exception {
		assertNotNull(this.guitarService);
		List<Guitar> actual = this.guitarService.all();
		assertEquals(3, actual.size());
	}

	@Test
	public void testSelectByPk() throws Exception {
		Guitar actual = this.guitarService.findByPk(1);
		assertEquals("フェンダー", actual.getName());
		assertEquals(new Integer(1), actual.getMakerId());
	}

	@Test
	public void testDelete() throws Exception {
		assertEquals(1, this.guitarService.delete(1));
	}

	@Test
	public void testDeleteAll() throws Exception {
		assertEquals(3, this.guitarService.deleteAll());
	}

	@Test
	public void testAllCount() throws Exception {
		assertEquals(3, this.guitarService.allCount());
	}

	@Test
	public void testInsert() throws Exception {
		Guitar guitar = new Guitar();
		guitar.setName("ヤイリ");
		guitar.setMakerId(8989);
		assertEquals(1, this.guitarService.insert(guitar));
		assertEquals(new Integer(4), guitar.getId());
	}

	@Test
	public void testUpdate() throws Exception {
		Guitar guitar = new Guitar();
		guitar.setId(1);
		guitar.setName("テストギター");
		guitar.setMakerId(99999999);
		assertEquals(1, this.guitarService.update(guitar));
		
		Guitar actual = this.guitarService.findByPk(1);
		assertNotNull(actual);
		
		assertEquals("テストギター", actual.getName());
		assertEquals(new Integer(99999999), actual.getMakerId());
	}
	
	@Test
	public void testDirectMapper() throws Exception {
		this.guitarService.getGuitarMapper().allCount();
	}
}
