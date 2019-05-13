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
public class com_infinite_fireapp_model_realms_DeletedMessageRealmProxy extends com.infinite.fireapp.model.realms.DeletedMessage
    implements RealmObjectProxy, com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface {

    static final class DeletedMessageColumnInfo extends ColumnInfo {
        long messageIdIndex;

        DeletedMessageColumnInfo(OsSchemaInfo schemaInfo) {
            super(1);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("DeletedMessage");
            this.messageIdIndex = addColumnDetails("messageId", "messageId", objectSchemaInfo);
        }

        DeletedMessageColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new DeletedMessageColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final DeletedMessageColumnInfo src = (DeletedMessageColumnInfo) rawSrc;
            final DeletedMessageColumnInfo dst = (DeletedMessageColumnInfo) rawDst;
            dst.messageIdIndex = src.messageIdIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private DeletedMessageColumnInfo columnInfo;
    private ProxyState<com.infinite.fireapp.model.realms.DeletedMessage> proxyState;

    com_infinite_fireapp_model_realms_DeletedMessageRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (DeletedMessageColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.infinite.fireapp.model.realms.DeletedMessage>(this);
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

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("DeletedMessage", 1, 0);
        builder.addPersistedProperty("messageId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static DeletedMessageColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new DeletedMessageColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "DeletedMessage";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "DeletedMessage";
    }

    @SuppressWarnings("cast")
    public static com.infinite.fireapp.model.realms.DeletedMessage createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.infinite.fireapp.model.realms.DeletedMessage obj = null;
        if (update) {
            Table table = realm.getTable(com.infinite.fireapp.model.realms.DeletedMessage.class);
            DeletedMessageColumnInfo columnInfo = (DeletedMessageColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.DeletedMessage.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.DeletedMessage.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_infinite_fireapp_model_realms_DeletedMessageRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("messageId")) {
                if (json.isNull("messageId")) {
                    obj = (io.realm.com_infinite_fireapp_model_realms_DeletedMessageRealmProxy) realm.createObjectInternal(com.infinite.fireapp.model.realms.DeletedMessage.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_infinite_fireapp_model_realms_DeletedMessageRealmProxy) realm.createObjectInternal(com.infinite.fireapp.model.realms.DeletedMessage.class, json.getString("messageId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'messageId'.");
            }
        }

        final com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface) obj;
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.infinite.fireapp.model.realms.DeletedMessage createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.infinite.fireapp.model.realms.DeletedMessage obj = new com.infinite.fireapp.model.realms.DeletedMessage();
        final com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface) obj;
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

    public static com.infinite.fireapp.model.realms.DeletedMessage copyOrUpdate(Realm realm, com.infinite.fireapp.model.realms.DeletedMessage object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.infinite.fireapp.model.realms.DeletedMessage) cachedRealmObject;
        }

        com.infinite.fireapp.model.realms.DeletedMessage realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.infinite.fireapp.model.realms.DeletedMessage.class);
            DeletedMessageColumnInfo columnInfo = (DeletedMessageColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.DeletedMessage.class);
            long pkColumnIndex = columnInfo.messageIdIndex;
            String value = ((com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface) object).realmGet$messageId();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.DeletedMessage.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_infinite_fireapp_model_realms_DeletedMessageRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.infinite.fireapp.model.realms.DeletedMessage copy(Realm realm, com.infinite.fireapp.model.realms.DeletedMessage newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.infinite.fireapp.model.realms.DeletedMessage) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.infinite.fireapp.model.realms.DeletedMessage realmObject = realm.createObjectInternal(com.infinite.fireapp.model.realms.DeletedMessage.class, ((com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface) newObject).realmGet$messageId(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface realmObjectSource = (com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface) newObject;
        com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface realmObjectCopy = (com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface) realmObject;

        return realmObject;
    }

    public static long insert(Realm realm, com.infinite.fireapp.model.realms.DeletedMessage object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.DeletedMessage.class);
        long tableNativePtr = table.getNativePtr();
        DeletedMessageColumnInfo columnInfo = (DeletedMessageColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.DeletedMessage.class);
        long pkColumnIndex = columnInfo.messageIdIndex;
        String primaryKeyValue = ((com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface) object).realmGet$messageId();
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
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.DeletedMessage.class);
        long tableNativePtr = table.getNativePtr();
        DeletedMessageColumnInfo columnInfo = (DeletedMessageColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.DeletedMessage.class);
        long pkColumnIndex = columnInfo.messageIdIndex;
        com.infinite.fireapp.model.realms.DeletedMessage object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.DeletedMessage) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface) object).realmGet$messageId();
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
        }
    }

    public static long insertOrUpdate(Realm realm, com.infinite.fireapp.model.realms.DeletedMessage object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.DeletedMessage.class);
        long tableNativePtr = table.getNativePtr();
        DeletedMessageColumnInfo columnInfo = (DeletedMessageColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.DeletedMessage.class);
        long pkColumnIndex = columnInfo.messageIdIndex;
        String primaryKeyValue = ((com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface) object).realmGet$messageId();
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
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.DeletedMessage.class);
        long tableNativePtr = table.getNativePtr();
        DeletedMessageColumnInfo columnInfo = (DeletedMessageColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.DeletedMessage.class);
        long pkColumnIndex = columnInfo.messageIdIndex;
        com.infinite.fireapp.model.realms.DeletedMessage object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.DeletedMessage) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface) object).realmGet$messageId();
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
        }
    }

    public static com.infinite.fireapp.model.realms.DeletedMessage createDetachedCopy(com.infinite.fireapp.model.realms.DeletedMessage realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.infinite.fireapp.model.realms.DeletedMessage unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.infinite.fireapp.model.realms.DeletedMessage();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.infinite.fireapp.model.realms.DeletedMessage) cachedObject.object;
            }
            unmanagedObject = (com.infinite.fireapp.model.realms.DeletedMessage) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface unmanagedCopy = (com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface) unmanagedObject;
        com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface realmSource = (com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$messageId(realmSource.realmGet$messageId());

        return unmanagedObject;
    }

    static com.infinite.fireapp.model.realms.DeletedMessage update(Realm realm, com.infinite.fireapp.model.realms.DeletedMessage realmObject, com.infinite.fireapp.model.realms.DeletedMessage newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface realmObjectTarget = (com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface) realmObject;
        com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface realmObjectSource = (com_infinite_fireapp_model_realms_DeletedMessageRealmProxyInterface) newObject;
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("DeletedMessage = proxy[");
        stringBuilder.append("{messageId:");
        stringBuilder.append(realmGet$messageId() != null ? realmGet$messageId() : "null");
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
        com_infinite_fireapp_model_realms_DeletedMessageRealmProxy aDeletedMessage = (com_infinite_fireapp_model_realms_DeletedMessageRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aDeletedMessage.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aDeletedMessage.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aDeletedMessage.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
