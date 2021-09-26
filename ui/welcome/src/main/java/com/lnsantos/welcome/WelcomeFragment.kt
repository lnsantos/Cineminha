package com.lnsantos.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.lnsantos.base.navigation.BaseFragment
import com.lnsantos.base.navigation.NavigationManager
import com.lnsantos.base.navigation.model.FragmentData
import com.lnsantos.base.navigation.model.FragmentId
import com.lnsantos.base_clean.ResultClean
import com.lnsantos.welcome.databinding.FragmentWelcomeBinding

class WelcomeFragment : BaseFragment(){

    private lateinit var binding : FragmentWelcomeBinding
    private val viewModel by viewModels<WelcomeViewModel>()

    override fun contentView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentWelcomeBinding.inflate(inflater, container, false).run {
            lifecycleOwner = this@WelcomeFragment
            binding = this
            root
        }
    }

    override fun init(savedInstanceState: Bundle?) {
        setupView()
        setupObservers()
    }

    private fun setupObservers() {

        viewModel.nextPage.observe(this){ result ->
            when(result){
                is ResultClean.Success -> {
                    val data = FragmentData(result.value)
                    NavigationManager.addFragment(data)
                }

                else -> Toast.makeText(context, "Ocorreu um erro", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun setupView(){

        binding.buttonSignIn.setOnClickListener {
            viewModel.onNextPage(FragmentId.SIGN_IN)
        }

        binding.buttonSignUp.setOnClickListener {
            viewModel.onNextPage(FragmentId.SIGN_UP)
        }

    }

    override val fragmentData: FragmentData = FragmentData(FragmentId.WELCOME, null)
    override val name: String = this::class.java.simpleName

}