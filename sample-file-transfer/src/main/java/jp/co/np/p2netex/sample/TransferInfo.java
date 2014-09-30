package jp.co.np.p2netex.sample;

public class TransferInfo {

    /**
     * 取り出すファイルのパス
     */
    private String retrievePath;

    /**
     * 取り出すファイル名
     */
    private String retrieveFilaName;

    /**
     * 取り出したファイルの置き場所のパス
     */
    private String putPath;

    /**
     * 取り出したファイルの置き場所のファイル名
     */
    private String putFileName;

    public String getRetrievePath() {
        return retrievePath;
    }

    public void setRetrievePath(String retrievePath) {
        this.retrievePath = retrievePath;
    }

    public String getRetrieveFilaName() {
        return retrieveFilaName;
    }

    public void setRetrieveFilaName(String retrieveFilaName) {
        this.retrieveFilaName = retrieveFilaName;
    }

    public String getPutPath() {
        return putPath;
    }

    public void setPutPath(String putPath) {
        this.putPath = putPath;
    }

    public String getPutFileName() {
        return putFileName;
    }

    public void setPutFileName(String putFileName) {
        this.putFileName = putFileName;
    }

}
