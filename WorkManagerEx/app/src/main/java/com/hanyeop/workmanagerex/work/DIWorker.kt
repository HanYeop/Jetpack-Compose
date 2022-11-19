package com.hanyeop.workmanagerex.work

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class DIWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters
) : Worker(appContext, workerParams) {

    override fun doWork(): Result {

        Log.d("test5", "doWork: 통신")

        return Result.success()
    }
}