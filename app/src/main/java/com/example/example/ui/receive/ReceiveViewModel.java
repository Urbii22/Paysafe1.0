package com.example.example.ui.receive;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReceiveViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public ReceiveViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the receive fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}