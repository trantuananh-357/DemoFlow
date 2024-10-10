package com.example.demowhyusingflow.ui

import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.demowhyusingflow.R
import com.example.demowhyusingflow.databinding.ActivityCrashFlowBinding
import com.example.demowhyusingflow.uitls.AppLoader

class ActivityCrashFlow : Activity() {
    lateinit var binding: ActivityCrashFlowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_crash_flow)
        binding.btnGetNumber.setOnClickListener{
            AppLoader.loadContactsDontUsingFlow()

        }

    }
}
