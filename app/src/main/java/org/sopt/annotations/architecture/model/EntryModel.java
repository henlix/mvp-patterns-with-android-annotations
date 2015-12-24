package org.sopt.annotations.architecture.model;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.rest.RestService;
import org.androidannotations.annotations.sharedpreferences.Pref;
import org.sopt.annotations.domain.VersionInfo;
import org.sopt.annotations.network.Api;
import org.sopt.annotations.pref.Settings_;

@EBean
public class EntryModel {

    @RestService
    Api api;

    @Pref
    Settings_ settings;


    public VersionInfo getVersionInfo() {

        boolean queryBefore = settings.queryBefore().get();

        VersionInfo info;

        if (queryBefore) {

            info = new VersionInfo();
            info.version = settings.version().get();
        }
        else {

            info = api.getVersionInfoFromServer();

            settings.queryBefore().put(true);
            settings.version().put(info.version);
            settings.edit().apply();
        }

        return info;
    }
}
