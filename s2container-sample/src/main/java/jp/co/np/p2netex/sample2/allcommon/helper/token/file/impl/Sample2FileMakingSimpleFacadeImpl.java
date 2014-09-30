package jp.co.np.p2netex.sample2.allcommon.helper.token.file.impl;

import jp.co.np.p2netex.sample2.allcommon.helper.token.file.Sample2FileToken;

import jp.co.np.p2netex.sample2.allcommon.helper.token.file.Sample2FileMakingCallback;
import jp.co.np.p2netex.sample2.allcommon.helper.token.file.Sample2FileMakingOption;
import jp.co.np.p2netex.sample2.allcommon.helper.token.file.Sample2FileMakingRowResource;
import jp.co.np.p2netex.sample2.allcommon.helper.token.file.Sample2FileMakingSimpleFacade;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample2FileMakingSimpleFacadeImpl implements Sample2FileMakingSimpleFacade {

    protected Sample2FileToken _fileToken = new Sample2FileTokenImpl();

    public void setFileToken(Sample2FileToken fileToken) {
        this._fileToken = fileToken;
    }

    /**
     * Make token-file from row-list.
     * 
     * @param filename Output target file name. (NotNull)
     * @param rowList Row-list composed of value-list. (NotNull)
     * @param fileMakingOption File-making option. (NotNull and Required{encoding and delimiter})
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public void makeFromRowList(final String filename, final java.util.List<java.util.List<String>> rowList, final Sample2FileMakingOption fileMakingOption) throws java.io.FileNotFoundException, java.io.IOException {
        final Sample2FileMakingCallback fileMakingCallback = new Sample2FileMakingCallback() {
            protected int rowCount = 0;
            public Sample2FileMakingRowResource getRowResource() {
                ++rowCount;
                if (rowList.size() < rowCount) {
                    return null;// The End!
                }
                final java.util.List<String> valueList = (java.util.List<String>)rowList.get(rowCount - 1);
                final Sample2FileMakingRowResource fileMakingRowResource = new Sample2FileMakingRowResource();
                fileMakingRowResource.setValueList(valueList);
                return fileMakingRowResource;
            }
        };
        _fileToken.make(filename, fileMakingCallback, fileMakingOption);
    }

    /**
     * Make bytes from row-list.
     * 
     * @param rowList Row-list composed of value-list. (NotNull)
     * @param fileMakingOption File-making option. (NotNull and Required{encoding and delimiter})
     * @return Result byte array. (NotNull)
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public byte[] makeFromRowList(final java.util.List<java.util.List<String>> rowList, final Sample2FileMakingOption fileMakingOption) throws java.io.FileNotFoundException, java.io.IOException {
        final Sample2FileMakingCallback fileMakingCallback = new Sample2FileMakingCallback() {
            protected int rowCount = 0;
            public Sample2FileMakingRowResource getRowResource() {
                ++rowCount;
                if (rowList.size() < rowCount) {
                    return null;// The End!
                }
                final java.util.List<String> valueList = (java.util.List<String>)rowList.get(rowCount - 1);
                final Sample2FileMakingRowResource fileMakingRowResource = new Sample2FileMakingRowResource();
                fileMakingRowResource.setValueList(valueList);
                return fileMakingRowResource;
            }
        };
        final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        _fileToken.make(baos, fileMakingCallback, fileMakingOption);
        return baos.toByteArray();
    }
}
