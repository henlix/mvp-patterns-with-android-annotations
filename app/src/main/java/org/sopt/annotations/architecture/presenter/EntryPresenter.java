package org.sopt.annotations.architecture.presenter;

import org.sopt.annotations.architecture.view.EntryView;

public interface EntryPresenter {

    void setView(EntryView view);
    void queryVersion();
}
