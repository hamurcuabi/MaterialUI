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
public class com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy extends com.infinite.fireapp.model.realms.UnUpdatedStat
    implements RealmObjectProxy, com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface {

    static final class UnUpdatedStatColumnInfo extends ColumnInfo {
        long messageIdIndex;
        long myUidIndex;
        long statToBeUpdatedIndex;

        UnUpdatedStatColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("UnUpdatedStat");
            this.messageIdIndex = addColumnDetails("messageId", "messageId", objectSchemaInfo);
            this.myUidIndex = addColumnDetails("myUid", "myUid", objectSchemaInfo);
            this.statToBeUpdatedIndex = addColumnDetails("statToBeUpdated", "statToBeUpdated", objectSchemaInfo);
        }

        UnUpdatedStatColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UnUpdatedStatColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UnUpdatedStatColumnInfo src = (UnUpdatedStatColumnInfo) rawSrc;
            final UnUpdatedStatColumnInfo dst = (UnUpdatedStatColumnInfo) rawDst;
            dst.messageIdIndex = src.messageIdIndex;
            dst.myUidIndex = src.myUidIndex;
            dst.statToBeUpdatedIndex = src.statToBeUpdatedIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UnUpdatedStatColumnInfo columnInfo;
    private ProxyState<com.infinite.fireapp.model.realms.UnUpdatedStat> proxyState;

    com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UnUpdatedStatColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.infinite.fireapp.model.realms.UnUpdatedStat>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$messageId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.messageIdIndex);
    }

    @Override
    public void realmSet$messageId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'messageId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$myUid() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.myUidIndex);
    }

    @Override
    public void realmSet$myUid(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.myUidIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.myUidIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.myUidIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.myUidIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$statToBeUpdated() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.statToBeUpdatedIndex);
    }

    @Override
    public void realmSet$statToBeUpdated(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.statToBeUpdatedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.statToBeUpdatedIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("UnUpdatedStat", 3, 0);
        builder.addPersistedProperty("messageId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("myUid", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("statToBeUpdated", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UnUpdatedStatColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UnUpdatedStatColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "UnUpdatedStat";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "UnUpdatedStat";
    }

    @SuppressWarnings("cast")
    public static com.infinite.fireapp.model.realms.UnUpdatedStat createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.infinite.fireapp.model.realms.UnUpdatedStat obj = null;
        if (update) {
            Table table = realm.getTable(com.infinite.fireapp.model.realms.UnUpdatedStat.class);
            UnUpdatedStatColumnInfo columnInfo = (UnUpdatedStatColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.UnUpdatedStat.class);
            long pkColumnIndex = columnInfo.messageIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("messageId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("messageId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.UnUpdatedStat.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("messageId")) {
                if (json.isNull("messageId")) {
                    obj = (io.realm.com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy) realm.createObjectInternal(com.infinite.fireapp.model.realms.UnUpdatedStat.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy) realm.createObjectInternal(com.infinite.fireapp.model.realms.UnUpdatedStat.class, json.getString("messageId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'messageId'.");
            }
        }

        final com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) obj;
        if (json.has("myUid")) {
            if (json.isNull("myUid")) {
                objProxy.realmSet$myUid(null);
            } else {
                objProxy.realmSet$myUid((String) json.getString("myUid"));
            }
        }
        if (json.has("statToBeUpdated")) {
            if (json.isNull("statToBeUpdated")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'statToBeUpdated' to null.");
            } else {
                objProxy.realmSet$statToBeUpdated((int) json.getInt("statToBeUpdated"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.infinite.fireapp.model.realms.UnUpdatedStat createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.infinite.fireapp.model.realms.UnUpdatedStat obj = new com.infinite.fireapp.model.realms.UnUpdatedStat();
        final com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("messageId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$messageId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$messageId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("myUid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$myUid((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$myUid(null);
                }
            } else if (name.equals("statToBeUpdated")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$statToBeUpdated((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'statToBeUpdated' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'messageId'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.infinite.fireapp.model.realms.UnUpdatedStat copyOrUpdate(Realm realm, com.infinite.fireapp.model.realms.UnUpdatedStat object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.infinite.fireapp.model.realms.UnUpdatedStat) cachedRealmObject;
        }

        com.infinite.fireapp.model.realms.UnUpdatedStat realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.infinite.fireapp.model.realms.UnUpdatedStat.class);
            UnUpdatedStatColumnInfo columnInfo = (UnUpdatedStatColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.UnUpdatedStat.class);
            long pkColumnIndex = columnInfo.messageIdIndex;
            String value = ((com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) object).realmGet$messageId();
            long rowIndex = Table.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, value);
            }
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.UnUpdatedStat.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.infinite.fireapp.model.realms.UnUpdatedStat copy(Realm realm, com.infinite.fireapp.model.realms.UnUpdatedStat newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.infinite.fireapp.model.realms.UnUpdatedStat) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.infinite.fireapp.model.realms.UnUpdatedStat realmObject = realm.createObjectInternal(com.infinite.fireapp.model.realms.UnUpdatedStat.class, ((com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) newObject).realmGet$messageId(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface realmObjectSource = (com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) newObject;
        com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface realmObjectCopy = (com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$myUid(realmObjectSource.realmGet$myUid());
        realmObjectCopy.realmSet$statToBeUpdated(realmObjectSource.realmGet$statToBeUpdated());
        return realmObject;
    }

    public static long insert(Realm realm, com.infinite.fireapp.model.realms.UnUpdatedStat object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.UnUpdatedStat.class);
        long tableNativePtr = table.getNativePtr();
        UnUpdatedStatColumnInfo columnInfo = (UnUpdatedStatColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.UnUpdatedStat.class);
        long pkColumnIndex = columnInfo.messageIdIndex;
        String primaryKeyValue = ((com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) object).realmGet$messageId();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$myUid = ((com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) object).realmGet$myUid();
        if (realmGet$myUid != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.myUidIndex, rowIndex, realmGet$myUid, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.statToBeUpdatedIndex, rowIndex, ((com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) object).realmGet$statToBeUpdated(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.UnUpdatedStat.class);
        long tableNativePtr = table.getNativePtr();
        UnUpdatedStatColumnInfo columnInfo = (UnUpdatedStatColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.UnUpdatedStat.class);
        long pkColumnIndex = columnInfo.messageIdIndex;
        com.infinite.fireapp.model.realms.UnUpdatedStat object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.UnUpdatedStat) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) object).realmGet$messageId();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$myUid = ((com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) object).realmGet$myUid();
            if (realmGet$myUid != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.myUidIndex, rowIndex, realmGet$myUid, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.statToBeUpdatedIndex, rowIndex, ((com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) object).realmGet$statToBeUpdated(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.infinite.fireapp.model.realms.UnUpdatedStat object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.UnUpdatedStat.class);
        long tableNativePtr = table.getNativePtr();
        UnUpdatedStatColumnInfo columnInfo = (UnUpdatedStatColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.UnUpdatedStat.class);
        long pkColumnIndex = columnInfo.messageIdIndex;
        String primaryKeyValue = ((com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) object).realmGet$messageId();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$myUid = ((com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) object).realmGet$myUid();
        if (realmGet$myUid != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.myUidIndex, rowIndex, realmGet$myUid, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.myUidIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.statToBeUpdatedIndex, rowIndex, ((com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) object).realmGet$statToBeUpdated(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.UnUpdatedStat.class);
        long tableNativePtr = table.getNativePtr();
        UnUpdatedStatColumnInfo columnInfo = (UnUpdatedStatColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.UnUpdatedStat.class);
        long pkColumnIndex = columnInfo.messageIdIndex;
        com.infinite.fireapp.model.realms.UnUpdatedStat object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.UnUpdatedStat) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) object).realmGet$messageId();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$myUid = ((com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) object).realmGet$myUid();
            if (realmGet$myUid != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.myUidIndex, rowIndex, realmGet$myUid, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.myUidIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.statToBeUpdatedIndex, rowIndex, ((com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) object).realmGet$statToBeUpdated(), false);
        }
    }

    public static com.infinite.fireapp.model.realms.UnUpdatedStat createDetachedCopy(com.infinite.fireapp.model.realms.UnUpdatedStat realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.infinite.fireapp.model.realms.UnUpdatedStat unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.infinite.fireapp.model.realms.UnUpdatedStat();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.infinite.fireapp.model.realms.UnUpdatedStat) cachedObject.object;
            }
            unmanagedObject = (com.infinite.fireapp.model.realms.UnUpdatedStat) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface unmanagedCopy = (com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) unmanagedObject;
        com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface realmSource = (com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$messageId(realmSource.realmGet$messageId());
        unmanagedCopy.realmSet$myUid(realmSource.realmGet$myUid());
        unmanagedCopy.realmSet$statToBeUpdated(realmSource.realmGet$statToBeUpdated());

        return unmanagedObject;
    }

    static com.infinite.fireapp.model.realms.UnUpdatedStat update(Realm realm, com.infinite.fireapp.model.realms.UnUpdatedStat realmObject, com.infinite.fireapp.model.realms.UnUpdatedStat newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface realmObjectTarget = (com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) realmObject;
        com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface realmObjectSource = (com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$myUid(realmObjectSource.realmGet$myUid());
        realmObjectTarget.realmSet$statToBeUpdated(realmObjectSource.realmGet$statToBeUpdated());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("UnUpdatedStat = proxy[");
        stringBuilder.append("{messageId:");
        stringBuilder.append(realmGet$messageId() != null ? realmGet$messageId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{myUid:");
        stringBuilder.append(realmGet$myUid() != null ? realmGet$myUid() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{statToBeUpdated:");
        stringBuilder.append(realmGet$statToBeUpdated());
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
        com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy aUnUpdatedStat = (com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aUnUpdatedStat.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUnUpdatedStat.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aUnUpdatedStat.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
