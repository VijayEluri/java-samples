package jp.canetrash.sample.mybatis.service;

import java.util.List;

import javax.inject.Inject;

import jp.canetrash.sample.mybatis.dao.GuitarDao;
import jp.canetrash.sample.mybatis.mapper.GuitarMapper;
import jp.canetrash.sample.mybatis.model.Guitar;

import org.mybatis.guice.transactional.Transactional;

public class GuitarServiceImpl implements GuitarService {

	@Inject
	private GuitarDao guitarDao;

	@Inject
	private GuitarMapper guitarMapper;

	@Override
	@Transactional
	public List<Guitar> all() {
		return this.guitarDao.selectAll();
	}

	@Override
	public Guitar findByPk(Integer id) {
		return guitarDao.findByPk(id);

	}

	@Override
	public int deleteAll() {
		return this.guitarDao.deleteAll();
	}

	@Override
	public int delete(int id) {
		return this.guitarDao.delete(id);
	}

	@Override
	public int selectCount() {
		return this.guitarDao.selectCount();
	}

	@Override
	public int allCount() {
		return this.guitarDao.selectCount();
	}

	@Override
	public int insert(Guitar guitar) {
		return this.guitarDao.insert(guitar);
	}

	@Override
	public int update(Guitar guitar) {
		return this.guitarDao.update(guitar);
	}

	public GuitarMapper getGuitarMapper() {
		return guitarMapper;
	}
}
