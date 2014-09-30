package jp.co.np.p2netex.sample1.allcommon.dbmeta.hierarchy;


import java.util.ArrayList;
import java.util.List;

import jp.co.np.p2netex.sample1.allcommon.Sample1Entity;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.Sample1DBMeta;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.hierarchy.basic.Sample1HierarchySourceEntityColumn;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.hierarchy.basic.Sample1HierarchySourceEntityListIterator;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.info.Sample1ColumnInfo;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.info.Sample1RelationInfo;

/**
 * The request of hierarchy.
 * 
 * @author DBFlute(AutoGenerator)
 * @param <LOCAL_ENTITY> The type of local entity.
 */
@SuppressWarnings("unchecked")
public class Sample1HierarchyRequest<LOCAL_ENTITY extends Sample1Entity> {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The dbmeta of desination. */
    protected Sample1DBMeta destinationDBMeta;

    /** The iterator of hierarychy source. */
    protected Sample1HierarchySourceIterator sourceIterator;

    /** The list of request element. */
    protected List<Sample1HierarchyRequestElement> requestElementList = new ArrayList<Sample1HierarchyRequestElement>();

    /** The set of already registered source column info for check. */
    protected java.util.Set<Sample1ColumnInfo> alreadyRegisteredSourceColumnInfoSet4Check = new java.util.HashSet<Sample1ColumnInfo>();

    /** First source column info for check. */
    protected Sample1ColumnInfo firstSourceColumnInfo4Check;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor.
     * 
     * @param localEntityType The type of local entity. (NotNull)
     */
    public Sample1HierarchyRequest(Class<LOCAL_ENTITY> localEntityType) {
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
    public void mapping(Sample1HierarchySourceColumn sourceColumn, Sample1DBMeta.RelationTrace relationTrace) {
        setupElement(sourceColumn, relationTrace.getTraceColumn());
        addRelationToLastElement(relationTrace.getTraceRelation());
    }

    /**
     * Set up mapping between the source column and the destination relation.
     * 
     * @param sourceColumnInfo The column info of source. (NotNull)
     * @param relationTrace The relation trace of destination. (NotNull)
     */
    public void mapping(Sample1ColumnInfo sourceColumnInfo, Sample1DBMeta.RelationTrace relationTrace) {
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
    protected void setupElement(Sample1HierarchySourceColumn sourceColumn, Sample1ColumnInfo destinationColumnInfo) {
        assertSameLocalDestinationDBMeta(destinationColumnInfo);
        final Sample1HierarchyRequestElement element = new Sample1HierarchyRequestElement();
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
    protected void setupElement(Sample1ColumnInfo sourceColumnInfo, Sample1ColumnInfo destinationColumnInfo) {
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
        final Sample1HierarchyRequestElement element = new Sample1HierarchyRequestElement();
        requestElementList.add(element);
        final Sample1HierarchySourceColumn sourceColumn = createDefaultSourceColumn(sourceColumnInfo);
        element.mapping(sourceColumn, destinationColumnInfo);
        element.setDestinationDBMeta(destinationColumnInfo.getDBMeta());
    }

    /**
     * Make relatetion by the list of relation info.
     * 
     * @param relationInfoList The list of relation info. (NotNull)
     */
    protected void addRelationToLastElement(List<Sample1RelationInfo> relationInfoList) {
        if (requestElementList.isEmpty()) {
            String msg = "You shuold invoke mapping() before invoking relation()!";
            throw new IllegalStateException(msg);
        }
        for (Sample1RelationInfo relationInfo : relationInfoList) {
            final int lastIndex = requestElementList.size() - 1;
            final Sample1HierarchyRequestElement element = (Sample1HierarchyRequestElement) requestElementList.get(lastIndex);
            element.relation(relationInfo);
        }
    }

    /**
     * Assert same source dbmeta.
     * 
     * @param sourceColumnInfo The column info of source. (NotNull)
     */
    protected void assertSameSourceDBMeta(Sample1ColumnInfo sourceColumnInfo) {
        if (firstSourceColumnInfo4Check == null) {
            firstSourceColumnInfo4Check = sourceColumnInfo;
            return;
        }
        final Sample1DBMeta expectedDBMeta = firstSourceColumnInfo4Check.getDBMeta();
        final Sample1DBMeta actualDBMeta = sourceColumnInfo.getDBMeta();
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
    protected void assertSameLocalDestinationDBMeta(Sample1ColumnInfo destinationColumnInfo) {
        if (!requestElementList.isEmpty()) {
            final Sample1HierarchyRequestElement currentElement = currentElement();
            final List<Sample1RelationInfo> relationInfoList = currentElement.getRelationInfoList();
            if (relationInfoList.isEmpty()) {
                final Sample1DBMeta actualDBMeta = currentElement().getDestinationDBMeta();
                final Sample1DBMeta expectedDBMeta = destinationDBMeta;
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
    protected <SOURCE> Sample1HierarchySourceIterator createDefaultSourceIterator(java.util.List<SOURCE> sourceList) {
        return new Sample1HierarchySourceEntityListIterator<SOURCE>(sourceList);
    }

    /**
     * @param sourceColumnInfo The column info of source. (NotNull)
     * @return Default source column. (NotNull)
     */
    protected Sample1HierarchySourceColumn createDefaultSourceColumn(Sample1ColumnInfo sourceColumnInfo) {
        return new Sample1HierarchySourceEntityColumn(sourceColumnInfo);
    }

    /**
     * Get current element.
     * 
     * @return Current element. (NotNull)
     */
    protected Sample1HierarchyRequestElement currentElement() {
        final int lastIndex = requestElementList.size() - 1;
        return (Sample1HierarchyRequestElement) requestElementList.get(lastIndex);
    }

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /**
     * @param relationPropertyKey Relation Property key. (NotNull)
     * @return The list of request element. (NotNull)
     */
    public List<Sample1HierarchyRequestElement> findPrimaryKeyElement(String relationPropertyKey) {
        final List<Sample1HierarchyRequestElement> resultList = new ArrayList<Sample1HierarchyRequestElement>();
        for (Sample1HierarchyRequestElement element : requestElementList) {
            if (!relationPropertyKey.equals(element.getRelationPropertyKey())) {
                continue;
            }
            final Sample1ColumnInfo destinationColumnInfo = element.getDestinationColumnInfo();
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
    public Sample1DBMeta getDestinationDBMeta() {
        return destinationDBMeta;
    }

    public void setDestinationDBMeta(Sample1DBMeta destinationDBMeta) {
        this.destinationDBMeta = destinationDBMeta;
    }

    public List<Sample1HierarchyRequestElement> getRequestElementList() {
        return requestElementList;
    }

    public void addRequestElementList(Sample1HierarchyRequestElement element) {
        this.requestElementList.add(element);
    }

    public Sample1HierarchySourceIterator getSourceIterator() {
        return sourceIterator;
    }

    public void setSourceIterator(Sample1HierarchySourceIterator sourceIterator) {
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
