package jp.co.np.p2netex.sample1.allcommon.bhv.setup;

import jp.co.np.p2netex.sample1.allcommon.Sample1Entity;

/**
 * The interface of Value-Label Setupper.
 * @param <ENTITY> The type of entity.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample1ValueLabelSetupper<ENTITY extends Sample1Entity> {

    /**
     * Set up value-label.
     * @param box Value-label box. (NotNull)
     * @param entity Entity. (NotNull)
     */
    public void setup(Sample1ValueLabelBox box, ENTITY entity);
}
