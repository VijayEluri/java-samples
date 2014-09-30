package jp.canetrash.sample.mybatis.mapper;

import java.util.List;

import jp.canetrash.sample.mybatis.model.Guitar;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface GuitarMapper {

	List<Guitar> select();

	@Select("SELECT * FROM GUITAR WHERE ID = #{id}")
	@ResultMap("guitarResultMap")
	Guitar findByPk(Integer id);

	@Insert("INSERT INTO GUITAR (ID, NAME, MAKER_ID) VALUES (#{id}, #{name}, #{makerId})")
	@SelectKey(statement = "select max(id) + 1 from guitar", keyProperty = "id", before = true, resultType = int.class)
	void insert(Guitar guitar);

	@Update("UPDATE GUITAR SET NAME=#{name}, MAKER_ID= #{makerId} WHERE ID = #{id}")
	void update(Guitar guitar);

	@Delete("delete from guitar where id = #{id}")
	void delete(Integer id);

	void deleteAll();

	@Select("select count(*) from guitar")
	int allCount();
}
