package io.realm;


import android.util.JsonReader;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(19);
        modelClasses.add(com.infinite.fireapp.model.realms.Broadcast.class);
        modelClasses.add(com.infinite.fireapp.model.realms.Chat.class);
        modelClasses.add(com.infinite.fireapp.model.realms.CurrentUserInfo.class);
        modelClasses.add(com.infinite.fireapp.model.realms.DeletedMessage.class);
        modelClasses.add(com.infinite.fireapp.model.realms.FireCall.class);
        modelClasses.add(com.infinite.fireapp.model.realms.Group.class);
        modelClasses.add(com.infinite.fireapp.model.realms.GroupEvent.class);
        modelClasses.add(com.infinite.fireapp.model.realms.JobId.class);
        modelClasses.add(com.infinite.fireapp.model.realms.Message.class);
        modelClasses.add(com.infinite.fireapp.model.realms.PendingGroupJob.class);
        modelClasses.add(com.infinite.fireapp.model.realms.PhoneNumber.class);
        modelClasses.add(com.infinite.fireapp.model.realms.QuotedMessage.class);
        modelClasses.add(com.infinite.fireapp.model.realms.RealmContact.class);
        modelClasses.add(com.infinite.fireapp.model.realms.RealmLocation.class);
        modelClasses.add(com.infinite.fireapp.model.realms.Status.class);
        modelClasses.add(com.infinite.fireapp.model.realms.UnUpdatedStat.class);
        modelClasses.add(com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat.class);
        modelClasses.add(com.infinite.fireapp.model.realms.User.class);
        modelClasses.add(com.infinite.fireapp.model.realms.UserStatuses.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(19);
        infoMap.put(com.infinite.fireapp.model.realms.Broadcast.class, io.realm.com_infinite_fireapp_model_realms_BroadcastRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.infinite.fireapp.model.realms.Chat.class, io.realm.com_infinite_fireapp_model_realms_ChatRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.infinite.fireapp.model.realms.CurrentUserInfo.class, io.realm.com_infinite_fireapp_model_realms_CurrentUserInfoRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.infinite.fireapp.model.realms.DeletedMessage.class, io.realm.com_infinite_fireapp_model_realms_DeletedMessageRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.infinite.fireapp.model.realms.FireCall.class, io.realm.com_infinite_fireapp_model_realms_FireCallRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.infinite.fireapp.model.realms.Group.class, io.realm.com_infinite_fireapp_model_realms_GroupRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.infinite.fireapp.model.realms.GroupEvent.class, io.realm.com_infinite_fireapp_model_realms_GroupEventRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.infinite.fireapp.model.realms.JobId.class, io.realm.com_infinite_fireapp_model_realms_JobIdRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.infinite.fireapp.model.realms.Message.class, io.realm.com_infinite_fireapp_model_realms_MessageRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.infinite.fireapp.model.realms.PendingGroupJob.class, io.realm.com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.infinite.fireapp.model.realms.PhoneNumber.class, io.realm.com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.infinite.fireapp.model.realms.QuotedMessage.class, io.realm.com_infinite_fireapp_model_realms_QuotedMessageRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.infinite.fireapp.model.realms.RealmContact.class, io.realm.com_infinite_fireapp_model_realms_RealmContactRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.infinite.fireapp.model.realms.RealmLocation.class, io.realm.com_infinite_fireapp_model_realms_RealmLocationRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.infinite.fireapp.model.realms.Status.class, io.realm.com_infinite_fireapp_model_realms_StatusRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.infinite.fireapp.model.realms.UnUpdatedStat.class, io.realm.com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat.class, io.realm.com_infinite_fireapp_model_realms_UnUpdatedVoiceMessageStatRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.infinite.fireapp.model.realms.User.class, io.realm.com_infinite_fireapp_model_realms_UserRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.infinite.fireapp.model.realms.UserStatuses.class, io.realm.com_infinite_fireapp_model_realms_UserStatusesRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(com.infinite.fireapp.model.realms.Broadcast.class)) {
            return io.realm.com_infinite_fireapp_model_realms_BroadcastRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Chat.class)) {
            return io.realm.com_infinite_fireapp_model_realms_ChatRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.CurrentUserInfo.class)) {
            return io.realm.com_infinite_fireapp_model_realms_CurrentUserInfoRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.DeletedMessage.class)) {
            return io.realm.com_infinite_fireapp_model_realms_DeletedMessageRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.FireCall.class)) {
            return io.realm.com_infinite_fireapp_model_realms_FireCallRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Group.class)) {
            return io.realm.com_infinite_fireapp_model_realms_GroupRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.GroupEvent.class)) {
            return io.realm.com_infinite_fireapp_model_realms_GroupEventRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.JobId.class)) {
            return io.realm.com_infinite_fireapp_model_realms_JobIdRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Message.class)) {
            return io.realm.com_infinite_fireapp_model_realms_MessageRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.PendingGroupJob.class)) {
            return io.realm.com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.PhoneNumber.class)) {
            return io.realm.com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.QuotedMessage.class)) {
            return io.realm.com_infinite_fireapp_model_realms_QuotedMessageRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.RealmContact.class)) {
            return io.realm.com_infinite_fireapp_model_realms_RealmContactRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.RealmLocation.class)) {
            return io.realm.com_infinite_fireapp_model_realms_RealmLocationRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Status.class)) {
            return io.realm.com_infinite_fireapp_model_realms_StatusRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedStat.class)) {
            return io.realm.com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat.class)) {
            return io.realm.com_infinite_fireapp_model_realms_UnUpdatedVoiceMessageStatRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.User.class)) {
            return io.realm.com_infinite_fireapp_model_realms_UserRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.UserStatuses.class)) {
            return io.realm.com_infinite_fireapp_model_realms_UserStatusesRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.infinite.fireapp.model.realms.Broadcast.class)) {
            return "Broadcast";
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Chat.class)) {
            return "Chat";
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.CurrentUserInfo.class)) {
            return "CurrentUserInfo";
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.DeletedMessage.class)) {
            return "DeletedMessage";
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.FireCall.class)) {
            return "FireCall";
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Group.class)) {
            return "Group";
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.GroupEvent.class)) {
            return "GroupEvent";
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.JobId.class)) {
            return "JobId";
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Message.class)) {
            return "Message";
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.PendingGroupJob.class)) {
            return "PendingGroupJob";
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.PhoneNumber.class)) {
            return "PhoneNumber";
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.QuotedMessage.class)) {
            return "QuotedMessage";
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.RealmContact.class)) {
            return "RealmContact";
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.RealmLocation.class)) {
            return "RealmLocation";
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Status.class)) {
            return "Status";
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedStat.class)) {
            return "UnUpdatedStat";
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat.class)) {
            return "UnUpdatedVoiceMessageStat";
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.User.class)) {
            return "User";
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.UserStatuses.class)) {
            return "UserStatuses";
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.infinite.fireapp.model.realms.Broadcast.class)) {
                return clazz.cast(new io.realm.com_infinite_fireapp_model_realms_BroadcastRealmProxy());
            }
            if (clazz.equals(com.infinite.fireapp.model.realms.Chat.class)) {
                return clazz.cast(new io.realm.com_infinite_fireapp_model_realms_ChatRealmProxy());
            }
            if (clazz.equals(com.infinite.fireapp.model.realms.CurrentUserInfo.class)) {
                return clazz.cast(new io.realm.com_infinite_fireapp_model_realms_CurrentUserInfoRealmProxy());
            }
            if (clazz.equals(com.infinite.fireapp.model.realms.DeletedMessage.class)) {
                return clazz.cast(new io.realm.com_infinite_fireapp_model_realms_DeletedMessageRealmProxy());
            }
            if (clazz.equals(com.infinite.fireapp.model.realms.FireCall.class)) {
                return clazz.cast(new io.realm.com_infinite_fireapp_model_realms_FireCallRealmProxy());
            }
            if (clazz.equals(com.infinite.fireapp.model.realms.Group.class)) {
                return clazz.cast(new io.realm.com_infinite_fireapp_model_realms_GroupRealmProxy());
            }
            if (clazz.equals(com.infinite.fireapp.model.realms.GroupEvent.class)) {
                return clazz.cast(new io.realm.com_infinite_fireapp_model_realms_GroupEventRealmProxy());
            }
            if (clazz.equals(com.infinite.fireapp.model.realms.JobId.class)) {
                return clazz.cast(new io.realm.com_infinite_fireapp_model_realms_JobIdRealmProxy());
            }
            if (clazz.equals(com.infinite.fireapp.model.realms.Message.class)) {
                return clazz.cast(new io.realm.com_infinite_fireapp_model_realms_MessageRealmProxy());
            }
            if (clazz.equals(com.infinite.fireapp.model.realms.PendingGroupJob.class)) {
                return clazz.cast(new io.realm.com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy());
            }
            if (clazz.equals(com.infinite.fireapp.model.realms.PhoneNumber.class)) {
                return clazz.cast(new io.realm.com_infinite_fireapp_model_realms_PhoneNumberRealmProxy());
            }
            if (clazz.equals(com.infinite.fireapp.model.realms.QuotedMessage.class)) {
                return clazz.cast(new io.realm.com_infinite_fireapp_model_realms_QuotedMessageRealmProxy());
            }
            if (clazz.equals(com.infinite.fireapp.model.realms.RealmContact.class)) {
                return clazz.cast(new io.realm.com_infinite_fireapp_model_realms_RealmContactRealmProxy());
            }
            if (clazz.equals(com.infinite.fireapp.model.realms.RealmLocation.class)) {
                return clazz.cast(new io.realm.com_infinite_fireapp_model_realms_RealmLocationRealmProxy());
            }
            if (clazz.equals(com.infinite.fireapp.model.realms.Status.class)) {
                return clazz.cast(new io.realm.com_infinite_fireapp_model_realms_StatusRealmProxy());
            }
            if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedStat.class)) {
                return clazz.cast(new io.realm.com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy());
            }
            if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat.class)) {
                return clazz.cast(new io.realm.com_infinite_fireapp_model_realms_UnUpdatedVoiceMessageStatRealmProxy());
            }
            if (clazz.equals(com.infinite.fireapp.model.realms.User.class)) {
                return clazz.cast(new io.realm.com_infinite_fireapp_model_realms_UserRealmProxy());
            }
            if (clazz.equals(com.infinite.fireapp.model.realms.UserStatuses.class)) {
                return clazz.cast(new io.realm.com_infinite_fireapp_model_realms_UserStatusesRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.infinite.fireapp.model.realms.Broadcast.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_BroadcastRealmProxy.copyOrUpdate(realm, (com.infinite.fireapp.model.realms.Broadcast) obj, update, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Chat.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_ChatRealmProxy.copyOrUpdate(realm, (com.infinite.fireapp.model.realms.Chat) obj, update, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.CurrentUserInfo.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_CurrentUserInfoRealmProxy.copyOrUpdate(realm, (com.infinite.fireapp.model.realms.CurrentUserInfo) obj, update, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.DeletedMessage.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_DeletedMessageRealmProxy.copyOrUpdate(realm, (com.infinite.fireapp.model.realms.DeletedMessage) obj, update, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.FireCall.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_FireCallRealmProxy.copyOrUpdate(realm, (com.infinite.fireapp.model.realms.FireCall) obj, update, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Group.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_GroupRealmProxy.copyOrUpdate(realm, (com.infinite.fireapp.model.realms.Group) obj, update, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.GroupEvent.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_GroupEventRealmProxy.copyOrUpdate(realm, (com.infinite.fireapp.model.realms.GroupEvent) obj, update, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.JobId.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_JobIdRealmProxy.copyOrUpdate(realm, (com.infinite.fireapp.model.realms.JobId) obj, update, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Message.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_MessageRealmProxy.copyOrUpdate(realm, (com.infinite.fireapp.model.realms.Message) obj, update, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.PendingGroupJob.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy.copyOrUpdate(realm, (com.infinite.fireapp.model.realms.PendingGroupJob) obj, update, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.PhoneNumber.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.copyOrUpdate(realm, (com.infinite.fireapp.model.realms.PhoneNumber) obj, update, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.QuotedMessage.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_QuotedMessageRealmProxy.copyOrUpdate(realm, (com.infinite.fireapp.model.realms.QuotedMessage) obj, update, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.RealmContact.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_RealmContactRealmProxy.copyOrUpdate(realm, (com.infinite.fireapp.model.realms.RealmContact) obj, update, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.RealmLocation.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_RealmLocationRealmProxy.copyOrUpdate(realm, (com.infinite.fireapp.model.realms.RealmLocation) obj, update, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Status.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_StatusRealmProxy.copyOrUpdate(realm, (com.infinite.fireapp.model.realms.Status) obj, update, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedStat.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy.copyOrUpdate(realm, (com.infinite.fireapp.model.realms.UnUpdatedStat) obj, update, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_UnUpdatedVoiceMessageStatRealmProxy.copyOrUpdate(realm, (com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat) obj, update, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.User.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_UserRealmProxy.copyOrUpdate(realm, (com.infinite.fireapp.model.realms.User) obj, update, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.UserStatuses.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_UserStatusesRealmProxy.copyOrUpdate(realm, (com.infinite.fireapp.model.realms.UserStatuses) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.infinite.fireapp.model.realms.Broadcast.class)) {
            io.realm.com_infinite_fireapp_model_realms_BroadcastRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.Broadcast) object, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.Chat.class)) {
            io.realm.com_infinite_fireapp_model_realms_ChatRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.Chat) object, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.CurrentUserInfo.class)) {
            io.realm.com_infinite_fireapp_model_realms_CurrentUserInfoRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.CurrentUserInfo) object, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.DeletedMessage.class)) {
            io.realm.com_infinite_fireapp_model_realms_DeletedMessageRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.DeletedMessage) object, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.FireCall.class)) {
            io.realm.com_infinite_fireapp_model_realms_FireCallRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.FireCall) object, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.Group.class)) {
            io.realm.com_infinite_fireapp_model_realms_GroupRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.Group) object, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.GroupEvent.class)) {
            io.realm.com_infinite_fireapp_model_realms_GroupEventRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.GroupEvent) object, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.JobId.class)) {
            io.realm.com_infinite_fireapp_model_realms_JobIdRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.JobId) object, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.Message.class)) {
            io.realm.com_infinite_fireapp_model_realms_MessageRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.Message) object, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.PendingGroupJob.class)) {
            io.realm.com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.PendingGroupJob) object, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.PhoneNumber.class)) {
            io.realm.com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.PhoneNumber) object, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.QuotedMessage.class)) {
            io.realm.com_infinite_fireapp_model_realms_QuotedMessageRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.QuotedMessage) object, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.RealmContact.class)) {
            io.realm.com_infinite_fireapp_model_realms_RealmContactRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.RealmContact) object, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.RealmLocation.class)) {
            io.realm.com_infinite_fireapp_model_realms_RealmLocationRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.RealmLocation) object, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.Status.class)) {
            io.realm.com_infinite_fireapp_model_realms_StatusRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.Status) object, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedStat.class)) {
            io.realm.com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.UnUpdatedStat) object, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat.class)) {
            io.realm.com_infinite_fireapp_model_realms_UnUpdatedVoiceMessageStatRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat) object, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.User.class)) {
            io.realm.com_infinite_fireapp_model_realms_UserRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.User) object, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.UserStatuses.class)) {
            io.realm.com_infinite_fireapp_model_realms_UserStatusesRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.UserStatuses) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.infinite.fireapp.model.realms.Broadcast.class)) {
                io.realm.com_infinite_fireapp_model_realms_BroadcastRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.Broadcast) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.Chat.class)) {
                io.realm.com_infinite_fireapp_model_realms_ChatRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.Chat) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.CurrentUserInfo.class)) {
                io.realm.com_infinite_fireapp_model_realms_CurrentUserInfoRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.CurrentUserInfo) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.DeletedMessage.class)) {
                io.realm.com_infinite_fireapp_model_realms_DeletedMessageRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.DeletedMessage) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.FireCall.class)) {
                io.realm.com_infinite_fireapp_model_realms_FireCallRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.FireCall) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.Group.class)) {
                io.realm.com_infinite_fireapp_model_realms_GroupRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.Group) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.GroupEvent.class)) {
                io.realm.com_infinite_fireapp_model_realms_GroupEventRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.GroupEvent) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.JobId.class)) {
                io.realm.com_infinite_fireapp_model_realms_JobIdRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.JobId) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.Message.class)) {
                io.realm.com_infinite_fireapp_model_realms_MessageRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.Message) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.PendingGroupJob.class)) {
                io.realm.com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.PendingGroupJob) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.PhoneNumber.class)) {
                io.realm.com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.PhoneNumber) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.QuotedMessage.class)) {
                io.realm.com_infinite_fireapp_model_realms_QuotedMessageRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.QuotedMessage) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.RealmContact.class)) {
                io.realm.com_infinite_fireapp_model_realms_RealmContactRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.RealmContact) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.RealmLocation.class)) {
                io.realm.com_infinite_fireapp_model_realms_RealmLocationRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.RealmLocation) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.Status.class)) {
                io.realm.com_infinite_fireapp_model_realms_StatusRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.Status) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedStat.class)) {
                io.realm.com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.UnUpdatedStat) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat.class)) {
                io.realm.com_infinite_fireapp_model_realms_UnUpdatedVoiceMessageStatRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.User.class)) {
                io.realm.com_infinite_fireapp_model_realms_UserRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.User) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.UserStatuses.class)) {
                io.realm.com_infinite_fireapp_model_realms_UserStatusesRealmProxy.insert(realm, (com.infinite.fireapp.model.realms.UserStatuses) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.infinite.fireapp.model.realms.Broadcast.class)) {
                    io.realm.com_infinite_fireapp_model_realms_BroadcastRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.Chat.class)) {
                    io.realm.com_infinite_fireapp_model_realms_ChatRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.CurrentUserInfo.class)) {
                    io.realm.com_infinite_fireapp_model_realms_CurrentUserInfoRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.DeletedMessage.class)) {
                    io.realm.com_infinite_fireapp_model_realms_DeletedMessageRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.FireCall.class)) {
                    io.realm.com_infinite_fireapp_model_realms_FireCallRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.Group.class)) {
                    io.realm.com_infinite_fireapp_model_realms_GroupRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.GroupEvent.class)) {
                    io.realm.com_infinite_fireapp_model_realms_GroupEventRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.JobId.class)) {
                    io.realm.com_infinite_fireapp_model_realms_JobIdRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.Message.class)) {
                    io.realm.com_infinite_fireapp_model_realms_MessageRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.PendingGroupJob.class)) {
                    io.realm.com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.PhoneNumber.class)) {
                    io.realm.com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.QuotedMessage.class)) {
                    io.realm.com_infinite_fireapp_model_realms_QuotedMessageRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.RealmContact.class)) {
                    io.realm.com_infinite_fireapp_model_realms_RealmContactRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.RealmLocation.class)) {
                    io.realm.com_infinite_fireapp_model_realms_RealmLocationRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.Status.class)) {
                    io.realm.com_infinite_fireapp_model_realms_StatusRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedStat.class)) {
                    io.realm.com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat.class)) {
                    io.realm.com_infinite_fireapp_model_realms_UnUpdatedVoiceMessageStatRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.User.class)) {
                    io.realm.com_infinite_fireapp_model_realms_UserRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.UserStatuses.class)) {
                    io.realm.com_infinite_fireapp_model_realms_UserStatusesRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.infinite.fireapp.model.realms.Broadcast.class)) {
            io.realm.com_infinite_fireapp_model_realms_BroadcastRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.Broadcast) obj, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.Chat.class)) {
            io.realm.com_infinite_fireapp_model_realms_ChatRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.Chat) obj, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.CurrentUserInfo.class)) {
            io.realm.com_infinite_fireapp_model_realms_CurrentUserInfoRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.CurrentUserInfo) obj, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.DeletedMessage.class)) {
            io.realm.com_infinite_fireapp_model_realms_DeletedMessageRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.DeletedMessage) obj, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.FireCall.class)) {
            io.realm.com_infinite_fireapp_model_realms_FireCallRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.FireCall) obj, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.Group.class)) {
            io.realm.com_infinite_fireapp_model_realms_GroupRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.Group) obj, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.GroupEvent.class)) {
            io.realm.com_infinite_fireapp_model_realms_GroupEventRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.GroupEvent) obj, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.JobId.class)) {
            io.realm.com_infinite_fireapp_model_realms_JobIdRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.JobId) obj, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.Message.class)) {
            io.realm.com_infinite_fireapp_model_realms_MessageRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.Message) obj, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.PendingGroupJob.class)) {
            io.realm.com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.PendingGroupJob) obj, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.PhoneNumber.class)) {
            io.realm.com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.PhoneNumber) obj, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.QuotedMessage.class)) {
            io.realm.com_infinite_fireapp_model_realms_QuotedMessageRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.QuotedMessage) obj, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.RealmContact.class)) {
            io.realm.com_infinite_fireapp_model_realms_RealmContactRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.RealmContact) obj, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.RealmLocation.class)) {
            io.realm.com_infinite_fireapp_model_realms_RealmLocationRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.RealmLocation) obj, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.Status.class)) {
            io.realm.com_infinite_fireapp_model_realms_StatusRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.Status) obj, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedStat.class)) {
            io.realm.com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.UnUpdatedStat) obj, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat.class)) {
            io.realm.com_infinite_fireapp_model_realms_UnUpdatedVoiceMessageStatRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat) obj, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.User.class)) {
            io.realm.com_infinite_fireapp_model_realms_UserRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.User) obj, cache);
        } else if (clazz.equals(com.infinite.fireapp.model.realms.UserStatuses.class)) {
            io.realm.com_infinite_fireapp_model_realms_UserStatusesRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.UserStatuses) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.infinite.fireapp.model.realms.Broadcast.class)) {
                io.realm.com_infinite_fireapp_model_realms_BroadcastRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.Broadcast) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.Chat.class)) {
                io.realm.com_infinite_fireapp_model_realms_ChatRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.Chat) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.CurrentUserInfo.class)) {
                io.realm.com_infinite_fireapp_model_realms_CurrentUserInfoRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.CurrentUserInfo) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.DeletedMessage.class)) {
                io.realm.com_infinite_fireapp_model_realms_DeletedMessageRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.DeletedMessage) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.FireCall.class)) {
                io.realm.com_infinite_fireapp_model_realms_FireCallRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.FireCall) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.Group.class)) {
                io.realm.com_infinite_fireapp_model_realms_GroupRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.Group) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.GroupEvent.class)) {
                io.realm.com_infinite_fireapp_model_realms_GroupEventRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.GroupEvent) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.JobId.class)) {
                io.realm.com_infinite_fireapp_model_realms_JobIdRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.JobId) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.Message.class)) {
                io.realm.com_infinite_fireapp_model_realms_MessageRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.Message) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.PendingGroupJob.class)) {
                io.realm.com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.PendingGroupJob) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.PhoneNumber.class)) {
                io.realm.com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.PhoneNumber) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.QuotedMessage.class)) {
                io.realm.com_infinite_fireapp_model_realms_QuotedMessageRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.QuotedMessage) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.RealmContact.class)) {
                io.realm.com_infinite_fireapp_model_realms_RealmContactRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.RealmContact) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.RealmLocation.class)) {
                io.realm.com_infinite_fireapp_model_realms_RealmLocationRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.RealmLocation) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.Status.class)) {
                io.realm.com_infinite_fireapp_model_realms_StatusRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.Status) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedStat.class)) {
                io.realm.com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.UnUpdatedStat) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat.class)) {
                io.realm.com_infinite_fireapp_model_realms_UnUpdatedVoiceMessageStatRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.User.class)) {
                io.realm.com_infinite_fireapp_model_realms_UserRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.User) object, cache);
            } else if (clazz.equals(com.infinite.fireapp.model.realms.UserStatuses.class)) {
                io.realm.com_infinite_fireapp_model_realms_UserStatusesRealmProxy.insertOrUpdate(realm, (com.infinite.fireapp.model.realms.UserStatuses) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.infinite.fireapp.model.realms.Broadcast.class)) {
                    io.realm.com_infinite_fireapp_model_realms_BroadcastRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.Chat.class)) {
                    io.realm.com_infinite_fireapp_model_realms_ChatRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.CurrentUserInfo.class)) {
                    io.realm.com_infinite_fireapp_model_realms_CurrentUserInfoRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.DeletedMessage.class)) {
                    io.realm.com_infinite_fireapp_model_realms_DeletedMessageRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.FireCall.class)) {
                    io.realm.com_infinite_fireapp_model_realms_FireCallRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.Group.class)) {
                    io.realm.com_infinite_fireapp_model_realms_GroupRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.GroupEvent.class)) {
                    io.realm.com_infinite_fireapp_model_realms_GroupEventRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.JobId.class)) {
                    io.realm.com_infinite_fireapp_model_realms_JobIdRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.Message.class)) {
                    io.realm.com_infinite_fireapp_model_realms_MessageRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.PendingGroupJob.class)) {
                    io.realm.com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.PhoneNumber.class)) {
                    io.realm.com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.QuotedMessage.class)) {
                    io.realm.com_infinite_fireapp_model_realms_QuotedMessageRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.RealmContact.class)) {
                    io.realm.com_infinite_fireapp_model_realms_RealmContactRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.RealmLocation.class)) {
                    io.realm.com_infinite_fireapp_model_realms_RealmLocationRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.Status.class)) {
                    io.realm.com_infinite_fireapp_model_realms_StatusRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedStat.class)) {
                    io.realm.com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat.class)) {
                    io.realm.com_infinite_fireapp_model_realms_UnUpdatedVoiceMessageStatRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.User.class)) {
                    io.realm.com_infinite_fireapp_model_realms_UserRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.infinite.fireapp.model.realms.UserStatuses.class)) {
                    io.realm.com_infinite_fireapp_model_realms_UserStatusesRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.infinite.fireapp.model.realms.Broadcast.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_BroadcastRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Chat.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_ChatRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.CurrentUserInfo.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_CurrentUserInfoRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.DeletedMessage.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_DeletedMessageRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.FireCall.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_FireCallRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Group.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_GroupRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.GroupEvent.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_GroupEventRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.JobId.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_JobIdRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Message.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_MessageRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.PendingGroupJob.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.PhoneNumber.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.QuotedMessage.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_QuotedMessageRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.RealmContact.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_RealmContactRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.RealmLocation.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_RealmLocationRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Status.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_StatusRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedStat.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_UnUpdatedVoiceMessageStatRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.User.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_UserRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.UserStatuses.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_UserStatusesRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.infinite.fireapp.model.realms.Broadcast.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_BroadcastRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Chat.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_ChatRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.CurrentUserInfo.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_CurrentUserInfoRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.DeletedMessage.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_DeletedMessageRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.FireCall.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_FireCallRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Group.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_GroupRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.GroupEvent.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_GroupEventRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.JobId.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_JobIdRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Message.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_MessageRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.PendingGroupJob.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.PhoneNumber.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.QuotedMessage.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_QuotedMessageRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.RealmContact.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_RealmContactRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.RealmLocation.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_RealmLocationRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Status.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_StatusRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedStat.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_UnUpdatedVoiceMessageStatRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.User.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_UserRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.UserStatuses.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_UserStatusesRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.infinite.fireapp.model.realms.Broadcast.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_BroadcastRealmProxy.createDetachedCopy((com.infinite.fireapp.model.realms.Broadcast) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Chat.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_ChatRealmProxy.createDetachedCopy((com.infinite.fireapp.model.realms.Chat) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.CurrentUserInfo.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_CurrentUserInfoRealmProxy.createDetachedCopy((com.infinite.fireapp.model.realms.CurrentUserInfo) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.DeletedMessage.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_DeletedMessageRealmProxy.createDetachedCopy((com.infinite.fireapp.model.realms.DeletedMessage) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.FireCall.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_FireCallRealmProxy.createDetachedCopy((com.infinite.fireapp.model.realms.FireCall) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Group.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_GroupRealmProxy.createDetachedCopy((com.infinite.fireapp.model.realms.Group) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.GroupEvent.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_GroupEventRealmProxy.createDetachedCopy((com.infinite.fireapp.model.realms.GroupEvent) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.JobId.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_JobIdRealmProxy.createDetachedCopy((com.infinite.fireapp.model.realms.JobId) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Message.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_MessageRealmProxy.createDetachedCopy((com.infinite.fireapp.model.realms.Message) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.PendingGroupJob.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_PendingGroupJobRealmProxy.createDetachedCopy((com.infinite.fireapp.model.realms.PendingGroupJob) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.PhoneNumber.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_PhoneNumberRealmProxy.createDetachedCopy((com.infinite.fireapp.model.realms.PhoneNumber) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.QuotedMessage.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_QuotedMessageRealmProxy.createDetachedCopy((com.infinite.fireapp.model.realms.QuotedMessage) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.RealmContact.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_RealmContactRealmProxy.createDetachedCopy((com.infinite.fireapp.model.realms.RealmContact) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.RealmLocation.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_RealmLocationRealmProxy.createDetachedCopy((com.infinite.fireapp.model.realms.RealmLocation) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.Status.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_StatusRealmProxy.createDetachedCopy((com.infinite.fireapp.model.realms.Status) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedStat.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_UnUpdatedStatRealmProxy.createDetachedCopy((com.infinite.fireapp.model.realms.UnUpdatedStat) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_UnUpdatedVoiceMessageStatRealmProxy.createDetachedCopy((com.infinite.fireapp.model.realms.UnUpdatedVoiceMessageStat) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.User.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_UserRealmProxy.createDetachedCopy((com.infinite.fireapp.model.realms.User) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.infinite.fireapp.model.realms.UserStatuses.class)) {
            return clazz.cast(io.realm.com_infinite_fireapp_model_realms_UserStatusesRealmProxy.createDetachedCopy((com.infinite.fireapp.model.realms.UserStatuses) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
