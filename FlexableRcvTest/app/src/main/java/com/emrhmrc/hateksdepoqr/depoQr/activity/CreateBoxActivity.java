package com.emrhmrc.hateksdepoqr.depoQr.activity;

import android.view.Menu;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.emrhmrc.hateksdepoqr.depoQr.base.BaseActivity;
import com.emrhmrc.hateksdepoqr.depoQr.fragment.FragmentBoxInPalet;
import com.emrhmrc.hateksdepoqr.depoQr.fragment.FragmentHolderSectionsDepoQr;
import com.emrhmrc.hateksdepoqr.depoQr.fragment.FragmentProductInBox;
import com.emrhmrc.hateksdepoqr.samples.flexibleadapter.fragments.OnFragmentInteractionListener;

import java.util.ArrayList;
import java.util.List;

import eu.davidea.fastscroller.FastScroller;

public class CreateBoxActivity extends BaseActivity implements
        OnFragmentInteractionListener, FastScroller.OnScrollStateChangeListener {
    @Override
    protected String getHeaderString() {
        return "Koli Oluşturma";
    }

    @Override
    protected List<Fragment> getFragments() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(FragmentHolderSectionsDepoQr.newInstance());
        fragmentList.add(FragmentProductInBox.newInstance());
        fragmentList.add(FragmentBoxInPalet.newInstance());
        return fragmentList;
    }


    @Override
    public void onFragmentChange(SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, int mode) {

    }

    @Override
    public void initSearchView(Menu menu) {

    }

    @Override
    public void onFastScrollerStateChange(boolean scrolling) {

    }
}
