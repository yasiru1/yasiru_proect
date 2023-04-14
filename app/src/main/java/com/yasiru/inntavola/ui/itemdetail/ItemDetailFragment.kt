package com.yasiru.inntavola.ui.itemdetail

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.yasiru.inntavola.data.entities.Item
import com.yasiru.inntavola.databinding.ItemDetailFragmentBinding
import com.yasiru.inntavola.utils.Resource
import com.yasiru.inntavola.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemDetailFragment : Fragment() {

    private lateinit var layoutListener: ViewTreeObserver.OnGlobalLayoutListener

    private var binding: ItemDetailFragmentBinding by autoCleared()

    private val viewModel: ItemDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ItemDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt("id")?.let { viewModel.start(it) }
        setupObservers()
    }

    private fun setupObservers() {

        viewModel.item.observe(
            viewLifecycleOwner
        ) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    it.data?.let { _ ->
                        bindItemView(it.data.results[0])
                    } ?: run {
                        Toast.makeText(requireContext(), "No data", Toast.LENGTH_SHORT).show()
                    }
                    binding.progressBar.visibility = View.INVISIBLE
                    binding.itemView.visibility = View.VISIBLE
                }
                Resource.Status.ERROR ->
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.itemView.visibility = View.INVISIBLE
                }
            }
        }
    }

    private fun bindItemView(item: Item) {
          binding.itemTitle.text = item.item_name
          binding.itemAllergeni.text = item.item_allergies.toSpanned()
          binding.itemIngredienti.text = item.item_ingredients.toSpanned()
          binding.itemDescriptionLong.text = item.item_description_long



     /*       Glide.with(binding.root)
                .load(item.item_image)
                .error(R.drawable.error)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(binding.itemImage)*/
        }

    }

    fun String.toSpanned(): Spanned {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
        } else {
            @Suppress("DEPRECATION")
            return Html.fromHtml(this)
        }
    }