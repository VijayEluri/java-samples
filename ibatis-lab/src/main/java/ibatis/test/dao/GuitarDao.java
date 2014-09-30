package ibatis.test.dao;

import ibatis.test.bean.Guitar;

import java.util.List;

public interface GuitarDao {

	List<Guitar> findById(String id);

	void insert(Guitar guitar);

	void createTable();

	void dropTable();

}
