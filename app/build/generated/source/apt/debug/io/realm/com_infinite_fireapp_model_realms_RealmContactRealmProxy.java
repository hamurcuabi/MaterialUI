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
public class com_infinite_fireapp_model_realms_RealmContactRealmProxy extends com.infinite.fireapp.model.realms.RealmContact
    implements RealmObjectProxy, com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface {

    static final class RealmContactColumnInfo extends ColumnInfo {
        long nameIndex;
        long realmListIndex;

        RealmContactColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RealmContact");
            this.nameIndex = addColumnDetails("name", "name", objectSchemaInfo);
            this.realmListIndex = addColumnDetails("realmList", "realmList", objectSchemaInfo);
        }

        RealmContactColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RealmContactColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RealmContactColumnInfo src = (RealmContactColumnInfo) rawSrc;
            final RealmContactColumnInfo dst = (RealmContactColumnInfo) rawDst;
            dst.nameIndex = src.nameIndex;
            dst.realmListIndex = src.realmListIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private RealmContactColumnInfo columnInfo;
    private ProxyState<com.infinite.fireapp.model.realms.RealmContact> proxyState;
    private RealmList<com.infinite.fireapp.model.realms.PhoneNumber> realmListRealmList;

    com_infinite_fireapp_model_realms_RealmContactRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmContactColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.infinite.fireapp.model.realms.RealmContact>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    public RealmList<com.infinite.fireapp.model.realms.PhoneNumber> realmGet$realmList() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (realmListRealmList != null) {
            return realmListRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.realmListIndex);
            realmListRealmList = new RealmList<com.infinite.fireapp.model.realms.PhoneNumber>(com.infinite.fireapp.model.realms.PhoneNumber.class, osList, proxyState.getRealm$realm());
            return realmListRealmList;
        }
    }

    @Override
    public void realmSet$realmList(RealmList<com.infinite.fireapp.model.realms.PhoneNumber> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("realmList")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.infinite.fireapp.model.realms.PhoneNumber> original = value;
                value = new RealmList<com.infinite.fireapp.model.realms.PhoneNumber>();
                for (com.infinite.fireapp.model.realms.PhoneNumber item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.realmListIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.infinite.fireapp.model.realms.PhoneNumber linkedObject = value.get(i);
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
                com.infinite.fireapp.model.realms.PhoneNumber linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmContact", 2, 0);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("realmList", RealmFieldType.LIST, "PhoneNumber");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmContactColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RealmContactColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RealmContact";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "RealmContact";
    }

    @SuppressWarnings("cast")
    public static com.infinite.fireapp.model.realms.RealmContact createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        if (json.has("realmList")) {
            excludeFields.add("realmList");
        }
        com.infinite.fireapp.model.realms.RealmContact obj = realm.createObjectInternal(com.infinite.fireapp.model.realms.RealmContact.class, true, excludeFields);

        final com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("realmList")) {
            if (json.isNull("realmList")) {
                objProxy.realmSet$realmList(null);
            } else {
                objProxy.realmGet$realmList().clear();
                JSONArray array = json.getJSONArray("realmList");
                for (int i = 0; i < array.length(); i++) {
                    com.infinite.fireapp.model.realms.PhoneNumber item = com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$realmList().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.infinite.fireapp.model.realms.RealmContact createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.infinite.fireapp.model.realms.RealmContact obj = new com.infinite.fireapp.model.realms.RealmContact();
        final com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("realmList")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$realmList(null);
                } else {
                    objProxy.realmSet$realmList(new RealmList<com.infinite.fireapp.model.realms.PhoneNumber>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.infinite.fireapp.model.realms.PhoneNumber item = com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$realmList().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.infinite.fireapp.model.realms.RealmContact copyOrUpdate(Realm realm, com.infinite.fireapp.model.realms.RealmContact object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.infinite.fireapp.model.realms.RealmContact) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.infinite.fireapp.model.realms.RealmContact copy(Realm realm, com.infinite.fireapp.model.realms.RealmContact newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.infinite.fireapp.model.realms.RealmContact) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.infinite.fireapp.model.realms.RealmContact realmObject = realm.createObjectInternal(com.infinite.fireapp.model.realms.RealmContact.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface realmObjectSource = (com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface) newObject;
        com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface realmObjectCopy = (com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());

        RealmList<com.infinite.fireapp.model.realms.PhoneNumber> realmListList = realmObjectSource.realmGet$realmList();
        if (realmListList != null) {
            RealmList<com.infinite.fireapp.model.realms.PhoneNumber> realmListRealmList = realmObjectCopy.realmGet$realmList();
            realmListRealmList.clear();
            for (int i = 0; i < realmListList.size(); i++) {
                com.infinite.fireapp.model.realms.PhoneNumber realmListItem = realmListList.get(i);
                com.infinite.fireapp.model.realms.PhoneNumber cacherealmList = (com.infinite.fireapp.model.realms.PhoneNumber) cache.get(realmListItem);
                if (cacherealmList != null) {
                    realmListRealmList.add(cacherealmList);
                } else {
                    realmListRealmList.add(com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.copyOrUpdate(realm, realmListItem, update, cache));
                }
            }
        }

        return realmObject;
    }

    public static long insert(Realm realm, com.infinite.fireapp.model.realms.RealmContact object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.RealmContact.class);
        long tableNativePtr = table.getNativePtr();
        RealmContactColumnInfo columnInfo = (RealmContactColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.RealmContact.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$name = ((com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }

        RealmList<com.infinite.fireapp.model.realms.PhoneNumber> realmListList = ((com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface) object).realmGet$realmList();
        if (realmListList != null) {
            OsList realmListOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.realmListIndex);
            for (com.infinite.fireapp.model.realms.PhoneNumber realmListItem : realmListList) {
                Long cacheItemIndexrealmList = cache.get(realmListItem);
                if (cacheItemIndexrealmList == null) {
                    cacheItemIndexrealmList = com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.insert(realm, realmListItem, cache);
                }
                realmListOsList.addRow(cacheItemIndexrealmList);
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.RealmContact.class);
        long tableNativePtr = table.getNativePtr();
        RealmContactColumnInfo columnInfo = (RealmContactColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.RealmContact.class);
        com.infinite.fireapp.model.realms.RealmContact object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.RealmContact) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$name = ((com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }

            RealmList<com.infinite.fireapp.model.realms.PhoneNumber> realmListList = ((com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface) object).realmGet$realmList();
            if (realmListList != null) {
                OsList realmListOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.realmListIndex);
                for (com.infinite.fireapp.model.realms.PhoneNumber realmListItem : realmListList) {
                    Long cacheItemIndexrealmList = cache.get(realmListItem);
                    if (cacheItemIndexrealmList == null) {
                        cacheItemIndexrealmList = com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.insert(realm, realmListItem, cache);
                    }
                    realmListOsList.addRow(cacheItemIndexrealmList);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.infinite.fireapp.model.realms.RealmContact object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.RealmContact.class);
        long tableNativePtr = table.getNativePtr();
        RealmContactColumnInfo columnInfo = (RealmContactColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.RealmContact.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$name = ((com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }

        OsList realmListOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.realmListIndex);
        RealmList<com.infinite.fireapp.model.realms.PhoneNumber> realmListList = ((com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface) object).realmGet$realmList();
        if (realmListList != null && realmListList.size() == realmListOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = realmListList.size();
            for (int i = 0; i < objects; i++) {
                com.infinite.fireapp.model.realms.PhoneNumber realmListItem = realmListList.get(i);
                Long cacheItemIndexrealmList = cache.get(realmListItem);
                if (cacheItemIndexrealmList == null) {
                    cacheItemIndexrealmList = com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.insertOrUpdate(realm, realmListItem, cache);
                }
                realmListOsList.setRow(i, cacheItemIndexrealmList);
            }
        } else {
            realmListOsList.removeAll();
            if (realmListList != null) {
                for (com.infinite.fireapp.model.realms.PhoneNumber realmListItem : realmListList) {
                    Long cacheItemIndexrealmList = cache.get(realmListItem);
                    if (cacheItemIndexrealmList == null) {
                        cacheItemIndexrealmList = com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.insertOrUpdate(realm, realmListItem, cache);
                    }
                    realmListOsList.addRow(cacheItemIndexrealmList);
                }
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.RealmContact.class);
        long tableNativePtr = table.getNativePtr();
        RealmContactColumnInfo columnInfo = (RealmContactColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.RealmContact.class);
        com.infinite.fireapp.model.realms.RealmContact object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.RealmContact) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$name = ((com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }

            OsList realmListOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.realmListIndex);
            RealmList<com.infinite.fireapp.model.realms.PhoneNumber> realmListList = ((com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface) object).realmGet$realmList();
            if (realmListList != null && realmListList.size() == realmListOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = realmListList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.infinite.fireapp.model.realms.PhoneNumber realmListItem = realmListList.get(i);
                    Long cacheItemIndexrealmList = cache.get(realmListItem);
                    if (cacheItemIndexrealmList == null) {
                        cacheItemIndexrealmList = com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.insertOrUpdate(realm, realmListItem, cache);
                    }
                    realmListOsList.setRow(i, cacheItemIndexrealmList);
                }
            } else {
                realmListOsList.removeAll();
                if (realmListList != null) {
                    for (com.infinite.fireapp.model.realms.PhoneNumber realmListItem : realmListList) {
                        Long cacheItemIndexrealmList = cache.get(realmListItem);
                        if (cacheItemIndexrealmList == null) {
                            cacheItemIndexrealmList = com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.insertOrUpdate(realm, realmListItem, cache);
                        }
                        realmListOsList.addRow(cacheItemIndexrealmList);
                    }
                }
            }

        }
    }

    public static com.infinite.fireapp.model.realms.RealmContact createDetachedCopy(com.infinite.fireapp.model.realms.RealmContact realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.infinite.fireapp.model.realms.RealmContact unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.infinite.fireapp.model.realms.RealmContact();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.infinite.fireapp.model.realms.RealmContact) cachedObject.object;
            }
            unmanagedObject = (com.infinite.fireapp.model.realms.RealmContact) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface unmanagedCopy = (com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface) unmanagedObject;
        com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface realmSource = (com_infinite_fireapp_model_realms_RealmContactRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());

        // Deep copy of realmList
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$realmList(null);
        } else {
            RealmList<com.infinite.fireapp.model.realms.PhoneNumber> managedrealmListList = realmSource.realmGet$realmList();
            RealmList<com.infinite.fireapp.model.realms.PhoneNumber> unmanagedrealmListList = new RealmList<com.infinite.fireapp.model.realms.PhoneNumber>();
            unmanagedCopy.realmSet$realmList(unmanagedrealmListList);
            int nextDepth = currentDepth + 1;
            int size = managedrealmListList.size();
            for (int i = 0; i < size; i++) {
                com.infinite.fireapp.model.realms.PhoneNumber item = com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.createDetachedCopy(managedrealmListList.get(i), nextDepth, maxDepth, cache);
                unmanagedrealmListList.add(item);
            }
        }

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmContact = proxy[");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{realmList:");
        stringBuilder.append("RealmList<PhoneNumber>[").append(realmGet$realmList().size()).append("]");
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
        com_infinite_fireapp_model_realms_RealmContactRealmProxy aRealmContact = (com_infinite_fireapp_model_realms_RealmContactRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRealmContact.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRealmContact.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRealmContact.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
