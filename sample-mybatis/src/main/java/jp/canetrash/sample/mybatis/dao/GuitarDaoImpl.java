package jp.canetrash.sample.mybatis.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import jp.canetrash.sample.mybatis.model.Guitar;

public class GuitarDaoImpl implements GuitarDao {

	private SqlSession sqlSession;

	@Inject
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Guitar> selectAll() {
		return this.sqlSession.selectList("guitarMapper.select");
	}

	@Override
	public Guitar findByPk(Integer id) {
		return (Guitar) this.sqlSession.selectOne("guitarMapper.findByPk", id);
	}

	@Override
	public int deleteAll() {
		return this.sqlSession.delete("guitarMapper.deleteAll");
	}

	@Override
	public int delete(int id) {
		return sqlSession.delete("guitarMapper.delete", id);
	}

	@Override
	public int selectCount() {
		return (Integer) sqlSession.selectOne("guitarMapper.allCount");
	}

	@Override
	public int insert(Guitar guitar) {
		return (Integer) sqlSession.insert("guitarMapper.insert", guitar);
	}

	@Override
	public int update(Guitar guitar) {
		return (Integer) sqlSession.update("guitarMapper.update", guitar);
	}
}
