package com.hanyeop.workmanagerex.work

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class LogWorker(appContext: Context, workerParams: WorkerParameters)
    : Worker(appContext, workerParams) {

    override fun doWork(): Result {

        Log.d("test5", "doWork: 통신")

        return Result.success()
    }
}