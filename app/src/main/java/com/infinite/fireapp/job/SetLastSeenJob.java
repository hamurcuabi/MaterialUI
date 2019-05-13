package com.infinite.fireapp.job;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.infinite.fireapp.model.constants.LastSeenStates;
import com.infinite.fireapp.utils.EmreUtil;
import com.infinite.fireapp.utils.FireManager;
import com.infinite.fireapp.utils.JobSchedulerSingleton;
import com.infinite.fireapp.utils.MyApp;
import com.infinite.fireapp.utils.SharedPreferencesManager;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class SetLastSeenJob extends JobService {

    private static final String TAG = "SetLastSeenJob";

    public static void schedule(Context context) {
        ComponentName component = new ComponentName(context, SetLastSeenJob.class);

        JobInfo.Builder builder = new JobInfo.Builder(JobIds.JOB_ID_SET_LAST_SEEN, component)
                .setPersisted(true)
                .setPeriodic(TimeUnit.MINUTES.toMillis(5))
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);


        JobSchedulerSingleton.getInstance().schedule(builder.build());
    }

    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        int lastSeenState = SharedPreferencesManager.getLastSeenState();
        if (MyApp.isBaseActivityVisible() && lastSeenState != LastSeenStates.ONLINE) {
            Log.d(TAG, "setOnline: ");
            FireManager.setOnlineStatus();


        } else if (!MyApp.isBaseActivityVisible() && lastSeenState != LastSeenStates.LAST_SEEN) {
            Log.d(TAG, "setOffline: ");
            FireManager.setLastSeen();

        }
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

}
