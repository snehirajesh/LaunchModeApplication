package com.test.launchmodeapplication

import android.app.Activity
import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log

class Myapplication : Application(), Application.ActivityLifecycleCallbacks {
    private val TAG = "Myapplication"
    private lateinit var  activityManager:ActivityManager

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)
        activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Log.e(TAG, "=============== created instance $activity")
    }


    private fun printTaskList(activity: Activity) {
        val listTask = activityManager.getRunningTasks(Int.MAX_VALUE)
        Log.e(TAG,"size of totalTask ${listTask.size}")

        for (task in listTask){
            Log.e(TAG,"Task Id ${task.id} total activities ${task.numActivities}")
            Log.e(TAG,"Top Activity ${task.topActivity?.className?.replace("com.test.launchmodeapplication.","")}  instance ${activity.toString().replace("com.test.launchmodeapplication.","")}")
            Log.e(TAG,"Base Activity ${task.baseActivity?.className?.replace("com.test.launchmodeapplication.","")}")
        }
    }


    override fun onActivityStarted(activity: Activity) {

    }

    override fun onActivityResumed(activity: Activity) {
        printTaskList(activity)
    }

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityDestroyed(activity: Activity) {

    }
}