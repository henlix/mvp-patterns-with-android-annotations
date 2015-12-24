package org.sopt.annotations.pref;

import android.content.Context;

import org.androidannotations.annotations.sharedpreferences.DefaultBoolean;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

@SharedPref(value = SharedPref.Scope.UNIQUE, mode = Context.MODE_PRIVATE)
public interface Settings {

    @DefaultBoolean(value = false)
    boolean queryBefore();

    String version();
}
