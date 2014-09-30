package jp.co.np.p2netex.sample2.allcommon.helper.token.file;

/**
 * @author DBFlute(AutoGenerator)
 */
public interface Sample2FileMakingCallback {

    /**
     * Get file-making header information.
     * <pre>
     * You should return your row resource for file-making.
     * It continues invoking until this method returns null.
     * </pre>
     * @return File-making header information. (Nullable)
     */
    public Sample2FileMakingRowResource getRowResource();
}
