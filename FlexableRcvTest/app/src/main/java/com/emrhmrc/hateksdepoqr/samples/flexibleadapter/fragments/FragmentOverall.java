package com.emrhmrc.hateksdepoqr.samples.flexibleadapter.fragments;

import android.os.Bundle;

import com.emrhmrc.hateksdepoqr.R;
import com.google.android.material.snackbar.Snackbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.DecelerateInterpolator;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.SelectableAdapter.Mode;
import eu.davidea.flexibleadapter.common.FlexibleItemDecoration;
import eu.davidea.flexibleadapter.common.SmoothScrollGridLayoutManager;

import com.emrhmrc.hateksdepoqr.samples.flexibleadapter.OverallAdapter;
import com.emrhmrc.hateksdepoqr.samples.flexibleadapter.dialogs.BottomSheetDecorationDialog;
import com.emrhmrc.hateksdepoqr.samples.flexibleadapter.dialogs.OnDecorationSelectedListener;
import com.emrhmrc.hateksdepoqr.samples.flexibleadapter.items.ScrollableUseCaseItem;
import com.emrhmrc.hateksdepoqr.samples.flexibleadapter.services.DatabaseService;

/**
 * A fragment representing a list of Examples for FlexibleAdapter displayed with GridLayout.
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
public class FragmentOverall extends AbstractFragment
        implements OnDecorationSelectedListener {

    public static final String TAG = FragmentOverall.class.getSimpleName();
    private static final long INITIAL_DELAY_300 = 300L;

    /**
     * Custom implementation of FlexibleAdapter
     */
    private OverallAdapter mAdapter;
    private ScrollableUseCaseItem scrollableUseCaseItem;
    private FlexibleItemDecoration mItemDecoration;


    public static FragmentOverall newInstance(int columnCount) {
        FragmentOverall fragment = new FragmentOverall();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FragmentOverall() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Create overall items and Initialize RecyclerView
        if (savedInstanceState == null) {
            DatabaseService.getInstance().createOverallDatabaseDepoQr(getActivity().getResources());
        }
        initializeRecyclerView(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (DatabaseService.getInstance().isEmpty()) {
            DatabaseService.getInstance().createOverallDatabaseDepoQr(getActivity().getResources());
        }
    }

    @SuppressWarnings({"ConstantConditions", "NullableProblems"})
    private void initializeRecyclerView(Bundle savedInstanceState) {
        // Initialize Adapter and RecyclerView
        // OverallAdapter makes use of stableIds, I strongly suggest to implement 'item.hashCode()'
        FlexibleAdapter.useTag("OverallAdapter");
        mAdapter = new OverallAdapter(getActivity());
        mAdapter.setOnlyEntryAnimation(true)
                .setAnimationInterpolator(new DecelerateInterpolator())
                .setAnimationInitialDelay(INITIAL_DELAY_300);

        // Prepare the RecyclerView and attach the Adapter to it
        mRecyclerView = getView().findViewById(R.id.recycler_view);
        mRecyclerView.setItemViewCacheSize(0); //Setting ViewCache to 0 (default=2) will animate items better while scrolling down+up with LinearLayout
        mRecyclerView.setLayoutManager(createNewStaggeredGridLayoutManager());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true); //Size of RV will not change
        mItemDecoration = new FlexibleItemDecoration(getActivity())
                .addItemViewType(R.layout.recycler_overall_item)
                .withOffset(8) // This helps when top items are removed!!
                .withEdge(true);
        mRecyclerView.addItemDecoration(mItemDecoration);

        // After Adapter is attached to RecyclerView
        mAdapter.setLongPressDragEnabled(true);
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getView() != null) { //Fix NPE when closing app before the execution of Runnable
                    Snackbar.make(getView(), "Uzun tıklamada sürükleme etkin", Snackbar.LENGTH_SHORT).show();
                }
            }
        }, 4000L);

        SwipeRefreshLayout swipeRefreshLayout = getView().findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setEnabled(true);
        mListener.onFragmentChange(swipeRefreshLayout, mRecyclerView, Mode.IDLE);

        // Add 1 Scrollable Header
        scrollableUseCaseItem = new ScrollableUseCaseItem(
                getString(R.string.home_info_title),
                getString(R.string.home_info_description));
        // Delayed! So entry animation will perform together
        mAdapter.addScrollableHeaderWithDelay(scrollableUseCaseItem, INITIAL_DELAY_300, true);
    }

    @Override
    public void showNewLayoutInfo(MenuItem item) {
        super.showNewLayoutInfo(item);
        mAdapter.showLayoutInfo(true);
    }

    @Override
    protected LinearLayoutManager createNewLinearLayoutManager() {
        mAdapter.setAnimationEntryStep(true);
        return super.createNewLinearLayoutManager();
    }

    @Override
    protected GridLayoutManager createNewGridLayoutManager() {
        mAdapter.setAnimationEntryStep(false);
        GridLayoutManager gridLayoutManager = new SmoothScrollGridLayoutManager(getActivity(), mColumnCount);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mAdapter.getItem(position).getSpanSize(mColumnCount, position);
            }
        });
        return gridLayoutManager;
    }

    @Override
    protected StaggeredGridLayoutManager createNewStaggeredGridLayoutManager() {
        mAdapter.setAnimationEntryStep(true);
        return super.createNewStaggeredGridLayoutManager();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_overall, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

        MenuItem gridMenuItem = menu.findItem(R.id.action_list_type);
        if (mRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            gridMenuItem.setIcon(R.drawable.ic_view_agenda_white_24dp);
            gridMenuItem.setTitle(R.string.linear_layout);
        } else if (mRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
            gridMenuItem.setIcon(R.drawable.ic_dashboard_white_24dp);
            gridMenuItem.setTitle(R.string.staggered_layout);
        } else {
            gridMenuItem.setIcon(R.drawable.ic_view_grid_white_24dp);
            gridMenuItem.setTitle(R.string.grid_layout);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_list_type) {
            mAdapter.setAnimationOnForwardScrolling(true);
        } else if (item.getItemId() == R.id.action_decoration) {
            BottomSheetDecorationDialog bottomSheetDialogFragment = BottomSheetDecorationDialog.newInstance(R.layout.bottom_sheet_item_decoration, this);
            bottomSheetDialogFragment.show(getActivity().getSupportFragmentManager(), BottomSheetDecorationDialog.TAG);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDecorationSelected() {
        mAdapter.invalidateItemDecorations(200l);
    }

    @Override
    public FlexibleItemDecoration getItemDecoration() {
        return mItemDecoration;
    }

}