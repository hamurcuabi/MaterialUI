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
public class com_infinite_fireapp_model_realms_MessageRealmProxy extends com.infinite.fireapp.model.realms.Message
    implements RealmObjectProxy, com_infinite_fireapp_model_realms_MessageRealmProxyInterface {

    static final class MessageColumnInfo extends ColumnInfo {
        long messageIdIndex;
        long fromIdIndex;
        long fromPhoneIndex;
        long toIdIndex;
        long typeIndex;
        long contentIndex;
        long timestampIndex;
        long chatIdIndex;
        long messageStatIndex;
        long localPathIndex;
        long downloadUploadStatIndex;
        long metadataIndex;
        long voiceMessageSeenIndex;
        long mediaDurationIndex;
        long thumbIndex;
        long isForwardedIndex;
        long videoThumbIndex;
        long fileSizeIndex;
        long contactIndex;
        long locationIndex;
        long isGroupIndex;
        long isBroadcastIndex;
        long isSeenIndex;
        long quotedMessageIndex;

        MessageColumnInfo(OsSchemaInfo schemaInfo) {
            super(24);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Message");
            this.messageIdIndex = addColumnDetails("messageId", "messageId", objectSchemaInfo);
            this.fromIdIndex = addColumnDetails("fromId", "fromId", objectSchemaInfo);
            this.fromPhoneIndex = addColumnDetails("fromPhone", "fromPhone", objectSchemaInfo);
            this.toIdIndex = addColumnDetails("toId", "toId", objectSchemaInfo);
            this.typeIndex = addColumnDetails("type", "type", objectSchemaInfo);
            this.contentIndex = addColumnDetails("content", "content", objectSchemaInfo);
            this.timestampIndex = addColumnDetails("timestamp", "timestamp", objectSchemaInfo);
            this.chatIdIndex = addColumnDetails("chatId", "chatId", objectSchemaInfo);
            this.messageStatIndex = addColumnDetails("messageStat", "messageStat", objectSchemaInfo);
            this.localPathIndex = addColumnDetails("localPath", "localPath", objectSchemaInfo);
            this.downloadUploadStatIndex = addColumnDetails("downloadUploadStat", "downloadUploadStat", objectSchemaInfo);
            this.metadataIndex = addColumnDetails("metadata", "metadata", objectSchemaInfo);
            this.voiceMessageSeenIndex = addColumnDetails("voiceMessageSeen", "voiceMessageSeen", objectSchemaInfo);
            this.mediaDurationIndex = addColumnDetails("mediaDuration", "mediaDuration", objectSchemaInfo);
            this.thumbIndex = addColumnDetails("thumb", "thumb", objectSchemaInfo);
            this.isForwardedIndex = addColumnDetails("isForwarded", "isForwarded", objectSchemaInfo);
            this.videoThumbIndex = addColumnDetails("videoThumb", "videoThumb", objectSchemaInfo);
            this.fileSizeIndex = addColumnDetails("fileSize", "fileSize", objectSchemaInfo);
            this.contactIndex = addColumnDetails("contact", "contact", objectSchemaInfo);
            this.locationIndex = addColumnDetails("location", "location", objectSchemaInfo);
            this.isGroupIndex = addColumnDetails("isGroup", "isGroup", objectSchemaInfo);
            this.isBroadcastIndex = addColumnDetails("isBroadcast", "isBroadcast", objectSchemaInfo);
            this.isSeenIndex = addColumnDetails("isSeen", "isSeen", objectSchemaInfo);
            this.quotedMessageIndex = addColumnDetails("quotedMessage", "quotedMessage", objectSchemaInfo);
        }

        MessageColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new MessageColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final MessageColumnInfo src = (MessageColumnInfo) rawSrc;
            final MessageColumnInfo dst = (MessageColumnInfo) rawDst;
            dst.messageIdIndex = src.messageIdIndex;
            dst.fromIdIndex = src.fromIdIndex;
            dst.fromPhoneIndex = src.fromPhoneIndex;
            dst.toIdIndex = src.toIdIndex;
            dst.typeIndex = src.typeIndex;
            dst.contentIndex = src.contentIndex;
            dst.timestampIndex = src.timestampIndex;
            dst.chatIdIndex = src.chatIdIndex;
            dst.messageStatIndex = src.messageStatIndex;
            dst.localPathIndex = src.localPathIndex;
            dst.downloadUploadStatIndex = src.downloadUploadStatIndex;
            dst.metadataIndex = src.metadataIndex;
            dst.voiceMessageSeenIndex = src.voiceMessageSeenIndex;
            dst.mediaDurationIndex = src.mediaDurationIndex;
            dst.thumbIndex = src.thumbIndex;
            dst.isForwardedIndex = src.isForwardedIndex;
            dst.videoThumbIndex = src.videoThumbIndex;
            dst.fileSizeIndex = src.fileSizeIndex;
            dst.contactIndex = src.contactIndex;
            dst.locationIndex = src.locationIndex;
            dst.isGroupIndex = src.isGroupIndex;
            dst.isBroadcastIndex = src.isBroadcastIndex;
            dst.isSeenIndex = src.isSeenIndex;
            dst.quotedMessageIndex = src.quotedMessageIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private MessageColumnInfo columnInfo;
    private ProxyState<com.infinite.fireapp.model.realms.Message> proxyState;

    com_infinite_fireapp_model_realms_MessageRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MessageColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.infinite.fireapp.model.realms.Message>(this);
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
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.messageIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.messageIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.messageIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.messageIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fromId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fromIdIndex);
    }

    @Override
    public void realmSet$fromId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fromIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fromIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fromIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fromIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fromPhone() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fromPhoneIndex);
    }

    @Override
    public void realmSet$fromPhone(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fromPhoneIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fromPhoneIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fromPhoneIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fromPhoneIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$toId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.toIdIndex);
    }

    @Override
    public void realmSet$toId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.toIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.toIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.toIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.toIdIndex, value);
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
    public String realmGet$chatId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.chatIdIndex);
    }

    @Override
    public void realmSet$chatId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.chatIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.chatIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.chatIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.chatIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$messageStat() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.messageStatIndex);
    }

    @Override
    public void realmSet$messageStat(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.messageStatIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.messageStatIndex, value);
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
    public int realmGet$downloadUploadStat() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.downloadUploadStatIndex);
    }

    @Override
    public void realmSet$downloadUploadStat(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.downloadUploadStatIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.downloadUploadStatIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$metadata() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.metadataIndex);
    }

    @Override
    public void realmSet$metadata(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.metadataIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.metadataIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.metadataIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.metadataIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$voiceMessageSeen() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.voiceMessageSeenIndex);
    }

    @Override
    public void realmSet$voiceMessageSeen(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.voiceMessageSeenIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.voiceMessageSeenIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$mediaDuration() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.mediaDurationIndex);
    }

    @Override
    public void realmSet$mediaDuration(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.mediaDurationIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.mediaDurationIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.mediaDurationIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.mediaDurationIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$thumb() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.thumbIndex);
    }

    @Override
    public void realmSet$thumb(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.thumbIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.thumbIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.thumbIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.thumbIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isForwarded() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isForwardedIndex);
    }

    @Override
    public void realmSet$isForwarded(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isForwardedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isForwardedIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$videoThumb() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.videoThumbIndex);
    }

    @Override
    public void realmSet$videoThumb(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.videoThumbIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.videoThumbIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.videoThumbIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.videoThumbIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fileSize() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fileSizeIndex);
    }

    @Override
    public void realmSet$fileSize(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fileSizeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fileSizeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fileSizeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fileSizeIndex, value);
    }

    @Override
    public com.infinite.fireapp.model.realms.RealmContact realmGet$contact() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.contactIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.infinite.fireapp.model.realms.RealmContact.class, proxyState.getRow$realm().getLink(columnInfo.contactIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$contact(com.infinite.fireapp.model.realms.RealmContact value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("contact")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.contactIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.contactIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.contactIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.contactIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public com.infinite.fireapp.model.realms.RealmLocation realmGet$location() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.locationIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.infinite.fireapp.model.realms.RealmLocation.class, proxyState.getRow$realm().getLink(columnInfo.locationIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$location(com.infinite.fireapp.model.realms.RealmLocation value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("location")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.locationIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.locationIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.locationIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.locationIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isGroup() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isGroupIndex);
    }

    @Override
    public void realmSet$isGroup(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isGroupIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isGroupIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isBroadcast() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isBroadcastIndex);
    }

    @Override
    public void realmSet$isBroadcast(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isBroadcastIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isBroadcastIndex, value);
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

    @Override
    public com.infinite.fireapp.model.realms.QuotedMessage realmGet$quotedMessage() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.quotedMessageIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.infinite.fireapp.model.realms.QuotedMessage.class, proxyState.getRow$realm().getLink(columnInfo.quotedMessageIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$quotedMessage(com.infinite.fireapp.model.realms.QuotedMessage value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("quotedMessage")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.quotedMessageIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.quotedMessageIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.quotedMessageIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.quotedMessageIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Message", 24, 0);
        builder.addPersistedProperty("messageId", RealmFieldType.STRING, !Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fromId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fromPhone", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("toId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("type", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("content", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("timestamp", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("chatId", RealmFieldType.STRING, !Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("messageStat", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("localPath", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("downloadUploadStat", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("metadata", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("voiceMessageSeen", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("mediaDuration", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("thumb", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("isForwarded", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("videoThumb", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fileSize", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("contact", RealmFieldType.OBJECT, "RealmContact");
        builder.addPersistedLinkProperty("location", RealmFieldType.OBJECT, "RealmLocation");
        builder.addPersistedProperty("isGroup", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("isBroadcast", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("isSeen", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedLinkProperty("quotedMessage", RealmFieldType.OBJECT, "QuotedMessage");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static MessageColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new MessageColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Message";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Message";
    }

    @SuppressWarnings("cast")
    public static com.infinite.fireapp.model.realms.Message createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(3);
        if (json.has("contact")) {
            excludeFields.add("contact");
        }
        if (json.has("location")) {
            excludeFields.add("location");
        }
        if (json.has("quotedMessage")) {
            excludeFields.add("quotedMessage");
        }
        com.infinite.fireapp.model.realms.Message obj = realm.createObjectInternal(com.infinite.fireapp.model.realms.Message.class, true, excludeFields);

        final com_infinite_fireapp_model_realms_MessageRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_MessageRealmProxyInterface) obj;
        if (json.has("messageId")) {
            if (json.isNull("messageId")) {
                objProxy.realmSet$messageId(null);
            } else {
                objProxy.realmSet$messageId((String) json.getString("messageId"));
            }
        }
        if (json.has("fromId")) {
            if (json.isNull("fromId")) {
                objProxy.realmSet$fromId(null);
            } else {
                objProxy.realmSet$fromId((String) json.getString("fromId"));
            }
        }
        if (json.has("fromPhone")) {
            if (json.isNull("fromPhone")) {
                objProxy.realmSet$fromPhone(null);
            } else {
                objProxy.realmSet$fromPhone((String) json.getString("fromPhone"));
            }
        }
        if (json.has("toId")) {
            if (json.isNull("toId")) {
                objProxy.realmSet$toId(null);
            } else {
                objProxy.realmSet$toId((String) json.getString("toId"));
            }
        }
        if (json.has("type")) {
            if (json.isNull("type")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'type' to null.");
            } else {
                objProxy.realmSet$type((int) json.getInt("type"));
            }
        }
        if (json.has("content")) {
            if (json.isNull("content")) {
                objProxy.realmSet$content(null);
            } else {
                objProxy.realmSet$content((String) json.getString("content"));
            }
        }
        if (json.has("timestamp")) {
            if (json.isNull("timestamp")) {
                objProxy.realmSet$timestamp(null);
            } else {
                objProxy.realmSet$timestamp((String) json.getString("timestamp"));
            }
        }
        if (json.has("chatId")) {
            if (json.isNull("chatId")) {
                objProxy.realmSet$chatId(null);
            } else {
                objProxy.realmSet$chatId((String) json.getString("chatId"));
            }
        }
        if (json.has("messageStat")) {
            if (json.isNull("messageStat")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'messageStat' to null.");
            } else {
                objProxy.realmSet$messageStat((int) json.getInt("messageStat"));
            }
        }
        if (json.has("localPath")) {
            if (json.isNull("localPath")) {
                objProxy.realmSet$localPath(null);
            } else {
                objProxy.realmSet$localPath((String) json.getString("localPath"));
            }
        }
        if (json.has("downloadUploadStat")) {
            if (json.isNull("downloadUploadStat")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'downloadUploadStat' to null.");
            } else {
                objProxy.realmSet$downloadUploadStat((int) json.getInt("downloadUploadStat"));
            }
        }
        if (json.has("metadata")) {
            if (json.isNull("metadata")) {
                objProxy.realmSet$metadata(null);
            } else {
                objProxy.realmSet$metadata((String) json.getString("metadata"));
            }
        }
        if (json.has("voiceMessageSeen")) {
            if (json.isNull("voiceMessageSeen")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'voiceMessageSeen' to null.");
            } else {
                objProxy.realmSet$voiceMessageSeen((boolean) json.getBoolean("voiceMessageSeen"));
            }
        }
        if (json.has("mediaDuration")) {
            if (json.isNull("mediaDuration")) {
                objProxy.realmSet$mediaDuration(null);
            } else {
                objProxy.realmSet$mediaDuration((String) json.getString("mediaDuration"));
            }
        }
        if (json.has("thumb")) {
            if (json.isNull("thumb")) {
                objProxy.realmSet$thumb(null);
            } else {
                objProxy.realmSet$thumb((String) json.getString("thumb"));
            }
        }
        if (json.has("isForwarded")) {
            if (json.isNull("isForwarded")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isForwarded' to null.");
            } else {
                objProxy.realmSet$isForwarded((boolean) json.getBoolean("isForwarded"));
            }
        }
        if (json.has("videoThumb")) {
            if (json.isNull("videoThumb")) {
                objProxy.realmSet$videoThumb(null);
            } else {
                objProxy.realmSet$videoThumb((String) json.getString("videoThumb"));
            }
        }
        if (json.has("fileSize")) {
            if (json.isNull("fileSize")) {
                objProxy.realmSet$fileSize(null);
            } else {
                objProxy.realmSet$fileSize((String) json.getString("fileSize"));
            }
        }
        if (json.has("contact")) {
            if (json.isNull("contact")) {
                objProxy.realmSet$contact(null);
            } else {
                com.infinite.fireapp.model.realms.RealmContact contactObj = com_infinite_fireapp_model_realms_RealmContactRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("contact"), update);
                objProxy.realmSet$contact(contactObj);
            }
        }
        if (json.has("location")) {
            if (json.isNull("location")) {
                objProxy.realmSet$location(null);
            } else {
                com.infinite.fireapp.model.realms.RealmLocation locationObj = com_infinite_fireapp_model_realms_RealmLocationRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("location"), update);
                objProxy.realmSet$location(locationObj);
            }
        }
        if (json.has("isGroup")) {
            if (json.isNull("isGroup")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isGroup' to null.");
            } else {
                objProxy.realmSet$isGroup((boolean) json.getBoolean("isGroup"));
            }
        }
        if (json.has("isBroadcast")) {
            if (json.isNull("isBroadcast")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isBroadcast' to null.");
            } else {
                objProxy.realmSet$isBroadcast((boolean) json.getBoolean("isBroadcast"));
            }
        }
        if (json.has("isSeen")) {
            if (json.isNull("isSeen")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isSeen' to null.");
            } else {
                objProxy.realmSet$isSeen((boolean) json.getBoolean("isSeen"));
            }
        }
        if (json.has("quotedMessage")) {
            if (json.isNull("quotedMessage")) {
                objProxy.realmSet$quotedMessage(null);
            } else {
                com.infinite.fireapp.model.realms.QuotedMessage quotedMessageObj = com_infinite_fireapp_model_realms_QuotedMessageRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("quotedMessage"), update);
                objProxy.realmSet$quotedMessage(quotedMessageObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.infinite.fireapp.model.realms.Message createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.infinite.fireapp.model.realms.Message obj = new com.infinite.fireapp.model.realms.Message();
        final com_infinite_fireapp_model_realms_MessageRealmProxyInterface objProxy = (com_infinite_fireapp_model_realms_MessageRealmProxyInterface) obj;
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
            } else if (name.equals("fromId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fromId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fromId(null);
                }
            } else if (name.equals("fromPhone")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fromPhone((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fromPhone(null);
                }
            } else if (name.equals("toId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$toId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$toId(null);
                }
            } else if (name.equals("type")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$type((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'type' to null.");
                }
            } else if (name.equals("content")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$content((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$content(null);
                }
            } else if (name.equals("timestamp")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$timestamp((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$timestamp(null);
                }
            } else if (name.equals("chatId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$chatId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$chatId(null);
                }
            } else if (name.equals("messageStat")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$messageStat((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'messageStat' to null.");
                }
            } else if (name.equals("localPath")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$localPath((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$localPath(null);
                }
            } else if (name.equals("downloadUploadStat")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$downloadUploadStat((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'downloadUploadStat' to null.");
                }
            } else if (name.equals("metadata")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$metadata((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$metadata(null);
                }
            } else if (name.equals("voiceMessageSeen")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$voiceMessageSeen((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'voiceMessageSeen' to null.");
                }
            } else if (name.equals("mediaDuration")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$mediaDuration((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$mediaDuration(null);
                }
            } else if (name.equals("thumb")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$thumb((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$thumb(null);
                }
            } else if (name.equals("isForwarded")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isForwarded((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isForwarded' to null.");
                }
            } else if (name.equals("videoThumb")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$videoThumb((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$videoThumb(null);
                }
            } else if (name.equals("fileSize")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fileSize((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fileSize(null);
                }
            } else if (name.equals("contact")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$contact(null);
                } else {
                    com.infinite.fireapp.model.realms.RealmContact contactObj = com_infinite_fireapp_model_realms_RealmContactRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$contact(contactObj);
                }
            } else if (name.equals("location")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$location(null);
                } else {
                    com.infinite.fireapp.model.realms.RealmLocation locationObj = com_infinite_fireapp_model_realms_RealmLocationRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$location(locationObj);
                }
            } else if (name.equals("isGroup")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isGroup((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isGroup' to null.");
                }
            } else if (name.equals("isBroadcast")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isBroadcast((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isBroadcast' to null.");
                }
            } else if (name.equals("isSeen")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isSeen((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isSeen' to null.");
                }
            } else if (name.equals("quotedMessage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$quotedMessage(null);
                } else {
                    com.infinite.fireapp.model.realms.QuotedMessage quotedMessageObj = com_infinite_fireapp_model_realms_QuotedMessageRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$quotedMessage(quotedMessageObj);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.infinite.fireapp.model.realms.Message copyOrUpdate(Realm realm, com.infinite.fireapp.model.realms.Message object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.infinite.fireapp.model.realms.Message) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.infinite.fireapp.model.realms.Message copy(Realm realm, com.infinite.fireapp.model.realms.Message newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.infinite.fireapp.model.realms.Message) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.infinite.fireapp.model.realms.Message realmObject = realm.createObjectInternal(com.infinite.fireapp.model.realms.Message.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_infinite_fireapp_model_realms_MessageRealmProxyInterface realmObjectSource = (com_infinite_fireapp_model_realms_MessageRealmProxyInterface) newObject;
        com_infinite_fireapp_model_realms_MessageRealmProxyInterface realmObjectCopy = (com_infinite_fireapp_model_realms_MessageRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$messageId(realmObjectSource.realmGet$messageId());
        realmObjectCopy.realmSet$fromId(realmObjectSource.realmGet$fromId());
        realmObjectCopy.realmSet$fromPhone(realmObjectSource.realmGet$fromPhone());
        realmObjectCopy.realmSet$toId(realmObjectSource.realmGet$toId());
        realmObjectCopy.realmSet$type(realmObjectSource.realmGet$type());
        realmObjectCopy.realmSet$content(realmObjectSource.realmGet$content());
        realmObjectCopy.realmSet$timestamp(realmObjectSource.realmGet$timestamp());
        realmObjectCopy.realmSet$chatId(realmObjectSource.realmGet$chatId());
        realmObjectCopy.realmSet$messageStat(realmObjectSource.realmGet$messageStat());
        realmObjectCopy.realmSet$localPath(realmObjectSource.realmGet$localPath());
        realmObjectCopy.realmSet$downloadUploadStat(realmObjectSource.realmGet$downloadUploadStat());
        realmObjectCopy.realmSet$metadata(realmObjectSource.realmGet$metadata());
        realmObjectCopy.realmSet$voiceMessageSeen(realmObjectSource.realmGet$voiceMessageSeen());
        realmObjectCopy.realmSet$mediaDuration(realmObjectSource.realmGet$mediaDuration());
        realmObjectCopy.realmSet$thumb(realmObjectSource.realmGet$thumb());
        realmObjectCopy.realmSet$isForwarded(realmObjectSource.realmGet$isForwarded());
        realmObjectCopy.realmSet$videoThumb(realmObjectSource.realmGet$videoThumb());
        realmObjectCopy.realmSet$fileSize(realmObjectSource.realmGet$fileSize());

        com.infinite.fireapp.model.realms.RealmContact contactObj = realmObjectSource.realmGet$contact();
        if (contactObj == null) {
            realmObjectCopy.realmSet$contact(null);
        } else {
            com.infinite.fireapp.model.realms.RealmContact cachecontact = (com.infinite.fireapp.model.realms.RealmContact) cache.get(contactObj);
            if (cachecontact != null) {
                realmObjectCopy.realmSet$contact(cachecontact);
            } else {
                realmObjectCopy.realmSet$contact(com_infinite_fireapp_model_realms_RealmContactRealmProxy.copyOrUpdate(realm, contactObj, update, cache));
            }
        }

        com.infinite.fireapp.model.realms.RealmLocation locationObj = realmObjectSource.realmGet$location();
        if (locationObj == null) {
            realmObjectCopy.realmSet$location(null);
        } else {
            com.infinite.fireapp.model.realms.RealmLocation cachelocation = (com.infinite.fireapp.model.realms.RealmLocation) cache.get(locationObj);
            if (cachelocation != null) {
                realmObjectCopy.realmSet$location(cachelocation);
            } else {
                realmObjectCopy.realmSet$location(com_infinite_fireapp_model_realms_RealmLocationRealmProxy.copyOrUpdate(realm, locationObj, update, cache));
            }
        }
        realmObjectCopy.realmSet$isGroup(realmObjectSource.realmGet$isGroup());
        realmObjectCopy.realmSet$isBroadcast(realmObjectSource.realmGet$isBroadcast());
        realmObjectCopy.realmSet$isSeen(realmObjectSource.realmGet$isSeen());

        com.infinite.fireapp.model.realms.QuotedMessage quotedMessageObj = realmObjectSource.realmGet$quotedMessage();
        if (quotedMessageObj == null) {
            realmObjectCopy.realmSet$quotedMessage(null);
        } else {
            com.infinite.fireapp.model.realms.QuotedMessage cachequotedMessage = (com.infinite.fireapp.model.realms.QuotedMessage) cache.get(quotedMessageObj);
            if (cachequotedMessage != null) {
                realmObjectCopy.realmSet$quotedMessage(cachequotedMessage);
            } else {
                realmObjectCopy.realmSet$quotedMessage(com_infinite_fireapp_model_realms_QuotedMessageRealmProxy.copyOrUpdate(realm, quotedMessageObj, update, cache));
            }
        }
        return realmObject;
    }

    public static long insert(Realm realm, com.infinite.fireapp.model.realms.Message object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.Message.class);
        long tableNativePtr = table.getNativePtr();
        MessageColumnInfo columnInfo = (MessageColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Message.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$messageId = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$messageId();
        if (realmGet$messageId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.messageIdIndex, rowIndex, realmGet$messageId, false);
        }
        String realmGet$fromId = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$fromId();
        if (realmGet$fromId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fromIdIndex, rowIndex, realmGet$fromId, false);
        }
        String realmGet$fromPhone = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$fromPhone();
        if (realmGet$fromPhone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fromPhoneIndex, rowIndex, realmGet$fromPhone, false);
        }
        String realmGet$toId = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$toId();
        if (realmGet$toId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.toIdIndex, rowIndex, realmGet$toId, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$type(), false);
        String realmGet$content = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$content();
        if (realmGet$content != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
        }
        String realmGet$timestamp = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$timestamp();
        if (realmGet$timestamp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.timestampIndex, rowIndex, realmGet$timestamp, false);
        }
        String realmGet$chatId = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$chatId();
        if (realmGet$chatId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.chatIdIndex, rowIndex, realmGet$chatId, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.messageStatIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$messageStat(), false);
        String realmGet$localPath = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$localPath();
        if (realmGet$localPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.localPathIndex, rowIndex, realmGet$localPath, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.downloadUploadStatIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$downloadUploadStat(), false);
        String realmGet$metadata = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$metadata();
        if (realmGet$metadata != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.metadataIndex, rowIndex, realmGet$metadata, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.voiceMessageSeenIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$voiceMessageSeen(), false);
        String realmGet$mediaDuration = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$mediaDuration();
        if (realmGet$mediaDuration != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mediaDurationIndex, rowIndex, realmGet$mediaDuration, false);
        }
        String realmGet$thumb = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$thumb();
        if (realmGet$thumb != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.thumbIndex, rowIndex, realmGet$thumb, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isForwardedIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$isForwarded(), false);
        String realmGet$videoThumb = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$videoThumb();
        if (realmGet$videoThumb != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.videoThumbIndex, rowIndex, realmGet$videoThumb, false);
        }
        String realmGet$fileSize = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$fileSize();
        if (realmGet$fileSize != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fileSizeIndex, rowIndex, realmGet$fileSize, false);
        }

        com.infinite.fireapp.model.realms.RealmContact contactObj = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$contact();
        if (contactObj != null) {
            Long cachecontact = cache.get(contactObj);
            if (cachecontact == null) {
                cachecontact = com_infinite_fireapp_model_realms_RealmContactRealmProxy.insert(realm, contactObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.contactIndex, rowIndex, cachecontact, false);
        }

        com.infinite.fireapp.model.realms.RealmLocation locationObj = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$location();
        if (locationObj != null) {
            Long cachelocation = cache.get(locationObj);
            if (cachelocation == null) {
                cachelocation = com_infinite_fireapp_model_realms_RealmLocationRealmProxy.insert(realm, locationObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.locationIndex, rowIndex, cachelocation, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isGroupIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$isGroup(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isBroadcastIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$isBroadcast(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isSeenIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$isSeen(), false);

        com.infinite.fireapp.model.realms.QuotedMessage quotedMessageObj = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$quotedMessage();
        if (quotedMessageObj != null) {
            Long cachequotedMessage = cache.get(quotedMessageObj);
            if (cachequotedMessage == null) {
                cachequotedMessage = com_infinite_fireapp_model_realms_QuotedMessageRealmProxy.insert(realm, quotedMessageObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.quotedMessageIndex, rowIndex, cachequotedMessage, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.Message.class);
        long tableNativePtr = table.getNativePtr();
        MessageColumnInfo columnInfo = (MessageColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Message.class);
        com.infinite.fireapp.model.realms.Message object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.Message) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$messageId = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$messageId();
            if (realmGet$messageId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.messageIdIndex, rowIndex, realmGet$messageId, false);
            }
            String realmGet$fromId = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$fromId();
            if (realmGet$fromId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fromIdIndex, rowIndex, realmGet$fromId, false);
            }
            String realmGet$fromPhone = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$fromPhone();
            if (realmGet$fromPhone != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fromPhoneIndex, rowIndex, realmGet$fromPhone, false);
            }
            String realmGet$toId = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$toId();
            if (realmGet$toId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.toIdIndex, rowIndex, realmGet$toId, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$type(), false);
            String realmGet$content = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$content();
            if (realmGet$content != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
            }
            String realmGet$timestamp = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$timestamp();
            if (realmGet$timestamp != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.timestampIndex, rowIndex, realmGet$timestamp, false);
            }
            String realmGet$chatId = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$chatId();
            if (realmGet$chatId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.chatIdIndex, rowIndex, realmGet$chatId, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.messageStatIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$messageStat(), false);
            String realmGet$localPath = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$localPath();
            if (realmGet$localPath != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.localPathIndex, rowIndex, realmGet$localPath, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.downloadUploadStatIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$downloadUploadStat(), false);
            String realmGet$metadata = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$metadata();
            if (realmGet$metadata != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.metadataIndex, rowIndex, realmGet$metadata, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.voiceMessageSeenIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$voiceMessageSeen(), false);
            String realmGet$mediaDuration = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$mediaDuration();
            if (realmGet$mediaDuration != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.mediaDurationIndex, rowIndex, realmGet$mediaDuration, false);
            }
            String realmGet$thumb = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$thumb();
            if (realmGet$thumb != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.thumbIndex, rowIndex, realmGet$thumb, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isForwardedIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$isForwarded(), false);
            String realmGet$videoThumb = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$videoThumb();
            if (realmGet$videoThumb != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.videoThumbIndex, rowIndex, realmGet$videoThumb, false);
            }
            String realmGet$fileSize = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$fileSize();
            if (realmGet$fileSize != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fileSizeIndex, rowIndex, realmGet$fileSize, false);
            }

            com.infinite.fireapp.model.realms.RealmContact contactObj = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$contact();
            if (contactObj != null) {
                Long cachecontact = cache.get(contactObj);
                if (cachecontact == null) {
                    cachecontact = com_infinite_fireapp_model_realms_RealmContactRealmProxy.insert(realm, contactObj, cache);
                }
                table.setLink(columnInfo.contactIndex, rowIndex, cachecontact, false);
            }

            com.infinite.fireapp.model.realms.RealmLocation locationObj = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$location();
            if (locationObj != null) {
                Long cachelocation = cache.get(locationObj);
                if (cachelocation == null) {
                    cachelocation = com_infinite_fireapp_model_realms_RealmLocationRealmProxy.insert(realm, locationObj, cache);
                }
                table.setLink(columnInfo.locationIndex, rowIndex, cachelocation, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isGroupIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$isGroup(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isBroadcastIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$isBroadcast(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isSeenIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$isSeen(), false);

            com.infinite.fireapp.model.realms.QuotedMessage quotedMessageObj = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$quotedMessage();
            if (quotedMessageObj != null) {
                Long cachequotedMessage = cache.get(quotedMessageObj);
                if (cachequotedMessage == null) {
                    cachequotedMessage = com_infinite_fireapp_model_realms_QuotedMessageRealmProxy.insert(realm, quotedMessageObj, cache);
                }
                table.setLink(columnInfo.quotedMessageIndex, rowIndex, cachequotedMessage, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.infinite.fireapp.model.realms.Message object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.infinite.fireapp.model.realms.Message.class);
        long tableNativePtr = table.getNativePtr();
        MessageColumnInfo columnInfo = (MessageColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Message.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$messageId = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$messageId();
        if (realmGet$messageId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.messageIdIndex, rowIndex, realmGet$messageId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.messageIdIndex, rowIndex, false);
        }
        String realmGet$fromId = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$fromId();
        if (realmGet$fromId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fromIdIndex, rowIndex, realmGet$fromId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fromIdIndex, rowIndex, false);
        }
        String realmGet$fromPhone = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$fromPhone();
        if (realmGet$fromPhone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fromPhoneIndex, rowIndex, realmGet$fromPhone, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fromPhoneIndex, rowIndex, false);
        }
        String realmGet$toId = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$toId();
        if (realmGet$toId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.toIdIndex, rowIndex, realmGet$toId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.toIdIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$type(), false);
        String realmGet$content = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$content();
        if (realmGet$content != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contentIndex, rowIndex, false);
        }
        String realmGet$timestamp = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$timestamp();
        if (realmGet$timestamp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.timestampIndex, rowIndex, realmGet$timestamp, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.timestampIndex, rowIndex, false);
        }
        String realmGet$chatId = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$chatId();
        if (realmGet$chatId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.chatIdIndex, rowIndex, realmGet$chatId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.chatIdIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.messageStatIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$messageStat(), false);
        String realmGet$localPath = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$localPath();
        if (realmGet$localPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.localPathIndex, rowIndex, realmGet$localPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.localPathIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.downloadUploadStatIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$downloadUploadStat(), false);
        String realmGet$metadata = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$metadata();
        if (realmGet$metadata != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.metadataIndex, rowIndex, realmGet$metadata, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.metadataIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.voiceMessageSeenIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$voiceMessageSeen(), false);
        String realmGet$mediaDuration = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$mediaDuration();
        if (realmGet$mediaDuration != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mediaDurationIndex, rowIndex, realmGet$mediaDuration, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mediaDurationIndex, rowIndex, false);
        }
        String realmGet$thumb = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$thumb();
        if (realmGet$thumb != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.thumbIndex, rowIndex, realmGet$thumb, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.thumbIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isForwardedIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$isForwarded(), false);
        String realmGet$videoThumb = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$videoThumb();
        if (realmGet$videoThumb != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.videoThumbIndex, rowIndex, realmGet$videoThumb, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.videoThumbIndex, rowIndex, false);
        }
        String realmGet$fileSize = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$fileSize();
        if (realmGet$fileSize != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fileSizeIndex, rowIndex, realmGet$fileSize, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fileSizeIndex, rowIndex, false);
        }

        com.infinite.fireapp.model.realms.RealmContact contactObj = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$contact();
        if (contactObj != null) {
            Long cachecontact = cache.get(contactObj);
            if (cachecontact == null) {
                cachecontact = com_infinite_fireapp_model_realms_RealmContactRealmProxy.insertOrUpdate(realm, contactObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.contactIndex, rowIndex, cachecontact, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.contactIndex, rowIndex);
        }

        com.infinite.fireapp.model.realms.RealmLocation locationObj = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$location();
        if (locationObj != null) {
            Long cachelocation = cache.get(locationObj);
            if (cachelocation == null) {
                cachelocation = com_infinite_fireapp_model_realms_RealmLocationRealmProxy.insertOrUpdate(realm, locationObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.locationIndex, rowIndex, cachelocation, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.locationIndex, rowIndex);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isGroupIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$isGroup(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isBroadcastIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$isBroadcast(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isSeenIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$isSeen(), false);

        com.infinite.fireapp.model.realms.QuotedMessage quotedMessageObj = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$quotedMessage();
        if (quotedMessageObj != null) {
            Long cachequotedMessage = cache.get(quotedMessageObj);
            if (cachequotedMessage == null) {
                cachequotedMessage = com_infinite_fireapp_model_realms_QuotedMessageRealmProxy.insertOrUpdate(realm, quotedMessageObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.quotedMessageIndex, rowIndex, cachequotedMessage, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.quotedMessageIndex, rowIndex);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.infinite.fireapp.model.realms.Message.class);
        long tableNativePtr = table.getNativePtr();
        MessageColumnInfo columnInfo = (MessageColumnInfo) realm.getSchema().getColumnInfo(com.infinite.fireapp.model.realms.Message.class);
        com.infinite.fireapp.model.realms.Message object = null;
        while (objects.hasNext()) {
            object = (com.infinite.fireapp.model.realms.Message) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$messageId = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$messageId();
            if (realmGet$messageId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.messageIdIndex, rowIndex, realmGet$messageId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.messageIdIndex, rowIndex, false);
            }
            String realmGet$fromId = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$fromId();
            if (realmGet$fromId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fromIdIndex, rowIndex, realmGet$fromId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fromIdIndex, rowIndex, false);
            }
            String realmGet$fromPhone = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$fromPhone();
            if (realmGet$fromPhone != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fromPhoneIndex, rowIndex, realmGet$fromPhone, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fromPhoneIndex, rowIndex, false);
            }
            String realmGet$toId = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$toId();
            if (realmGet$toId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.toIdIndex, rowIndex, realmGet$toId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.toIdIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$type(), false);
            String realmGet$content = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$content();
            if (realmGet$content != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.contentIndex, rowIndex, false);
            }
            String realmGet$timestamp = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$timestamp();
            if (realmGet$timestamp != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.timestampIndex, rowIndex, realmGet$timestamp, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.timestampIndex, rowIndex, false);
            }
            String realmGet$chatId = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$chatId();
            if (realmGet$chatId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.chatIdIndex, rowIndex, realmGet$chatId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.chatIdIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.messageStatIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$messageStat(), false);
            String realmGet$localPath = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$localPath();
            if (realmGet$localPath != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.localPathIndex, rowIndex, realmGet$localPath, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.localPathIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.downloadUploadStatIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$downloadUploadStat(), false);
            String realmGet$metadata = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$metadata();
            if (realmGet$metadata != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.metadataIndex, rowIndex, realmGet$metadata, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.metadataIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.voiceMessageSeenIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$voiceMessageSeen(), false);
            String realmGet$mediaDuration = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$mediaDuration();
            if (realmGet$mediaDuration != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.mediaDurationIndex, rowIndex, realmGet$mediaDuration, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.mediaDurationIndex, rowIndex, false);
            }
            String realmGet$thumb = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$thumb();
            if (realmGet$thumb != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.thumbIndex, rowIndex, realmGet$thumb, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.thumbIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isForwardedIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$isForwarded(), false);
            String realmGet$videoThumb = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$videoThumb();
            if (realmGet$videoThumb != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.videoThumbIndex, rowIndex, realmGet$videoThumb, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.videoThumbIndex, rowIndex, false);
            }
            String realmGet$fileSize = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$fileSize();
            if (realmGet$fileSize != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fileSizeIndex, rowIndex, realmGet$fileSize, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fileSizeIndex, rowIndex, false);
            }

            com.infinite.fireapp.model.realms.RealmContact contactObj = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$contact();
            if (contactObj != null) {
                Long cachecontact = cache.get(contactObj);
                if (cachecontact == null) {
                    cachecontact = com_infinite_fireapp_model_realms_RealmContactRealmProxy.insertOrUpdate(realm, contactObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.contactIndex, rowIndex, cachecontact, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.contactIndex, rowIndex);
            }

            com.infinite.fireapp.model.realms.RealmLocation locationObj = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$location();
            if (locationObj != null) {
                Long cachelocation = cache.get(locationObj);
                if (cachelocation == null) {
                    cachelocation = com_infinite_fireapp_model_realms_RealmLocationRealmProxy.insertOrUpdate(realm, locationObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.locationIndex, rowIndex, cachelocation, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.locationIndex, rowIndex);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isGroupIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$isGroup(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isBroadcastIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$isBroadcast(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isSeenIndex, rowIndex, ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$isSeen(), false);

            com.infinite.fireapp.model.realms.QuotedMessage quotedMessageObj = ((com_infinite_fireapp_model_realms_MessageRealmProxyInterface) object).realmGet$quotedMessage();
            if (quotedMessageObj != null) {
                Long cachequotedMessage = cache.get(quotedMessageObj);
                if (cachequotedMessage == null) {
                    cachequotedMessage = com_infinite_fireapp_model_realms_QuotedMessageRealmProxy.insertOrUpdate(realm, quotedMessageObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.quotedMessageIndex, rowIndex, cachequotedMessage, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.quotedMessageIndex, rowIndex);
            }
        }
    }

    public static com.infinite.fireapp.model.realms.Message createDetachedCopy(com.infinite.fireapp.model.realms.Message realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.infinite.fireapp.model.realms.Message unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.infinite.fireapp.model.realms.Message();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.infinite.fireapp.model.realms.Message) cachedObject.object;
            }
            unmanagedObject = (com.infinite.fireapp.model.realms.Message) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_infinite_fireapp_model_realms_MessageRealmProxyInterface unmanagedCopy = (com_infinite_fireapp_model_realms_MessageRealmProxyInterface) unmanagedObject;
        com_infinite_fireapp_model_realms_MessageRealmProxyInterface realmSource = (com_infinite_fireapp_model_realms_MessageRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$messageId(realmSource.realmGet$messageId());
        unmanagedCopy.realmSet$fromId(realmSource.realmGet$fromId());
        unmanagedCopy.realmSet$fromPhone(realmSource.realmGet$fromPhone());
        unmanagedCopy.realmSet$toId(realmSource.realmGet$toId());
        unmanagedCopy.realmSet$type(realmSource.realmGet$type());
        unmanagedCopy.realmSet$content(realmSource.realmGet$content());
        unmanagedCopy.realmSet$timestamp(realmSource.realmGet$timestamp());
        unmanagedCopy.realmSet$chatId(realmSource.realmGet$chatId());
        unmanagedCopy.realmSet$messageStat(realmSource.realmGet$messageStat());
        unmanagedCopy.realmSet$localPath(realmSource.realmGet$localPath());
        unmanagedCopy.realmSet$downloadUploadStat(realmSource.realmGet$downloadUploadStat());
        unmanagedCopy.realmSet$metadata(realmSource.realmGet$metadata());
        unmanagedCopy.realmSet$voiceMessageSeen(realmSource.realmGet$voiceMessageSeen());
        unmanagedCopy.realmSet$mediaDuration(realmSource.realmGet$mediaDuration());
        unmanagedCopy.realmSet$thumb(realmSource.realmGet$thumb());
        unmanagedCopy.realmSet$isForwarded(realmSource.realmGet$isForwarded());
        unmanagedCopy.realmSet$videoThumb(realmSource.realmGet$videoThumb());
        unmanagedCopy.realmSet$fileSize(realmSource.realmGet$fileSize());

        // Deep copy of contact
        unmanagedCopy.realmSet$contact(com_infinite_fireapp_model_realms_RealmContactRealmProxy.createDetachedCopy(realmSource.realmGet$contact(), currentDepth + 1, maxDepth, cache));

        // Deep copy of location
        unmanagedCopy.realmSet$location(com_infinite_fireapp_model_realms_RealmLocationRealmProxy.createDetachedCopy(realmSource.realmGet$location(), currentDepth + 1, maxDepth, cache));
        unmanagedCopy.realmSet$isGroup(realmSource.realmGet$isGroup());
        unmanagedCopy.realmSet$isBroadcast(realmSource.realmGet$isBroadcast());
        unmanagedCopy.realmSet$isSeen(realmSource.realmGet$isSeen());

        // Deep copy of quotedMessage
        unmanagedCopy.realmSet$quotedMessage(com_infinite_fireapp_model_realms_QuotedMessageRealmProxy.createDetachedCopy(realmSource.realmGet$quotedMessage(), currentDepth + 1, maxDepth, cache));

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

}
