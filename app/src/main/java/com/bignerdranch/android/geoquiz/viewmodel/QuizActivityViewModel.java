package com.bignerdranch.android.geoquiz.viewmodel;


import android.content.Context;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.bignerdranch.android.geoquiz.R;
import com.bignerdranch.android.geoquiz.model.Quiz;


public class QuizActivityViewModel implements ViewModel{
    private Quiz quiz;
    private Context viewModelContext;
    public final ObservableField<String> mQuestionTextView = new ObservableField();
    public final ObservableField<String> mResultTextView = new ObservableField();
    public final ObservableInt mResultColor = new ObservableInt();
    public final ObservableBoolean tFbtn = new ObservableBoolean();
    public final ObservableBoolean nxtBtn = new ObservableBoolean();

    public QuizActivityViewModel(Context viewContext) {
        this.quiz = new Quiz();
        viewModelContext = viewContext;
        initialize();
    }

    public void initialize(){
        mQuestionTextView.set(viewModelContext.getResources().getString(quiz.getCurrentQuestion().getTextResId()));
        mResultTextView.set("");
        tFbtn.set(true);
        nxtBtn.set(false);
   }

    @Override
    public void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = quiz.getCurrentQuestion().isAnswerTrue();
        tFbtn.set(false);
        nxtBtn.set(true);
        if(userPressedTrue == answerIsTrue){
           mResultTextView.set(viewModelContext.getResources().getString(R.string.correct_toast));
           mResultColor.set(viewModelContext.getResources().getColor(R.color.green));
        }
        else{
            mResultTextView.set(viewModelContext.getResources().getString(R.string.incorrect_toast));
            mResultColor.set(viewModelContext.getResources().getColor(R.color.red));
        }
    }

    @Override
    public void goToNextQuestion(){
        quiz.nextQuestion();
        mQuestionTextView.set(viewModelContext.getResources().getString(quiz.getCurrentQuestion().getTextResId()));
        mResultTextView.set("");
        tFbtn.set(true);
        nxtBtn.set(false);
    }
}
