package jp.co.np.p2netex.sample2.allcommon.cbean.sqlclause;


import jp.co.np.p2netex.sample2.allcommon.dbmeta.info.Sample2ColumnInfo;

/**
 * The interface of simple filter for where clause.
 * 
 * @author DBFlute(AutoGenerator)
 */
public interface Sample2WhereClauseSimpleFilter {

    public static final String BIND_COMMENT_BEGIN_PART = "/*dto";
    public static final String BIND_COMMENT_END_PART = "*/null";

    public static final String EMBEDDED_COMMENT_BEGIN_PART = "/*$dto";
    public static final String EMBEDDED_COMMENT_END_PART = "*/null";

    public static final String EMBEDDED_COMMENT_QUOTED_BEGIN_PART = "'/*$dto";
    public static final String EMBEDDED_COMMENT_QUOTED_END_PART = "*/'dummy''";

    /**
     * Filter clause element.
     * 
     * @param clauseElement Clause element of where. (NotNull and NotEmpty)
     * @return Filtered where clause. (NotNull and NotEmpty)
     */
    public String filterClauseElement(String clauseElement);

    /**
     * The simple filter for where clause to embedded. <br />
     * *Attension -- Target column is not perfect. This class determines by column name only!
     * So when the column name of base table is same as the column name of join table, both are target!
     * 
     * @author DBFlute(AutoGenerator)
     */
    public static class WhereClauseToEmbeddedSimpleFilter implements Sample2WhereClauseSimpleFilter {

        protected java.util.Set<Sample2ColumnInfo> _filterTargetColumnInfoSet;

        public WhereClauseToEmbeddedSimpleFilter(Sample2ColumnInfo filterTargetColumnInfo) {
            this._filterTargetColumnInfoSet = new java.util.HashSet<Sample2ColumnInfo>();
            this._filterTargetColumnInfoSet.add(filterTargetColumnInfo);
        }

        public WhereClauseToEmbeddedSimpleFilter(java.util.Set<Sample2ColumnInfo> filterTargetColumnInfoSet) {
            this._filterTargetColumnInfoSet = filterTargetColumnInfoSet;
        }

        /**
         * Filter clause element.
         * 
         * @param clauseElement Clause element of where. (NotNull and NotEmpty)
         * @return Filtered where clause. (NotNull and NotEmpty)
         */
        public String filterClauseElement(String clauseElement) {
            if (_filterTargetColumnInfoSet == null || _filterTargetColumnInfoSet.isEmpty()) {
                return toEmbedded(clauseElement);
            }
            for (final java.util.Iterator<Sample2ColumnInfo> ite = _filterTargetColumnInfoSet.iterator(); ite.hasNext(); ) {
                final Sample2ColumnInfo columnInfo = (Sample2ColumnInfo)ite.next();
                if (isTargetClause(clauseElement, columnInfo.getColumnDbName())) {
                    return toEmbedded(clauseElement);
                }
            }
            return clauseElement;
        }

        protected boolean isTargetClause(String clauseElement, final String columnDbName) {
            return clauseElement.indexOf("." + columnDbName + " ") >= 0;
        }

        protected String toEmbedded(String clauseElement) {
            clauseElement = replace(clauseElement, BIND_COMMENT_BEGIN_PART, EMBEDDED_COMMENT_BEGIN_PART);
            clauseElement = replace(clauseElement, BIND_COMMENT_END_PART, EMBEDDED_COMMENT_END_PART);
            return clauseElement;
        }

        protected final String replace(String text, String fromText,
                String toText) {

            if (text == null || fromText == null || toText == null) {
                return null;
            }
            StringBuffer buf = new StringBuffer(100);
            int pos = 0;
            int pos2 = 0;
            while (true) {
                pos = text.indexOf(fromText, pos2);
                if (pos == 0) {
                    buf.append(toText);
                    pos2 = fromText.length();
                } else if (pos > 0) {
                    buf.append(text.substring(pos2, pos));
                    buf.append(toText);
                    pos2 = pos + fromText.length();
                } else {
                    buf.append(text.substring(pos2));
                    break;
                }
            }
            return buf.toString();
        }
    }

    /**
     * The simple filter for where clause to embedded and quoted. <br />
     * *Attension -- Target column is not perfect. This class determines by column name only!
     * So when the column name of base table is same as the column name of join table, both are target!
     * 
     * @author DBFlute(AutoGenerator)
     */
    public static class WhereClauseToEmbeddedQuotedSimpleFilter extends WhereClauseToEmbeddedSimpleFilter {

        public WhereClauseToEmbeddedQuotedSimpleFilter(Sample2ColumnInfo filterTargetColumnInfo) {
            super(filterTargetColumnInfo);
        }

        public WhereClauseToEmbeddedQuotedSimpleFilter(java.util.Set<Sample2ColumnInfo> filterTargetColumnInfoSet) {
            super(filterTargetColumnInfoSet);
        }

        protected String toEmbedded(String clauseElement) {
            clauseElement = replace(clauseElement, BIND_COMMENT_BEGIN_PART, EMBEDDED_COMMENT_QUOTED_BEGIN_PART);
            clauseElement = replace(clauseElement, BIND_COMMENT_END_PART, EMBEDDED_COMMENT_QUOTED_END_PART);
            return clauseElement;
        }
    }
}
