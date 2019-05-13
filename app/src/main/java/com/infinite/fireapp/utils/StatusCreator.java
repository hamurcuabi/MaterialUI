package com.infinite.fireapp.utils;

import com.infinite.fireapp.model.constants.StatusType;
import com.infinite.fireapp.model.realms.Status;

import java.util.Date;

public class StatusCreator {
    public static Status createImageStatus(String imagePath) {
        String statusId = FireConstants.getMyStatusRef().push().getKey();
        String thumbImg = BitmapUtils.decodeImage(imagePath,false);
        Status status = new Status(statusId, FireManager.getUid(), new Date().getTime(), thumbImg,null,imagePath, StatusType.IMAGE);
        RealmHelper.getInstance().saveObjectToRealm(status);
        return status;
    }

    public static Status createVideoStatus(String videoPath) {
        String statusId = FireConstants.getMyStatusRef().push().getKey();
        String thumbImg = BitmapUtils.generateVideoThumbAsBase64(videoPath);
        long mediaLengthInMillis = Util.getMediaLengthInMillis(MyApp.context(), videoPath);
        Status status = new Status(statusId, FireManager.getUid(), new Date().getTime(), thumbImg,null,videoPath, StatusType.VIDEO,mediaLengthInMillis);
        RealmHelper.getInstance().saveObjectToRealm(status);
        return status;
    }
}
