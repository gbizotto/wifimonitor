package com.gbizotto.wifimonitor.feature

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.gbizotto.wifimonitor.data.ConnectionLog
import com.gbizotto.wifimonitor.usecase.CheckConnectivityUseCase
import com.gbizotto.wifimonitor.usecase.GetAllLogsUseCase
import com.google.common.truth.Truth
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    val instantTask = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    private val checkConnectivity = mockk<CheckConnectivityUseCase>()
    private val getAllLogs = mockk<GetAllLogsUseCase>()

    private val viewModel = MainViewModel(checkConnectivity, getAllLogs)
    private val logs = listOf(
        ConnectionLog(true, 2),
        ConnectionLog(false, 1)
    )

    @Test
    fun onStart_mustCheckConnectivity() {
        prepareScenario()

        viewModel.onAction(Action.START)

        verify { checkConnectivity() }
    }

    @Test
    fun onRefresh_mustLoadLogs() = runBlockingTest {
        prepareScenario()

        viewModel.onAction(Action.REFRESH)
        coVerify { getAllLogs() }

        Truth.assertThat(viewModel.logs.value).isEqualTo(logs)
    }

    private fun prepareScenario() {
        every { checkConnectivity() } just runs
        coEvery { getAllLogs() } returns logs
    }
}