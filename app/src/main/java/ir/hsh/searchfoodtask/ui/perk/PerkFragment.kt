package ir.hsh.searchfoodtask.ui.perk

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.hsh.searchfoodtask.R

class PerkFragment : Fragment() {

    companion object {
        fun newInstance() = PerkFragment()
    }

    private lateinit var viewModel: PerkViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.perk_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PerkViewModel::class.java)
        // TODO: Use the ViewModel
    }

}