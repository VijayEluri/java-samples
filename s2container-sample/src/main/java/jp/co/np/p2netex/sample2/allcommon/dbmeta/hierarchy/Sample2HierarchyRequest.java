package jp.co.np.p2netex.sample2.allcommon.dbmeta.hierarchy;


import java.util.ArrayList;
import java.util.List;

import jp.co.np.p2netex.sample2.allcommon.Sample2Entity;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMeta;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.hierarchy.basic.Sample2HierarchySourceEntityColumn;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.hierarchy.basic.Sample2HierarchySourceEntityListIterator;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.info.Sample2ColumnInfo;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.info.Sample2RelationInfo;

/**
 * The request of hierarchy.
 * 
 * @author DBFlute(AutoGenerator)
 * @param <LOCAL_ENTITY> The type of local entity.
 */
@SuppressWarnings("unchecked")
public class Sample2HierarchyRequest<LOCAL_ENTITY extends Sample2Entity> {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The dbmeta of desination. */
    protected Sample2DBMeta destinationDBMeta;

    /** The iterator of hierarychy source. */
    protected Sample2HierarchySourceIterator sourceIterator;

    /** The list of request element. */
    protected List<Sample2HierarchyRequestElement> requestElementList = new ArrayList<Sample2HierarchyRequestElement>();

    /** The set of already registered source column info for check. */
    protected java.util.Set<Sample2ColumnInfo> alreadyRegisteredSourceColumnInfoSet4Check = new java.util.HashSet<Sample2ColumnInfo>();

    /** First source column info for check. */
    protected Sample2ColumnInfo firstSourceColumnInfo4Check;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor.
     * 
     * @param localEntityType The type of local entity. (NotNull)
     */
    public Sample2HierarchyRequest(Class<LOCAL_ENTITY> localEntityType) {
        LOCAL_ENTITY localEntity;
        try {
            localEntity = localEntityType.newInstance();
        } catch (InstantiationException e) {
            String msg = "localEntityType.newInstance() threw the InstantiationException:";
            msg = msg + " localEntityType=" + localEntityType;
            throw new IllegalStateException(msg, e);
        } catch (IllegalAccessException e) {
            String msg = "localEntityType.newInstance() threw the IllegalAccessException:";
            msg = msg + " localEntityType=" + localEntityType;
            throw new IllegalStateException(msg, e);
        }
        destinationDBMeta = localEntity.getDBMeta();
    }

    // ===================================================================================
    //                                                                         Easy-to-Use
    //                                                                         ===========
    // -----------------------------------------------------
    //                                                public
    //                                                ------
    /**
     * Register the list of source. <br />
     * This method uses the default source iterator.
     * 
     * @param sourceList The list of source. (NotNull)
     * @param <SOURCE> The type of source. (NotNull)
     */
    public <SOURCE> void registerSourceList(java.util.List<SOURCE> sourceList) {
        sourceIterator = createDefaultSourceIterator(sourceList);
    }

    /**
     * Set up mapping between the source column and the destination relation.
     * 
     * @param sourceColumn The column of source. (NotNull)
     * @param relationTrace The relation trace of destination. (NotNull)
     */
    public void mapping(Sample2HierarchySourceColumn sourceColumn, Sample2DBMeta.RelationTrace relationTrace) {
        setupElement(sourceColumn, relationTrace.getTraceColumn());
        addRelationToLastElement(relationTrace.getTraceRelation());
    }

    /**
     * Set up mapping between the source column and the destination relation.
     * 
     * @param sourceColumnInfo The column info of source. (NotNull)
     * @param relationTrace The relation trace of destination. (NotNull)
     */
    public void mapping(Sample2ColumnInfo sourceColumnInfo, Sample2DBMeta.RelationTrace relationTrace) {
        setupElement(sourceColumnInfo, relationTrace.getTraceColumn());
        addRelationToLastElement(relationTrace.getTraceRelation());
    }

    // -----------------------------------------------------
    //                                               internal
    //                                               -------
    /**
     * Set up element.
     * 
     * @param sourceColumn The column of source. (NotNull)
     * @param destinationColumnInfo The column info of destination. (NotNull)
     */
    protected void setupElement(Sample2HierarchySourceColumn sourceColumn, Sample2ColumnInfo destinationColumnInfo) {
        assertSameLocalDestinationDBMeta(destinationColumnInfo);
        final Sample2HierarchyRequestElement element = new Sample2HierarchyRequestElement();
        requestElementList.add(element);
        element.mapping(sourceColumn, destinationColumnInfo);
        element.setDestinationDBMeta(destinationColumnInfo.getDBMeta());
    }

    /**
     * Set up element. <br />
     * This method uses the default source column.
     * 
     * @param sourceColumnInfo The column info of source. (NotNull)
     * @param destinationColumnInfo The column info of destination. (NotNull)
     */
    protected void setupElement(Sample2ColumnInfo sourceColumnInfo, Sample2ColumnInfo destinationColumnInfo) {
        if (alreadyRegisteredSourceColumnInfoSet4Check.contains(sourceColumnInfo)) {
            String msg = "The wrong sourceColumnInfo!" + getLineSeparator();
            msg = msg + "/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *" + getLineSeparator();
            msg = msg + "The source column has already been registered:" + getLineSeparator();
            msg = msg + "- - - - -" + getLineSeparator();
            msg = msg + " sourceColumnInfo=" + sourceColumnInfo + getLineSeparator();
            msg = msg + " registeredColumnInfo=" + alreadyRegisteredSourceColumnInfoSet4Check + getLineSeparator();
            msg = msg + "* * * * * * * * * */" + getLineSeparator();
            throw new IllegalStateException(msg);
        }
        alreadyRegisteredSourceColumnInfoSet4Check.add(sourceColumnInfo);
        assertSameSourceDBMeta(sourceColumnInfo);
        assertSameLocalDestinationDBMeta(destinationColumnInfo);
        final Sample2HierarchyRequestElement element = new Sample2HierarchyRequestElement();
        requestElementList.add(element);
        final Sample2HierarchySourceColumn sourceColumn = createDefaultSourceColumn(sourceColumnInfo);
        element.mapping(sourceColumn, destinationColumnInfo);
        element.setDestinationDBMeta(destinationColumnInfo.getDBMeta());
    }

    /**
     * Make relatetion by the list of relation info.
     * 
     * @param relationInfoList The list of relation info. (NotNull)
     */
    protected void addRelationToLastElement(List<Sample2RelationInfo> relationInfoList) {
        if (requestElementList.isEmpty()) {
            String msg = "You shuold invoke mapping() before invoking relation()!";
            throw new IllegalStateException(msg);
        }
        for (Sample2RelationInfo relationInfo : relationInfoList) {
            final int lastIndex = requestElementList.size() - 1;
            final Sample2HierarchyRequestElement element = (Sample2HierarchyRequestElement) requestElementList.get(lastIndex);
            element.relation(relationInfo);
        }
    }

    /**
     * Assert same source dbmeta.
     * 
     * @param sourceColumnInfo The column info of source. (NotNull)
     */
    protected void assertSameSourceDBMeta(Sample2ColumnInfo sourceColumnInfo) {
        if (firstSourceColumnInfo4Check == null) {
            firstSourceColumnInfo4Check = sourceColumnInfo;
            return;
        }
        final Sample2DBMeta expectedDBMeta = firstSourceColumnInfo4Check.getDBMeta();
        final Sample2DBMeta actualDBMeta = sourceColumnInfo.getDBMeta();
        if (!expectedDBMeta.equals(actualDBMeta)) {
            String msg = "The wrong sourceColumnInfo!" + getLineSeparator();
            msg = msg + "/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *" + getLineSeparator();
            msg = msg + "The dbmeta of sourceColumnInfo is difference from";
            msg = msg + " the one of Your First Source Column Info:" + getLineSeparator();
            msg = msg + "- - - - -" + getLineSeparator();
            msg = msg + "sourceColumnInfo=" + sourceColumnInfo + getLineSeparator();
            msg = msg + "firstSourceColumnInfo4Check=" + firstSourceColumnInfo4Check + getLineSeparator();
            msg = msg + "* * * * * * * * * */" + getLineSeparator();
            throw new IllegalStateException(msg);
        }
    }

    /**
     * Assert same source dbmeta.
     * @param destinationColumnInfo The column info of destination. (NotNull)
     */
    protected void assertSameLocalDestinationDBMeta(Sample2ColumnInfo destinationColumnInfo) {
        if (!requestElementList.isEmpty()) {
            final Sample2HierarchyRequestElement currentElement = currentElement();
            final List<Sample2RelationInfo> relationInfoList = currentElement.getRelationInfoList();
            if (relationInfoList.isEmpty()) {
                final Sample2DBMeta actualDBMeta = currentElement().getDestinationDBMeta();
                final Sample2DBMeta expectedDBMeta = destinationDBMeta;
                if (!expectedDBMeta.equals(actualDBMeta)) {
                    String msg = "The wrong destinationColumnInfo!" + getLineSeparator();
                    msg = msg + "/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *" + getLineSeparator();
                    msg = msg + "The dbmeta of destinationColumnInfo is difference from";
                    msg = msg + " the one of Your Local Entity:" + getLineSeparator();
                    msg = msg + "- - - - -" + getLineSeparator();
                    msg = msg + "destinationColumnInfo=" + currentElement.getDestinationColumnInfo() + getLineSeparator();
                    msg = msg + "localEntity=" + destinationDBMeta.getEntityTypeName() + getLineSeparator();
                    msg = msg + "* * * * * * * * * */" + getLineSeparator();
                    throw new IllegalStateException(msg);
                }
            }
        }
    }

    /**
     * @param sourceList The list of source. (NotNull)
     * @param <SOURCE> The type of source. (NotNull)
     * @return Default source iterator. (NotNull)
     */
    protected <SOURCE> Sample2HierarchySourceIterator createDefaultSourceIterator(java.util.List<SOURCE> sourceList) {
        return new Sample2HierarchySourceEntityListIterator<SOURCE>(sourceList);
    }

    /**
     * @param sourceColumnInfo The column info of source. (NotNull)
     * @return Default source column. (NotNull)
     */
    protected Sample2HierarchySourceColumn createDefaultSourceColumn(Sample2ColumnInfo sourceColumnInfo) {
        return new Sample2HierarchySourceEntityColumn(sourceColumnInfo);
    }

    /**
     * Get current element.
     * 
     * @return Current element. (NotNull)
     */
    protected Sample2HierarchyRequestElement currentElement() {
        final int lastIndex = requestElementList.size() - 1;
        return (Sample2HierarchyRequestElement) requestElementList.get(lastIndex);
    }

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /**
     * @param relationPropertyKey Relation Property key. (NotNull)
     * @return The list of request element. (NotNull)
     */
    public List<Sample2HierarchyRequestElement> findPrimaryKeyElement(String relationPropertyKey) {
        final List<Sample2HierarchyRequestElement> resultList = new ArrayList<Sample2HierarchyRequestElement>();
        for (Sample2HierarchyRequestElement element : requestElementList) {
            if (!relationPropertyKey.equals(element.getRelationPropertyKey())) {
                continue;
            }
            final Sample2ColumnInfo destinationColumnInfo = element.getDestinationColumnInfo();
            if (!destinationColumnInfo.isPrimary()) {
                continue;
            }
            resultList.add(element);
        }
        if (resultList.isEmpty()) {
            String msg = "Not found primary key element by relationPropertyKey in requestElementList: ";
            msg = msg + " relationPropertyKey=" + relationPropertyKey + " requestElementList=" + requestElementList;
            throw new IllegalStateException(msg);
        }
        return resultList;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public Sample2DBMeta getDestinationDBMeta() {
        return destinationDBMeta;
    }

    public void setDestinationDBMeta(Sample2DBMeta destinationDBMeta) {
        this.destinationDBMeta = destinationDBMeta;
    }

    public List<Sample2HierarchyRequestElement> getRequestElementList() {
        return requestElementList;
    }

    public void addRequestElementList(Sample2HierarchyRequestElement element) {
        this.requestElementList.add(element);
    }

    public Sample2HierarchySourceIterator getSourceIterator() {
        return sourceIterator;
    }

    public void setSourceIterator(Sample2HierarchySourceIterator sourceIterator) {
        this.sourceIterator = sourceIterator;
    }

    // ===================================================================================
    //                                                                              Helper
    //                                                                              ======
    /**
     * Get the value of line separator.
     * 
     * @return The value of line separator. (NotNull)
     */
    protected String getLineSeparator() {
        return System.getProperty("line.separator");
    }
}
