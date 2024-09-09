package com.example.myflexiblefragment

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class CategoryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnDetailCategory: Button = view.findViewById(R.id.btn_detail_category)
        btnDetailCategory.setOnClickListener {
            if (it?.id == R.id.btn_detail_category) {
                val mDetailCategoryFragment = DetailCategoryFragment()
                val mBundle = Bundle()
                mBundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle")
                val description = "Kategori ini akan berisi produk-produk lifestyle"
                mDetailCategoryFragment.arguments = mBundle
                mDetailCategoryFragment.description = description
                val mFragmentManager = parentFragmentManager
                mFragmentManager?.beginTransaction()?.apply {
                    replace(R.id.frame_container, mDetailCategoryFragment, DetailCategoryFragment::class.java.simpleName)
                    addToBackStack(null)
                    commit()
                }
            }
        }
    }
}