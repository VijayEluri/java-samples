package jp.co.np.p2netex.sample1.allcommon.bhv.setup;

import jp.co.np.p2netex.sample1.allcommon.Sample1Entity;

/**
 * The interface of entity list setupper.
 * 
 * @param <ENTITY> The type of entity.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample1EntityListSetupper<ENTITY extends Sample1Entity> {

    /**
     * Set up entity list.
     * 
     * @param entityList Entity list. (NotNull)
     */
    public void setup(java.util.List<ENTITY> entityList);
}
