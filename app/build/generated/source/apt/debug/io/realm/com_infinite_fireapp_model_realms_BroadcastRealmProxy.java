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
public class com_infinite_fireapp_model_realms_BroadcastRealmProxy extends com.infinite.fireapp.model.realms.Broadcast
    implements RealmObjectProxy, com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface {

    static final class BroadcastColumnInfo extends ColumnInfo {
        long broadcastIdIndex;
        long createdByNumberIndex;
        long timestampIndex;
        long usersIndex;

        BroadcastColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Broadcast");
            this.broadcastIdIndex = addColumnDetails("broadcastId", "broadcastId", objectSchemaInfo);
            this.createdByNumberIndex = addColumnDetails("createdByNumber", "createdByNumber", objectSchemaInfo);
            this.timestampIndex = addColumnDetails("timestamp", "timestamp", objectSchemaInfo);
            this.usersIndex = addColumnDetails("users", "users", objectSchemaInfo);
        }

        BroadcastColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new BroadcastColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final BroadcastColumnInfo src = (BroadcastColumnInfo) rawSrc;
            final BroadcastColumnInfo dst = (BroadcastColumnInfo) rawDst;
            dst.broadcastIdIndex = src.broadcastIdIndex;
            dst.createdByNumberIndex = src.createdByNumberIndex;
            dst.timestampIndex = src.timestampIndex;
            dst.usersIndex = src.usersIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private BroadcastColumnInfo columnInfo;
    private ProxyState<com.infinite.fireapp.model.realms.Broadcast> proxyState;
    private RealmList<com.infinite.fireapp.model.realms.User> usersRealmList;

    com_infinite_fireapp_model_realms_BroadcastRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (BroadcastColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.infinite.fireapp.model.realms.Broadcast>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$broadcastId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.broadcastIdIndex);
    }

    @Override
    public void realmSet$broadcastId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'broadcastId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$createdByNumber() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.createdByNumberIndex);
    }

    @Override
    public void realmSet$createdByNumber(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.createdByNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.createdByNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.createdByNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.createdByNumberIndex, value);
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
    public RealmList<com.infinite.fireapp.model.realms.User> realmGet$users() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (usersRealmList != null) {
            return usersRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.usersIndex);
            usersRealmList = new RealmList<com.infinite.fireapp.model.realms.User>(com.infinite.fireapp.model.realms.User.class, osList, proxyState.getRealm$realm());
            return usersRealmList;
        }
    }

    @Override
    public void realmSet$users(RealmList<com.infinite.fireapp.model.realms.User> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("users")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.infinite.fireapp.model.realms.User> original = value;
                value = new RealmList<com.infinite.fireapp.model.realms.User>();
                for (com.infinite.fireapp.model.realms.User item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.usersIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.infinite.fireapp.model.realms.User linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.infinite.fireapp.model.realms.User linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Broadcast", 4, 0);
        builder.addPersistedProperty("broadcastId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("createdByNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("timestamp", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedLinkProperty("users", RealmFieldType.LIST, "User");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static BroadcastColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new BroadcastColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Broadcast";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Broadcast";
    }

    @SuppressWarnings("cast")
    public static com.infinite.fireapp.model.realms.Broadcast createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.infinite.fireapp.model.realms.Broadcast obj = null;
        if (update) {
            Table table = realm.getTable(com.infinite.fireapp.model.realms.Broadcast.class);
            BroadcastColumnInfo columnInfo = (BroadcastColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Broadcast.class);
            long pkColumnIndex = columnInfo.broadcastIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("broadcastId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("broadcastId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Broadcast.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_infinite_fireapp_model_realms_BroadcastRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("users")) {
                excludeFields.add("users");
            }
            if (json.has("broadcastId")) {
                if (json.isNull("broadcastId")) {
                    obj = (io.realm.com_infinite_fireapp_model_realms_BroadcastRealmProxy) realm.createObjectInternal(com.infinite.fireapp.model.realms.Broadcast.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_infinite_fireapp_model_realms_BroadcastRealmProxy) realm.createObjectInternal(com.infinite.fireapp.model.realms.Broadcast.class, json.getString("broadcastId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'broadcastId'.");
            }
        }

        final com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) obj;
        if (json.has("createdByNumber")) {
            if (json.isNull("createdByNumber")) {
                objProxy.realmSet$createdByNumber(null);
            } else {
                objProxy.realmSet$createdByNumber((String) json.getString("createdByNumber"));
            }
        }
        if (json.has("timestamp")) {
            if (json.isNull("timestamp")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'timestamp' to null.");
            } else {
                objProxy.realmSet$timestamp((long) json.getLong("timestamp"));
            }
        }
        if (json.has("users")) {
            if (json.isNull("users")) {
                objProxy.realmSet$users(null);
            } else {
                objProxy.realmGet$users().clear();
                JSONArray array = json.getJSONArray("users");
                for (int i = 0; i < array.length(); i++) {
                    com.infinite.fireapp.model.realms.User item = com_infinite_fireapp_model_realms_UserRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$users().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.infinite.fireapp.model.realms.Broadcast createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.infinite.fireapp.model.realms.Broadcast obj = new com.infinite.fireapp.model.realms.Broadcast();
        final com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("broadcastId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$broadcastId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$broadcastId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("createdByNumber")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$createdByNumber((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$createdByNumber(null);
                }
            } else if (name.equals("timestamp")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$timestamp((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'timestamp' to null.");
                }
            } else if (name.equals("users")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$users(null);
                } else {
                    objProxy.realmSet$users(new RealmList<com.infinite.fireapp.model.realms.User>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.infinite.fireapp.model.realms.User item = com_infinite_fireapp_model_realms_UserRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$users().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'broadcastId'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.infinite.fireapp.model.realms.Broadcast copyOrUpdate(Realm realm, com.infinite.fireapp.model.realms.Broadcast object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.infinite.fireapp.model.realms.Broadcast) cachedRealmObject;
        }

        com.infinite.fireapp.model.realms.Broadcast realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.infinite.fireapp.model.realms.Broadcast.class);
            BroadcastColumnInfo columnInfo = (BroadcastColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Broadcast.class);
            long pkColumnIndex = columnInfo.broadcastIdIndex;
            String value = ((com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) object).realmGet$broadcastId();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Broadcast.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_infinite_fireapp_model_realms_BroadcastRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.infinite.fireapp.model.realms.Broadcast copy(Realm realm, com.infinite.fireapp.model.realms.Broadcast newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.infinite.fireapp.model.realms.Broadcast) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.infinite.fireapp.model.realms.Broadcast realmObject = realm.createObjectInternal(com.infinite.fireapp.model.realms.Broadcast.class, ((com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) newObject).realmGet$broadcastId(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface realmObjectSource = (com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) newObject;
        com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface realmObjectCopy = (com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$createdByNumber(realmObjectSource.realmGet$createdByNumber());
        realmObjectCopy.realmSet$timestamp(realmObjectSource.realmGet$timestamp());

        RealmList<com.infinite.fireapp.model.realms.User> usersList = realmObjectSource.realmGet$users();
        if (usersList != null) {
            RealmList<com.infinite.fireapp.model.realms.User> usersRealmList = realmObjectCopy.realmGet$users();
            usersRealmList.clear();
            for (int i = 0; i < usersList.size(); i++) {
                com.infinite.fireapp.model.realms.User usersItem = usersList.get(i);
                com.infinite.fireapp.model.realms.User cacheusers = (com.infinite.fireapp.model.realms.User) cache.get(usersItem);
                if (cacheusers != null) {
                    usersRealmList.add(cacheusers);
                } else {
                    usersRealmList.add(com_infinite_fireapp_model_realms_UserRealmProxy.copyOrUpdate(realm, usersItem, update, cache));
                }
            }
        }

        return realmObject;
    }

    public static long insert(Realm realm, com.infinite.fireapp.model.realms.Broadcast object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.Broadcast.class);
        long tableNativePtr = table.getNativePtr();
        BroadcastColumnInfo columnInfo = (BroadcastColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Broadcast.class);
        long pkColumnIndex = columnInfo.broadcastIdIndex;
        String primaryKeyValue = ((com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) object).realmGet$broadcastId();
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
        String realmGet$createdByNumber = ((com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) object).realmGet$createdByNumber();
        if (realmGet$createdByNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdByNumberIndex, rowIndex, realmGet$createdByNumber, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.timestampIndex, rowIndex, ((com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) object).realmGet$timestamp(), false);

        RealmList<com.infinite.fireapp.model.realms.User> usersList = ((com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) object).realmGet$users();
        if (usersList != null) {
            OsList usersOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.usersIndex);
            for (com.infinite.fireapp.model.realms.User usersItem : usersList) {
                Long cacheItemIndexusers = cache.get(usersItem);
                if (cacheItemIndexusers == null) {
                    cacheItemIndexusers = com_infinite_fireapp_model_realms_UserRealmProxy.insert(realm, usersItem, cache);
                }
                usersOsList.addRow(cacheItemIndexusers);
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.Broadcast.class);
        long tableNativePtr = table.getNativePtr();
        BroadcastColumnInfo columnInfo = (BroadcastColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Broadcast.class);
        long pkColumnIndex = columnInfo.broadcastIdIndex;
        com.infinite.fireapp.model.realms.Broadcast object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.Broadcast) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) object).realmGet$broadcastId();
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
            String realmGet$createdByNumber = ((com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) object).realmGet$createdByNumber();
            if (realmGet$createdByNumber != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.createdByNumberIndex, rowIndex, realmGet$createdByNumber, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.timestampIndex, rowIndex, ((com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) object).realmGet$timestamp(), false);

            RealmList<com.infinite.fireapp.model.realms.User> usersList = ((com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) object).realmGet$users();
            if (usersList != null) {
                OsList usersOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.usersIndex);
                for (com.infinite.fireapp.model.realms.User usersItem : usersList) {
                    Long cacheItemIndexusers = cache.get(usersItem);
                    if (cacheItemIndexusers == null) {
                        cacheItemIndexusers = com_infinite_fireapp_model_realms_UserRealmProxy.insert(realm, usersItem, cache);
                    }
                    usersOsList.addRow(cacheItemIndexusers);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.infinite.fireapp.model.realms.Broadcast object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.Broadcast.class);
        long tableNativePtr = table.getNativePtr();
        BroadcastColumnInfo columnInfo = (BroadcastColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Broadcast.class);
        long pkColumnIndex = columnInfo.broadcastIdIndex;
        String primaryKeyValue = ((com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) object).realmGet$broadcastId();
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
        String realmGet$createdByNumber = ((com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) object).realmGet$createdByNumber();
        if (realmGet$createdByNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdByNumberIndex, rowIndex, realmGet$createdByNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.createdByNumberIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.timestampIndex, rowIndex, ((com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) object).realmGet$timestamp(), false);

        OsList usersOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.usersIndex);
        RealmList<com.infinite.fireapp.model.realms.User> usersList = ((com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) object).realmGet$users();
        if (usersList != null && usersList.size() == usersOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = usersList.size();
            for (int i = 0; i < objects; i++) {
                com.infinite.fireapp.model.realms.User usersItem = usersList.get(i);
                Long cacheItemIndexusers = cache.get(usersItem);
                if (cacheItemIndexusers == null) {
                    cacheItemIndexusers = com_infinite_fireapp_model_realms_UserRealmProxy.insertOrUpdate(realm, usersItem, cache);
                }
                usersOsList.setRow(i, cacheItemIndexusers);
            }
        } else {
            usersOsList.removeAll();
            if (usersList != null) {
                for (com.infinite.fireapp.model.realms.User usersItem : usersList) {
                    Long cacheItemIndexusers = cache.get(usersItem);
                    if (cacheItemIndexusers == null) {
                        cacheItemIndexusers = com_infinite_fireapp_model_realms_UserRealmProxy.insertOrUpdate(realm, usersItem, cache);
                    }
                    usersOsList.addRow(cacheItemIndexusers);
                }
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.Broadcast.class);
        long tableNativePtr = table.getNativePtr();
        BroadcastColumnInfo columnInfo = (BroadcastColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Broadcast.class);
        long pkColumnIndex = columnInfo.broadcastIdIndex;
        com.infinite.fireapp.model.realms.Broadcast object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.Broadcast) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) object).realmGet$broadcastId();
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
            String realmGet$createdByNumber = ((com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) object).realmGet$createdByNumber();
            if (realmGet$createdByNumber != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.createdByNumberIndex, rowIndex, realmGet$createdByNumber, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.createdByNumberIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.timestampIndex, rowIndex, ((com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) object).realmGet$timestamp(), false);

            OsList usersOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.usersIndex);
            RealmList<com.infinite.fireapp.model.realms.User> usersList = ((com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) object).realmGet$users();
            if (usersList != null && usersList.size() == usersOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = usersList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.infinite.fireapp.model.realms.User usersItem = usersList.get(i);
                    Long cacheItemIndexusers = cache.get(usersItem);
                    if (cacheItemIndexusers == null) {
                        cacheItemIndexusers = com_infinite_fireapp_model_realms_UserRealmProxy.insertOrUpdate(realm, usersItem, cache);
                    }
                    usersOsList.setRow(i, cacheItemIndexusers);
                }
            } else {
                usersOsList.removeAll();
                if (usersList != null) {
                    for (com.infinite.fireapp.model.realms.User usersItem : usersList) {
                        Long cacheItemIndexusers = cache.get(usersItem);
                        if (cacheItemIndexusers == null) {
                            cacheItemIndexusers = com_infinite_fireapp_model_realms_UserRealmProxy.insertOrUpdate(realm, usersItem, cache);
                        }
                        usersOsList.addRow(cacheItemIndexusers);
                    }
                }
            }

        }
    }

    public static com.infinite.fireapp.model.realms.Broadcast createDetachedCopy(com.infinite.fireapp.model.realms.Broadcast realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.infinite.fireapp.model.realms.Broadcast unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.infinite.fireapp.model.realms.Broadcast();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.infinite.fireapp.model.realms.Broadcast) cachedObject.object;
            }
            unmanagedObject = (com.infinite.fireapp.model.realms.Broadcast) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface unmanagedCopy = (com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) unmanagedObject;
        com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface realmSource = (com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$broadcastId(realmSource.realmGet$broadcastId());
        unmanagedCopy.realmSet$createdByNumber(realmSource.realmGet$createdByNumber());
        unmanagedCopy.realmSet$timestamp(realmSource.realmGet$timestamp());

        // Deep copy of users
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$users(null);
        } else {
            RealmList<com.infinite.fireapp.model.realms.User> managedusersList = realmSource.realmGet$users();
            RealmList<com.infinite.fireapp.model.realms.User> unmanagedusersList = new RealmList<com.infinite.fireapp.model.realms.User>();
            unmanagedCopy.realmSet$users(unmanagedusersList);
            int nextDepth = currentDepth + 1;
            int size = managedusersList.size();
            for (int i = 0; i < size; i++) {
                com.infinite.fireapp.model.realms.User item = com_infinite_fireapp_model_realms_UserRealmProxy.createDetachedCopy(managedusersList.get(i), nextDepth, maxDepth, cache);
                unmanagedusersList.add(item);
            }
        }

        return unmanagedObject;
    }

    static com.infinite.fireapp.model.realms.Broadcast update(Realm realm, com.infinite.fireapp.model.realms.Broadcast realmObject, com.infinite.fireapp.model.realms.Broadcast newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface realmObjectTarget = (com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) realmObject;
        com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface realmObjectSource = (com_infinite_fireapp_model_realms_BroadcastRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$createdByNumber(realmObjectSource.realmGet$createdByNumber());
        realmObjectTarget.realmSet$timestamp(realmObjectSource.realmGet$timestamp());
        RealmList<com.infinite.fireapp.model.realms.User> usersList = realmObjectSource.realmGet$users();
        RealmList<com.infinite.fireapp.model.realms.User> usersRealmList = realmObjectTarget.realmGet$users();
        if (usersList != null && usersList.size() == usersRealmList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = usersList.size();
            for (int i = 0; i < objects; i++) {
                com.infinite.fireapp.model.realms.User usersItem = usersList.get(i);
                com.infinite.fireapp.model.realms.User cacheusers = (com.infinite.fireapp.model.realms.User) cache.get(usersItem);
                if (cacheusers != null) {
                    usersRealmList.set(i, cacheusers);
                } else {
                    usersRealmList.set(i, com_infinite_fireapp_model_realms_UserRealmProxy.copyOrUpdate(realm, usersItem, true, cache));
                }
            }
        } else {
            usersRealmList.clear();
            if (usersList != null) {
                for (int i = 0; i < usersList.size(); i++) {
                    com.infinite.fireapp.model.realms.User usersItem = usersList.get(i);
                    com.infinite.fireapp.model.realms.User cacheusers = (com.infinite.fireapp.model.realms.User) cache.get(usersItem);
                    if (cacheusers != null) {
                        usersRealmList.add(cacheusers);
                    } else {
                        usersRealmList.add(com_infinite_fireapp_model_realms_UserRealmProxy.copyOrUpdate(realm, usersItem, true, cache));
                    }
                }
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
        StringBuilder stringBuilder = new StringBuilder("Broadcast = proxy[");
        stringBuilder.append("{broadcastId:");
        stringBuilder.append(realmGet$broadcastId() != null ? realmGet$broadcastId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{createdByNumber:");
        stringBuilder.append(realmGet$createdByNumber() != null ? realmGet$createdByNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{timestamp:");
        stringBuilder.append(realmGet$timestamp());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{users:");
        stringBuilder.append("RealmList<User>[").append(realmGet$users().size()).append("]");
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
        com_infinite_fireapp_model_realms_BroadcastRealmProxy aBroadcast = (com_infinite_fireapp_model_realms_BroadcastRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aBroadcast.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aBroadcast.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aBroadcast.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
