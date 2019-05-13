package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_infinite_fireapp_model_realms_JobIdRealmProxy extends com.infinite.fireapp.model.realms.JobId
    implements RealmObjectProxy, com_infinite_fireapp_model_realms_JobIdRealmProxyInterface {

    static final class JobIdColumnInfo extends ColumnInfo {
        long idIndex;
        long jobIdIndex;
        long isVoiceMessageIndex;

        JobIdColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("JobId");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.jobIdIndex = addColumnDetails("jobId", "jobId", objectSchemaInfo);
            this.isVoiceMessageIndex = addColumnDetails("isVoiceMessage", "isVoiceMessage", objectSchemaInfo);
        }

        JobIdColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new JobIdColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final JobIdColumnInfo src = (JobIdColumnInfo) rawSrc;
            final JobIdColumnInfo dst = (JobIdColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.jobIdIndex = src.jobIdIndex;
            dst.isVoiceMessageIndex = src.isVoiceMessageIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private JobIdColumnInfo columnInfo;
    private ProxyState<com.infinite.fireapp.model.realms.JobId> proxyState;

    com_infinite_fireapp_model_realms_JobIdRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (JobIdColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.infinite.fireapp.model.realms.JobId>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$jobId() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.jobIdIndex);
    }

    @Override
    public void realmSet$jobId(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.jobIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.jobIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isVoiceMessage() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isVoiceMessageIndex);
    }

    @Override
    public void realmSet$isVoiceMessage(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isVoiceMessageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isVoiceMessageIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("JobId", 3, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("jobId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("isVoiceMessage", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static JobIdColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new JobIdColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "JobId";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "JobId";
    }

    @SuppressWarnings("cast")
    public static com.infinite.fireapp.model.realms.JobId createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.infinite.fireapp.model.realms.JobId obj = realm.createObjectInternal(com.infinite.fireapp.model.realms.JobId.class, true, excludeFields);

        final com_infinite_fireapp_model_realms_JobIdRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_JobIdRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                objProxy.realmSet$id(null);
            } else {
                objProxy.realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("jobId")) {
            if (json.isNull("jobId")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'jobId' to null.");
            } else {
                objProxy.realmSet$jobId((int) json.getInt("jobId"));
            }
        }
        if (json.has("isVoiceMessage")) {
            if (json.isNull("isVoiceMessage")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isVoiceMessage' to null.");
            } else {
                objProxy.realmSet$isVoiceMessage((boolean) json.getBoolean("isVoiceMessage"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.infinite.fireapp.model.realms.JobId createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.infinite.fireapp.model.realms.JobId obj = new com.infinite.fireapp.model.realms.JobId();
        final com_infinite_fireapp_model_realms_JobIdRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_JobIdRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
            } else if (name.equals("jobId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$jobId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'jobId' to null.");
                }
            } else if (name.equals("isVoiceMessage")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isVoiceMessage((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isVoiceMessage' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.infinite.fireapp.model.realms.JobId copyOrUpdate(Realm realm, com.infinite.fireapp.model.realms.JobId object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.infinite.fireapp.model.realms.JobId) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.infinite.fireapp.model.realms.JobId copy(Realm realm, com.infinite.fireapp.model.realms.JobId newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.infinite.fireapp.model.realms.JobId) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.infinite.fireapp.model.realms.JobId realmObject = realm.createObjectInternal(com.infinite.fireapp.model.realms.JobId.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_infinite_fireapp_model_realms_JobIdRealmProxyInterface realmObjectSource = (com_infinite_fireapp_model_realms_JobIdRealmProxyInterface) newObject;
        com_infinite_fireapp_model_realms_JobIdRealmProxyInterface realmObjectCopy = (com_infinite_fireapp_model_realms_JobIdRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$id(realmObjectSource.realmGet$id());
        realmObjectCopy.realmSet$jobId(realmObjectSource.realmGet$jobId());
        realmObjectCopy.realmSet$isVoiceMessage(realmObjectSource.realmGet$isVoiceMessage());
        return realmObject;
    }

    public static long insert(Realm realm, com.infinite.fireapp.model.realms.JobId object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.JobId.class);
        long tableNativePtr = table.getNativePtr();
        JobIdColumnInfo columnInfo = (JobIdColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.JobId.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$id = ((com_infinite_fireapp_model_realms_JobIdRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.jobIdIndex, rowIndex, ((com_infinite_fireapp_model_realms_JobIdRealmProxyInterface) object).realmGet$jobId(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isVoiceMessageIndex, rowIndex, ((com_infinite_fireapp_model_realms_JobIdRealmProxyInterface) object).realmGet$isVoiceMessage(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.JobId.class);
        long tableNativePtr = table.getNativePtr();
        JobIdColumnInfo columnInfo = (JobIdColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.JobId.class);
        com.infinite.fireapp.model.realms.JobId object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.JobId) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$id = ((com_infinite_fireapp_model_realms_JobIdRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.jobIdIndex, rowIndex, ((com_infinite_fireapp_model_realms_JobIdRealmProxyInterface) object).realmGet$jobId(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isVoiceMessageIndex, rowIndex, ((com_infinite_fireapp_model_realms_JobIdRealmProxyInterface) object).realmGet$isVoiceMessage(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.infinite.fireapp.model.realms.JobId object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.JobId.class);
        long tableNativePtr = table.getNativePtr();
        JobIdColumnInfo columnInfo = (JobIdColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.JobId.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$id = ((com_infinite_fireapp_model_realms_JobIdRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.jobIdIndex, rowIndex, ((com_infinite_fireapp_model_realms_JobIdRealmProxyInterface) object).realmGet$jobId(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isVoiceMessageIndex, rowIndex, ((com_infinite_fireapp_model_realms_JobIdRealmProxyInterface) object).realmGet$isVoiceMessage(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.JobId.class);
        long tableNativePtr = table.getNativePtr();
        JobIdColumnInfo columnInfo = (JobIdColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.JobId.class);
        com.infinite.fireapp.model.realms.JobId object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.JobId) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$id = ((com_infinite_fireapp_model_realms_JobIdRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.jobIdIndex, rowIndex, ((com_infinite_fireapp_model_realms_JobIdRealmProxyInterface) object).realmGet$jobId(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isVoiceMessageIndex, rowIndex, ((com_infinite_fireapp_model_realms_JobIdRealmProxyInterface) object).realmGet$isVoiceMessage(), false);
        }
    }

    public static com.infinite.fireapp.model.realms.JobId createDetachedCopy(com.infinite.fireapp.model.realms.JobId realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.infinite.fireapp.model.realms.JobId unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.infinite.fireapp.model.realms.JobId();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.infinite.fireapp.model.realms.JobId) cachedObject.object;
            }
            unmanagedObject = (com.infinite.fireapp.model.realms.JobId) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_infinite_fireapp_model_realms_JobIdRealmProxyInterface unmanagedCopy = (com_infinite_fireapp_model_realms_JobIdRealmProxyInterface) unmanagedObject;
        com_infinite_fireapp_model_realms_JobIdRealmProxyInterface realmSource = (com_infinite_fireapp_model_realms_JobIdRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$jobId(realmSource.realmGet$jobId());
        unmanagedCopy.realmSet$isVoiceMessage(realmSource.realmGet$isVoiceMessage());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("JobId = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{jobId:");
        stringBuilder.append(realmGet$jobId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isVoiceMessage:");
        stringBuilder.append(realmGet$isVoiceMessage());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_infinite_fireapp_model_realms_JobIdRealmProxy aJobId = (com_infinite_fireapp_model_realms_JobIdRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aJobId.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aJobId.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aJobId.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
