package jp.co.np.p2netex.sample2.allcommon.bhv.setup;

import jp.co.np.p2netex.sample2.allcommon.Sample2Entity;

/**
 * The interface of entity list setupper.
 * 
 * @param <ENTITY> The type of entity.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample2EntityListSetupper<ENTITY extends Sample2Entity> {

    /**
     * Set up entity list.
     * 
     * @param entityList Entity list. (NotNull)
     */
    public void setup(java.util.List<ENTITY> entityList);
}
