package jp.co.np.p2netex.sample2.allcommon.helper.collection.order;

/**
 * @author DBFlute(AutoGenerator)
 * @param <ELEMENT_TYPE> The type of element.
 * @param <ID_TYPE> The type of ID.
 */
public interface Sample2AccordingToOrderIdExtractor<ELEMENT_TYPE, ID_TYPE> {

    /**
     * Extract ID from the element instance.
     * 
     * @param element Element instance. (NotNull)
     * @return Extracted ID. (NotNull)
     */
    ID_TYPE extractId(ELEMENT_TYPE element);
}
