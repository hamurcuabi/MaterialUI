package com.emrhmrc.motionsteel.ocr.others;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.emrhmrc.motionsteel.ocr.R;
import com.emrhmrc.motionsteel.ocr.activity.PreviewActivity;

public class LanguageListFragment extends ListFragment implements AdapterView.OnItemClickListener {

    private LanguagItemClick languagItemClick;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.list_fragment, container, false);

        return v;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.language,
                android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
        languagItemClick = (PreviewActivity) getActivity();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedLang;
        switch (position) {

            case 0:
                selectedLang = "en";
                break;
            case 1:
                selectedLang = "tr";
                break;

            case 2:
                selectedLang = "ar";
                break;

            case 3:
                selectedLang = "zh";
                break;

            case 4:
                selectedLang = "da";
                break;

            case 5:
                selectedLang = "de";
                break;

            case 6:
                selectedLang = "es";
                break;

            case 7:
                selectedLang = "sv";
                break;

            case 8:
                selectedLang = "ru";
                break;

            case 9:
                selectedLang = "it";
                break;

            default:
                selectedLang = "tr";
                break;


        }
        languagItemClick.itemClick(selectedLang);

    }
}