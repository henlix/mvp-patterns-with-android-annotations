package org.sopt.annotations.architecture.view;

import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.SystemService;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringRes;
import org.sopt.annotations.R;
import org.sopt.annotations.architecture.presenter.EntryPresenter;
import org.sopt.annotations.architecture.presenter.EntryPresenterImpl;
import org.sopt.annotations.domain.VersionInfo;

@EActivity(R.layout.activity_entry)
public class EntryActivity extends AppCompatActivity implements EntryView {


    @Bean(EntryPresenterImpl.class)
    EntryPresenter presenter;


    @ViewById(R.id.button_query_version)
    Button buttonQueryVersion;


    @SystemService
    LocationManager locationManager;


    @StringRes(R.string.button_label)
    String buttonLabel;

    @AfterViews
    public void initialize() {

        presenter.setView(this);
        buttonQueryVersion.setText(buttonLabel);
    }


    @Click(R.id.button_query_version)
    public void onQueryVersionButtonClicked() {

        presenter.queryVersion();
    }

    @UiThread
    @Override
    public void setButtonTextWithVersionInfo(VersionInfo info) {

        buttonQueryVersion.setText("Current Version : " + info.version);
    }
}
