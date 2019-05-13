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
public class com_infinite_fireapp_model_realms_StatusRealmProxy extends com.infinite.fireapp.model.realms.Status
    implements RealmObjectProxy, com_infinite_fireapp_model_realms_StatusRealmProxyInterface {

    static final class StatusColumnInfo extends ColumnInfo {
        long statusIdIndex;
        long userIdIndex;
        long timestampIndex;
        long thumbImgIndex;
        long contentIndex;
        long localPathIndex;
        long typeIndex;
        long durationIndex;
        long seenCountIndex;
        long seenCountSentIndex;
        long isSeenIndex;

        StatusColumnInfo(OsSchemaInfo schemaInfo) {
            super(11);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Status");
            this.statusIdIndex = addColumnDetails("statusId", "statusId", objectSchemaInfo);
            this.userIdIndex = addColumnDetails("userId", "userId", objectSchemaInfo);
            this.timestampIndex = addColumnDetails("timestamp", "timestamp", objectSchemaInfo);
            this.thumbImgIndex = addColumnDetails("thumbImg", "thumbImg", objectSchemaInfo);
            this.contentIndex = addColumnDetails("content", "content", objectSchemaInfo);
            this.localPathIndex = addColumnDetails("localPath", "localPath", objectSchemaInfo);
            this.typeIndex = addColumnDetails("type", "type", objectSchemaInfo);
            this.durationIndex = addColumnDetails("duration", "duration", objectSchemaInfo);
            this.seenCountIndex = addColumnDetails("seenCount", "seenCount", objectSchemaInfo);
            this.seenCountSentIndex = addColumnDetails("seenCountSent", "seenCountSent", objectSchemaInfo);
            this.isSeenIndex = addColumnDetails("isSeen", "isSeen", objectSchemaInfo);
        }

        StatusColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new StatusColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final StatusColumnInfo src = (StatusColumnInfo) rawSrc;
            final StatusColumnInfo dst = (StatusColumnInfo) rawDst;
            dst.statusIdIndex = src.statusIdIndex;
            dst.userIdIndex = src.userIdIndex;
            dst.timestampIndex = src.timestampIndex;
            dst.thumbImgIndex = src.thumbImgIndex;
            dst.contentIndex = src.contentIndex;
            dst.localPathIndex = src.localPathIndex;
            dst.typeIndex = src.typeIndex;
            dst.durationIndex = src.durationIndex;
            dst.seenCountIndex = src.seenCountIndex;
            dst.seenCountSentIndex = src.seenCountSentIndex;
            dst.isSeenIndex = src.isSeenIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private StatusColumnInfo columnInfo;
    private ProxyState<com.infinite.fireapp.model.realms.Status> proxyState;

    com_infinite_fireapp_model_realms_StatusRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (StatusColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.infinite.fireapp.model.realms.Status>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$statusId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.statusIdIndex);
    }

    @Override
    public void realmSet$statusId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'statusId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$userId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.userIdIndex);
    }

    @Override
    public void realmSet$userId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.userIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.userIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.userIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.userIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$timestamp() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.timestampIndex);
    }

    @Override
    public void realmSet$timestamp(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.timestampIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.timestampIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$thumbImg() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.thumbImgIndex);
    }

    @Override
    public void realmSet$thumbImg(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.thumbImgIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.thumbImgIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.thumbImgIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.thumbImgIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$content() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.contentIndex);
    }

    @Override
    public void realmSet$content(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.contentIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.contentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.contentIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.contentIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$localPath() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.localPathIndex);
    }

    @Override
    public void realmSet$localPath(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.localPathIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.localPathIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.localPathIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.localPathIndex, value);
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
    @SuppressWarnings("cast")
    public long realmGet$duration() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.durationIndex);
    }

    @Override
    public void realmSet$duration(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.durationIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.durationIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$seenCount() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.seenCountIndex);
    }

    @Override
    public void realmSet$seenCount(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.seenCountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.seenCountIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$seenCountSent() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.seenCountSentIndex);
    }

    @Override
    public void realmSet$seenCountSent(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.seenCountSentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.seenCountSentIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isSeen() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isSeenIndex);
    }

    @Override
    public void realmSet$isSeen(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isSeenIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isSeenIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Status", 11, 0);
        builder.addPersistedProperty("statusId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("userId", RealmFieldType.STRING, !Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("timestamp", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("thumbImg", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("content", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("localPath", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("type", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("duration", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("seenCount", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("seenCountSent", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("isSeen", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static StatusColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new StatusColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Status";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Status";
    }

    @SuppressWarnings("cast")
    public static com.infinite.fireapp.model.realms.Status createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.infinite.fireapp.model.realms.Status obj = null;
        if (update) {
            Table table = realm.getTable(com.infinite.fireapp.model.realms.Status.class);
            StatusColumnInfo columnInfo = (StatusColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Status.class);
            long pkColumnIndex = columnInfo.statusIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("statusId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("statusId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Status.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_infinite_fireapp_model_realms_StatusRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("statusId")) {
                if (json.isNull("statusId")) {
                    obj = (io.realm.com_infinite_fireapp_model_realms_StatusRealmProxy) realm.createObjectInternal(com.infinite.fireapp.model.realms.Status.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_infinite_fireapp_model_realms_StatusRealmProxy) realm.createObjectInternal(com.infinite.fireapp.model.realms.Status.class, json.getString("statusId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'statusId'.");
            }
        }

        final com_infinite_fireapp_model_realms_StatusRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_StatusRealmProxyInterface) obj;
        if (json.has("userId")) {
            if (json.isNull("userId")) {
                objProxy.realmSet$userId(null);
            } else {
                objProxy.realmSet$userId((String) json.getString("userId"));
            }
        }
        if (json.has("timestamp")) {
            if (json.isNull("timestamp")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'timestamp' to null.");
            } else {
                objProxy.realmSet$timestamp((long) json.getLong("timestamp"));
            }
        }
        if (json.has("thumbImg")) {
            if (json.isNull("thumbImg")) {
                objProxy.realmSet$thumbImg(null);
            } else {
                objProxy.realmSet$thumbImg((String) json.getString("thumbImg"));
            }
        }
        if (json.has("content")) {
            if (json.isNull("content")) {
                objProxy.realmSet$content(null);
            } else {
                objProxy.realmSet$content((String) json.getString("content"));
            }
        }
        if (json.has("localPath")) {
            if (json.isNull("localPath")) {
                objProxy.realmSet$localPath(null);
            } else {
                objProxy.realmSet$localPath((String) json.getString("localPath"));
            }
        }
        if (json.has("type")) {
            if (json.isNull("type")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'type' to null.");
            } else {
                objProxy.realmSet$type((int) json.getInt("type"));
            }
        }
        if (json.has("duration")) {
            if (json.isNull("duration")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'duration' to null.");
            } else {
                objProxy.realmSet$duration((long) json.getLong("duration"));
            }
        }
        if (json.has("seenCount")) {
            if (json.isNull("seenCount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'seenCount' to null.");
            } else {
                objProxy.realmSet$seenCount((int) json.getInt("seenCount"));
            }
        }
        if (json.has("seenCountSent")) {
            if (json.isNull("seenCountSent")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'seenCountSent' to null.");
            } else {
                objProxy.realmSet$seenCountSent((boolean) json.getBoolean("seenCountSent"));
            }
        }
        if (json.has("isSeen")) {
            if (json.isNull("isSeen")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isSeen' to null.");
            } else {
                objProxy.realmSet$isSeen((boolean) json.getBoolean("isSeen"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.infinite.fireapp.model.realms.Status createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.infinite.fireapp.model.realms.Status obj = new com.infinite.fireapp.model.realms.Status();
        final com_infinite_fireapp_model_realms_StatusRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_StatusRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("statusId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$statusId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$statusId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("userId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$userId(null);
                }
            } else if (name.equals("timestamp")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$timestamp((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'timestamp' to null.");
                }
            } else if (name.equals("thumbImg")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$thumbImg((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$thumbImg(null);
                }
            } else if (name.equals("content")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$content((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$content(null);
                }
            } else if (name.equals("localPath")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$localPath((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$localPath(null);
                }
            } else if (name.equals("type")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$type((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'type' to null.");
                }
            } else if (name.equals("duration")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$duration((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'duration' to null.");
                }
            } else if (name.equals("seenCount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$seenCount((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'seenCount' to null.");
                }
            } else if (name.equals("seenCountSent")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$seenCountSent((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'seenCountSent' to null.");
                }
            } else if (name.equals("isSeen")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isSeen((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isSeen' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'statusId'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.infinite.fireapp.model.realms.Status copyOrUpdate(Realm realm, com.infinite.fireapp.model.realms.Status object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.infinite.fireapp.model.realms.Status) cachedRealmObject;
        }

        com.infinite.fireapp.model.realms.Status realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.infinite.fireapp.model.realms.Status.class);
            StatusColumnInfo columnInfo = (StatusColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Status.class);
            long pkColumnIndex = columnInfo.statusIdIndex;
            String value = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$statusId();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Status.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_infinite_fireapp_model_realms_StatusRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.infinite.fireapp.model.realms.Status copy(Realm realm, com.infinite.fireapp.model.realms.Status newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.infinite.fireapp.model.realms.Status) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.infinite.fireapp.model.realms.Status realmObject = realm.createObjectInternal(com.infinite.fireapp.model.realms.Status.class, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) newObject).realmGet$statusId(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_infinite_fireapp_model_realms_StatusRealmProxyInterface realmObjectSource = (com_infinite_fireapp_model_realms_StatusRealmProxyInterface) newObject;
        com_infinite_fireapp_model_realms_StatusRealmProxyInterface realmObjectCopy = (com_infinite_fireapp_model_realms_StatusRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$userId(realmObjectSource.realmGet$userId());
        realmObjectCopy.realmSet$timestamp(realmObjectSource.realmGet$timestamp());
        realmObjectCopy.realmSet$thumbImg(realmObjectSource.realmGet$thumbImg());
        realmObjectCopy.realmSet$content(realmObjectSource.realmGet$content());
        realmObjectCopy.realmSet$localPath(realmObjectSource.realmGet$localPath());
        realmObjectCopy.realmSet$type(realmObjectSource.realmGet$type());
        realmObjectCopy.realmSet$duration(realmObjectSource.realmGet$duration());
        realmObjectCopy.realmSet$seenCount(realmObjectSource.realmGet$seenCount());
        realmObjectCopy.realmSet$seenCountSent(realmObjectSource.realmGet$seenCountSent());
        realmObjectCopy.realmSet$isSeen(realmObjectSource.realmGet$isSeen());
        return realmObject;
    }

    public static long insert(Realm realm, com.infinite.fireapp.model.realms.Status object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.Status.class);
        long tableNativePtr = table.getNativePtr();
        StatusColumnInfo columnInfo = (StatusColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Status.class);
        long pkColumnIndex = columnInfo.statusIdIndex;
        String primaryKeyValue = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$statusId();
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
        String realmGet$userId = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$userId();
        if (realmGet$userId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userIdIndex, rowIndex, realmGet$userId, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.timestampIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$timestamp(), false);
        String realmGet$thumbImg = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$thumbImg();
        if (realmGet$thumbImg != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.thumbImgIndex, rowIndex, realmGet$thumbImg, false);
        }
        String realmGet$content = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$content();
        if (realmGet$content != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
        }
        String realmGet$localPath = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$localPath();
        if (realmGet$localPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.localPathIndex, rowIndex, realmGet$localPath, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$type(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.durationIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$duration(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.seenCountIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$seenCount(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.seenCountSentIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$seenCountSent(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isSeenIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$isSeen(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.Status.class);
        long tableNativePtr = table.getNativePtr();
        StatusColumnInfo columnInfo = (StatusColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Status.class);
        long pkColumnIndex = columnInfo.statusIdIndex;
        com.infinite.fireapp.model.realms.Status object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.Status) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$statusId();
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
            String realmGet$userId = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$userId();
            if (realmGet$userId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userIdIndex, rowIndex, realmGet$userId, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.timestampIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$timestamp(), false);
            String realmGet$thumbImg = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$thumbImg();
            if (realmGet$thumbImg != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.thumbImgIndex, rowIndex, realmGet$thumbImg, false);
            }
            String realmGet$content = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$content();
            if (realmGet$content != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
            }
            String realmGet$localPath = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$localPath();
            if (realmGet$localPath != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.localPathIndex, rowIndex, realmGet$localPath, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$type(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.durationIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$duration(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.seenCountIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$seenCount(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.seenCountSentIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$seenCountSent(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isSeenIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$isSeen(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.infinite.fireapp.model.realms.Status object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.Status.class);
        long tableNativePtr = table.getNativePtr();
        StatusColumnInfo columnInfo = (StatusColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Status.class);
        long pkColumnIndex = columnInfo.statusIdIndex;
        String primaryKeyValue = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$statusId();
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
        String realmGet$userId = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$userId();
        if (realmGet$userId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userIdIndex, rowIndex, realmGet$userId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.userIdIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.timestampIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$timestamp(), false);
        String realmGet$thumbImg = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$thumbImg();
        if (realmGet$thumbImg != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.thumbImgIndex, rowIndex, realmGet$thumbImg, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.thumbImgIndex, rowIndex, false);
        }
        String realmGet$content = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$content();
        if (realmGet$content != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contentIndex, rowIndex, false);
        }
        String realmGet$localPath = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$localPath();
        if (realmGet$localPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.localPathIndex, rowIndex, realmGet$localPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.localPathIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$type(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.durationIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$duration(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.seenCountIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$seenCount(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.seenCountSentIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$seenCountSent(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isSeenIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$isSeen(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.Status.class);
        long tableNativePtr = table.getNativePtr();
        StatusColumnInfo columnInfo = (StatusColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Status.class);
        long pkColumnIndex = columnInfo.statusIdIndex;
        com.infinite.fireapp.model.realms.Status object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.Status) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$statusId();
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
            String realmGet$userId = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$userId();
            if (realmGet$userId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userIdIndex, rowIndex, realmGet$userId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.userIdIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.timestampIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$timestamp(), false);
            String realmGet$thumbImg = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$thumbImg();
            if (realmGet$thumbImg != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.thumbImgIndex, rowIndex, realmGet$thumbImg, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.thumbImgIndex, rowIndex, false);
            }
            String realmGet$content = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$content();
            if (realmGet$content != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.contentIndex, rowIndex, false);
            }
            String realmGet$localPath = ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$localPath();
            if (realmGet$localPath != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.localPathIndex, rowIndex, realmGet$localPath, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.localPathIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$type(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.durationIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$duration(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.seenCountIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$seenCount(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.seenCountSentIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$seenCountSent(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isSeenIndex, rowIndex, ((com_infinite_fireapp_model_realms_StatusRealmProxyInterface) object).realmGet$isSeen(), false);
        }
    }

    public static com.infinite.fireapp.model.realms.Status createDetachedCopy(com.infinite.fireapp.model.realms.Status realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.infinite.fireapp.model.realms.Status unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.infinite.fireapp.model.realms.Status();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.infinite.fireapp.model.realms.Status) cachedObject.object;
            }
            unmanagedObject = (com.infinite.fireapp.model.realms.Status) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_infinite_fireapp_model_realms_StatusRealmProxyInterface unmanagedCopy = (com_infinite_fireapp_model_realms_StatusRealmProxyInterface) unmanagedObject;
        com_infinite_fireapp_model_realms_StatusRealmProxyInterface realmSource = (com_infinite_fireapp_model_realms_StatusRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$statusId(realmSource.realmGet$statusId());
        unmanagedCopy.realmSet$userId(realmSource.realmGet$userId());
        unmanagedCopy.realmSet$timestamp(realmSource.realmGet$timestamp());
        unmanagedCopy.realmSet$thumbImg(realmSource.realmGet$thumbImg());
        unmanagedCopy.realmSet$content(realmSource.realmGet$content());
        unmanagedCopy.realmSet$localPath(realmSource.realmGet$localPath());
        unmanagedCopy.realmSet$type(realmSource.realmGet$type());
        unmanagedCopy.realmSet$duration(realmSource.realmGet$duration());
        unmanagedCopy.realmSet$seenCount(realmSource.realmGet$seenCount());
        unmanagedCopy.realmSet$seenCountSent(realmSource.realmGet$seenCountSent());
        unmanagedCopy.realmSet$isSeen(realmSource.realmGet$isSeen());

        return unmanagedObject;
    }

    static com.infinite.fireapp.model.realms.Status update(Realm realm, com.infinite.fireapp.model.realms.Status realmObject, com.infinite.fireapp.model.realms.Status newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_infinite_fireapp_model_realms_StatusRealmProxyInterface realmObjectTarget = (com_infinite_fireapp_model_realms_StatusRealmProxyInterface) realmObject;
        com_infinite_fireapp_model_realms_StatusRealmProxyInterface realmObjectSource = (com_infinite_fireapp_model_realms_StatusRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$userId(realmObjectSource.realmGet$userId());
        realmObjectTarget.realmSet$timestamp(realmObjectSource.realmGet$timestamp());
        realmObjectTarget.realmSet$thumbImg(realmObjectSource.realmGet$thumbImg());
        realmObjectTarget.realmSet$content(realmObjectSource.realmGet$content());
        realmObjectTarget.realmSet$localPath(realmObjectSource.realmGet$localPath());
        realmObjectTarget.realmSet$type(realmObjectSource.realmGet$type());
        realmObjectTarget.realmSet$duration(realmObjectSource.realmGet$duration());
        realmObjectTarget.realmSet$seenCount(realmObjectSource.realmGet$seenCount());
        realmObjectTarget.realmSet$seenCountSent(realmObjectSource.realmGet$seenCountSent());
        realmObjectTarget.realmSet$isSeen(realmObjectSource.realmGet$isSeen());
        return realmObject;
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
        com_infinite_fireapp_model_realms_StatusRealmProxy aStatus = (com_infinite_fireapp_model_realms_StatusRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aStatus.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aStatus.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aStatus.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
