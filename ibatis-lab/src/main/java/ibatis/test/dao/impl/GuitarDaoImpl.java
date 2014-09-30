package ibatis.test.dao.impl;

import ibatis.test.bean.Guitar;
import ibatis.test.dao.GuitarDao;

import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

public class GuitarDaoImpl extends SqlMapClientTemplate implements GuitarDao {

    /**
     * {@inheritDoc}
     */
    public void createTable() {
        update("Guitar.createTable");
    }

    /**
     * {@inheritDoc}
     */
    public void dropTable() {
        update("Guitar.dropTable");
    }

    /**
     * {@inheritDoc}
     */
    public List<Guitar> findById(String id) {
        return queryForList("Guitar.findById", id);
    }

    /**
     * {@inheritDoc}
     */
    public void insert(Guitar guitar) {
        insert("Guitar.insert", guitar);

    }

}
