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
import ir.hsh.searchfoodtask.di.component.DaggerNetworkComponent
import ir.hsh.searchfoodtask.di.module.ContextModule
import ir.hsh.searchfoodtask.di.module.NetworkModule
import ir.hsh.searchfoodtask.utils.setVerticalList
import javax.inject.Inject

class HomeFragment : Fragment() {


    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding

    @Inject
    lateinit var adapter: MenuAdapter

    lateinit var networkViewModel: NetworkViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return inflater.inflate(R.layout.home_fragment, container, false)
        binding = HomeFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.setVerticalList(requireContext())
        //adapter=MenuAdapter(requireContext())
        DaggerNetworkComponent.builder()
            .contextModule(ContextModule(requireContext()))
            .networkModule(NetworkModule("https://cdn.opeqe.com/"))
            .build()
            .inject(this)

        initViewModel()
        binding.recyclerView.adapter = adapter
        fetchMenus()


    }

    private fun initViewModel() {
        var networkViewModelFactory = NetworkViewModelFactory(App.networkComponent.getRetrofit())
        networkViewModel = ViewModelProvider(this, networkViewModelFactory).get(NetworkViewModel::class.java)
    }

    private fun fetchMenus() {
        networkViewModel.postInfoLiveData?.observe(viewLifecycleOwner, {
            adapter.swapData(it)

        })
    }
}