package com.hanyeop.workmanagerex

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.hanyeop.workmanagerex.ui.theme.WorkManagerExTheme
import com.hanyeop.workmanagerex.work.LogWorker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

const val UNIQUE_NAME = "LOG"
class MainActivity : ComponentActivity() {

    companion object{
        // 주기 설정. 최소 15분
        private val workRequest: PeriodicWorkRequest =
            PeriodicWorkRequestBuilder<LogWorker>(15, TimeUnit.MINUTES)
                .build()
        lateinit var workManager: WorkManager

        // 워크매니저 시작
        fun startWorkManager() {
            workManager.enqueueUniquePeriodicWork(
                UNIQUE_NAME,
                ExistingPeriodicWorkPolicy.KEEP, // 충돌 정책 : 기존 작업을 유지하고 새 작업을 무시
                workRequest
            )

            // 워크 매니저 상태 확인
            val state = workManager.getWorkInfosForUniqueWork(UNIQUE_NAME).get()
            for(i in state){
                Log.d("test5", "startWorkManager: $state")
            }
        }

        // 워크매니저 종료
        fun stopWorkManager() {
            workManager.cancelUniqueWork(UNIQUE_NAME)

            // 워크 매니저 상태 확인
            val state = workManager.getWorkInfosForUniqueWork(UNIQUE_NAME).get()
            for(i in state){
                Log.d("test5", "stopWorkManager: $state")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        workManager = WorkManager.getInstance(applicationContext)

        startWorkManager()

        stopWorkManager()

        setContent {
            WorkManagerExTheme {
                MyApp()
            }
        }
    }
}

@Composable
private fun MyApp(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

    }
}
