package com.lnsantos.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lnsantos.base.navigation.BaseFragment
import com.lnsantos.base.navigation.NavigationManager
import com.lnsantos.base.navigation.model.FragmentData
import com.lnsantos.base.navigation.model.FragmentId
import com.lnsantos.signin.databinding.FragmentSignInBinding

class SignInFragment : BaseFragment(){

    private lateinit var binding : FragmentSignInBinding

    override fun init(savedInstanceState: Bundle?) {
        binding.button.setOnClickListener {
            NavigationManager.addFragment(FragmentData(FragmentId.SIGN_UP))
        }
    }

    override fun contentView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentSignInBinding.inflate(inflater, container, false).run {
            lifecycleOwner = viewLifecycleOwner
            binding = this
            root
        }
    }

    override val fragmentData: FragmentData = FragmentData(FragmentId.SIGN_IN, null)
    override val name: String = activity?.getString(R.string.string_tag_sign_in_fragment) ?: ""

}