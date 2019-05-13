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
public class com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy extends com.infinite.fireapp.model.realms.PendingGroupJob
    implements RealmObjectProxy, com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface {

    static final class PendingGroupJobColumnInfo extends ColumnInfo {
        long groupIdIndex;
        long typeIndex;
        long groupEventIndex;

        PendingGroupJobColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PendingGroupJob");
            this.groupIdIndex = addColumnDetails("groupId", "groupId", objectSchemaInfo);
            this.typeIndex = addColumnDetails("type", "type", objectSchemaInfo);
            this.groupEventIndex = addColumnDetails("groupEvent", "groupEvent", objectSchemaInfo);
        }

        PendingGroupJobColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PendingGroupJobColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PendingGroupJobColumnInfo src = (PendingGroupJobColumnInfo) rawSrc;
            final PendingGroupJobColumnInfo dst = (PendingGroupJobColumnInfo) rawDst;
            dst.groupIdIndex = src.groupIdIndex;
            dst.typeIndex = src.typeIndex;
            dst.groupEventIndex = src.groupEventIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PendingGroupJobColumnInfo columnInfo;
    private ProxyState<com.infinite.fireapp.model.realms.PendingGroupJob> proxyState;

    com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PendingGroupJobColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.infinite.fireapp.model.realms.PendingGroupJob>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$groupId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.groupIdIndex);
    }

    @Override
    public void realmSet$groupId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'groupId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$type() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.typeIndex);
    }

    @Override
    public void realmSet$type(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.typeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.typeIndex, value);
    }

    @Override
    public com.infinite.fireapp.model.realms.GroupEvent realmGet$groupEvent() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.groupEventIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.infinite.fireapp.model.realms.GroupEvent.class, proxyState.getRow$realm().getLink(columnInfo.groupEventIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$groupEvent(com.infinite.fireapp.model.realms.GroupEvent value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("groupEvent")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.groupEventIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.groupEventIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.groupEventIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.groupEventIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PendingGroupJob", 3, 0);
        builder.addPersistedProperty("groupId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("type", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedLinkProperty("groupEvent", RealmFieldType.OBJECT, "GroupEvent");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PendingGroupJobColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PendingGroupJobColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PendingGroupJob";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PendingGroupJob";
    }

    @SuppressWarnings("cast")
    public static com.infinite.fireapp.model.realms.PendingGroupJob createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.infinite.fireapp.model.realms.PendingGroupJob obj = null;
        if (update) {
            Table table = realm.getTable(com.infinite.fireapp.model.realms.PendingGroupJob.class);
            PendingGroupJobColumnInfo columnInfo = (PendingGroupJobColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.PendingGroupJob.class);
            long pkColumnIndex = columnInfo.groupIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("groupId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("groupId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.PendingGroupJob.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("groupEvent")) {
                excludeFields.add("groupEvent");
            }
            if (json.has("groupId")) {
                if (json.isNull("groupId")) {
                    obj = (io.realm.com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy) realm.createObjectInternal(com.infinite.fireapp.model.realms.PendingGroupJob.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy) realm.createObjectInternal(com.infinite.fireapp.model.realms.PendingGroupJob.class, json.getString("groupId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'groupId'.");
            }
        }

        final com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) obj;
        if (json.has("type")) {
            if (json.isNull("type")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'type' to null.");
            } else {
                objProxy.realmSet$type((int) json.getInt("type"));
            }
        }
        if (json.has("groupEvent")) {
            if (json.isNull("groupEvent")) {
                objProxy.realmSet$groupEvent(null);
            } else {
                com.infinite.fireapp.model.realms.GroupEvent groupEventObj = com_infinite_fireapp_model_realms_GroupEventRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("groupEvent"), update);
                objProxy.realmSet$groupEvent(groupEventObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.infinite.fireapp.model.realms.PendingGroupJob createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.infinite.fireapp.model.realms.PendingGroupJob obj = new com.infinite.fireapp.model.realms.PendingGroupJob();
        final com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("groupId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$groupId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$groupId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("type")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$type((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'type' to null.");
                }
            } else if (name.equals("groupEvent")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$groupEvent(null);
                } else {
                    com.infinite.fireapp.model.realms.GroupEvent groupEventObj = com_infinite_fireapp_model_realms_GroupEventRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$groupEvent(groupEventObj);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'groupId'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.infinite.fireapp.model.realms.PendingGroupJob copyOrUpdate(Realm realm, com.infinite.fireapp.model.realms.PendingGroupJob object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.infinite.fireapp.model.realms.PendingGroupJob) cachedRealmObject;
        }

        com.infinite.fireapp.model.realms.PendingGroupJob realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.infinite.fireapp.model.realms.PendingGroupJob.class);
            PendingGroupJobColumnInfo columnInfo = (PendingGroupJobColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.PendingGroupJob.class);
            long pkColumnIndex = columnInfo.groupIdIndex;
            String value = ((com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) object).realmGet$groupId();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.PendingGroupJob.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.infinite.fireapp.model.realms.PendingGroupJob copy(Realm realm, com.infinite.fireapp.model.realms.PendingGroupJob newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.infinite.fireapp.model.realms.PendingGroupJob) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.infinite.fireapp.model.realms.PendingGroupJob realmObject = realm.createObjectInternal(com.infinite.fireapp.model.realms.PendingGroupJob.class, ((com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) newObject).realmGet$groupId(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface realmObjectSource = (com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) newObject;
        com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface realmObjectCopy = (com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$type(realmObjectSource.realmGet$type());

        com.infinite.fireapp.model.realms.GroupEvent groupEventObj = realmObjectSource.realmGet$groupEvent();
        if (groupEventObj == null) {
            realmObjectCopy.realmSet$groupEvent(null);
        } else {
            com.infinite.fireapp.model.realms.GroupEvent cachegroupEvent = (com.infinite.fireapp.model.realms.GroupEvent) cache.get(groupEventObj);
            if (cachegroupEvent != null) {
                realmObjectCopy.realmSet$groupEvent(cachegroupEvent);
            } else {
                realmObjectCopy.realmSet$groupEvent(com_infinite_fireapp_model_realms_GroupEventRealmProxy.copyOrUpdate(realm, groupEventObj, update, cache));
            }
        }
        return realmObject;
    }

    public static long insert(Realm realm, com.infinite.fireapp.model.realms.PendingGroupJob object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.PendingGroupJob.class);
        long tableNativePtr = table.getNativePtr();
        PendingGroupJobColumnInfo columnInfo = (PendingGroupJobColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.PendingGroupJob.class);
        long pkColumnIndex = columnInfo.groupIdIndex;
        String primaryKeyValue = ((com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) object).realmGet$groupId();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) object).realmGet$type(), false);

        com.infinite.fireapp.model.realms.GroupEvent groupEventObj = ((com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) object).realmGet$groupEvent();
        if (groupEventObj != null) {
            Long cachegroupEvent = cache.get(groupEventObj);
            if (cachegroupEvent == null) {
                cachegroupEvent = com_infinite_fireapp_model_realms_GroupEventRealmProxy.insert(realm, groupEventObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.groupEventIndex, rowIndex, cachegroupEvent, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.PendingGroupJob.class);
        long tableNativePtr = table.getNativePtr();
        PendingGroupJobColumnInfo columnInfo = (PendingGroupJobColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.PendingGroupJob.class);
        long pkColumnIndex = columnInfo.groupIdIndex;
        com.infinite.fireapp.model.realms.PendingGroupJob object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.PendingGroupJob) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) object).realmGet$groupId();
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
            Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) object).realmGet$type(), false);

            com.infinite.fireapp.model.realms.GroupEvent groupEventObj = ((com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) object).realmGet$groupEvent();
            if (groupEventObj != null) {
                Long cachegroupEvent = cache.get(groupEventObj);
                if (cachegroupEvent == null) {
                    cachegroupEvent = com_infinite_fireapp_model_realms_GroupEventRealmProxy.insert(realm, groupEventObj, cache);
                }
                table.setLink(columnInfo.groupEventIndex, rowIndex, cachegroupEvent, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.infinite.fireapp.model.realms.PendingGroupJob object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.PendingGroupJob.class);
        long tableNativePtr = table.getNativePtr();
        PendingGroupJobColumnInfo columnInfo = (PendingGroupJobColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.PendingGroupJob.class);
        long pkColumnIndex = columnInfo.groupIdIndex;
        String primaryKeyValue = ((com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) object).realmGet$groupId();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) object).realmGet$type(), false);

        com.infinite.fireapp.model.realms.GroupEvent groupEventObj = ((com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) object).realmGet$groupEvent();
        if (groupEventObj != null) {
            Long cachegroupEvent = cache.get(groupEventObj);
            if (cachegroupEvent == null) {
                cachegroupEvent = com_infinite_fireapp_model_realms_GroupEventRealmProxy.insertOrUpdate(realm, groupEventObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.groupEventIndex, rowIndex, cachegroupEvent, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.groupEventIndex, rowIndex);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.PendingGroupJob.class);
        long tableNativePtr = table.getNativePtr();
        PendingGroupJobColumnInfo columnInfo = (PendingGroupJobColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.PendingGroupJob.class);
        long pkColumnIndex = columnInfo.groupIdIndex;
        com.infinite.fireapp.model.realms.PendingGroupJob object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.PendingGroupJob) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) object).realmGet$groupId();
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
            Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) object).realmGet$type(), false);

            com.infinite.fireapp.model.realms.GroupEvent groupEventObj = ((com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) object).realmGet$groupEvent();
            if (groupEventObj != null) {
                Long cachegroupEvent = cache.get(groupEventObj);
                if (cachegroupEvent == null) {
                    cachegroupEvent = com_infinite_fireapp_model_realms_GroupEventRealmProxy.insertOrUpdate(realm, groupEventObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.groupEventIndex, rowIndex, cachegroupEvent, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.groupEventIndex, rowIndex);
            }
        }
    }

    public static com.infinite.fireapp.model.realms.PendingGroupJob createDetachedCopy(com.infinite.fireapp.model.realms.PendingGroupJob realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.infinite.fireapp.model.realms.PendingGroupJob unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.infinite.fireapp.model.realms.PendingGroupJob();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.infinite.fireapp.model.realms.PendingGroupJob) cachedObject.object;
            }
            unmanagedObject = (com.infinite.fireapp.model.realms.PendingGroupJob) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface unmanagedCopy = (com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) unmanagedObject;
        com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface realmSource = (com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$groupId(realmSource.realmGet$groupId());
        unmanagedCopy.realmSet$type(realmSource.realmGet$type());

        // Deep copy of groupEvent
        unmanagedCopy.realmSet$groupEvent(com_infinite_fireapp_model_realms_GroupEventRealmProxy.createDetachedCopy(realmSource.realmGet$groupEvent(), currentDepth + 1, maxDepth, cache));

        return unmanagedObject;
    }

    static com.infinite.fireapp.model.realms.PendingGroupJob update(Realm realm, com.infinite.fireapp.model.realms.PendingGroupJob realmObject, com.infinite.fireapp.model.realms.PendingGroupJob newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface realmObjectTarget = (com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) realmObject;
        com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface realmObjectSource = (com_infinite_fireapp_model_realms_PendingGroupJobRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$type(realmObjectSource.realmGet$type());
        com.infinite.fireapp.model.realms.GroupEvent groupEventObj = realmObjectSource.realmGet$groupEvent();
        if (groupEventObj == null) {
            realmObjectTarget.realmSet$groupEvent(null);
        } else {
            com.infinite.fireapp.model.realms.GroupEvent cachegroupEvent = (com.infinite.fireapp.model.realms.GroupEvent) cache.get(groupEventObj);
            if (cachegroupEvent != null) {
                realmObjectTarget.realmSet$groupEvent(cachegroupEvent);
            } else {
                realmObjectTarget.realmSet$groupEvent(com_infinite_fireapp_model_realms_GroupEventRealmProxy.copyOrUpdate(realm, groupEventObj, true, cache));
            }
        }
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PendingGroupJob = proxy[");
        stringBuilder.append("{groupId:");
        stringBuilder.append(realmGet$groupId() != null ? realmGet$groupId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{groupEvent:");
        stringBuilder.append(realmGet$groupEvent() != null ? "GroupEvent" : "null");
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
        com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy aPendingGroupJob = (com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPendingGroupJob.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPendingGroupJob.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPendingGroupJob.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
