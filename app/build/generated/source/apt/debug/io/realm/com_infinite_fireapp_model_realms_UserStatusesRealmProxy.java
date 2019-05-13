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
public class com_infinite_fireapp_model_realms_UserStatusesRealmProxy extends com.infinite.fireapp.model.realms.UserStatuses
    implements RealmObjectProxy, com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface {

    static final class UserStatusesColumnInfo extends ColumnInfo {
        long userIdIndex;
        long lastStatusTimestampIndex;
        long userIndex;
        long statusesIndex;
        long areAllSeenIndex;

        UserStatusesColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("UserStatuses");
            this.userIdIndex = addColumnDetails("userId", "userId", objectSchemaInfo);
            this.lastStatusTimestampIndex = addColumnDetails("lastStatusTimestamp", "lastStatusTimestamp", objectSchemaInfo);
            this.userIndex = addColumnDetails("user", "user", objectSchemaInfo);
            this.statusesIndex = addColumnDetails("statuses", "statuses", objectSchemaInfo);
            this.areAllSeenIndex = addColumnDetails("areAllSeen", "areAllSeen", objectSchemaInfo);
        }

        UserStatusesColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UserStatusesColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UserStatusesColumnInfo src = (UserStatusesColumnInfo) rawSrc;
            final UserStatusesColumnInfo dst = (UserStatusesColumnInfo) rawDst;
            dst.userIdIndex = src.userIdIndex;
            dst.lastStatusTimestampIndex = src.lastStatusTimestampIndex;
            dst.userIndex = src.userIndex;
            dst.statusesIndex = src.statusesIndex;
            dst.areAllSeenIndex = src.areAllSeenIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UserStatusesColumnInfo columnInfo;
    private ProxyState<com.infinite.fireapp.model.realms.UserStatuses> proxyState;
    private RealmList<com.infinite.fireapp.model.realms.Status> statusesRealmList;

    com_infinite_fireapp_model_realms_UserStatusesRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserStatusesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.infinite.fireapp.model.realms.UserStatuses>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'userId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$lastStatusTimestamp() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.lastStatusTimestampIndex);
    }

    @Override
    public void realmSet$lastStatusTimestamp(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.lastStatusTimestampIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.lastStatusTimestampIndex, value);
    }

    @Override
    public com.infinite.fireapp.model.realms.User realmGet$user() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.userIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.infinite.fireapp.model.realms.User.class, proxyState.getRow$realm().getLink(columnInfo.userIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$user(com.infinite.fireapp.model.realms.User value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("user")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.userIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.userIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.userIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.userIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public RealmList<com.infinite.fireapp.model.realms.Status> realmGet$statuses() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (statusesRealmList != null) {
            return statusesRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.statusesIndex);
            statusesRealmList = new RealmList<com.infinite.fireapp.model.realms.Status>(com.infinite.fireapp.model.realms.Status.class, osList, proxyState.getRealm$realm());
            return statusesRealmList;
        }
    }

    @Override
    public void realmSet$statuses(RealmList<com.infinite.fireapp.model.realms.Status> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("statuses")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.infinite.fireapp.model.realms.Status> original = value;
                value = new RealmList<com.infinite.fireapp.model.realms.Status>();
                for (com.infinite.fireapp.model.realms.Status item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.statusesIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.infinite.fireapp.model.realms.Status linkedObject = value.get(i);
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
                com.infinite.fireapp.model.realms.Status linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$areAllSeen() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.areAllSeenIndex);
    }

    @Override
    public void realmSet$areAllSeen(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.areAllSeenIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.areAllSeenIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("UserStatuses", 5, 0);
        builder.addPersistedProperty("userId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("lastStatusTimestamp", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedLinkProperty("user", RealmFieldType.OBJECT, "User");
        builder.addPersistedLinkProperty("statuses", RealmFieldType.LIST, "Status");
        builder.addPersistedProperty("areAllSeen", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UserStatusesColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UserStatusesColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "UserStatuses";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "UserStatuses";
    }

    @SuppressWarnings("cast")
    public static com.infinite.fireapp.model.realms.UserStatuses createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        com.infinite.fireapp.model.realms.UserStatuses obj = null;
        if (update) {
            Table table = realm.getTable(com.infinite.fireapp.model.realms.UserStatuses.class);
            UserStatusesColumnInfo columnInfo = (UserStatusesColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.UserStatuses.class);
            long pkColumnIndex = columnInfo.userIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("userId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("userId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.UserStatuses.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_infinite_fireapp_model_realms_UserStatusesRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("user")) {
                excludeFields.add("user");
            }
            if (json.has("statuses")) {
                excludeFields.add("statuses");
            }
            if (json.has("userId")) {
                if (json.isNull("userId")) {
                    obj = (io.realm.com_infinite_fireapp_model_realms_UserStatusesRealmProxy) realm.createObjectInternal(com.infinite.fireapp.model.realms.UserStatuses.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_infinite_fireapp_model_realms_UserStatusesRealmProxy) realm.createObjectInternal(com.infinite.fireapp.model.realms.UserStatuses.class, json.getString("userId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'userId'.");
            }
        }

        final com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) obj;
        if (json.has("lastStatusTimestamp")) {
            if (json.isNull("lastStatusTimestamp")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'lastStatusTimestamp' to null.");
            } else {
                objProxy.realmSet$lastStatusTimestamp((long) json.getLong("lastStatusTimestamp"));
            }
        }
        if (json.has("user")) {
            if (json.isNull("user")) {
                objProxy.realmSet$user(null);
            } else {
                com.infinite.fireapp.model.realms.User userObj = com_infinite_fireapp_model_realms_UserRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("user"), update);
                objProxy.realmSet$user(userObj);
            }
        }
        if (json.has("statuses")) {
            if (json.isNull("statuses")) {
                objProxy.realmSet$statuses(null);
            } else {
                objProxy.realmGet$statuses().clear();
                JSONArray array = json.getJSONArray("statuses");
                for (int i = 0; i < array.length(); i++) {
                    com.infinite.fireapp.model.realms.Status item = com_infinite_fireapp_model_realms_StatusRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$statuses().add(item);
                }
            }
        }
        if (json.has("areAllSeen")) {
            if (json.isNull("areAllSeen")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'areAllSeen' to null.");
            } else {
                objProxy.realmSet$areAllSeen((boolean) json.getBoolean("areAllSeen"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.infinite.fireapp.model.realms.UserStatuses createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.infinite.fireapp.model.realms.UserStatuses obj = new com.infinite.fireapp.model.realms.UserStatuses();
        final com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("userId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$userId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("lastStatusTimestamp")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$lastStatusTimestamp((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'lastStatusTimestamp' to null.");
                }
            } else if (name.equals("user")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$user(null);
                } else {
                    com.infinite.fireapp.model.realms.User userObj = com_infinite_fireapp_model_realms_UserRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$user(userObj);
                }
            } else if (name.equals("statuses")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$statuses(null);
                } else {
                    objProxy.realmSet$statuses(new RealmList<com.infinite.fireapp.model.realms.Status>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.infinite.fireapp.model.realms.Status item = com_infinite_fireapp_model_realms_StatusRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$statuses().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("areAllSeen")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$areAllSeen((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'areAllSeen' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'userId'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.infinite.fireapp.model.realms.UserStatuses copyOrUpdate(Realm realm, com.infinite.fireapp.model.realms.UserStatuses object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.infinite.fireapp.model.realms.UserStatuses) cachedRealmObject;
        }

        com.infinite.fireapp.model.realms.UserStatuses realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.infinite.fireapp.model.realms.UserStatuses.class);
            UserStatusesColumnInfo columnInfo = (UserStatusesColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.UserStatuses.class);
            long pkColumnIndex = columnInfo.userIdIndex;
            String value = ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$userId();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.UserStatuses.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_infinite_fireapp_model_realms_UserStatusesRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.infinite.fireapp.model.realms.UserStatuses copy(Realm realm, com.infinite.fireapp.model.realms.UserStatuses newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.infinite.fireapp.model.realms.UserStatuses) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.infinite.fireapp.model.realms.UserStatuses realmObject = realm.createObjectInternal(com.infinite.fireapp.model.realms.UserStatuses.class, ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) newObject).realmGet$userId(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface realmObjectSource = (com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) newObject;
        com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface realmObjectCopy = (com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$lastStatusTimestamp(realmObjectSource.realmGet$lastStatusTimestamp());

        com.infinite.fireapp.model.realms.User userObj = realmObjectSource.realmGet$user();
        if (userObj == null) {
            realmObjectCopy.realmSet$user(null);
        } else {
            com.infinite.fireapp.model.realms.User cacheuser = (com.infinite.fireapp.model.realms.User) cache.get(userObj);
            if (cacheuser != null) {
                realmObjectCopy.realmSet$user(cacheuser);
            } else {
                realmObjectCopy.realmSet$user(com_infinite_fireapp_model_realms_UserRealmProxy.copyOrUpdate(realm, userObj, update, cache));
            }
        }

        RealmList<com.infinite.fireapp.model.realms.Status> statusesList = realmObjectSource.realmGet$statuses();
        if (statusesList != null) {
            RealmList<com.infinite.fireapp.model.realms.Status> statusesRealmList = realmObjectCopy.realmGet$statuses();
            statusesRealmList.clear();
            for (int i = 0; i < statusesList.size(); i++) {
                com.infinite.fireapp.model.realms.Status statusesItem = statusesList.get(i);
                com.infinite.fireapp.model.realms.Status cachestatuses = (com.infinite.fireapp.model.realms.Status) cache.get(statusesItem);
                if (cachestatuses != null) {
                    statusesRealmList.add(cachestatuses);
                } else {
                    statusesRealmList.add(com_infinite_fireapp_model_realms_StatusRealmProxy.copyOrUpdate(realm, statusesItem, update, cache));
                }
            }
        }

        realmObjectCopy.realmSet$areAllSeen(realmObjectSource.realmGet$areAllSeen());
        return realmObject;
    }

    public static long insert(Realm realm, com.infinite.fireapp.model.realms.UserStatuses object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.UserStatuses.class);
        long tableNativePtr = table.getNativePtr();
        UserStatusesColumnInfo columnInfo = (UserStatusesColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.UserStatuses.class);
        long pkColumnIndex = columnInfo.userIdIndex;
        String primaryKeyValue = ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$userId();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.lastStatusTimestampIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$lastStatusTimestamp(), false);

        com.infinite.fireapp.model.realms.User userObj = ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$user();
        if (userObj != null) {
            Long cacheuser = cache.get(userObj);
            if (cacheuser == null) {
                cacheuser = com_infinite_fireapp_model_realms_UserRealmProxy.insert(realm, userObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
        }

        RealmList<com.infinite.fireapp.model.realms.Status> statusesList = ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$statuses();
        if (statusesList != null) {
            OsList statusesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.statusesIndex);
            for (com.infinite.fireapp.model.realms.Status statusesItem : statusesList) {
                Long cacheItemIndexstatuses = cache.get(statusesItem);
                if (cacheItemIndexstatuses == null) {
                    cacheItemIndexstatuses = com_infinite_fireapp_model_realms_StatusRealmProxy.insert(realm, statusesItem, cache);
                }
                statusesOsList.addRow(cacheItemIndexstatuses);
            }
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.areAllSeenIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$areAllSeen(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.UserStatuses.class);
        long tableNativePtr = table.getNativePtr();
        UserStatusesColumnInfo columnInfo = (UserStatusesColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.UserStatuses.class);
        long pkColumnIndex = columnInfo.userIdIndex;
        com.infinite.fireapp.model.realms.UserStatuses object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.UserStatuses) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$userId();
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
            Table.nativeSetLong(tableNativePtr, columnInfo.lastStatusTimestampIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$lastStatusTimestamp(), false);

            com.infinite.fireapp.model.realms.User userObj = ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$user();
            if (userObj != null) {
                Long cacheuser = cache.get(userObj);
                if (cacheuser == null) {
                    cacheuser = com_infinite_fireapp_model_realms_UserRealmProxy.insert(realm, userObj, cache);
                }
                table.setLink(columnInfo.userIndex, rowIndex, cacheuser, false);
            }

            RealmList<com.infinite.fireapp.model.realms.Status> statusesList = ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$statuses();
            if (statusesList != null) {
                OsList statusesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.statusesIndex);
                for (com.infinite.fireapp.model.realms.Status statusesItem : statusesList) {
                    Long cacheItemIndexstatuses = cache.get(statusesItem);
                    if (cacheItemIndexstatuses == null) {
                        cacheItemIndexstatuses = com_infinite_fireapp_model_realms_StatusRealmProxy.insert(realm, statusesItem, cache);
                    }
                    statusesOsList.addRow(cacheItemIndexstatuses);
                }
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.areAllSeenIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$areAllSeen(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.infinite.fireapp.model.realms.UserStatuses object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.UserStatuses.class);
        long tableNativePtr = table.getNativePtr();
        UserStatusesColumnInfo columnInfo = (UserStatusesColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.UserStatuses.class);
        long pkColumnIndex = columnInfo.userIdIndex;
        String primaryKeyValue = ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$userId();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.lastStatusTimestampIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$lastStatusTimestamp(), false);

        com.infinite.fireapp.model.realms.User userObj = ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$user();
        if (userObj != null) {
            Long cacheuser = cache.get(userObj);
            if (cacheuser == null) {
                cacheuser = com_infinite_fireapp_model_realms_UserRealmProxy.insertOrUpdate(realm, userObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.userIndex, rowIndex);
        }

        OsList statusesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.statusesIndex);
        RealmList<com.infinite.fireapp.model.realms.Status> statusesList = ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$statuses();
        if (statusesList != null && statusesList.size() == statusesOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = statusesList.size();
            for (int i = 0; i < objects; i++) {
                com.infinite.fireapp.model.realms.Status statusesItem = statusesList.get(i);
                Long cacheItemIndexstatuses = cache.get(statusesItem);
                if (cacheItemIndexstatuses == null) {
                    cacheItemIndexstatuses = com_infinite_fireapp_model_realms_StatusRealmProxy.insertOrUpdate(realm, statusesItem, cache);
                }
                statusesOsList.setRow(i, cacheItemIndexstatuses);
            }
        } else {
            statusesOsList.removeAll();
            if (statusesList != null) {
                for (com.infinite.fireapp.model.realms.Status statusesItem : statusesList) {
                    Long cacheItemIndexstatuses = cache.get(statusesItem);
                    if (cacheItemIndexstatuses == null) {
                        cacheItemIndexstatuses = com_infinite_fireapp_model_realms_StatusRealmProxy.insertOrUpdate(realm, statusesItem, cache);
                    }
                    statusesOsList.addRow(cacheItemIndexstatuses);
                }
            }
        }

        Table.nativeSetBoolean(tableNativePtr, columnInfo.areAllSeenIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$areAllSeen(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.UserStatuses.class);
        long tableNativePtr = table.getNativePtr();
        UserStatusesColumnInfo columnInfo = (UserStatusesColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.UserStatuses.class);
        long pkColumnIndex = columnInfo.userIdIndex;
        com.infinite.fireapp.model.realms.UserStatuses object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.UserStatuses) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$userId();
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
            Table.nativeSetLong(tableNativePtr, columnInfo.lastStatusTimestampIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$lastStatusTimestamp(), false);

            com.infinite.fireapp.model.realms.User userObj = ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$user();
            if (userObj != null) {
                Long cacheuser = cache.get(userObj);
                if (cacheuser == null) {
                    cacheuser = com_infinite_fireapp_model_realms_UserRealmProxy.insertOrUpdate(realm, userObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.userIndex, rowIndex);
            }

            OsList statusesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.statusesIndex);
            RealmList<com.infinite.fireapp.model.realms.Status> statusesList = ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$statuses();
            if (statusesList != null && statusesList.size() == statusesOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = statusesList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.infinite.fireapp.model.realms.Status statusesItem = statusesList.get(i);
                    Long cacheItemIndexstatuses = cache.get(statusesItem);
                    if (cacheItemIndexstatuses == null) {
                        cacheItemIndexstatuses = com_infinite_fireapp_model_realms_StatusRealmProxy.insertOrUpdate(realm, statusesItem, cache);
                    }
                    statusesOsList.setRow(i, cacheItemIndexstatuses);
                }
            } else {
                statusesOsList.removeAll();
                if (statusesList != null) {
                    for (com.infinite.fireapp.model.realms.Status statusesItem : statusesList) {
                        Long cacheItemIndexstatuses = cache.get(statusesItem);
                        if (cacheItemIndexstatuses == null) {
                            cacheItemIndexstatuses = com_infinite_fireapp_model_realms_StatusRealmProxy.insertOrUpdate(realm, statusesItem, cache);
                        }
                        statusesOsList.addRow(cacheItemIndexstatuses);
                    }
                }
            }

            Table.nativeSetBoolean(tableNativePtr, columnInfo.areAllSeenIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) object).realmGet$areAllSeen(), false);
        }
    }

    public static com.infinite.fireapp.model.realms.UserStatuses createDetachedCopy(com.infinite.fireapp.model.realms.UserStatuses realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.infinite.fireapp.model.realms.UserStatuses unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.infinite.fireapp.model.realms.UserStatuses();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.infinite.fireapp.model.realms.UserStatuses) cachedObject.object;
            }
            unmanagedObject = (com.infinite.fireapp.model.realms.UserStatuses) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface unmanagedCopy = (com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) unmanagedObject;
        com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface realmSource = (com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$userId(realmSource.realmGet$userId());
        unmanagedCopy.realmSet$lastStatusTimestamp(realmSource.realmGet$lastStatusTimestamp());

        // Deep copy of user
        unmanagedCopy.realmSet$user(com_infinite_fireapp_model_realms_UserRealmProxy.createDetachedCopy(realmSource.realmGet$user(), currentDepth + 1, maxDepth, cache));

        // Deep copy of statuses
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$statuses(null);
        } else {
            RealmList<com.infinite.fireapp.model.realms.Status> managedstatusesList = realmSource.realmGet$statuses();
            RealmList<com.infinite.fireapp.model.realms.Status> unmanagedstatusesList = new RealmList<com.infinite.fireapp.model.realms.Status>();
            unmanagedCopy.realmSet$statuses(unmanagedstatusesList);
            int nextDepth = currentDepth + 1;
            int size = managedstatusesList.size();
            for (int i = 0; i < size; i++) {
                com.infinite.fireapp.model.realms.Status item = com_infinite_fireapp_model_realms_StatusRealmProxy.createDetachedCopy(managedstatusesList.get(i), nextDepth, maxDepth, cache);
                unmanagedstatusesList.add(item);
            }
        }
        unmanagedCopy.realmSet$areAllSeen(realmSource.realmGet$areAllSeen());

        return unmanagedObject;
    }

    static com.infinite.fireapp.model.realms.UserStatuses update(Realm realm, com.infinite.fireapp.model.realms.UserStatuses realmObject, com.infinite.fireapp.model.realms.UserStatuses newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface realmObjectTarget = (com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) realmObject;
        com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface realmObjectSource = (com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$lastStatusTimestamp(realmObjectSource.realmGet$lastStatusTimestamp());
        com.infinite.fireapp.model.realms.User userObj = realmObjectSource.realmGet$user();
        if (userObj == null) {
            realmObjectTarget.realmSet$user(null);
        } else {
            com.infinite.fireapp.model.realms.User cacheuser = (com.infinite.fireapp.model.realms.User) cache.get(userObj);
            if (cacheuser != null) {
                realmObjectTarget.realmSet$user(cacheuser);
            } else {
                realmObjectTarget.realmSet$user(com_infinite_fireapp_model_realms_UserRealmProxy.copyOrUpdate(realm, userObj, true, cache));
            }
        }
        RealmList<com.infinite.fireapp.model.realms.Status> statusesList = realmObjectSource.realmGet$statuses();
        RealmList<com.infinite.fireapp.model.realms.Status> statusesRealmList = realmObjectTarget.realmGet$statuses();
        if (statusesList != null && statusesList.size() == statusesRealmList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = statusesList.size();
            for (int i = 0; i < objects; i++) {
                com.infinite.fireapp.model.realms.Status statusesItem = statusesList.get(i);
                com.infinite.fireapp.model.realms.Status cachestatuses = (com.infinite.fireapp.model.realms.Status) cache.get(statusesItem);
                if (cachestatuses != null) {
                    statusesRealmList.set(i, cachestatuses);
                } else {
                    statusesRealmList.set(i, com_infinite_fireapp_model_realms_StatusRealmProxy.copyOrUpdate(realm, statusesItem, true, cache));
                }
            }
        } else {
            statusesRealmList.clear();
            if (statusesList != null) {
                for (int i = 0; i < statusesList.size(); i++) {
                    com.infinite.fireapp.model.realms.Status statusesItem = statusesList.get(i);
                    com.infinite.fireapp.model.realms.Status cachestatuses = (com.infinite.fireapp.model.realms.Status) cache.get(statusesItem);
                    if (cachestatuses != null) {
                        statusesRealmList.add(cachestatuses);
                    } else {
                        statusesRealmList.add(com_infinite_fireapp_model_realms_StatusRealmProxy.copyOrUpdate(realm, statusesItem, true, cache));
                    }
                }
            }
        }
        realmObjectTarget.realmSet$areAllSeen(realmObjectSource.realmGet$areAllSeen());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("UserStatuses = proxy[");
        stringBuilder.append("{userId:");
        stringBuilder.append(realmGet$userId() != null ? realmGet$userId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lastStatusTimestamp:");
        stringBuilder.append(realmGet$lastStatusTimestamp());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{user:");
        stringBuilder.append(realmGet$user() != null ? "User" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{statuses:");
        stringBuilder.append("RealmList<Status>[").append(realmGet$statuses().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{areAllSeen:");
        stringBuilder.append(realmGet$areAllSeen());
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

}
