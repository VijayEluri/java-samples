package jp.canetrash.quextractor.builder;

import jp.canetrash.quextractor.context.Context;


/**
 * データを作成するビルダー
 * @version $Revision$
 * @author $Author$
 */
public interface DataBuilder {
    
    void setContext(Context ctx);
    Context getContext();

    void execute();
    
}
