package co.com.pragma.exampleobserver1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.com.pragma.exampleobserver1.databinding.FragmentMVVMBinding


class MVVMFragment : Fragment() {

    private lateinit var binding: FragmentMVVMBinding
    private lateinit var viewModel: MVVMViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        viewModel = ViewModelProvider(this).get(MVVMViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_m_v_v_m, container, false)
        binding.viewModel = viewModel
        initObserver()
        binding.lifecycleOwner = this
        return binding.root
    }

    fun initObserver() {
        viewModel.showMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it) {
                    Toast.makeText(requireContext(), "Hola Mundo MVVM", Toast.LENGTH_SHORT).show()
                }
                viewModel.endShowMessage()
            }

        })
    }

}