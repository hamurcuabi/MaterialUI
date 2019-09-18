package com.emrhmrc.flexablercvtest.depoQr.base;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.emrhmrc.flexablercvtest.depoQr.adapter.ViewPagerAdapter;
import com.emrhmrc.flexablercvtest.R;
import com.emrhmrc.flexablercvtest.samples.flexibleadapter.fragments.FragmentViewPager;
import com.emrhmrc.flexablercvtest.samples.flexibleadapter.views.HeaderView;
import com.emrhmrc.sweetdialoglib.DialogCreater;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

    public abstract class BaseActivity extends AppCompatActivity implements StepView.OnStepClickListener {

    @BindView(R.id.view_pager)
    ViewPager viewpager;
    @BindView(R.id.step_view)
    StepView stepView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_header_view)
    HeaderView headerView;
    private ViewPagerAdapter viewPagerAdapter;
    private List<String> steps;
    private List<String> stepDescriptions;
    private int step = 1;
    private List<Fragment> fragmentList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);
        setToolbar();
        setStatusBar();
        setupViewPagerAndStepView();
        setHeaderView();


    }

        private void setStatusBar() {
            Window window = this.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark_light));
        }

    public StepView getStepView() {
        return stepView;
    }

    private void setHeaderView() {
        headerView.bindTo(getString(R.string.app_name), getHeaderString() + " " + steps.get(0));
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupViewPagerAndStepView() {

        steps = new ArrayList<>();
        stepDescriptions = new ArrayList<>();

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        fragmentList = getFragments();
        for (Fragment fragment : fragmentList) {
            viewPagerAdapter.addFragment(fragment, (FragmentViewPager.DESCP));
            steps.add("" + (step) + ". Adım");
            stepDescriptions.add((FragmentViewPager.DESCP) + step);
            step++;
        }
        viewpager.setOffscreenPageLimit(fragmentList.size());
        viewpager.setAdapter(viewPagerAdapter);
        viewpager.setCurrentItem(0);
        viewpager.addOnPageChangeListener(viewPagerPageChangeListener());

        stepView.setSteps(steps);
        stepView.setOnStepClickListener(BaseActivity.this);
    }


    private ViewPager.OnPageChangeListener viewPagerPageChangeListener() {
        return new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                stepView.go(position, true);
                headerView.bindTo(getString(R.string.app_name), getHeaderString() + " " + steps.get(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };

    }

        protected abstract String getHeaderString();

    protected abstract List<Fragment> getFragments();

    public List<Fragment> AddFragment(Fragment fragment) {

        getFragments().add(fragment);
        return getFragments();
    }

    @Override
    public void onStepClick(int step) {
        viewpager.setCurrentItem(step, true);
        //  DialogCreater.basicDialog(this, steps.get(step), stepDescriptions.get(step));

    }

    public void checkJobIsDone() {
        if (step == steps.size() - 1) {
            stepView.done(true);
            DialogCreater.succesDialog(this);
        }
    }

    @Override
    public void onBackPressed() {
        if (stepView.getCurrentStep() > 0) {
            viewpager.setCurrentItem(stepView.getCurrentStep() - 1, true);
            stepView.go(stepView.getCurrentStep() - 1, true);
        } else super.onBackPressed();

    }
}
