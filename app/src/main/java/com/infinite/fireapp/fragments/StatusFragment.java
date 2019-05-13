package com.infinite.fireapp.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cjt2325.cameralibrary.ResultCodes;
import com.devlomi.circularstatusview.CircularStatusView;
import com.infinite.fireapp.R;
import com.infinite.fireapp.activities.MyStatusActivity;
import com.infinite.fireapp.activities.ViewStatusActivity;
import com.infinite.fireapp.adapters.StatusAdapter;
import com.infinite.fireapp.interfaces.StatusFragmentCallbacks;
import com.infinite.fireapp.model.constants.MessageType;
import com.infinite.fireapp.model.realms.Status;
import com.infinite.fireapp.model.realms.UserStatuses;
import com.infinite.fireapp.utils.BitmapUtils;
import com.infinite.fireapp.utils.DirManager;
import com.infinite.fireapp.utils.FileUtils;
import com.infinite.fireapp.utils.FireManager;
import com.infinite.fireapp.utils.IntentUtils;
import com.infinite.fireapp.utils.MyApp;
import com.infinite.fireapp.utils.NetworkHelper;
import com.infinite.fireapp.utils.RealmHelper;
import com.infinite.fireapp.utils.SharedPreferencesManager;
import com.infinite.fireapp.utils.StatusManager;
import com.infinite.fireapp.utils.TimeHelper;
import com.infinite.fireapp.utils.Util;
import com.infinite.fireapp.views.HeaderViewDecoration;
import com.google.android.gms.ads.AdView;
import com.zhihu.matisse.Matisse;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import de.hdodenhof.circleimageview.CircleImageView;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatusFragment extends BaseFragment implements StatusAdapter.OnClickListener {
    //max duration for status video time (30sec)
    public static final int MAX_STATUS_VIDEO_TIME = 30;

    RecyclerView recyclerView;
    StatusAdapter adapter;
    RealmResults<UserStatuses> statusesList;

    private CircleImageView profileImage;
    ConstraintLayout myStatusContainer;
    private TextView tvLastStatusTime;
    private ImageButton btnViewMyStatuses;
    private UserStatuses myStatuses;
    private HeaderViewDecoration decor;
    private CircularStatusView circularStatusView;


    private int header1pos, header2pos = 0;
    private String header1Title, header2Title = "";

    AdView adView;
    StatusFragmentCallbacks callbacks;

    @Override
    public boolean showAds() {
        return getResources().getBoolean(R.bool.is_status_ad_enabled);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callbacks = (StatusFragmentCallbacks) context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_status, container, false);
        initViews(view);
        adViewInitialized(adView);

        btnViewMyStatuses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myStatuses == null)
                    return;

                startActivity(new Intent(getActivity(), MyStatusActivity.class));
            }
        });

        statusesList = RealmHelper.getInstance().getAllStatuses();
        initMyStatuses();
        circularStatusView.setVisibility(View.GONE);


        initAdapter();
        myStatusContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myStatuses != null && !myStatuses.getFilteredStatuses().isEmpty()) {
                    Intent intent = new Intent(getActivity(), ViewStatusActivity.class);
                    intent.putExtra(IntentUtils.UID, myStatuses.getUserId());
                    startActivity(intent);
                } else {
                    if (callbacks != null)
                        callbacks.openCamera();
                }
            }
        });


        return view;
    }

    private void initMyStatuses() {
        myStatuses = RealmHelper.getInstance().getUserStatuses(FireManager.getUid());
    }

    private void setMyStatus() {
        if (myStatuses == null)
            initMyStatuses();

        if (myStatuses != null
                && !myStatuses.getFilteredStatuses().isEmpty()) {
            Status lastStatus = myStatuses.getStatuses().last();
            String statusTime = TimeHelper.getStatusTime(lastStatus.getTimestamp());
            tvLastStatusTime.setText(statusTime);
            btnViewMyStatuses.setVisibility(View.VISIBLE);
            circularStatusView.setVisibility(View.VISIBLE);
            Glide.with(getActivity()).load(BitmapUtils.encodeImageAsBytes(lastStatus.getThumbImg())).asBitmap().into(profileImage);
        } else {
            circularStatusView.setVisibility(View.GONE);
            Glide.with(getActivity()).load(BitmapUtils.encodeImageAsBytes(SharedPreferencesManager.getThumbImg())).asBitmap().into(profileImage);
            btnViewMyStatuses.setVisibility(View.GONE);
            tvLastStatusTime.setText(getString(R.string.tap_to_add_status));
        }
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.rv_status);
        profileImage = view.findViewById(R.id.profile_image);
        myStatusContainer = view.findViewById(R.id.row_status_container);
        tvLastStatusTime = view.findViewById(R.id.tv_last_status_time);
        btnViewMyStatuses = view.findViewById(R.id.btn_view_my_statuses);
        circularStatusView = view.findViewById(R.id.circular_status_view);
        adView = view.findViewById(R.id.ad_view);
    }

    public void onCameraActivityResult(int resultCode, Intent data) {
        if (resultCode != ResultCodes.CAMERA_ERROR_STATE) {
            if (resultCode == ResultCodes.IMAGE_CAPTURE_SUCCESS) {
                String path = data.getStringExtra(IntentUtils.EXTRA_PATH_RESULT);
                uploadImageStatus(path);
            } else if (resultCode == ResultCodes.VIDEO_RECORD_SUCCESS) {
                String path = data.getStringExtra(IntentUtils.EXTRA_PATH_RESULT);
                uploadVideoStatus(path);
            } else if (resultCode == ResultCodes.PICK_IMAGE_FROM_CAMERA) {
                List<String> mPaths = Matisse.obtainPathResult(data);
                for (String mPath : mPaths) {
                    if (!FileUtils.isFileExists(mPath)) {
                        Toast.makeText(getActivity(), MyApp.context().getResources().getString(R.string.image_video_not_found), Toast.LENGTH_SHORT).show();
                        return;
                    }

                }


                //Check if it's a video
                if (FileUtils.isPickedVideo(mPaths.get(0))) {

                    //check if video is longer than 30sec
                    long mediaLengthInMillis = Util.getMediaLengthInMillis(getContext(), mPaths.get(0));
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(mediaLengthInMillis);
                    if (seconds <= MAX_STATUS_VIDEO_TIME) {
                        for (String mPath : mPaths) {
                            uploadVideoStatus(mPath);
                        }
                    } else {
                        Toast.makeText(getActivity(), MyApp.context().getResources().getString(R.string.video_length_is_too_long), Toast.LENGTH_SHORT).show();
                    }


                } else {
                    for (String path : mPaths) {
                        uploadImageStatus(path);
                    }
                }
            }
        }
    }


    private void initAdapter() {
        adapter = new StatusAdapter(statusesList, true, getContext(), StatusFragment.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        decor = new HeaderViewDecoration(getContext());
        recyclerView.addItemDecoration(decor);
    }


    private void setupHeaders() {
        header1pos = -1;
        header2pos = -1;

        for (UserStatuses userStatuses : statusesList) {
            if (!userStatuses.isAreAllSeen()) {
                if (header1pos == -1) {
                    header1pos = statusesList.indexOf(userStatuses);
                }
            } else {
                if (header2pos == -1) {
                    header2pos = statusesList.indexOf(userStatuses);

                    break;
                }
            }
        }

        //if the statuses are all seen,then set the header title as Viewed updates
        if (header1pos == -1) {
            header1Title = MyApp.context().getResources().getString(R.string.viewed_statuses);
            header2Title = MyApp.context().getResources().getString(R.string.viewed_statuses);
        } else {
            header1Title = MyApp.context().getResources().getString(R.string.recent_updates);
            header2Title = MyApp.context().getResources().getString(R.string.viewed_statuses);

        }
    }


    private void uploadVideoStatus(String path) {
        if (!NetworkHelper.isConnected(MyApp.context())) {
            Toast.makeText(getActivity(), MyApp.context().getResources().getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(getActivity(), R.string.uploading_status, Toast.LENGTH_SHORT).show();

        StatusManager.uploadStatus(path, true, new StatusManager.UploadStatusCallback() {
            @Override
            public void onComplete(boolean isSuccessful) {
                if (isSuccessful) {
                    setMyStatus();
                    Toast.makeText(getActivity(), MyApp.context().getResources().getString(R.string.status_uploaded), Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getActivity(), MyApp.context().getResources().getString(R.string.error_uploading_status), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void uploadImageStatus(String path) {
        if (!NetworkHelper.isConnected(MyApp.context())) {
            Toast.makeText(MyApp.context(), MyApp.context().getResources().getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show();
            return;
        }


        Toast.makeText(MyApp.context(), MyApp.context().getResources().getString(R.string.uploading_status), Toast.LENGTH_SHORT).show();
        String mPath = compressImage(path);


        StatusManager.uploadStatus(mPath, false, new StatusManager.UploadStatusCallback() {
            @Override
            public void onComplete(boolean isSuccessful) {
                if (isSuccessful) {
                    setMyStatus();
                    Toast.makeText(getActivity(), MyApp.context().getResources().getString(R.string.status_uploaded), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), MyApp.context().getResources().getString(R.string.error_uploading_status), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        updateHeaders();
        setMyStatus();
    }

    private void updateHeaders() {
        if (decor != null) {
            setupHeaders();
            decor.updateHeaders(header1pos, header2pos, header1Title, header2Title);
            adapter.notifyDataSetChanged();
        }
    }

    public void statusInserted() {
        try {
            //Fix for crash 'fragment not attached to context'
            updateHeaders();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onQueryTextChange(String newText) {
        super.onQueryTextChange(newText);
        if (adapter != null) {
            adapter.filter(newText);
        }
    }

    @Override
    public void onSearchClose() {
        super.onSearchClose();
        adapter = new StatusAdapter(statusesList, true, getActivity(), StatusFragment.this);
        if (recyclerView != null)
            recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStatusClick(View view, UserStatuses userStatuses) {
        Intent intent = new Intent(getActivity(), ViewStatusActivity.class);
        intent.putExtra(IntentUtils.UID, userStatuses.getUserId());
        startActivity(intent);
    }

    //compress image when user chooses an image from gallery
    private String compressImage(String imagePath) {
        //generate file in sent images folder
        File file = DirManager.generateFile(MessageType.SENT_IMAGE);
        //compress image and copy it to the given file
        BitmapUtils.compressImage(imagePath, file);

        return file.getPath();
    }
}
