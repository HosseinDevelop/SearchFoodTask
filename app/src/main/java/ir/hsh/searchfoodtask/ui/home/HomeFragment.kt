package ir.hsh.searchfoodtask.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ir.hsh.searchfoodtask.App
import ir.hsh.searchfoodtask.data.viewmodel.NetworkViewModel
import ir.hsh.searchfoodtask.data.viewmodel.NetworkViewModelFactory
import ir.hsh.searchfoodtask.databinding.HomeFragmentBinding
import ir.hsh.searchfoodtask.di.factory.ViewModelFactory
import ir.hsh.searchfoodtask.utils.setVerticalList
import ir.hsh.searchfoodtask.utils.toast
import javax.inject.Inject

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var adapter: MenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = HomeFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        App.appComponent.inject(this)

        initViewModel()

        setupRecyclerView()
        fetchMenus()


    }

    private fun setupRecyclerView() {
        binding.recyclerView.setVerticalList(requireContext())
        binding.recyclerView.adapter = adapter
        adapter.setOnClick { id, title ->
            "You Choose $title".toast(requireContext())
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
    }

    private fun fetchMenus() {
        viewModel.postInfoLiveData.observe(viewLifecycleOwner, {
            adapter.swapData(it)

        })
    }
}