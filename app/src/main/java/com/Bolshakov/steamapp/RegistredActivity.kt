package com.Bolshakov.steamapp

import android.app.Activity
import android.os.Bundle

class RegistredActivity: Activity() {
    @Override
    protected override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)
    }
}