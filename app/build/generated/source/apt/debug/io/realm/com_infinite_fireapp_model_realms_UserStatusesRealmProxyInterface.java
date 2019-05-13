package io.realm;


public interface com_infinite_fireapp_model_realms_UserStatusesRealmProxyInterface {
    public String realmGet$userId();
    public void realmSet$userId(String value);
    public long realmGet$lastStatusTimestamp();
    public void realmSet$lastStatusTimestamp(long value);
    public com.infinite.fireapp.model.realms.User realmGet$user();
    public void realmSet$user(com.infinite.fireapp.model.realms.User value);
    public RealmList<com.infinite.fireapp.model.realms.Status> realmGet$statuses();
    public void realmSet$statuses(RealmList<com.infinite.fireapp.model.realms.Status> value);
    public boolean realmGet$areAllSeen();
    public void realmSet$areAllSeen(boolean value);
}
