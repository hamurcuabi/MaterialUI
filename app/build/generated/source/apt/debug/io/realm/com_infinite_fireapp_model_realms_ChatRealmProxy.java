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
public class com_infinite_fireapp_model_realms_ChatRealmProxy extends com.infinite.fireapp.model.realms.Chat
    implements RealmObjectProxy, com_infinite_fireapp_model_realms_ChatRealmProxyInterface {

    static final class ChatColumnInfo extends ColumnInfo {
        long chatIdIndex;
        long lastMessageIndex;
        long lastMessageTimestampIndex;
        long userIndex;
        long isMutedIndex;
        long unReadCountIndex;
        long firstUnreadMessageIdIndex;
        long notificationIdIndex;
        long unreadMessagesIndex;

        ChatColumnInfo(OsSchemaInfo schemaInfo) {
            super(9);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Chat");
            this.chatIdIndex = addColumnDetails("chatId", "chatId", objectSchemaInfo);
            this.lastMessageIndex = addColumnDetails("lastMessage", "lastMessage", objectSchemaInfo);
            this.lastMessageTimestampIndex = addColumnDetails("lastMessageTimestamp", "lastMessageTimestamp", objectSchemaInfo);
            this.userIndex = addColumnDetails("user", "user", objectSchemaInfo);
            this.isMutedIndex = addColumnDetails("isMuted", "isMuted", objectSchemaInfo);
            this.unReadCountIndex = addColumnDetails("unReadCount", "unReadCount", objectSchemaInfo);
            this.firstUnreadMessageIdIndex = addColumnDetails("firstUnreadMessageId", "firstUnreadMessageId", objectSchemaInfo);
            this.notificationIdIndex = addColumnDetails("notificationId", "notificationId", objectSchemaInfo);
            this.unreadMessagesIndex = addColumnDetails("unreadMessages", "unreadMessages", objectSchemaInfo);
        }

        ChatColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ChatColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ChatColumnInfo src = (ChatColumnInfo) rawSrc;
            final ChatColumnInfo dst = (ChatColumnInfo) rawDst;
            dst.chatIdIndex = src.chatIdIndex;
            dst.lastMessageIndex = src.lastMessageIndex;
            dst.lastMessageTimestampIndex = src.lastMessageTimestampIndex;
            dst.userIndex = src.userIndex;
            dst.isMutedIndex = src.isMutedIndex;
            dst.unReadCountIndex = src.unReadCountIndex;
            dst.firstUnreadMessageIdIndex = src.firstUnreadMessageIdIndex;
            dst.notificationIdIndex = src.notificationIdIndex;
            dst.unreadMessagesIndex = src.unreadMessagesIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ChatColumnInfo columnInfo;
    private ProxyState<com.infinite.fireapp.model.realms.Chat> proxyState;
    private RealmList<com.infinite.fireapp.model.realms.Message> unreadMessagesRealmList;

    com_infinite_fireapp_model_realms_ChatRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ChatColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.infinite.fireapp.model.realms.Chat>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$chatId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.chatIdIndex);
    }

    @Override
    public void realmSet$chatId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'chatId' cannot be changed after object was created.");
    }

    @Override
    public com.infinite.fireapp.model.realms.Message realmGet$lastMessage() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.lastMessageIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.infinite.fireapp.model.realms.Message.class, proxyState.getRow$realm().getLink(columnInfo.lastMessageIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$lastMessage(com.infinite.fireapp.model.realms.Message value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("lastMessage")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.lastMessageIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.lastMessageIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.lastMessageIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.lastMessageIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$lastMessageTimestamp() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.lastMessageTimestampIndex);
    }

    @Override
    public void realmSet$lastMessageTimestamp(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.lastMessageTimestampIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.lastMessageTimestampIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.lastMessageTimestampIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.lastMessageTimestampIndex, value);
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
    @SuppressWarnings("cast")
    public boolean realmGet$isMuted() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isMutedIndex);
    }

    @Override
    public void realmSet$isMuted(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isMutedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isMutedIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$unReadCount() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.unReadCountIndex);
    }

    @Override
    public void realmSet$unReadCount(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.unReadCountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.unReadCountIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$firstUnreadMessageId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.firstUnreadMessageIdIndex);
    }

    @Override
    public void realmSet$firstUnreadMessageId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.firstUnreadMessageIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.firstUnreadMessageIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.firstUnreadMessageIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.firstUnreadMessageIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$notificationId() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.notificationIdIndex);
    }

    @Override
    public void realmSet$notificationId(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.notificationIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.notificationIdIndex, value);
    }

    @Override
    public RealmList<com.infinite.fireapp.model.realms.Message> realmGet$unreadMessages() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (unreadMessagesRealmList != null) {
            return unreadMessagesRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.unreadMessagesIndex);
            unreadMessagesRealmList = new RealmList<com.infinite.fireapp.model.realms.Message>(com.infinite.fireapp.model.realms.Message.class, osList, proxyState.getRealm$realm());
            return unreadMessagesRealmList;
        }
    }

    @Override
    public void realmSet$unreadMessages(RealmList<com.infinite.fireapp.model.realms.Message> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("unreadMessages")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.infinite.fireapp.model.realms.Message> original = value;
                value = new RealmList<com.infinite.fireapp.model.realms.Message>();
                for (com.infinite.fireapp.model.realms.Message item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.unreadMessagesIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.infinite.fireapp.model.realms.Message linkedObject = value.get(i);
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
                com.infinite.fireapp.model.realms.Message linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Chat", 9, 0);
        builder.addPersistedProperty("chatId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("lastMessage", RealmFieldType.OBJECT, "Message");
        builder.addPersistedProperty("lastMessageTimestamp", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("user", RealmFieldType.OBJECT, "User");
        builder.addPersistedProperty("isMuted", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("unReadCount", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("firstUnreadMessageId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("notificationId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedLinkProperty("unreadMessages", RealmFieldType.LIST, "Message");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ChatColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ChatColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Chat";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Chat";
    }

    @SuppressWarnings("cast")
    public static com.infinite.fireapp.model.realms.Chat createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(3);
        com.infinite.fireapp.model.realms.Chat obj = null;
        if (update) {
            Table table = realm.getTable(com.infinite.fireapp.model.realms.Chat.class);
            ChatColumnInfo columnInfo = (ChatColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Chat.class);
            long pkColumnIndex = columnInfo.chatIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("chatId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("chatId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Chat.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_infinite_fireapp_model_realms_ChatRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("lastMessage")) {
                excludeFields.add("lastMessage");
            }
            if (json.has("user")) {
                excludeFields.add("user");
            }
            if (json.has("unreadMessages")) {
                excludeFields.add("unreadMessages");
            }
            if (json.has("chatId")) {
                if (json.isNull("chatId")) {
                    obj = (io.realm.com_infinite_fireapp_model_realms_ChatRealmProxy) realm.createObjectInternal(com.infinite.fireapp.model.realms.Chat.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_infinite_fireapp_model_realms_ChatRealmProxy) realm.createObjectInternal(com.infinite.fireapp.model.realms.Chat.class, json.getString("chatId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'chatId'.");
            }
        }

        final com_infinite_fireapp_model_realms_ChatRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_ChatRealmProxyInterface) obj;
        if (json.has("lastMessage")) {
            if (json.isNull("lastMessage")) {
                objProxy.realmSet$lastMessage(null);
            } else {
                com.infinite.fireapp.model.realms.Message lastMessageObj = com_infinite_fireapp_model_realms_MessageRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("lastMessage"), update);
                objProxy.realmSet$lastMessage(lastMessageObj);
            }
        }
        if (json.has("lastMessageTimestamp")) {
            if (json.isNull("lastMessageTimestamp")) {
                objProxy.realmSet$lastMessageTimestamp(null);
            } else {
                objProxy.realmSet$lastMessageTimestamp((String) json.getString("lastMessageTimestamp"));
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
        if (json.has("isMuted")) {
            if (json.isNull("isMuted")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isMuted' to null.");
            } else {
                objProxy.realmSet$isMuted((boolean) json.getBoolean("isMuted"));
            }
        }
        if (json.has("unReadCount")) {
            if (json.isNull("unReadCount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'unReadCount' to null.");
            } else {
                objProxy.realmSet$unReadCount((int) json.getInt("unReadCount"));
            }
        }
        if (json.has("firstUnreadMessageId")) {
            if (json.isNull("firstUnreadMessageId")) {
                objProxy.realmSet$firstUnreadMessageId(null);
            } else {
                objProxy.realmSet$firstUnreadMessageId((String) json.getString("firstUnreadMessageId"));
            }
        }
        if (json.has("notificationId")) {
            if (json.isNull("notificationId")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'notificationId' to null.");
            } else {
                objProxy.realmSet$notificationId((int) json.getInt("notificationId"));
            }
        }
        if (json.has("unreadMessages")) {
            if (json.isNull("unreadMessages")) {
                objProxy.realmSet$unreadMessages(null);
            } else {
                objProxy.realmGet$unreadMessages().clear();
                JSONArray array = json.getJSONArray("unreadMessages");
                for (int i = 0; i < array.length(); i++) {
                    com.infinite.fireapp.model.realms.Message item = com_infinite_fireapp_model_realms_MessageRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$unreadMessages().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.infinite.fireapp.model.realms.Chat createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.infinite.fireapp.model.realms.Chat obj = new com.infinite.fireapp.model.realms.Chat();
        final com_infinite_fireapp_model_realms_ChatRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_ChatRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("chatId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$chatId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$chatId(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("lastMessage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$lastMessage(null);
                } else {
                    com.infinite.fireapp.model.realms.Message lastMessageObj = com_infinite_fireapp_model_realms_MessageRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$lastMessage(lastMessageObj);
                }
            } else if (name.equals("lastMessageTimestamp")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$lastMessageTimestamp((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$lastMessageTimestamp(null);
                }
            } else if (name.equals("user")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$user(null);
                } else {
                    com.infinite.fireapp.model.realms.User userObj = com_infinite_fireapp_model_realms_UserRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$user(userObj);
                }
            } else if (name.equals("isMuted")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isMuted((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isMuted' to null.");
                }
            } else if (name.equals("unReadCount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$unReadCount((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'unReadCount' to null.");
                }
            } else if (name.equals("firstUnreadMessageId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$firstUnreadMessageId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$firstUnreadMessageId(null);
                }
            } else if (name.equals("notificationId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$notificationId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'notificationId' to null.");
                }
            } else if (name.equals("unreadMessages")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$unreadMessages(null);
                } else {
                    objProxy.realmSet$unreadMessages(new RealmList<com.infinite.fireapp.model.realms.Message>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.infinite.fireapp.model.realms.Message item = com_infinite_fireapp_model_realms_MessageRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$unreadMessages().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'chatId'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.infinite.fireapp.model.realms.Chat copyOrUpdate(Realm realm, com.infinite.fireapp.model.realms.Chat object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.infinite.fireapp.model.realms.Chat) cachedRealmObject;
        }

        com.infinite.fireapp.model.realms.Chat realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.infinite.fireapp.model.realms.Chat.class);
            ChatColumnInfo columnInfo = (ChatColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Chat.class);
            long pkColumnIndex = columnInfo.chatIdIndex;
            String value = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$chatId();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Chat.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_infinite_fireapp_model_realms_ChatRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.infinite.fireapp.model.realms.Chat copy(Realm realm, com.infinite.fireapp.model.realms.Chat newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.infinite.fireapp.model.realms.Chat) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.infinite.fireapp.model.realms.Chat realmObject = realm.createObjectInternal(com.infinite.fireapp.model.realms.Chat.class, ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) newObject).realmGet$chatId(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_infinite_fireapp_model_realms_ChatRealmProxyInterface realmObjectSource = (com_infinite_fireapp_model_realms_ChatRealmProxyInterface) newObject;
        com_infinite_fireapp_model_realms_ChatRealmProxyInterface realmObjectCopy = (com_infinite_fireapp_model_realms_ChatRealmProxyInterface) realmObject;


        com.infinite.fireapp.model.realms.Message lastMessageObj = realmObjectSource.realmGet$lastMessage();
        if (lastMessageObj == null) {
            realmObjectCopy.realmSet$lastMessage(null);
        } else {
            com.infinite.fireapp.model.realms.Message cachelastMessage = (com.infinite.fireapp.model.realms.Message) cache.get(lastMessageObj);
            if (cachelastMessage != null) {
                realmObjectCopy.realmSet$lastMessage(cachelastMessage);
            } else {
                realmObjectCopy.realmSet$lastMessage(com_infinite_fireapp_model_realms_MessageRealmProxy.copyOrUpdate(realm, lastMessageObj, update, cache));
            }
        }
        realmObjectCopy.realmSet$lastMessageTimestamp(realmObjectSource.realmGet$lastMessageTimestamp());

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
        realmObjectCopy.realmSet$isMuted(realmObjectSource.realmGet$isMuted());
        realmObjectCopy.realmSet$unReadCount(realmObjectSource.realmGet$unReadCount());
        realmObjectCopy.realmSet$firstUnreadMessageId(realmObjectSource.realmGet$firstUnreadMessageId());
        realmObjectCopy.realmSet$notificationId(realmObjectSource.realmGet$notificationId());

        RealmList<com.infinite.fireapp.model.realms.Message> unreadMessagesList = realmObjectSource.realmGet$unreadMessages();
        if (unreadMessagesList != null) {
            RealmList<com.infinite.fireapp.model.realms.Message> unreadMessagesRealmList = realmObjectCopy.realmGet$unreadMessages();
            unreadMessagesRealmList.clear();
            for (int i = 0; i < unreadMessagesList.size(); i++) {
                com.infinite.fireapp.model.realms.Message unreadMessagesItem = unreadMessagesList.get(i);
                com.infinite.fireapp.model.realms.Message cacheunreadMessages = (com.infinite.fireapp.model.realms.Message) cache.get(unreadMessagesItem);
                if (cacheunreadMessages != null) {
                    unreadMessagesRealmList.add(cacheunreadMessages);
                } else {
                    unreadMessagesRealmList.add(com_infinite_fireapp_model_realms_MessageRealmProxy.copyOrUpdate(realm, unreadMessagesItem, update, cache));
                }
            }
        }

        return realmObject;
    }

    public static long insert(Realm realm, com.infinite.fireapp.model.realms.Chat object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.Chat.class);
        long tableNativePtr = table.getNativePtr();
        ChatColumnInfo columnInfo = (ChatColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Chat.class);
        long pkColumnIndex = columnInfo.chatIdIndex;
        String primaryKeyValue = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$chatId();
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

        com.infinite.fireapp.model.realms.Message lastMessageObj = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$lastMessage();
        if (lastMessageObj != null) {
            Long cachelastMessage = cache.get(lastMessageObj);
            if (cachelastMessage == null) {
                cachelastMessage = com_infinite_fireapp_model_realms_MessageRealmProxy.insert(realm, lastMessageObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.lastMessageIndex, rowIndex, cachelastMessage, false);
        }
        String realmGet$lastMessageTimestamp = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$lastMessageTimestamp();
        if (realmGet$lastMessageTimestamp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.lastMessageTimestampIndex, rowIndex, realmGet$lastMessageTimestamp, false);
        }

        com.infinite.fireapp.model.realms.User userObj = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$user();
        if (userObj != null) {
            Long cacheuser = cache.get(userObj);
            if (cacheuser == null) {
                cacheuser = com_infinite_fireapp_model_realms_UserRealmProxy.insert(realm, userObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isMutedIndex, rowIndex, ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$isMuted(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.unReadCountIndex, rowIndex, ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$unReadCount(), false);
        String realmGet$firstUnreadMessageId = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$firstUnreadMessageId();
        if (realmGet$firstUnreadMessageId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.firstUnreadMessageIdIndex, rowIndex, realmGet$firstUnreadMessageId, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.notificationIdIndex, rowIndex, ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$notificationId(), false);

        RealmList<com.infinite.fireapp.model.realms.Message> unreadMessagesList = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$unreadMessages();
        if (unreadMessagesList != null) {
            OsList unreadMessagesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.unreadMessagesIndex);
            for (com.infinite.fireapp.model.realms.Message unreadMessagesItem : unreadMessagesList) {
                Long cacheItemIndexunreadMessages = cache.get(unreadMessagesItem);
                if (cacheItemIndexunreadMessages == null) {
                    cacheItemIndexunreadMessages = com_infinite_fireapp_model_realms_MessageRealmProxy.insert(realm, unreadMessagesItem, cache);
                }
                unreadMessagesOsList.addRow(cacheItemIndexunreadMessages);
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.Chat.class);
        long tableNativePtr = table.getNativePtr();
        ChatColumnInfo columnInfo = (ChatColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Chat.class);
        long pkColumnIndex = columnInfo.chatIdIndex;
        com.infinite.fireapp.model.realms.Chat object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.Chat) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$chatId();
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

            com.infinite.fireapp.model.realms.Message lastMessageObj = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$lastMessage();
            if (lastMessageObj != null) {
                Long cachelastMessage = cache.get(lastMessageObj);
                if (cachelastMessage == null) {
                    cachelastMessage = com_infinite_fireapp_model_realms_MessageRealmProxy.insert(realm, lastMessageObj, cache);
                }
                table.setLink(columnInfo.lastMessageIndex, rowIndex, cachelastMessage, false);
            }
            String realmGet$lastMessageTimestamp = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$lastMessageTimestamp();
            if (realmGet$lastMessageTimestamp != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.lastMessageTimestampIndex, rowIndex, realmGet$lastMessageTimestamp, false);
            }

            com.infinite.fireapp.model.realms.User userObj = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$user();
            if (userObj != null) {
                Long cacheuser = cache.get(userObj);
                if (cacheuser == null) {
                    cacheuser = com_infinite_fireapp_model_realms_UserRealmProxy.insert(realm, userObj, cache);
                }
                table.setLink(columnInfo.userIndex, rowIndex, cacheuser, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isMutedIndex, rowIndex, ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$isMuted(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.unReadCountIndex, rowIndex, ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$unReadCount(), false);
            String realmGet$firstUnreadMessageId = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$firstUnreadMessageId();
            if (realmGet$firstUnreadMessageId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.firstUnreadMessageIdIndex, rowIndex, realmGet$firstUnreadMessageId, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.notificationIdIndex, rowIndex, ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$notificationId(), false);

            RealmList<com.infinite.fireapp.model.realms.Message> unreadMessagesList = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$unreadMessages();
            if (unreadMessagesList != null) {
                OsList unreadMessagesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.unreadMessagesIndex);
                for (com.infinite.fireapp.model.realms.Message unreadMessagesItem : unreadMessagesList) {
                    Long cacheItemIndexunreadMessages = cache.get(unreadMessagesItem);
                    if (cacheItemIndexunreadMessages == null) {
                        cacheItemIndexunreadMessages = com_infinite_fireapp_model_realms_MessageRealmProxy.insert(realm, unreadMessagesItem, cache);
                    }
                    unreadMessagesOsList.addRow(cacheItemIndexunreadMessages);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.infinite.fireapp.model.realms.Chat object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.Chat.class);
        long tableNativePtr = table.getNativePtr();
        ChatColumnInfo columnInfo = (ChatColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Chat.class);
        long pkColumnIndex = columnInfo.chatIdIndex;
        String primaryKeyValue = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$chatId();
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

        com.infinite.fireapp.model.realms.Message lastMessageObj = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$lastMessage();
        if (lastMessageObj != null) {
            Long cachelastMessage = cache.get(lastMessageObj);
            if (cachelastMessage == null) {
                cachelastMessage = com_infinite_fireapp_model_realms_MessageRealmProxy.insertOrUpdate(realm, lastMessageObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.lastMessageIndex, rowIndex, cachelastMessage, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.lastMessageIndex, rowIndex);
        }
        String realmGet$lastMessageTimestamp = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$lastMessageTimestamp();
        if (realmGet$lastMessageTimestamp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.lastMessageTimestampIndex, rowIndex, realmGet$lastMessageTimestamp, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.lastMessageTimestampIndex, rowIndex, false);
        }

        com.infinite.fireapp.model.realms.User userObj = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$user();
        if (userObj != null) {
            Long cacheuser = cache.get(userObj);
            if (cacheuser == null) {
                cacheuser = com_infinite_fireapp_model_realms_UserRealmProxy.insertOrUpdate(realm, userObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.userIndex, rowIndex);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isMutedIndex, rowIndex, ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$isMuted(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.unReadCountIndex, rowIndex, ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$unReadCount(), false);
        String realmGet$firstUnreadMessageId = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$firstUnreadMessageId();
        if (realmGet$firstUnreadMessageId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.firstUnreadMessageIdIndex, rowIndex, realmGet$firstUnreadMessageId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.firstUnreadMessageIdIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.notificationIdIndex, rowIndex, ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$notificationId(), false);

        OsList unreadMessagesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.unreadMessagesIndex);
        RealmList<com.infinite.fireapp.model.realms.Message> unreadMessagesList = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$unreadMessages();
        if (unreadMessagesList != null && unreadMessagesList.size() == unreadMessagesOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = unreadMessagesList.size();
            for (int i = 0; i < objects; i++) {
                com.infinite.fireapp.model.realms.Message unreadMessagesItem = unreadMessagesList.get(i);
                Long cacheItemIndexunreadMessages = cache.get(unreadMessagesItem);
                if (cacheItemIndexunreadMessages == null) {
                    cacheItemIndexunreadMessages = com_infinite_fireapp_model_realms_MessageRealmProxy.insertOrUpdate(realm, unreadMessagesItem, cache);
                }
                unreadMessagesOsList.setRow(i, cacheItemIndexunreadMessages);
            }
        } else {
            unreadMessagesOsList.removeAll();
            if (unreadMessagesList != null) {
                for (com.infinite.fireapp.model.realms.Message unreadMessagesItem : unreadMessagesList) {
                    Long cacheItemIndexunreadMessages = cache.get(unreadMessagesItem);
                    if (cacheItemIndexunreadMessages == null) {
                        cacheItemIndexunreadMessages = com_infinite_fireapp_model_realms_MessageRealmProxy.insertOrUpdate(realm, unreadMessagesItem, cache);
                    }
                    unreadMessagesOsList.addRow(cacheItemIndexunreadMessages);
                }
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.Chat.class);
        long tableNativePtr = table.getNativePtr();
        ChatColumnInfo columnInfo = (ChatColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Chat.class);
        long pkColumnIndex = columnInfo.chatIdIndex;
        com.infinite.fireapp.model.realms.Chat object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.Chat) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$chatId();
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

            com.infinite.fireapp.model.realms.Message lastMessageObj = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$lastMessage();
            if (lastMessageObj != null) {
                Long cachelastMessage = cache.get(lastMessageObj);
                if (cachelastMessage == null) {
                    cachelastMessage = com_infinite_fireapp_model_realms_MessageRealmProxy.insertOrUpdate(realm, lastMessageObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.lastMessageIndex, rowIndex, cachelastMessage, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.lastMessageIndex, rowIndex);
            }
            String realmGet$lastMessageTimestamp = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$lastMessageTimestamp();
            if (realmGet$lastMessageTimestamp != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.lastMessageTimestampIndex, rowIndex, realmGet$lastMessageTimestamp, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.lastMessageTimestampIndex, rowIndex, false);
            }

            com.infinite.fireapp.model.realms.User userObj = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$user();
            if (userObj != null) {
                Long cacheuser = cache.get(userObj);
                if (cacheuser == null) {
                    cacheuser = com_infinite_fireapp_model_realms_UserRealmProxy.insertOrUpdate(realm, userObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.userIndex, rowIndex, cacheuser, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.userIndex, rowIndex);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isMutedIndex, rowIndex, ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$isMuted(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.unReadCountIndex, rowIndex, ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$unReadCount(), false);
            String realmGet$firstUnreadMessageId = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$firstUnreadMessageId();
            if (realmGet$firstUnreadMessageId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.firstUnreadMessageIdIndex, rowIndex, realmGet$firstUnreadMessageId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.firstUnreadMessageIdIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.notificationIdIndex, rowIndex, ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$notificationId(), false);

            OsList unreadMessagesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.unreadMessagesIndex);
            RealmList<com.infinite.fireapp.model.realms.Message> unreadMessagesList = ((com_infinite_fireapp_model_realms_ChatRealmProxyInterface) object).realmGet$unreadMessages();
            if (unreadMessagesList != null && unreadMessagesList.size() == unreadMessagesOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = unreadMessagesList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.infinite.fireapp.model.realms.Message unreadMessagesItem = unreadMessagesList.get(i);
                    Long cacheItemIndexunreadMessages = cache.get(unreadMessagesItem);
                    if (cacheItemIndexunreadMessages == null) {
                        cacheItemIndexunreadMessages = com_infinite_fireapp_model_realms_MessageRealmProxy.insertOrUpdate(realm, unreadMessagesItem, cache);
                    }
                    unreadMessagesOsList.setRow(i, cacheItemIndexunreadMessages);
                }
            } else {
                unreadMessagesOsList.removeAll();
                if (unreadMessagesList != null) {
                    for (com.infinite.fireapp.model.realms.Message unreadMessagesItem : unreadMessagesList) {
                        Long cacheItemIndexunreadMessages = cache.get(unreadMessagesItem);
                        if (cacheItemIndexunreadMessages == null) {
                            cacheItemIndexunreadMessages = com_infinite_fireapp_model_realms_MessageRealmProxy.insertOrUpdate(realm, unreadMessagesItem, cache);
                        }
                        unreadMessagesOsList.addRow(cacheItemIndexunreadMessages);
                    }
                }
            }

        }
    }

    public static com.infinite.fireapp.model.realms.Chat createDetachedCopy(com.infinite.fireapp.model.realms.Chat realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.infinite.fireapp.model.realms.Chat unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.infinite.fireapp.model.realms.Chat();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.infinite.fireapp.model.realms.Chat) cachedObject.object;
            }
            unmanagedObject = (com.infinite.fireapp.model.realms.Chat) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_infinite_fireapp_model_realms_ChatRealmProxyInterface unmanagedCopy = (com_infinite_fireapp_model_realms_ChatRealmProxyInterface) unmanagedObject;
        com_infinite_fireapp_model_realms_ChatRealmProxyInterface realmSource = (com_infinite_fireapp_model_realms_ChatRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$chatId(realmSource.realmGet$chatId());

        // Deep copy of lastMessage
        unmanagedCopy.realmSet$lastMessage(com_infinite_fireapp_model_realms_MessageRealmProxy.createDetachedCopy(realmSource.realmGet$lastMessage(), currentDepth + 1, maxDepth, cache));
        unmanagedCopy.realmSet$lastMessageTimestamp(realmSource.realmGet$lastMessageTimestamp());

        // Deep copy of user
        unmanagedCopy.realmSet$user(com_infinite_fireapp_model_realms_UserRealmProxy.createDetachedCopy(realmSource.realmGet$user(), currentDepth + 1, maxDepth, cache));
        unmanagedCopy.realmSet$isMuted(realmSource.realmGet$isMuted());
        unmanagedCopy.realmSet$unReadCount(realmSource.realmGet$unReadCount());
        unmanagedCopy.realmSet$firstUnreadMessageId(realmSource.realmGet$firstUnreadMessageId());
        unmanagedCopy.realmSet$notificationId(realmSource.realmGet$notificationId());

        // Deep copy of unreadMessages
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$unreadMessages(null);
        } else {
            RealmList<com.infinite.fireapp.model.realms.Message> managedunreadMessagesList = realmSource.realmGet$unreadMessages();
            RealmList<com.infinite.fireapp.model.realms.Message> unmanagedunreadMessagesList = new RealmList<com.infinite.fireapp.model.realms.Message>();
            unmanagedCopy.realmSet$unreadMessages(unmanagedunreadMessagesList);
            int nextDepth = currentDepth + 1;
            int size = managedunreadMessagesList.size();
            for (int i = 0; i < size; i++) {
                com.infinite.fireapp.model.realms.Message item = com_infinite_fireapp_model_realms_MessageRealmProxy.createDetachedCopy(managedunreadMessagesList.get(i), nextDepth, maxDepth, cache);
                unmanagedunreadMessagesList.add(item);
            }
        }

        return unmanagedObject;
    }

    static com.infinite.fireapp.model.realms.Chat update(Realm realm, com.infinite.fireapp.model.realms.Chat realmObject, com.infinite.fireapp.model.realms.Chat newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_infinite_fireapp_model_realms_ChatRealmProxyInterface realmObjectTarget = (com_infinite_fireapp_model_realms_ChatRealmProxyInterface) realmObject;
        com_infinite_fireapp_model_realms_ChatRealmProxyInterface realmObjectSource = (com_infinite_fireapp_model_realms_ChatRealmProxyInterface) newObject;
        com.infinite.fireapp.model.realms.Message lastMessageObj = realmObjectSource.realmGet$lastMessage();
        if (lastMessageObj == null) {
            realmObjectTarget.realmSet$lastMessage(null);
        } else {
            com.infinite.fireapp.model.realms.Message cachelastMessage = (com.infinite.fireapp.model.realms.Message) cache.get(lastMessageObj);
            if (cachelastMessage != null) {
                realmObjectTarget.realmSet$lastMessage(cachelastMessage);
            } else {
                realmObjectTarget.realmSet$lastMessage(com_infinite_fireapp_model_realms_MessageRealmProxy.copyOrUpdate(realm, lastMessageObj, true, cache));
            }
        }
        realmObjectTarget.realmSet$lastMessageTimestamp(realmObjectSource.realmGet$lastMessageTimestamp());
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
        realmObjectTarget.realmSet$isMuted(realmObjectSource.realmGet$isMuted());
        realmObjectTarget.realmSet$unReadCount(realmObjectSource.realmGet$unReadCount());
        realmObjectTarget.realmSet$firstUnreadMessageId(realmObjectSource.realmGet$firstUnreadMessageId());
        realmObjectTarget.realmSet$notificationId(realmObjectSource.realmGet$notificationId());
        RealmList<com.infinite.fireapp.model.realms.Message> unreadMessagesList = realmObjectSource.realmGet$unreadMessages();
        RealmList<com.infinite.fireapp.model.realms.Message> unreadMessagesRealmList = realmObjectTarget.realmGet$unreadMessages();
        if (unreadMessagesList != null && unreadMessagesList.size() == unreadMessagesRealmList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = unreadMessagesList.size();
            for (int i = 0; i < objects; i++) {
                com.infinite.fireapp.model.realms.Message unreadMessagesItem = unreadMessagesList.get(i);
                com.infinite.fireapp.model.realms.Message cacheunreadMessages = (com.infinite.fireapp.model.realms.Message) cache.get(unreadMessagesItem);
                if (cacheunreadMessages != null) {
                    unreadMessagesRealmList.set(i, cacheunreadMessages);
                } else {
                    unreadMessagesRealmList.set(i, com_infinite_fireapp_model_realms_MessageRealmProxy.copyOrUpdate(realm, unreadMessagesItem, true, cache));
                }
            }
        } else {
            unreadMessagesRealmList.clear();
            if (unreadMessagesList != null) {
                for (int i = 0; i < unreadMessagesList.size(); i++) {
                    com.infinite.fireapp.model.realms.Message unreadMessagesItem = unreadMessagesList.get(i);
                    com.infinite.fireapp.model.realms.Message cacheunreadMessages = (com.infinite.fireapp.model.realms.Message) cache.get(unreadMessagesItem);
                    if (cacheunreadMessages != null) {
                        unreadMessagesRealmList.add(cacheunreadMessages);
                    } else {
                        unreadMessagesRealmList.add(com_infinite_fireapp_model_realms_MessageRealmProxy.copyOrUpdate(realm, unreadMessagesItem, true, cache));
                    }
                }
            }
        }
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
