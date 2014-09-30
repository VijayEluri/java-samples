package jp.co.np.p2netex.sample2.allcommon.bhv.setup;

import jp.co.np.p2netex.sample2.allcommon.Sample2Entity;

/**
 * The interface of Value-Label Setupper.
 * @param <ENTITY> The type of entity.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample2ValueLabelSetupper<ENTITY extends Sample2Entity> {

    /**
     * Set up value-label.
     * @param box Value-label box. (NotNull)
     * @param entity Entity. (NotNull)
     */
    public void setup(Sample2ValueLabelBox box, ENTITY entity);
}
