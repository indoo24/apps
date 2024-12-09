package com.example.assignment3

import androidx.recyclerview.widget.DiffUtil


class MyDiffutil(
    private val oldList: List<BestPracticeAdapter.CardItem>,
    private val newList: List<BestPracticeAdapter.CardItem>
):DiffUtil.Callback(){
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition]==newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition]==newList[newItemPosition]
    }


}