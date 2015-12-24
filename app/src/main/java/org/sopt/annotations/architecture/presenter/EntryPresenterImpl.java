package org.sopt.annotations.architecture.presenter;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.sopt.annotations.architecture.model.EntryModel;
import org.sopt.annotations.architecture.view.EntryView;
import org.sopt.annotations.domain.VersionInfo;

@EBean
public class EntryPresenterImpl implements EntryPresenter {

    EntryView view;

    @Bean
    EntryModel model;

    @Override
    public void setView(EntryView view) { this.view = view; }

    @Background
    @Override
    public void queryVersion() {

        VersionInfo info = model.getVersionInfo();
        view.setButtonTextWithVersionInfo(info);
    }
}
