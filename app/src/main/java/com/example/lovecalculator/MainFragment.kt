package com.example.lovecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.viewModel.LoveViewModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: LoveViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container,false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
        binding.historyBtn.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }

    }

    private fun initClicker() {
        with(binding){
            btnCalculate.setOnClickListener {
                viewModel.getLiveLove(firstname = edFirstName.text.toString(), secondName= edSecontdame.text.toString()).observe(viewLifecycleOwner,
                    Observer {
                            LoveModel -> findNavController().navigate(R.id.resultLoveCalculator, bundleOf("result" to LoveModel))
                        App.dataBase.loveDao().insert(loveModel = LoveModel)
                    })
            }
        }


    }



}