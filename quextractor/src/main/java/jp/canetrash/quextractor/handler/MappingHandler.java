package jp.canetrash.quextractor.handler;

import jp.canetrash.quextractor.context.Context;


/**
 * マッピングを定義するハンドラー
 * @version $Revision$
 * @author $Author$
 */
public interface MappingHandler {
    /**
     * コンテキストを設定する
     * @param ctx
     */
    void setContext(Context ctx);
    
    /**
     * コンテキストを取得する
     * @return
     */
    Context getContext();

    /**
     * カラム名を設定する
     * @param culumnName
     */
    void setColumnName(String columnName);

    String getColumnName();

    /**
     * データを取得する
     * @return
     */
    Object getData();
    
    /**
     * JDBCタイプを設定する
     * @param type
     */
    void setSqlType(String type);

    /**
     * JDBCタイプを取得する
     * @return
     */
    String getSqlType();
    
    /**
     * デフォルトの値を設定する
     * @param value
     */
    void setDefaultValue(String value);
    
    /**
     * デフォルトの値を取得する
     * @return
     */
    String getDefaultValue();
}
