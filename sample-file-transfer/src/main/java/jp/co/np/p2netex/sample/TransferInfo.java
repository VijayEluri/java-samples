package jp.co.np.p2netex.sample;

public class TransferInfo {

    /**
     * ���o���t�@�C���̃p�X
     */
    private String retrievePath;

    /**
     * ���o���t�@�C����
     */
    private String retrieveFilaName;

    /**
     * ���o�����t�@�C���̒u���ꏊ�̃p�X
     */
    private String putPath;

    /**
     * ���o�����t�@�C���̒u���ꏊ�̃t�@�C����
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
