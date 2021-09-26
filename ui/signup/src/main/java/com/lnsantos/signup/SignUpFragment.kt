package com.lnsantos.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lnsantos.base.navigation.BaseFragment
import com.lnsantos.base.navigation.NavigationManager
import com.lnsantos.base.navigation.model.FragmentData
import com.lnsantos.base.navigation.model.FragmentId
import com.lnsantos.signup.databinding.FragmentSignUpBinding

class SignUpFragment : BaseFragment(){

    private lateinit var binding : FragmentSignUpBinding

    override val fragmentData: FragmentData = FragmentData(FragmentId.SIGN_UP)
    override val name: String = this::class.java.simpleName

    override fun init(savedInstanceState: Bundle?) {
        binding.iconBack.setOnClickListener {
            NavigationManager.onBackFragment()
        }
    }

    override fun contentView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentSignUpBinding.inflate(inflater, container, false).run {
            lifecycleOwner = viewLifecycleOwner
            binding = this
            root
        }
    }

}