package jp.canetrash.quextractor.builder.sql;

import jp.canetrash.quextractor.builder.AbstractDataBuilder;
import jp.canetrash.quextractor.util.Util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class FlowInstanceTableDataBuilder extends AbstractDataBuilder {
    protected static final Log log = LogFactory.getLog(FlowInstanceTableDataBuilder.class);

    public void execute() {
        StringBuffer header = new StringBuffer();
        header.append("INSERT INTO T_FLOW_INSTANCE (");
        StringBuffer value = new StringBuffer();
        value.append(" VALUES (");
        Object[] params = new Object[getMappingHandlers().length];

        for (int i = 0; i < getMappingHandlers().length; i++) {
            header.append(getMappingHandlers()[i].getColumnName());
            if (i < getMappingHandlers().length - 1 ) {
                header.append(",");
            }
            value.append("?");
            params[i] = getMappingHandlers()[i].getData();
            if (i < getMappingHandlers().length - 1 ) {
                value.append(",");
            }
        }
        header.append(") \n");
        value.append(")\n");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcTemplate.update(header.toString() + value.toString(), params);

        if (log.isDebugEnabled()) {
            log.debug("Params:" + Util.createToString(params));
            log.debug("Exec SQL:\n" + header.toString() + value.toString());
        }
    }
}
