package co.com.pragma.exampleobserver1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MVVMViewModel: ViewModel() {

    /*val showMessage = MutableLiveData<Boolean>()*/

    private val _showMessage = MutableLiveData<Boolean>()
    val showMessage: LiveData<Boolean>
    get() = _showMessage

    fun startShowMessage() {
        _showMessage.value = true
        //showMessage.value = true
        //showMessage.postValue(true)
    }

    fun endShowMessage() {
        _showMessage.value = null
        //showMessage.value = null
        //showMessage.postValue(null)
    }
}