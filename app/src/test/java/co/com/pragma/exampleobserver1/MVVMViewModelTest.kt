package co.com.pragma.exampleobserver1

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.resetMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MVVMViewModelTest {

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @get:Rule
    val rule = InstantTaskExecutorRule()
    lateinit var mvvmViewModel: MVVMViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        mvvmViewModel = MVVMViewModel()

    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun startShowMessageTest() = runBlocking {
        mvvmViewModel.startShowMessage()
        assertTrue(mvvmViewModel.showMessage.value!!)
    }

    @Test
    fun endShowMessageTest() = runBlocking {
        mvvmViewModel.endShowMessage()
        assertNull(mvvmViewModel.showMessage.value)
    }
}