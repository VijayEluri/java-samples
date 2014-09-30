package jp.canetrash.quextractor.handler.impl.basic;

import jp.canetrash.quextractor.handler.AbstractMappingHandler;

/**
 * 必ずNullを返す
 * @version $Revision$
 * @author $Author$
 */
public class NullMappingHandler extends AbstractMappingHandler {

    public Object getData() {
        return null;
    }

}
