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
public class com_infinite_fireapp_model_realms_GroupEventRealmProxy extends com.infinite.fireapp.model.realms.GroupEvent
    implements RealmObjectProxy, com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface {

    static final class GroupEventColumnInfo extends ColumnInfo {
        long contextStartIndex;
        long eventTypeIndex;
        long contextEndIndex;
        long timestampIndex;
        long eventIdIndex;

        GroupEventColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("GroupEvent");
            this.contextStartIndex = addColumnDetails("contextStart", "contextStart", objectSchemaInfo);
            this.eventTypeIndex = addColumnDetails("eventType", "eventType", objectSchemaInfo);
            this.contextEndIndex = addColumnDetails("contextEnd", "contextEnd", objectSchemaInfo);
            this.timestampIndex = addColumnDetails("timestamp", "timestamp", objectSchemaInfo);
            this.eventIdIndex = addColumnDetails("eventId", "eventId", objectSchemaInfo);
        }

        GroupEventColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new GroupEventColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final GroupEventColumnInfo src = (GroupEventColumnInfo) rawSrc;
            final GroupEventColumnInfo dst = (GroupEventColumnInfo) rawDst;
            dst.contextStartIndex = src.contextStartIndex;
            dst.eventTypeIndex = src.eventTypeIndex;
            dst.contextEndIndex = src.contextEndIndex;
            dst.timestampIndex = src.timestampIndex;
            dst.eventIdIndex = src.eventIdIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private GroupEventColumnInfo columnInfo;
    private ProxyState<com.infinite.fireapp.model.realms.GroupEvent> proxyState;

    com_infinite_fireapp_model_realms_GroupEventRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (GroupEventColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.infinite.fireapp.model.realms.GroupEvent>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$contextStart() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.contextStartIndex);
    }

    @Override
    public void realmSet$contextStart(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.contextStartIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.contextStartIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.contextStartIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.contextStartIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$eventType() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.eventTypeIndex);
    }

    @Override
    public void realmSet$eventType(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.eventTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.eventTypeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$contextEnd() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.contextEndIndex);
    }

    @Override
    public void realmSet$contextEnd(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.contextEndIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.contextEndIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.contextEndIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.contextEndIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$timestamp() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.timestampIndex);
    }

    @Override
    public void realmSet$timestamp(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.timestampIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.timestampIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.timestampIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.timestampIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$eventId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.eventIdIndex);
    }

    @Override
    public void realmSet$eventId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.eventIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.eventIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.eventIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.eventIdIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("GroupEvent", 5, 0);
        builder.addPersistedProperty("contextStart", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("eventType", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("contextEnd", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("timestamp", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("eventId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static GroupEventColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new GroupEventColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "GroupEvent";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "GroupEvent";
    }

    @SuppressWarnings("cast")
    public static com.infinite.fireapp.model.realms.GroupEvent createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.infinite.fireapp.model.realms.GroupEvent obj = realm.createObjectInternal(com.infinite.fireapp.model.realms.GroupEvent.class, true, excludeFields);

        final com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) obj;
        if (json.has("contextStart")) {
            if (json.isNull("contextStart")) {
                objProxy.realmSet$contextStart(null);
            } else {
                objProxy.realmSet$contextStart((String) json.getString("contextStart"));
            }
        }
        if (json.has("eventType")) {
            if (json.isNull("eventType")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'eventType' to null.");
            } else {
                objProxy.realmSet$eventType((int) json.getInt("eventType"));
            }
        }
        if (json.has("contextEnd")) {
            if (json.isNull("contextEnd")) {
                objProxy.realmSet$contextEnd(null);
            } else {
                objProxy.realmSet$contextEnd((String) json.getString("contextEnd"));
            }
        }
        if (json.has("timestamp")) {
            if (json.isNull("timestamp")) {
                objProxy.realmSet$timestamp(null);
            } else {
                objProxy.realmSet$timestamp((String) json.getString("timestamp"));
            }
        }
        if (json.has("eventId")) {
            if (json.isNull("eventId")) {
                objProxy.realmSet$eventId(null);
            } else {
                objProxy.realmSet$eventId((String) json.getString("eventId"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.infinite.fireapp.model.realms.GroupEvent createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.infinite.fireapp.model.realms.GroupEvent obj = new com.infinite.fireapp.model.realms.GroupEvent();
        final com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("contextStart")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$contextStart((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$contextStart(null);
                }
            } else if (name.equals("eventType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$eventType((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'eventType' to null.");
                }
            } else if (name.equals("contextEnd")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$contextEnd((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$contextEnd(null);
                }
            } else if (name.equals("timestamp")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$timestamp((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$timestamp(null);
                }
            } else if (name.equals("eventId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$eventId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$eventId(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.infinite.fireapp.model.realms.GroupEvent copyOrUpdate(Realm realm, com.infinite.fireapp.model.realms.GroupEvent object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.infinite.fireapp.model.realms.GroupEvent) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.infinite.fireapp.model.realms.GroupEvent copy(Realm realm, com.infinite.fireapp.model.realms.GroupEvent newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.infinite.fireapp.model.realms.GroupEvent) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.infinite.fireapp.model.realms.GroupEvent realmObject = realm.createObjectInternal(com.infinite.fireapp.model.realms.GroupEvent.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface realmObjectSource = (com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) newObject;
        com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface realmObjectCopy = (com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$contextStart(realmObjectSource.realmGet$contextStart());
        realmObjectCopy.realmSet$eventType(realmObjectSource.realmGet$eventType());
        realmObjectCopy.realmSet$contextEnd(realmObjectSource.realmGet$contextEnd());
        realmObjectCopy.realmSet$timestamp(realmObjectSource.realmGet$timestamp());
        realmObjectCopy.realmSet$eventId(realmObjectSource.realmGet$eventId());
        return realmObject;
    }

    public static long insert(Realm realm, com.infinite.fireapp.model.realms.GroupEvent object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.GroupEvent.class);
        long tableNativePtr = table.getNativePtr();
        GroupEventColumnInfo columnInfo = (GroupEventColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.GroupEvent.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$contextStart = ((com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) object).realmGet$contextStart();
        if (realmGet$contextStart != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contextStartIndex, rowIndex, realmGet$contextStart, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.eventTypeIndex, rowIndex, ((com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) object).realmGet$eventType(), false);
        String realmGet$contextEnd = ((com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) object).realmGet$contextEnd();
        if (realmGet$contextEnd != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contextEndIndex, rowIndex, realmGet$contextEnd, false);
        }
        String realmGet$timestamp = ((com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) object).realmGet$timestamp();
        if (realmGet$timestamp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.timestampIndex, rowIndex, realmGet$timestamp, false);
        }
        String realmGet$eventId = ((com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) object).realmGet$eventId();
        if (realmGet$eventId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.eventIdIndex, rowIndex, realmGet$eventId, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.GroupEvent.class);
        long tableNativePtr = table.getNativePtr();
        GroupEventColumnInfo columnInfo = (GroupEventColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.GroupEvent.class);
        com.infinite.fireapp.model.realms.GroupEvent object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.GroupEvent) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$contextStart = ((com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) object).realmGet$contextStart();
            if (realmGet$contextStart != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contextStartIndex, rowIndex, realmGet$contextStart, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.eventTypeIndex, rowIndex, ((com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) object).realmGet$eventType(), false);
            String realmGet$contextEnd = ((com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) object).realmGet$contextEnd();
            if (realmGet$contextEnd != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contextEndIndex, rowIndex, realmGet$contextEnd, false);
            }
            String realmGet$timestamp = ((com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) object).realmGet$timestamp();
            if (realmGet$timestamp != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.timestampIndex, rowIndex, realmGet$timestamp, false);
            }
            String realmGet$eventId = ((com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) object).realmGet$eventId();
            if (realmGet$eventId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.eventIdIndex, rowIndex, realmGet$eventId, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.infinite.fireapp.model.realms.GroupEvent object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.GroupEvent.class);
        long tableNativePtr = table.getNativePtr();
        GroupEventColumnInfo columnInfo = (GroupEventColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.GroupEvent.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$contextStart = ((com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) object).realmGet$contextStart();
        if (realmGet$contextStart != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contextStartIndex, rowIndex, realmGet$contextStart, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contextStartIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.eventTypeIndex, rowIndex, ((com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) object).realmGet$eventType(), false);
        String realmGet$contextEnd = ((com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) object).realmGet$contextEnd();
        if (realmGet$contextEnd != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contextEndIndex, rowIndex, realmGet$contextEnd, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contextEndIndex, rowIndex, false);
        }
        String realmGet$timestamp = ((com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) object).realmGet$timestamp();
        if (realmGet$timestamp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.timestampIndex, rowIndex, realmGet$timestamp, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.timestampIndex, rowIndex, false);
        }
        String realmGet$eventId = ((com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) object).realmGet$eventId();
        if (realmGet$eventId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.eventIdIndex, rowIndex, realmGet$eventId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.eventIdIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.GroupEvent.class);
        long tableNativePtr = table.getNativePtr();
        GroupEventColumnInfo columnInfo = (GroupEventColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.GroupEvent.class);
        com.infinite.fireapp.model.realms.GroupEvent object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.GroupEvent) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$contextStart = ((com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) object).realmGet$contextStart();
            if (realmGet$contextStart != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contextStartIndex, rowIndex, realmGet$contextStart, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.contextStartIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.eventTypeIndex, rowIndex, ((com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) object).realmGet$eventType(), false);
            String realmGet$contextEnd = ((com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) object).realmGet$contextEnd();
            if (realmGet$contextEnd != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contextEndIndex, rowIndex, realmGet$contextEnd, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.contextEndIndex, rowIndex, false);
            }
            String realmGet$timestamp = ((com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) object).realmGet$timestamp();
            if (realmGet$timestamp != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.timestampIndex, rowIndex, realmGet$timestamp, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.timestampIndex, rowIndex, false);
            }
            String realmGet$eventId = ((com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) object).realmGet$eventId();
            if (realmGet$eventId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.eventIdIndex, rowIndex, realmGet$eventId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.eventIdIndex, rowIndex, false);
            }
        }
    }

    public static com.infinite.fireapp.model.realms.GroupEvent createDetachedCopy(com.infinite.fireapp.model.realms.GroupEvent realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.infinite.fireapp.model.realms.GroupEvent unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.infinite.fireapp.model.realms.GroupEvent();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.infinite.fireapp.model.realms.GroupEvent) cachedObject.object;
            }
            unmanagedObject = (com.infinite.fireapp.model.realms.GroupEvent) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface unmanagedCopy = (com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) unmanagedObject;
        com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface realmSource = (com_infinite_fireapp_model_realms_GroupEventRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$contextStart(realmSource.realmGet$contextStart());
        unmanagedCopy.realmSet$eventType(realmSource.realmGet$eventType());
        unmanagedCopy.realmSet$contextEnd(realmSource.realmGet$contextEnd());
        unmanagedCopy.realmSet$timestamp(realmSource.realmGet$timestamp());
        unmanagedCopy.realmSet$eventId(realmSource.realmGet$eventId());

        return unmanagedObject;
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
        com_infinite_fireapp_model_realms_GroupEventRealmProxy aGroupEvent = (com_infinite_fireapp_model_realms_GroupEventRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aGroupEvent.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aGroupEvent.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aGroupEvent.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
