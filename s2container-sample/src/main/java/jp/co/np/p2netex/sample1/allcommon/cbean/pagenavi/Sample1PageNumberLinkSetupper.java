package jp.co.np.p2netex.sample1.allcommon.cbean.pagenavi;

/**
 * The setupper of page number link.
 * @param <LINK> The type of link.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample1PageNumberLinkSetupper<LINK extends Sample1PageNumberLink> {

    /**
     * Set up page number link.
     * @param pageNumberElement Page number element.
     * @param current Is current page?
     * @return Page number link. (NotNull)
     */
    public LINK setup(int pageNumberElement, boolean current);
}
