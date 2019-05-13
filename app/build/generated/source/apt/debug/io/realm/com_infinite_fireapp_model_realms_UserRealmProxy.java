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
public class com_infinite_fireapp_model_realms_UserRealmProxy extends com.infinite.fireapp.model.realms.User
    implements RealmObjectProxy, com_infinite_fireapp_model_realms_UserRealmProxyInterface {

    static final class UserColumnInfo extends ColumnInfo {
        long uidIndex;
        long photoIndex;
        long statusIndex;
        long phoneIndex;
        long userLocalPhotoIndex;
        long userNameIndex;
        long isBlockedIndex;
        long pointIndex;
        long appVerIndex;
        long thumbImgIndex;
        long isGroupBoolIndex;
        long groupIndex;
        long broadcastIndex;
        long isBroadcastBoolIndex;
        long isStoredInContactsIndex;

        UserColumnInfo(OsSchemaInfo schemaInfo) {
            super(15);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("User");
            this.uidIndex = addColumnDetails("uid", "uid", objectSchemaInfo);
            this.photoIndex = addColumnDetails("photo", "photo", objectSchemaInfo);
            this.statusIndex = addColumnDetails("status", "status", objectSchemaInfo);
            this.phoneIndex = addColumnDetails("phone", "phone", objectSchemaInfo);
            this.userLocalPhotoIndex = addColumnDetails("userLocalPhoto", "userLocalPhoto", objectSchemaInfo);
            this.userNameIndex = addColumnDetails("userName", "userName", objectSchemaInfo);
            this.isBlockedIndex = addColumnDetails("isBlocked", "isBlocked", objectSchemaInfo);
            this.pointIndex = addColumnDetails("point", "point", objectSchemaInfo);
            this.appVerIndex = addColumnDetails("appVer", "appVer", objectSchemaInfo);
            this.thumbImgIndex = addColumnDetails("thumbImg", "thumbImg", objectSchemaInfo);
            this.isGroupBoolIndex = addColumnDetails("isGroupBool", "isGroupBool", objectSchemaInfo);
            this.groupIndex = addColumnDetails("group", "group", objectSchemaInfo);
            this.broadcastIndex = addColumnDetails("broadcast", "broadcast", objectSchemaInfo);
            this.isBroadcastBoolIndex = addColumnDetails("isBroadcastBool", "isBroadcastBool", objectSchemaInfo);
            this.isStoredInContactsIndex = addColumnDetails("isStoredInContacts", "isStoredInContacts", objectSchemaInfo);
        }

        UserColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UserColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UserColumnInfo src = (UserColumnInfo) rawSrc;
            final UserColumnInfo dst = (UserColumnInfo) rawDst;
            dst.uidIndex = src.uidIndex;
            dst.photoIndex = src.photoIndex;
            dst.statusIndex = src.statusIndex;
            dst.phoneIndex = src.phoneIndex;
            dst.userLocalPhotoIndex = src.userLocalPhotoIndex;
            dst.userNameIndex = src.userNameIndex;
            dst.isBlockedIndex = src.isBlockedIndex;
            dst.pointIndex = src.pointIndex;
            dst.appVerIndex = src.appVerIndex;
            dst.thumbImgIndex = src.thumbImgIndex;
            dst.isGroupBoolIndex = src.isGroupBoolIndex;
            dst.groupIndex = src.groupIndex;
            dst.broadcastIndex = src.broadcastIndex;
            dst.isBroadcastBoolIndex = src.isBroadcastBoolIndex;
            dst.isStoredInContactsIndex = src.isStoredInContactsIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UserColumnInfo columnInfo;
    private ProxyState<com.infinite.fireapp.model.realms.User> proxyState;

    com_infinite_fireapp_model_realms_UserRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.infinite.fireapp.model.realms.User>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$uid() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.uidIndex);
    }

    @Override
    public void realmSet$uid(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'uid' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$photo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.photoIndex);
    }

    @Override
    public void realmSet$photo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.photoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.photoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.photoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.photoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$status() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.statusIndex);
    }

    @Override
    public void realmSet$status(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.statusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.statusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.statusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.statusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$phone() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.phoneIndex);
    }

    @Override
    public void realmSet$phone(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.phoneIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.phoneIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.phoneIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.phoneIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$userLocalPhoto() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.userLocalPhotoIndex);
    }

    @Override
    public void realmSet$userLocalPhoto(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.userLocalPhotoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.userLocalPhotoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.userLocalPhotoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.userLocalPhotoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$userName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.userNameIndex);
    }

    @Override
    public void realmSet$userName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.userNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.userNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.userNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.userNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isBlocked() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isBlockedIndex);
    }

    @Override
    public void realmSet$isBlocked(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isBlockedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isBlockedIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$point() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.pointIndex);
    }

    @Override
    public void realmSet$point(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.pointIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.pointIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$appVer() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.appVerIndex);
    }

    @Override
    public void realmSet$appVer(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.appVerIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.appVerIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.appVerIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.appVerIndex, value);
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
    public boolean realmGet$isGroupBool() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isGroupBoolIndex);
    }

    @Override
    public void realmSet$isGroupBool(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isGroupBoolIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isGroupBoolIndex, value);
    }

    @Override
    public com.infinite.fireapp.model.realms.Group realmGet$group() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.groupIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.infinite.fireapp.model.realms.Group.class, proxyState.getRow$realm().getLink(columnInfo.groupIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$group(com.infinite.fireapp.model.realms.Group value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("group")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.groupIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.groupIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.groupIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.groupIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public com.infinite.fireapp.model.realms.Broadcast realmGet$broadcast() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.broadcastIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.infinite.fireapp.model.realms.Broadcast.class, proxyState.getRow$realm().getLink(columnInfo.broadcastIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$broadcast(com.infinite.fireapp.model.realms.Broadcast value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("broadcast")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.broadcastIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.broadcastIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.broadcastIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.broadcastIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isBroadcastBool() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isBroadcastBoolIndex);
    }

    @Override
    public void realmSet$isBroadcastBool(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isBroadcastBoolIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isBroadcastBoolIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isStoredInContacts() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isStoredInContactsIndex);
    }

    @Override
    public void realmSet$isStoredInContacts(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isStoredInContactsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isStoredInContactsIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("User", 15, 0);
        builder.addPersistedProperty("uid", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("photo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("phone", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("userLocalPhoto", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("userName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("isBlocked", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("point", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("appVer", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("thumbImg", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("isGroupBool", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedLinkProperty("group", RealmFieldType.OBJECT, "Group");
        builder.addPersistedLinkProperty("broadcast", RealmFieldType.OBJECT, "Broadcast");
        builder.addPersistedProperty("isBroadcastBool", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("isStoredInContacts", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UserColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UserColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "User";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "User";
    }

    @SuppressWarnings("cast")
    public static com.infinite.fireapp.model.realms.User createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        com.infinite.fireapp.model.realms.User obj = null;
        if (update) {
            Table table = realm.getTable(com.infinite.fireapp.model.realms.User.class);
            UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.User.class);
            long pkColumnIndex = columnInfo.uidIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("uid")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("uid"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.User.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_infinite_fireapp_model_realms_UserRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("group")) {
                excludeFields.add("group");
            }
            if (json.has("broadcast")) {
                excludeFields.add("broadcast");
            }
            if (json.has("uid")) {
                if (json.isNull("uid")) {
                    obj = (io.realm.com_infinite_fireapp_model_realms_UserRealmProxy) realm.createObjectInternal(com.infinite.fireapp.model.realms.User.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_infinite_fireapp_model_realms_UserRealmProxy) realm.createObjectInternal(com.infinite.fireapp.model.realms.User.class, json.getString("uid"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'uid'.");
            }
        }

        final com_infinite_fireapp_model_realms_UserRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_UserRealmProxyInterface) obj;
        if (json.has("photo")) {
            if (json.isNull("photo")) {
                objProxy.realmSet$photo(null);
            } else {
                objProxy.realmSet$photo((String) json.getString("photo"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                objProxy.realmSet$status(null);
            } else {
                objProxy.realmSet$status((String) json.getString("status"));
            }
        }
        if (json.has("phone")) {
            if (json.isNull("phone")) {
                objProxy.realmSet$phone(null);
            } else {
                objProxy.realmSet$phone((String) json.getString("phone"));
            }
        }
        if (json.has("userLocalPhoto")) {
            if (json.isNull("userLocalPhoto")) {
                objProxy.realmSet$userLocalPhoto(null);
            } else {
                objProxy.realmSet$userLocalPhoto((String) json.getString("userLocalPhoto"));
            }
        }
        if (json.has("userName")) {
            if (json.isNull("userName")) {
                objProxy.realmSet$userName(null);
            } else {
                objProxy.realmSet$userName((String) json.getString("userName"));
            }
        }
        if (json.has("isBlocked")) {
            if (json.isNull("isBlocked")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isBlocked' to null.");
            } else {
                objProxy.realmSet$isBlocked((boolean) json.getBoolean("isBlocked"));
            }
        }
        if (json.has("point")) {
            if (json.isNull("point")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'point' to null.");
            } else {
                objProxy.realmSet$point((int) json.getInt("point"));
            }
        }
        if (json.has("appVer")) {
            if (json.isNull("appVer")) {
                objProxy.realmSet$appVer(null);
            } else {
                objProxy.realmSet$appVer((String) json.getString("appVer"));
            }
        }
        if (json.has("thumbImg")) {
            if (json.isNull("thumbImg")) {
                objProxy.realmSet$thumbImg(null);
            } else {
                objProxy.realmSet$thumbImg((String) json.getString("thumbImg"));
            }
        }
        if (json.has("isGroupBool")) {
            if (json.isNull("isGroupBool")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isGroupBool' to null.");
            } else {
                objProxy.realmSet$isGroupBool((boolean) json.getBoolean("isGroupBool"));
            }
        }
        if (json.has("group")) {
            if (json.isNull("group")) {
                objProxy.realmSet$group(null);
            } else {
                com.infinite.fireapp.model.realms.Group groupObj = com_infinite_fireapp_model_realms_GroupRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("group"), update);
                objProxy.realmSet$group(groupObj);
            }
        }
        if (json.has("broadcast")) {
            if (json.isNull("broadcast")) {
                objProxy.realmSet$broadcast(null);
            } else {
                com.infinite.fireapp.model.realms.Broadcast broadcastObj = com_infinite_fireapp_model_realms_BroadcastRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("broadcast"), update);
                objProxy.realmSet$broadcast(broadcastObj);
            }
        }
        if (json.has("isBroadcastBool")) {
            if (json.isNull("isBroadcastBool")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isBroadcastBool' to null.");
            } else {
                objProxy.realmSet$isBroadcastBool((boolean) json.getBoolean("isBroadcastBool"));
            }
        }
        if (json.has("isStoredInContacts")) {
            if (json.isNull("isStoredInContacts")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isStoredInContacts' to null.");
            } else {
                objProxy.realmSet$isStoredInContacts((boolean) json.getBoolean("isStoredInContacts"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.infinite.fireapp.model.realms.User createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.infinite.fireapp.model.realms.User obj = new com.infinite.fireapp.model.realms.User();
        final com_infinite_fireapp_model_realms_UserRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_UserRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("uid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$uid((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$uid(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("photo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$photo((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$photo(null);
                }
            } else if (name.equals("status")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$status((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$status(null);
                }
            } else if (name.equals("phone")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$phone((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$phone(null);
                }
            } else if (name.equals("userLocalPhoto")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userLocalPhoto((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$userLocalPhoto(null);
                }
            } else if (name.equals("userName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$userName(null);
                }
            } else if (name.equals("isBlocked")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isBlocked((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isBlocked' to null.");
                }
            } else if (name.equals("point")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$point((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'point' to null.");
                }
            } else if (name.equals("appVer")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$appVer((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$appVer(null);
                }
            } else if (name.equals("thumbImg")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$thumbImg((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$thumbImg(null);
                }
            } else if (name.equals("isGroupBool")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isGroupBool((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isGroupBool' to null.");
                }
            } else if (name.equals("group")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$group(null);
                } else {
                    com.infinite.fireapp.model.realms.Group groupObj = com_infinite_fireapp_model_realms_GroupRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$group(groupObj);
                }
            } else if (name.equals("broadcast")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$broadcast(null);
                } else {
                    com.infinite.fireapp.model.realms.Broadcast broadcastObj = com_infinite_fireapp_model_realms_BroadcastRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$broadcast(broadcastObj);
                }
            } else if (name.equals("isBroadcastBool")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isBroadcastBool((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isBroadcastBool' to null.");
                }
            } else if (name.equals("isStoredInContacts")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isStoredInContacts((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isStoredInContacts' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'uid'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.infinite.fireapp.model.realms.User copyOrUpdate(Realm realm, com.infinite.fireapp.model.realms.User object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.infinite.fireapp.model.realms.User) cachedRealmObject;
        }

        com.infinite.fireapp.model.realms.User realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.infinite.fireapp.model.realms.User.class);
            UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.User.class);
            long pkColumnIndex = columnInfo.uidIndex;
            String value = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$uid();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.User.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_infinite_fireapp_model_realms_UserRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.infinite.fireapp.model.realms.User copy(Realm realm, com.infinite.fireapp.model.realms.User newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.infinite.fireapp.model.realms.User) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.infinite.fireapp.model.realms.User realmObject = realm.createObjectInternal(com.infinite.fireapp.model.realms.User.class, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) newObject).realmGet$uid(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_infinite_fireapp_model_realms_UserRealmProxyInterface realmObjectSource = (com_infinite_fireapp_model_realms_UserRealmProxyInterface) newObject;
        com_infinite_fireapp_model_realms_UserRealmProxyInterface realmObjectCopy = (com_infinite_fireapp_model_realms_UserRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$photo(realmObjectSource.realmGet$photo());
        realmObjectCopy.realmSet$status(realmObjectSource.realmGet$status());
        realmObjectCopy.realmSet$phone(realmObjectSource.realmGet$phone());
        realmObjectCopy.realmSet$userLocalPhoto(realmObjectSource.realmGet$userLocalPhoto());
        realmObjectCopy.realmSet$userName(realmObjectSource.realmGet$userName());
        realmObjectCopy.realmSet$isBlocked(realmObjectSource.realmGet$isBlocked());
        realmObjectCopy.realmSet$point(realmObjectSource.realmGet$point());
        realmObjectCopy.realmSet$appVer(realmObjectSource.realmGet$appVer());
        realmObjectCopy.realmSet$thumbImg(realmObjectSource.realmGet$thumbImg());
        realmObjectCopy.realmSet$isGroupBool(realmObjectSource.realmGet$isGroupBool());

        com.infinite.fireapp.model.realms.Group groupObj = realmObjectSource.realmGet$group();
        if (groupObj == null) {
            realmObjectCopy.realmSet$group(null);
        } else {
            com.infinite.fireapp.model.realms.Group cachegroup = (com.infinite.fireapp.model.realms.Group) cache.get(groupObj);
            if (cachegroup != null) {
                realmObjectCopy.realmSet$group(cachegroup);
            } else {
                realmObjectCopy.realmSet$group(com_infinite_fireapp_model_realms_GroupRealmProxy.copyOrUpdate(realm, groupObj, update, cache));
            }
        }

        com.infinite.fireapp.model.realms.Broadcast broadcastObj = realmObjectSource.realmGet$broadcast();
        if (broadcastObj == null) {
            realmObjectCopy.realmSet$broadcast(null);
        } else {
            com.infinite.fireapp.model.realms.Broadcast cachebroadcast = (com.infinite.fireapp.model.realms.Broadcast) cache.get(broadcastObj);
            if (cachebroadcast != null) {
                realmObjectCopy.realmSet$broadcast(cachebroadcast);
            } else {
                realmObjectCopy.realmSet$broadcast(com_infinite_fireapp_model_realms_BroadcastRealmProxy.copyOrUpdate(realm, broadcastObj, update, cache));
            }
        }
        realmObjectCopy.realmSet$isBroadcastBool(realmObjectSource.realmGet$isBroadcastBool());
        realmObjectCopy.realmSet$isStoredInContacts(realmObjectSource.realmGet$isStoredInContacts());
        return realmObject;
    }

    public static long insert(Realm realm, com.infinite.fireapp.model.realms.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.User.class);
        long pkColumnIndex = columnInfo.uidIndex;
        String primaryKeyValue = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$uid();
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
        String realmGet$photo = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$photo();
        if (realmGet$photo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.photoIndex, rowIndex, realmGet$photo, false);
        }
        String realmGet$status = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        }
        String realmGet$phone = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$phone();
        if (realmGet$phone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phoneIndex, rowIndex, realmGet$phone, false);
        }
        String realmGet$userLocalPhoto = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$userLocalPhoto();
        if (realmGet$userLocalPhoto != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userLocalPhotoIndex, rowIndex, realmGet$userLocalPhoto, false);
        }
        String realmGet$userName = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$userName();
        if (realmGet$userName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userNameIndex, rowIndex, realmGet$userName, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isBlockedIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$isBlocked(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.pointIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$point(), false);
        String realmGet$appVer = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$appVer();
        if (realmGet$appVer != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.appVerIndex, rowIndex, realmGet$appVer, false);
        }
        String realmGet$thumbImg = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$thumbImg();
        if (realmGet$thumbImg != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.thumbImgIndex, rowIndex, realmGet$thumbImg, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isGroupBoolIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$isGroupBool(), false);

        com.infinite.fireapp.model.realms.Group groupObj = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$group();
        if (groupObj != null) {
            Long cachegroup = cache.get(groupObj);
            if (cachegroup == null) {
                cachegroup = com_infinite_fireapp_model_realms_GroupRealmProxy.insert(realm, groupObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.groupIndex, rowIndex, cachegroup, false);
        }

        com.infinite.fireapp.model.realms.Broadcast broadcastObj = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$broadcast();
        if (broadcastObj != null) {
            Long cachebroadcast = cache.get(broadcastObj);
            if (cachebroadcast == null) {
                cachebroadcast = com_infinite_fireapp_model_realms_BroadcastRealmProxy.insert(realm, broadcastObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.broadcastIndex, rowIndex, cachebroadcast, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isBroadcastBoolIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$isBroadcastBool(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isStoredInContactsIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$isStoredInContacts(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.User.class);
        long pkColumnIndex = columnInfo.uidIndex;
        com.infinite.fireapp.model.realms.User object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$uid();
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
            String realmGet$photo = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$photo();
            if (realmGet$photo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.photoIndex, rowIndex, realmGet$photo, false);
            }
            String realmGet$status = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
            }
            String realmGet$phone = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$phone();
            if (realmGet$phone != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.phoneIndex, rowIndex, realmGet$phone, false);
            }
            String realmGet$userLocalPhoto = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$userLocalPhoto();
            if (realmGet$userLocalPhoto != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userLocalPhotoIndex, rowIndex, realmGet$userLocalPhoto, false);
            }
            String realmGet$userName = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$userName();
            if (realmGet$userName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userNameIndex, rowIndex, realmGet$userName, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isBlockedIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$isBlocked(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.pointIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$point(), false);
            String realmGet$appVer = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$appVer();
            if (realmGet$appVer != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.appVerIndex, rowIndex, realmGet$appVer, false);
            }
            String realmGet$thumbImg = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$thumbImg();
            if (realmGet$thumbImg != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.thumbImgIndex, rowIndex, realmGet$thumbImg, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isGroupBoolIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$isGroupBool(), false);

            com.infinite.fireapp.model.realms.Group groupObj = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$group();
            if (groupObj != null) {
                Long cachegroup = cache.get(groupObj);
                if (cachegroup == null) {
                    cachegroup = com_infinite_fireapp_model_realms_GroupRealmProxy.insert(realm, groupObj, cache);
                }
                table.setLink(columnInfo.groupIndex, rowIndex, cachegroup, false);
            }

            com.infinite.fireapp.model.realms.Broadcast broadcastObj = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$broadcast();
            if (broadcastObj != null) {
                Long cachebroadcast = cache.get(broadcastObj);
                if (cachebroadcast == null) {
                    cachebroadcast = com_infinite_fireapp_model_realms_BroadcastRealmProxy.insert(realm, broadcastObj, cache);
                }
                table.setLink(columnInfo.broadcastIndex, rowIndex, cachebroadcast, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isBroadcastBoolIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$isBroadcastBool(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isStoredInContactsIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$isStoredInContacts(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.infinite.fireapp.model.realms.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.User.class);
        long pkColumnIndex = columnInfo.uidIndex;
        String primaryKeyValue = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$uid();
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
        String realmGet$photo = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$photo();
        if (realmGet$photo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.photoIndex, rowIndex, realmGet$photo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.photoIndex, rowIndex, false);
        }
        String realmGet$status = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
        }
        String realmGet$phone = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$phone();
        if (realmGet$phone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phoneIndex, rowIndex, realmGet$phone, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.phoneIndex, rowIndex, false);
        }
        String realmGet$userLocalPhoto = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$userLocalPhoto();
        if (realmGet$userLocalPhoto != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userLocalPhotoIndex, rowIndex, realmGet$userLocalPhoto, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.userLocalPhotoIndex, rowIndex, false);
        }
        String realmGet$userName = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$userName();
        if (realmGet$userName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userNameIndex, rowIndex, realmGet$userName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.userNameIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isBlockedIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$isBlocked(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.pointIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$point(), false);
        String realmGet$appVer = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$appVer();
        if (realmGet$appVer != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.appVerIndex, rowIndex, realmGet$appVer, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.appVerIndex, rowIndex, false);
        }
        String realmGet$thumbImg = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$thumbImg();
        if (realmGet$thumbImg != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.thumbImgIndex, rowIndex, realmGet$thumbImg, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.thumbImgIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isGroupBoolIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$isGroupBool(), false);

        com.infinite.fireapp.model.realms.Group groupObj = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$group();
        if (groupObj != null) {
            Long cachegroup = cache.get(groupObj);
            if (cachegroup == null) {
                cachegroup = com_infinite_fireapp_model_realms_GroupRealmProxy.insertOrUpdate(realm, groupObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.groupIndex, rowIndex, cachegroup, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.groupIndex, rowIndex);
        }

        com.infinite.fireapp.model.realms.Broadcast broadcastObj = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$broadcast();
        if (broadcastObj != null) {
            Long cachebroadcast = cache.get(broadcastObj);
            if (cachebroadcast == null) {
                cachebroadcast = com_infinite_fireapp_model_realms_BroadcastRealmProxy.insertOrUpdate(realm, broadcastObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.broadcastIndex, rowIndex, cachebroadcast, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.broadcastIndex, rowIndex);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isBroadcastBoolIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$isBroadcastBool(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isStoredInContactsIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$isStoredInContacts(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.User.class);
        long pkColumnIndex = columnInfo.uidIndex;
        com.infinite.fireapp.model.realms.User object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$uid();
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
            String realmGet$photo = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$photo();
            if (realmGet$photo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.photoIndex, rowIndex, realmGet$photo, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.photoIndex, rowIndex, false);
            }
            String realmGet$status = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
            }
            String realmGet$phone = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$phone();
            if (realmGet$phone != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.phoneIndex, rowIndex, realmGet$phone, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.phoneIndex, rowIndex, false);
            }
            String realmGet$userLocalPhoto = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$userLocalPhoto();
            if (realmGet$userLocalPhoto != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userLocalPhotoIndex, rowIndex, realmGet$userLocalPhoto, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.userLocalPhotoIndex, rowIndex, false);
            }
            String realmGet$userName = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$userName();
            if (realmGet$userName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userNameIndex, rowIndex, realmGet$userName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.userNameIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isBlockedIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$isBlocked(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.pointIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$point(), false);
            String realmGet$appVer = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$appVer();
            if (realmGet$appVer != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.appVerIndex, rowIndex, realmGet$appVer, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.appVerIndex, rowIndex, false);
            }
            String realmGet$thumbImg = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$thumbImg();
            if (realmGet$thumbImg != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.thumbImgIndex, rowIndex, realmGet$thumbImg, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.thumbImgIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isGroupBoolIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$isGroupBool(), false);

            com.infinite.fireapp.model.realms.Group groupObj = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$group();
            if (groupObj != null) {
                Long cachegroup = cache.get(groupObj);
                if (cachegroup == null) {
                    cachegroup = com_infinite_fireapp_model_realms_GroupRealmProxy.insertOrUpdate(realm, groupObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.groupIndex, rowIndex, cachegroup, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.groupIndex, rowIndex);
            }

            com.infinite.fireapp.model.realms.Broadcast broadcastObj = ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$broadcast();
            if (broadcastObj != null) {
                Long cachebroadcast = cache.get(broadcastObj);
                if (cachebroadcast == null) {
                    cachebroadcast = com_infinite_fireapp_model_realms_BroadcastRealmProxy.insertOrUpdate(realm, broadcastObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.broadcastIndex, rowIndex, cachebroadcast, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.broadcastIndex, rowIndex);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isBroadcastBoolIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$isBroadcastBool(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isStoredInContactsIndex, rowIndex, ((com_infinite_fireapp_model_realms_UserRealmProxyInterface) object).realmGet$isStoredInContacts(), false);
        }
    }

    public static com.infinite.fireapp.model.realms.User createDetachedCopy(com.infinite.fireapp.model.realms.User realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.infinite.fireapp.model.realms.User unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.infinite.fireapp.model.realms.User();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.infinite.fireapp.model.realms.User) cachedObject.object;
            }
            unmanagedObject = (com.infinite.fireapp.model.realms.User) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_infinite_fireapp_model_realms_UserRealmProxyInterface unmanagedCopy = (com_infinite_fireapp_model_realms_UserRealmProxyInterface) unmanagedObject;
        com_infinite_fireapp_model_realms_UserRealmProxyInterface realmSource = (com_infinite_fireapp_model_realms_UserRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$uid(realmSource.realmGet$uid());
        unmanagedCopy.realmSet$photo(realmSource.realmGet$photo());
        unmanagedCopy.realmSet$status(realmSource.realmGet$status());
        unmanagedCopy.realmSet$phone(realmSource.realmGet$phone());
        unmanagedCopy.realmSet$userLocalPhoto(realmSource.realmGet$userLocalPhoto());
        unmanagedCopy.realmSet$userName(realmSource.realmGet$userName());
        unmanagedCopy.realmSet$isBlocked(realmSource.realmGet$isBlocked());
        unmanagedCopy.realmSet$point(realmSource.realmGet$point());
        unmanagedCopy.realmSet$appVer(realmSource.realmGet$appVer());
        unmanagedCopy.realmSet$thumbImg(realmSource.realmGet$thumbImg());
        unmanagedCopy.realmSet$isGroupBool(realmSource.realmGet$isGroupBool());

        // Deep copy of group
        unmanagedCopy.realmSet$group(com_infinite_fireapp_model_realms_GroupRealmProxy.createDetachedCopy(realmSource.realmGet$group(), currentDepth + 1, maxDepth, cache));

        // Deep copy of broadcast
        unmanagedCopy.realmSet$broadcast(com_infinite_fireapp_model_realms_BroadcastRealmProxy.createDetachedCopy(realmSource.realmGet$broadcast(), currentDepth + 1, maxDepth, cache));
        unmanagedCopy.realmSet$isBroadcastBool(realmSource.realmGet$isBroadcastBool());
        unmanagedCopy.realmSet$isStoredInContacts(realmSource.realmGet$isStoredInContacts());

        return unmanagedObject;
    }

    static com.infinite.fireapp.model.realms.User update(Realm realm, com.infinite.fireapp.model.realms.User realmObject, com.infinite.fireapp.model.realms.User newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_infinite_fireapp_model_realms_UserRealmProxyInterface realmObjectTarget = (com_infinite_fireapp_model_realms_UserRealmProxyInterface) realmObject;
        com_infinite_fireapp_model_realms_UserRealmProxyInterface realmObjectSource = (com_infinite_fireapp_model_realms_UserRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$photo(realmObjectSource.realmGet$photo());
        realmObjectTarget.realmSet$status(realmObjectSource.realmGet$status());
        realmObjectTarget.realmSet$phone(realmObjectSource.realmGet$phone());
        realmObjectTarget.realmSet$userLocalPhoto(realmObjectSource.realmGet$userLocalPhoto());
        realmObjectTarget.realmSet$userName(realmObjectSource.realmGet$userName());
        realmObjectTarget.realmSet$isBlocked(realmObjectSource.realmGet$isBlocked());
        realmObjectTarget.realmSet$point(realmObjectSource.realmGet$point());
        realmObjectTarget.realmSet$appVer(realmObjectSource.realmGet$appVer());
        realmObjectTarget.realmSet$thumbImg(realmObjectSource.realmGet$thumbImg());
        realmObjectTarget.realmSet$isGroupBool(realmObjectSource.realmGet$isGroupBool());
        com.infinite.fireapp.model.realms.Group groupObj = realmObjectSource.realmGet$group();
        if (groupObj == null) {
            realmObjectTarget.realmSet$group(null);
        } else {
            com.infinite.fireapp.model.realms.Group cachegroup = (com.infinite.fireapp.model.realms.Group) cache.get(groupObj);
            if (cachegroup != null) {
                realmObjectTarget.realmSet$group(cachegroup);
            } else {
                realmObjectTarget.realmSet$group(com_infinite_fireapp_model_realms_GroupRealmProxy.copyOrUpdate(realm, groupObj, true, cache));
            }
        }
        com.infinite.fireapp.model.realms.Broadcast broadcastObj = realmObjectSource.realmGet$broadcast();
        if (broadcastObj == null) {
            realmObjectTarget.realmSet$broadcast(null);
        } else {
            com.infinite.fireapp.model.realms.Broadcast cachebroadcast = (com.infinite.fireapp.model.realms.Broadcast) cache.get(broadcastObj);
            if (cachebroadcast != null) {
                realmObjectTarget.realmSet$broadcast(cachebroadcast);
            } else {
                realmObjectTarget.realmSet$broadcast(com_infinite_fireapp_model_realms_BroadcastRealmProxy.copyOrUpdate(realm, broadcastObj, true, cache));
            }
        }
        realmObjectTarget.realmSet$isBroadcastBool(realmObjectSource.realmGet$isBroadcastBool());
        realmObjectTarget.realmSet$isStoredInContacts(realmObjectSource.realmGet$isStoredInContacts());
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

}
