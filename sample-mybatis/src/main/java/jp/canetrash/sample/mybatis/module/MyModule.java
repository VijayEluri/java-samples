package jp.canetrash.sample.mybatis.module;

import static com.google.inject.name.Names.bindProperties;

import java.util.Properties;

import jp.canetrash.sample.mybatis.dao.GuitarDao;
import jp.canetrash.sample.mybatis.dao.GuitarDaoImpl;
import jp.canetrash.sample.mybatis.interceptor.SampleInterceptor;
import jp.canetrash.sample.mybatis.mapper.GuitarMapper;
import jp.canetrash.sample.mybatis.service.GuitarService;
import jp.canetrash.sample.mybatis.service.GuitarServiceImpl;

import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.UnpooledDataSourceProvider;

public class MyModule extends MyBatisModule {

	@Override
	protected void initialize() {
		bindDataSourceProviderType(UnpooledDataSourceProvider.class);
		bindTransactionFactoryType(JdbcTransactionFactory.class);

		addMapperClass(GuitarMapper.class);
		bind(GuitarDao.class).to(GuitarDaoImpl.class);
		bind(GuitarService.class).to(GuitarServiceImpl.class);

		bindProperties(binder(), createProperties());

		addInterceptorClass(SampleInterceptor.class);
		
	}

	protected Properties createProperties() {
		Properties myBatisProperties = new Properties();
        myBatisProperties.setProperty("mybatis.environment.id", "test");
		myBatisProperties.setProperty("JDBC.schema", "mybatis-guice");
		myBatisProperties.setProperty("JDBC.username", "");
		myBatisProperties.setProperty("JDBC.password", "");
		myBatisProperties.setProperty("JDBC.autoCommit", "false");

		myBatisProperties.setProperty("JDBC.driver", "org.sqlite.JDBC");
		myBatisProperties.setProperty("JDBC.url", "jdbc:sqlite:sample.db");
		return myBatisProperties;
	}
}
