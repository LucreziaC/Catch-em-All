package com.example.catchemall.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.catchemall.R
import com.example.catchemall.databinding.FragmentDetailBinding
import com.example.catchemall.util.bindings.viewBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {

    val binding : FragmentDetailBinding by viewBinding(FragmentDetailBinding::bind)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}
