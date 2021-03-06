package jp.co.np.p2netex.sample2.allcommon.bhv;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import jp.co.np.p2netex.sample2.allcommon.Sample2Entity;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ConditionBean;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMeta;
import jp.co.np.p2netex.sample2.allcommon.helper.Sample2MapStringBuilder;
import jp.co.np.p2netex.sample2.allcommon.helper.Sample2MapStringBuilderImpl;

import jp.co.np.p2netex.sample2.allcommon.bhv.batch.Sample2TokenFileReflectionOption;
import jp.co.np.p2netex.sample2.allcommon.bhv.batch.Sample2TokenFileReflectionResult;
import jp.co.np.p2netex.sample2.allcommon.bhv.batch.Sample2TokenFileReflectionFailure;

import jp.co.np.p2netex.sample2.allcommon.helper.token.file.Sample2FileToken;
import jp.co.np.p2netex.sample2.allcommon.helper.token.file.Sample2FileTokenizingCallback;
import jp.co.np.p2netex.sample2.allcommon.helper.token.file.Sample2FileTokenizingRowResource;
import jp.co.np.p2netex.sample2.allcommon.helper.token.file.Sample2FileTokenizingHeaderInfo;
import jp.co.np.p2netex.sample2.allcommon.helper.token.file.Sample2FileTokenizingOption;
import jp.co.np.p2netex.sample2.allcommon.helper.token.file.impl.Sample2FileTokenImpl;

/**
 * The abstract class of behavior-writable.
 * @author DBFlute(AutoGenerator)
 */
public abstract class Sample2AbstractBehaviorWritable extends Sample2AbstractBehaviorReadable implements Sample2BehaviorWritable {

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    // -----------------------------------------------------
    //                                                Create
    //                                                ------
    /**
     * Create.
     * @param entity Entity. (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void create(Sample2Entity entity) {
        doCreate(entity);
    }

    protected abstract void doCreate(Sample2Entity entity);

    // -----------------------------------------------------
    //                                                Modify
    //                                                ------
    /**
     * Modify.
     * @param entity Entity. (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void modify(Sample2Entity entity) {
        doModify(entity);
    }

    protected abstract void doModify(Sample2Entity entity);

    /**
     * Modify non strict.
     * @param entity Entity. (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void modifyNonstrict(Sample2Entity entity) {
        doModifyNonstrict(entity);
    }

    protected abstract void doModifyNonstrict(Sample2Entity entity);

    // -----------------------------------------------------
    //                                      Create or Modify
    //                                      ----------------
    /**
     * The implementation.
     * @param entity Entity. This must contain primary-key value at least(Except use identity). (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void createOrModify(jp.co.np.p2netex.sample2.allcommon.Sample2Entity entity) {
        assertEntityNotNull(entity);
        doCreateOrUpdate(entity);
    }

    protected abstract void doCreateOrUpdate(Sample2Entity entity);

    /**
     * The implementation.
     * @param entity Entity. This must contain primary-key value at least(Except use identity). (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyExistsException When the entity already exists. (Unique Constraint Violation)
     */
    public void createOrModifyNonstrict(jp.co.np.p2netex.sample2.allcommon.Sample2Entity entity) {
        assertEntityNotNull(entity);
        doCreateOrUpdateNonstrict(entity);
    }

    protected abstract void doCreateOrUpdateNonstrict(Sample2Entity entity);

    // -----------------------------------------------------
    //                                                Remove
    //                                                ------
    /**
     * Remove.
     * @param entity Entity. (NotNull)
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException When the entity has already been deleted.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException When the entity has been duplicated.
     */
    public void remove(jp.co.np.p2netex.sample2.allcommon.Sample2Entity entity) {
        assertEntityNotNull(entity);
        callRemove(entity);
    }

    protected abstract void doRemove(Sample2Entity entity);

    // ===================================================================================
    //                                                       Entity Update Internal Helper
    //                                                       =============================
    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected <ENTITY_TYPE extends Sample2Entity> void helpUpdateInternally(ENTITY_TYPE entity, InternalUpdateCallback<ENTITY_TYPE> callback) {
        assertEntityNotNull(entity);
        assertEntityHasVersionNoValue(entity);
        assertEntityHasUpdateDateValue(entity);
        final int updatedCount = callback.callbackDelegateUpdate(entity);
        if (updatedCount == 0) {
            String msg = "The entity was Not Found! it has already been deleted: entity=" + entity;
            throw new jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException(msg);
        } else if (updatedCount > 1) {
            String msg = "The entity was Too Many! it has been duplicated. It should be the only one! But the updatedCount=" + updatedCount;
            msg = msg + ": entity=" + entity;
            throw new jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityDuplicatedException(msg);
        }
    }

    protected static interface InternalUpdateCallback<ENTITY_TYPE extends Sample2Entity> {
        public int callbackDelegateUpdate(ENTITY_TYPE entity);
    }

    protected <ENTITY_TYPE extends Sample2Entity> void helpUpdateNonstrictInternally(ENTITY_TYPE entity, InternalUpdateNonstrictCallback<ENTITY_TYPE> callback) {
        assertEntityNotNull(entity);
        final int updatedCount = callback.callbackDelegateUpdateNonstrict(entity);
        if (updatedCount == 0) {
            String msg = "The entity was Not Found! it has already been deleted: entity=" + entity;
            throw new jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException(msg);
        } else if (updatedCount > 1) {
            String msg = "The entity was Too Many! it has been duplicated. It should be the only one! But the updatedCount=" + updatedCount;
            msg = msg + ": entity=" + entity;
        }
    }

    protected static interface InternalUpdateNonstrictCallback<ENTITY_TYPE extends Sample2Entity> {
        public int callbackDelegateUpdateNonstrict(ENTITY_TYPE entity);
    }

    // -----------------------------------------------------
    //                                        InsertOrUpdate
    //                                        --------------
    protected <ENTITY_TYPE extends Sample2Entity, CB_TYPE extends Sample2ConditionBean>
            void helpInsertOrUpdateInternally(ENTITY_TYPE entity, InternalInsertOrUpdateCallback<ENTITY_TYPE, CB_TYPE> callback) {
        assertEntityNotNull(entity);
        if (!entity.hasPrimaryKeyValue()) {
            callback.callbackInsert(entity);
        } else {
            RuntimeException exception = null;
            try {
                callback.callbackUpdate(entity);
            } catch (jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyUpdatedException e) {
                if (e.getRows() == 0) {
                    exception = e;
                }
            } catch (jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException e) {
                exception = e;
            } catch (IllegalStateException e) {
                exception = e;
            }
            if (exception != null) {
                final CB_TYPE cb = callback.callbackNewMyConditionBean();
                cb.acceptPrimaryKeyMapString(getDBMeta().extractPrimaryKeyMapString(entity));
                if (callback.callbackSelectCount(cb) == 0) {
                    callback.callbackInsert(entity);
                } else {
                    throw exception;
                }
            }
        }
    }

    protected static interface InternalInsertOrUpdateCallback<ENTITY_TYPE extends Sample2Entity, CB_TYPE extends Sample2ConditionBean> {
        public void callbackInsert(ENTITY_TYPE entity);
        public void callbackUpdate(ENTITY_TYPE entity);
        public CB_TYPE callbackNewMyConditionBean();
        public int callbackSelectCount(CB_TYPE cb);
    }

    protected <ENTITY_TYPE extends Sample2Entity> void helpInsertOrUpdateInternally(ENTITY_TYPE entity, InternalInsertOrUpdateNonstrictCallback<ENTITY_TYPE> callback) {
        assertEntityNotNull(entity);
        if (!entity.hasPrimaryKeyValue()) {
            callback.callbackInsert(entity);
        } else {
            try {
                callback.callbackUpdateNonstrict(entity);
            } catch (jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyUpdatedException e) {
                callback.callbackInsert(entity);
            } catch (jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException e) {
                callback.callbackInsert(entity);
            }
        }
    }

    protected static interface InternalInsertOrUpdateNonstrictCallback<ENTITY_TYPE extends Sample2Entity> {
        public void callbackInsert(ENTITY_TYPE entity);
        public void callbackUpdateNonstrict(ENTITY_TYPE entity);
    }

    // -----------------------------------------------------
    //                                                Delete
    //                                                ------
    protected <ENTITY_TYPE extends Sample2Entity> void helpDeleteInternally(ENTITY_TYPE entity, InternalDeleteCallback<ENTITY_TYPE> callback) {
        assertEntityNotNull(entity);
        assertEntityHasVersionNoValue(entity);
        assertEntityHasUpdateDateValue(entity);
        final int deletedCount = callback.callbackDelegateDelete(entity);
        if (deletedCount == 0) {
            String msg = "The entity was Not Found! The entity has already been deleted: entity=" + entity;
            throw new jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException(msg);
        } else if (deletedCount > 1) {
            String msg = "The deleted entity was duplicated. It should be the only one! But the deletedCount=" + deletedCount;
            msg = msg + ": entity=" + entity;
        }
    }

    protected static interface InternalDeleteCallback<ENTITY_TYPE extends Sample2Entity> {
        public int callbackDelegateDelete(ENTITY_TYPE entity);
    }

    protected <ENTITY_TYPE extends Sample2Entity> void helpDeleteNonstrictInternally(ENTITY_TYPE entity, InternalDeleteNonstrictCallback<ENTITY_TYPE> callback) {
        assertEntityNotNull(entity);
        final int deletedCount = callback.callbackDelegateDeleteNonstrict(entity);
        if (deletedCount == 0) {
            String msg = "The entity was Not Found! The entity has already been deleted: entity=" + entity;
            throw new jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyDeletedException(msg);
        } else if (deletedCount > 1) {
            String msg = "The deleted entity was duplicated. It should be the only one! But the deletedCount=" + deletedCount;
            msg = msg + ": entity=" + entity;
        }
    }

    protected static interface InternalDeleteNonstrictCallback<ENTITY_TYPE extends Sample2Entity> {
        public int callbackDelegateDeleteNonstrict(ENTITY_TYPE entity);
    }

    protected <ENTITY_TYPE extends Sample2Entity> void helpDeleteNonstrictIgnoreDeletedInternally(ENTITY_TYPE entity, InternalDeleteNonstrictIgnoreDeletedCallback<ENTITY_TYPE> callback) {
        assertEntityNotNull(entity);
        final int deletedCount = callback.callbackDelegateDeleteNonstrict(entity);
        if (deletedCount == 0) {
            return;
        } else if (deletedCount > 1) {
            String msg = "The deleted entity was duplicated. It should be the only one! But the deletedCount=" + deletedCount;
            msg = msg + ": entity=" + entity;
        }
    }

    protected static interface InternalDeleteNonstrictIgnoreDeletedCallback<ENTITY_TYPE extends Sample2Entity> {
        public int callbackDelegateDeleteNonstrict(ENTITY_TYPE entity);
    }


    // ===================================================================================
    //                                                                         Lump Update
    //                                                                         ===========
    /**
     * Lump create the list.
     * @param entityList Entity list. (NotNull and NotEmpty)
     * @return The array of created count.
     */
    public int[] lumpCreate(java.util.List<Sample2Entity> entityList) {
        assertListNotNullAndNotEmpty(entityList);
        return callCreateList(entityList);
    }

    /**
     * Lump Modify the list.
     * @param entityList Entity list. (NotNull and NotEmpty)
     * @return Modified count.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyUpdatedException If s2dao's version is over 1.0.47 (contains 1.0.47).
     */
    public int[] lumpModify(java.util.List<Sample2Entity> entityList) {
        assertListNotNullAndNotEmpty(entityList);
        return callModifyList(entityList);
    }

    /**
     * Lump remove the list.
     * @param entityList Entity list. (NotNull and NotEmpty)
     * @return Removed count.
     * @exception jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyUpdatedException If s2dao's version is over 1.0.47 (contains 1.0.47).
     */
    public int[] lumpRemove(java.util.List<Sample2Entity> entityList) {
        assertListNotNullAndNotEmpty(entityList);
        return callRemoveList(entityList);
    }

    /**
     * Inject sequence to primary key if it needs.
     * @param entity Entity. (NotNull)
     */
    protected void injectSequenceToPrimaryKeyIfNeeds(Sample2Entity entity) {
        final Sample2DBMeta dbmeta = entity.getDBMeta();
        if (!dbmeta.hasSequence() || dbmeta.hasTwoOrMorePrimaryKeys() || entity.hasPrimaryKeyValue()) {
            return;
        }
        final java.math.BigDecimal sequenceValue = readNextVal();
        final String columnDbName = dbmeta.getPrimaryUniqueInfo().getFirstColumn().getColumnDbName();
        final java.util.Map<String, String> map = new java.util.HashMap<String, String>();
        map.put(columnDbName, sequenceValue.toString());
        dbmeta.acceptPrimaryKeyMap(entity, map);
    }

    // =====================================================================================
    //                                                                            Token File
    //                                                                            ==========
    public TokenFileReflectionExecutor tokenFileReflection() {
        return new TokenFileReflectionExecutor();
    }

    public class TokenFileReflectionExecutor {

        /**
         * Reflect(insert or update) token-file to this table.
         * @param filename Name of the file. (NotNull and NotEmpty)
         * @param tokenFileReflectionOption token-file-reflection-option. (NotNull and Required{delimiter and encoding})
         * @return Token-file-reflection-result. (NotNull)
         * @throws java.io.FileNotFoundException
         * @throws java.io.IOException
         */
        public Sample2TokenFileReflectionResult reflectTokenFile(String filename, Sample2TokenFileReflectionOption tokenFileReflectionOption) throws java.io.FileNotFoundException, java.io.IOException {
            assertStringNotNullAndNotTrimmedEmpty("filename", filename);
            assertFileTokenReflectionOption(tokenFileReflectionOption);

            final Sample2TokenFileReflectionResult result = buildTokenFileReflectionResult();
            final Sample2FileTokenizingCallback fileTokenizingCallback = buildFileTokenReflectionFileTokenizingCallback(tokenFileReflectionOption, result);
            final Sample2FileTokenizingOption fileTokenizingOption = buildFileTokenReflectionFileTokenizingOption(tokenFileReflectionOption);
            final Sample2FileToken fileToken = new Sample2FileTokenImpl();
            fileToken.tokenize(filename, fileTokenizingCallback, fileTokenizingOption);
            return result;
        }

        /**
         * Reflect(insert or update) token-file to this table.
         * @param inputStream Input stream. (NotNull and NotClosed)
         * @param tokenFileReflectionOption token-file-reflection-option. (NotNull and Required{delimiter and encoding})
         * @return Token-file-reflection-result. (NotNull)
         * @throws java.io.FileNotFoundException
         * @throws java.io.IOException
         */
        public Sample2TokenFileReflectionResult reflectTokenFile(java.io.InputStream inputStream, Sample2TokenFileReflectionOption tokenFileReflectionOption) throws java.io.FileNotFoundException, java.io.IOException {
            assertObjectNotNull("inputStream", inputStream);
            assertFileTokenReflectionOption(tokenFileReflectionOption);

            final Sample2TokenFileReflectionResult result = buildTokenFileReflectionResult();
            final Sample2FileTokenizingCallback fileTokenizingCallback = buildFileTokenReflectionFileTokenizingCallback(tokenFileReflectionOption, result);
            final Sample2FileTokenizingOption fileTokenizingOption = buildFileTokenReflectionFileTokenizingOption(tokenFileReflectionOption);
            final Sample2FileToken fileToken = new Sample2FileTokenImpl();
            fileToken.tokenize(inputStream, fileTokenizingCallback, fileTokenizingOption);
            return result;
        }

        protected void assertFileTokenReflectionOption(Sample2TokenFileReflectionOption tokenFileReflectionOption) {
            assertObjectNotNull("tokenFileReflectionOption", tokenFileReflectionOption);

            final String encoding = tokenFileReflectionOption.getEncoding();
            final String delimiter = tokenFileReflectionOption.getDelimiter();
            assertStringNotNullAndNotTrimmedEmpty("encoding", encoding);
            assertObjectNotNull("delimiter", delimiter);
        }

        protected Sample2TokenFileReflectionResult buildTokenFileReflectionResult() {
            final Sample2TokenFileReflectionResult result = new Sample2TokenFileReflectionResult();
            final java.util.List<Sample2TokenFileReflectionFailure> failureList = new java.util.ArrayList<Sample2TokenFileReflectionFailure>();
            result.setFailureList(failureList);
            return result;
        }

        protected Sample2FileTokenizingCallback buildFileTokenReflectionFileTokenizingCallback(Sample2TokenFileReflectionOption tokenFileReflectionOption, final Sample2TokenFileReflectionResult result) throws java.io.FileNotFoundException, java.io.IOException {
            assertObjectNotNull("tokenFileReflectionOption", tokenFileReflectionOption);

            final String encoding = tokenFileReflectionOption.getEncoding();
            final String delimiter = tokenFileReflectionOption.getDelimiter();
            final boolean interruptIfError = tokenFileReflectionOption.isInterruptIfError();
            assertStringNotNullAndNotTrimmedEmpty("encoding", encoding);
            assertObjectNotNull("delimiter", delimiter);
            final java.util.List<Sample2TokenFileReflectionFailure> failureList = result.getFailureList();
            assertObjectNotNull("failureList", failureList);

            final Sample2FileTokenizingCallback fileTokenizingCallback = new Sample2FileTokenizingCallback() {
                public void handleRowResource(Sample2FileTokenizingRowResource fileTokenizingRowResource) {
                    final Sample2FileTokenizingHeaderInfo fileTokenizingHeaderInfo = fileTokenizingRowResource.getFileTokenizingHeaderInfo();
                    final java.util.List<String> columnNameList = fileTokenizingHeaderInfo.getColumnNameList();
                    final java.util.List<String> valueList = fileTokenizingRowResource.getValueList();

                    // Set up columnNameList of result object.
                    if (result.getColumnNameList() == null) {
                        result.setColumnNameList(columnNameList);
                    }

                    Sample2Entity entity = null;
                    try {
                        // Create entity by the list of value composed of String.
                        entity = createEntityByStringValueList(columnNameList, valueList);

                        // Create or modify as non-strict.
                        doCreateOrUpdateNonstrict(entity);

                        // Increment successCount of result object.
                        result.incrementSuccessCount();
                    } catch (RuntimeException e) {
                        if (interruptIfError) {
                            throw e;
                        }
                        final Sample2TokenFileReflectionFailure failure = new Sample2TokenFileReflectionFailure();
                        failure.setColumnNameList(columnNameList);
                        failure.setValueList(valueList);
                        failure.setRowString(fileTokenizingRowResource.getRowString());
                        failure.setRowNumber(fileTokenizingRowResource.getRowNumber());
                        failure.setLineNumber(fileTokenizingRowResource.getLineNumber());
                        if (entity != null) {
                            failure.setEntity(entity);
                        }
                        failure.setException(e);
                        failureList.add(failure);
                    }
                }
            };
            return fileTokenizingCallback;
        }

        protected Sample2Entity createEntityByStringValueList(java.util.List<String> columnNameList, java.util.List<String> valueList) {
            final Sample2MapStringBuilder builder = new Sample2MapStringBuilderImpl();
            builder.setMsMapMark(MAP_STRING_MAP_MARK);
            builder.setMsStartBrace(MAP_STRING_START_BRACE);
            builder.setMsEndBrace(MAP_STRING_END_BRACE);
            builder.setMsDelimiter(MAP_STRING_DELIMITER);
            builder.setMsEqual(MAP_STRING_EQUAL);
            builder.setColumnNameList(columnNameList);
            final String mapString = builder.buildFromList(valueList);

            final Sample2Entity entity = getDBMeta().newEntity();
            getDBMeta().acceptColumnValueMapString(entity, mapString);
            return entity;
        }

        protected Sample2FileTokenizingOption buildFileTokenReflectionFileTokenizingOption(Sample2TokenFileReflectionOption tokenFileReflectionOption) throws java.io.FileNotFoundException, java.io.IOException {
            assertObjectNotNull("tokenFileReflectionOption", tokenFileReflectionOption);

            final String encoding = tokenFileReflectionOption.getEncoding();
            final String delimiter = tokenFileReflectionOption.getDelimiter();
            assertStringNotNullAndNotTrimmedEmpty("encoding", encoding);
            assertObjectNotNull("delimiter", delimiter);

            final Sample2FileTokenizingOption fileTokenizingOption = new Sample2FileTokenizingOption();
            fileTokenizingOption.setEncoding(encoding);
            fileTokenizingOption.setDelimiter(delimiter);
            if (tokenFileReflectionOption.isHandleEmptyAsNull()) {
                fileTokenizingOption.handleEmptyAsNull();
            }
            return fileTokenizingOption;
        }
    }


    // =====================================================================================
    //                                                                       Delegate Method
    //                                                                       ===============
    // -----------------------------------------------------
    //                                                Insert
    //                                                ------
    /**
     * The implementation.
     * @param entity Entity that the type is entity interface. (NotNull)
     * @return Inserted count.
     */
    protected int callCreate(Sample2Entity entity) {
        if (!processBeforeInsert(entity)) { return 1;/*as Normal End*/ }
        return getDaoWritable().create(entity);
    }

    /**
     * Process before insert.
     * @param entity Entity that the type is entity interface. (NotNull)
     * @return Execution Determination. (true: execute / false: non)
     */
    protected boolean processBeforeInsert(Sample2Entity entity) {
        if (!determineExecuteInsert(entity)) { return false; }
        assertEntityNotNull(entity);// If this table use identity, the entity does not have primary-key.
        frameworkFilterEntityOfInsert(entity);
        filterEntityOfInsert(entity);
        assertEntityOfInsert(entity);
        return true;
    }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    /**
     * The implementation.
     * {modified only}
     * @param entity Entity that the type is entity interface. (NotNull)
     * @return Updated count.
     */
    protected int callModify(Sample2Entity entity) {
        if (!processBeforeUpdate(entity)) { return 1;/*as Normal End*/ }
        return getDaoWritable().modifyModifiedOnly(entity);
    }

    /**
     * Process before update.
     * @param entity Entity that the type is entity interface. (NotNull)
     * @return Execution Determination. (true: execute / false: non)
     */
    protected boolean processBeforeUpdate(Sample2Entity entity) {
        if (!determineExecuteUpdate(entity)) { return false; }
        assertEntityNotNullAndHasPrimaryKeyValue(entity);
        frameworkFilterEntityOfUpdate(entity);
        filterEntityOfUpdate(entity);
        assertEntityOfUpdate(entity);
        return true;
    }

    // -----------------------------------------------------
    //                                                Delete
    //                                                ------
    /**
     * The implementation.
     * @param entity Entity that the type is entity interface. (NotNull)
     * @return Deleted count.
     */
    protected int callRemove(Sample2Entity entity) {
        if (!processBeforeDelete(entity)) { return 1;/*as Normal End*/ }
        return getDaoWritable().remove(entity);
    }

    /**
     * Process before delete.
     * @param entity Entity that the type is entity interface. (NotNull)
     * @return Execution Determination. (true: execute / false: non)
     */
    protected boolean processBeforeDelete(Sample2Entity entity) {
        if (!determineExecuteDelete(entity)) { return false; }
        assertEntityNotNullAndHasPrimaryKeyValue(entity);
        frameworkFilterEntityOfDelete(entity);
        filterEntityOfDelete(entity);
        assertEntityOfDelete(entity);
        return true;
    }

    // -----------------------------------------------------
    //                                    Pre-Process Insert
    //                                    ------------------
    /**
     * Determine execution of insert.
     * @param entity Entity. (NotNull)
     * @return Execution Determination. (true: execute / false: non)
     */
    protected boolean determineExecuteInsert(Sample2Entity entity) {
        return true;
    }

    /**
     * {Framework Method} Filter the entity of insert.
     * @param targetEntity Target entity that the type is entity interface. (NotNull)
     */
    protected void frameworkFilterEntityOfInsert(Sample2Entity targetEntity) {
        injectSequenceToPrimaryKeyIfNeeds(targetEntity);
		setupCommonColumnOfInsertIfNeeds(targetEntity);
    }

    /**
     * Set up common columns of insert if it needs.
     * @param targetEntity Target entity that the type is entity interface. (NotNull)
     */
	protected void setupCommonColumnOfInsertIfNeeds(Sample2Entity targetEntity) {
	}
	
    /**
     * Filter the entity of insert.
     * @param targetEntity Target entity that the type is entity interface. (NotNull)
     */
    protected void filterEntityOfInsert(Sample2Entity targetEntity) {
    }

    /**
     * Assert the entity of insert.
     * @param entity Entity that the type is entity interface. (NotNull)
     */
    protected void assertEntityOfInsert(Sample2Entity entity) {
    }

    // -----------------------------------------------------
    //                                    Pre-Process Update
    //                                    ------------------
    /**
     * Determine execution of update.
     * @param entity Entity. (NotNull)
     * @return Execution Determination. (true: execute / false: non)
     */
    protected boolean determineExecuteUpdate(Sample2Entity entity) {
        return true;
    }

    /**
     * {Framework Method} Filter the entity of update.
     * @param targetEntity Target entity that the type is entity interface. (NotNull)
     */
    protected void frameworkFilterEntityOfUpdate(Sample2Entity targetEntity) {
	    setupCommonColumnOfUpdateIfNeeds(targetEntity);
    }

    /**
     * Set up common columns of update if it needs.
     * @param targetEntity Target entity that the type is entity interface. (NotNull)
     */
	protected void setupCommonColumnOfUpdateIfNeeds(Sample2Entity targetEntity) {
	}
	
    /**
     * Filter the entity of update.
     * @param targetEntity Target entity that the type is entity interface. (NotNull)
     */
    protected void filterEntityOfUpdate(Sample2Entity targetEntity) {
    }

    /**
     * Assert the entity of update.
     * @param entity Entity that the type is entity interface. (NotNull)
     */
    protected void assertEntityOfUpdate(Sample2Entity entity) {
    }

    // -----------------------------------------------------
    //                                    Pre-Process Delete
    //                                    ------------------
    /**
     * Determine execution of delete.
     * @param entity Entity. (NotNull)
     * @return Execution Determination. (true: execute / false: non)
     */
    protected boolean determineExecuteDelete(Sample2Entity entity) {
        return true;
    }

    /**
     * {Framework Method} Filter the entity of delete.
     * @param targetEntity Target entity that the type is entity interface. (NotNull)
     */
    protected void frameworkFilterEntityOfDelete(Sample2Entity targetEntity) {
    }
	
    /**
     * Filter the entity of delete.
     * @param targetEntity Target entity that the type is entity interface. (NotNull)
     */
    protected void filterEntityOfDelete(Sample2Entity targetEntity) {
    }

    /**
     * Assert the entity of delete.
     * @param entity Entity that the type is entity interface. (NotNull)
     */
    protected void assertEntityOfDelete(Sample2Entity entity) {
    }


    /**
     * The implementation.
     * @param entityList Entity list that the type is entity interface. (NotNull)
     * @return Inserted count.
     */
    public int[] callCreateList(java.util.List<Sample2Entity> entityList) {
        assertObjectNotNull("entityList", entityList);
        helpFilterBeforeInsertInternally(entityList);
        return getDaoWritable().createList(entityList);
    }

    /**
     * The implementation.
     * @param entityList Entity list that the type is entity interface. (NotNull)
     * @return Updated count.
     */
    public int[] callModifyList(java.util.List<Sample2Entity> entityList) {
        assertObjectNotNull("entityList", entityList);
        helpFilterBeforeUpdateInternally(entityList);
        return getDaoWritable().modifyList(entityList);
    }

    /**
     * The implementation.
     * @param entityList Entity list that the type is entity interface. (NotNull)
     * @return Deleted count.
     */
    public int[] callRemoveList(java.util.List<Sample2Entity> entityList) {
        assertObjectNotNull("entityList", entityList);
        helpFilterBeforeDeleteInternally(entityList);
        return getDaoWritable().removeList(entityList);
    }

    protected void assertEntityHasVersionNoValue(Sample2Entity entity) {
        if (!getDBMeta().hasVersionNo()) {
            return;
        }
        if (hasVersionNoValue(entity)) {
            return;
        }
        String msg = "Look! Read the message below." + getLineSeparator();
        msg = msg + "/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *" + getLineSeparator();
        msg = msg + "The value of 'version no' on the entity was Not Found!" + getLineSeparator() + getLineSeparator();
        msg = msg + "[Advice]" + getLineSeparator();
        msg = msg + "Please confirm the existence of the value of 'version no' on the entity." + getLineSeparator();
        msg = msg + "You called the method in which the check for optimistic lock is indispensable. " + getLineSeparator();
        msg = msg + "So 'version no' is required on the entity. " + getLineSeparator();
        msg = msg + "In addition, please confirm the necessity of optimistic lock. It might possibly be unnecessary." + getLineSeparator() + getLineSeparator();
        msg = msg + "[Entity]" + getLineSeparator();
        msg = msg + "entity to string = " + entity + getLineSeparator();
        msg = msg + "entity to map    = " + entity.getDBMeta().convertToColumnValueMap(entity) + getLineSeparator();
        msg = msg + "* * * * * * * * * */" + getLineSeparator();
        throw new IllegalStateException(msg);
    }

    protected void assertEntityHasUpdateDateValue(Sample2Entity entity) {
        if (!getDBMeta().hasUpdateDate()) {
            return;
        }
        if (hasUpdateDateValue(entity)) {
            return;
        }
        String msg = "Look! Read the message below." + getLineSeparator();
        msg = msg + "/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *" + getLineSeparator();
        msg = msg + "The value of 'update date' on the entity was Not Found!" + getLineSeparator() + getLineSeparator();
        msg = msg + "[Advice]" + getLineSeparator();
        msg = msg + "Please confirm the existence of the value of 'update date' on the entity." + getLineSeparator();
        msg = msg + "You called the method in which the check for optimistic lock is indispensable. " + getLineSeparator();
        msg = msg + "So 'update date' is required on the entity. " + getLineSeparator();
        msg = msg + "In addition, please confirm the necessity of optimistic lock. It might possibly be unnecessary." + getLineSeparator() + getLineSeparator();
        msg = msg + "[Entity]" + getLineSeparator();
        msg = msg + "entity to string = " + entity + getLineSeparator();
        msg = msg + "entity to map    = " + entity.getDBMeta().convertToColumnValueMap(entity) + getLineSeparator();
        msg = msg + "* * * * * * * * * */" + getLineSeparator();
        throw new IllegalStateException(msg);
    }

    // ===================================================================================
    //                                                     Delegate Method Internal Helper
    //                                                     ===============================
    protected <ENTITY extends Sample2Entity> List<ENTITY> helpFilterBeforeInsertInternally(List<ENTITY> entityList) {
	    final List<ENTITY> filteredList = new ArrayList<ENTITY>();
        for (final Iterator<ENTITY> ite = entityList.iterator(); ite.hasNext(); ) {
            final ENTITY entity = ite.next();
            if (!processBeforeInsert(entity)) { continue; }
			filteredList.add(entity);
        }
		return filteredList;
    }

    protected <ENTITY extends Sample2Entity> List<ENTITY> helpFilterBeforeUpdateInternally(List<ENTITY> entityList) {
	    final List<ENTITY> filteredList = new ArrayList<ENTITY>();
        for (final Iterator<ENTITY> ite = entityList.iterator(); ite.hasNext(); ) {
            final ENTITY entity = ite.next();
            if (!processBeforeUpdate(entity)) { continue; }
			filteredList.add(entity);
        }
		return filteredList;
    }

    protected <ENTITY extends Sample2Entity> List<ENTITY> helpFilterBeforeDeleteInternally(List<ENTITY> entityList) {
		final List<ENTITY> filteredList = new ArrayList<ENTITY>();
        for (final Iterator<ENTITY> ite = entityList.iterator(); ite.hasNext(); ) {
            final ENTITY entity = ite.next();
            if (!processBeforeDelete(entity)) { continue; }
			filteredList.add(entity);
        }
		return filteredList;
    }
}
