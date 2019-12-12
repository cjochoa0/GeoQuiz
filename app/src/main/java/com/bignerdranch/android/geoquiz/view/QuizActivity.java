package com.bignerdranch.android.geoquiz.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bignerdranch.android.geoquiz.R;
import com.bignerdranch.android.geoquiz.viewmodel.QuizActivityViewModel;
import com.bignerdranch.android.geoquiz.databinding.ActivityQuizBinding;

public class QuizActivity extends AppCompatActivity {
    QuizActivityViewModel viewModel = new QuizActivityViewModel(getApplicationContext());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQuizBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_quiz);
        binding.setViewmodel(viewModel);
    }
}
