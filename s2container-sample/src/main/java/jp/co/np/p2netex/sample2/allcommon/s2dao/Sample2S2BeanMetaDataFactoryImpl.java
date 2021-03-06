package jp.co.np.p2netex.sample2.allcommon.s2dao;

import java.sql.DatabaseMetaData;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.seasar.dao.BeanMetaData;
import org.seasar.dao.impl.BeanMetaDataImpl;
import org.seasar.dao.impl.BeanMetaDataFactoryImpl;

import jp.co.np.p2netex.sample2.allcommon.Sample2Entity;

/**
 * BeanMetaDataFactoryImpl for DBFlute.
 * @author DBFlute(AutoGenerator)
 */
 @SuppressWarnings("unchecked")
public class Sample2S2BeanMetaDataFactoryImpl extends BeanMetaDataFactoryImpl {

    protected Map<Class<? extends Sample2Entity>, BeanMetaData> _metaMap = Collections.synchronizedMap(new HashMap<Class<? extends Sample2Entity>, BeanMetaData>());

    @Override
    public BeanMetaData createBeanMetaData(Class beanClass) {
        final BeanMetaData cachedMeta = findCachedMeta(beanClass);
        if (cachedMeta != null) {
            return cachedMeta;
        } else {
            return super.createBeanMetaData(beanClass);
        }
    }
    
    @Override
    public BeanMetaData createBeanMetaData(Class beanClass, int relationNestLevel) {
        final BeanMetaData cachedMeta = findCachedMeta(beanClass);
        if (cachedMeta != null) {
            return cachedMeta;
        } else {
            return super.createBeanMetaData(beanClass, relationNestLevel);
        }
    }

    @Override
    public BeanMetaData createBeanMetaData(DatabaseMetaData dbMetaData, Class beanClass, int relationNestLevel) {
        final BeanMetaData cachedMeta = findOrCreateCachedMetaIfNeeds(dbMetaData, beanClass, relationNestLevel);
        if (cachedMeta != null) {
            return cachedMeta;
        } else {
            return super.createBeanMetaData(dbMetaData, beanClass, relationNestLevel);
        }
    }
    
    protected BeanMetaData findCachedMeta(Class beanClass) {
        if (isDBFluteEntity(beanClass)) {
            final BeanMetaData cachedMeta = getMetaFromCache(beanClass);
            if (cachedMeta != null) {
                return cachedMeta;
            }
        }
        return null;
    }
    
    protected BeanMetaData findOrCreateCachedMetaIfNeeds(DatabaseMetaData dbMetaData, Class beanClass, int relationNestLevel) {
        if (isDBFluteEntity(beanClass)) {
            final BeanMetaData cachedMeta = getMetaFromCache(beanClass);
            if (cachedMeta != null) {
                return cachedMeta;
            } else {
                return super.createBeanMetaData(dbMetaData, beanClass, 0);
            }
        }
        return null;
    }
	
    @Override
    protected BeanMetaDataImpl createBeanMetaDataImpl() {
        return new BeanMetaDataImpl() {
            @Override
            public void initialize() {
                final Class myBeanClass = getBeanClass();
                if (isDBFluteEntity(myBeanClass)) {
                    final BeanMetaData cachedMeta = getMetaFromCache(myBeanClass);
                    if (cachedMeta == null) {
                        _metaMap.put(myBeanClass, this);
                    }
                }
                super.initialize();
            }
        };
    }
	
	protected boolean isDBFluteEntity(Class beanClass) {
	    return Sample2Entity.class.isAssignableFrom(beanClass);
	}
	
	protected BeanMetaData getMetaFromCache(Class beanClass) {
	    return _metaMap.get(beanClass);
	}
	
    /**
     * Get the limit nest level of relation.
     * @return The limit nest level of relation.
     */
	@Override
    protected int getLimitRelationNestLevel() {
	    return 2;// for Compatible to old version DBFlute
    }
}