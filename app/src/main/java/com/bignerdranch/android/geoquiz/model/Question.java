package com.bignerdranch.android.geoquiz.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Question extends BaseObservable {

    private int mTextResId;
    private boolean mAnswerTrue;

    public Question(int textResId, boolean answerTrue) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }
    @Bindable
    public int getTextResId() {
        return mTextResId;
    }
    @Bindable
    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

}
