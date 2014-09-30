package jp.canetrash.sample.mybatis.dao;

import java.util.List;

import jp.canetrash.sample.mybatis.model.Guitar;

public interface GuitarDao {

	List<Guitar> selectAll();
    
	Guitar findByPk(Integer id);
	
	int deleteAll();

	int delete(int id);

	int selectCount();
	
	int insert(Guitar guitar);

	int update(Guitar guitar);
}
