package com.yasiru.inntavola.ui.items

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.yasiru.inntavola.R
import com.yasiru.inntavola.databinding.ItemsFragmentBinding
import com.yasiru.inntavola.utils.Resource
import com.yasiru.inntavola.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), ItemsAdapter.ItemListener {

    private var binding: ItemsFragmentBinding by autoCleared()
    private val viewModel: ItemsViewModel by viewModels()
    private lateinit var adapter: ItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ItemsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        adapter = ItemsAdapter(this)
        binding.itemRecyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.itemRecyclerView.adapter = adapter
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun setupObservers() {
        viewModel.itemList.observe(
            viewLifecycleOwner
        ) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.INVISIBLE
                    if (!it.data?.results.isNullOrEmpty()) adapter.setItems(ArrayList(it.data!!.results))
                }
                Resource.Status.ERROR -> {
                    binding.progressBar.visibility = View.INVISIBLE
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }
        }
    }

    override fun onClickedItem(itemId: Int) {
        findNavController().navigate(
            R.id.action_drinksFragment_to_drinkDetailFragment,
            bundleOf("id" to itemId)
        )
    }
}
