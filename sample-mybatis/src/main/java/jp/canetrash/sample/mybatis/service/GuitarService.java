package jp.canetrash.sample.mybatis.service;

import java.util.List;

import jp.canetrash.sample.mybatis.mapper.GuitarMapper;
import jp.canetrash.sample.mybatis.model.Guitar;

public interface GuitarService {
	List<Guitar> all();

	Guitar findByPk(Integer i);

	
	int deleteAll();

	int delete(int i);
	
	int selectCount();

	int allCount();
	
	int insert(Guitar guitar);

	int update(Guitar guitar);
	
	GuitarMapper getGuitarMapper();
}
