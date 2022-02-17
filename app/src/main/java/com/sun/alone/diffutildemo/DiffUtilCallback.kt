package com.sun.alone.diffutildemo

import androidx.recyclerview.widget.DiffUtil

class DiffUtilCallback(oldDatas: List<TestBean>?, newDatas: List<TestBean>?): DiffUtil.Callback() {

  var mOldDatas: List<TestBean>? = oldDatas
  var mNewDatas: List<TestBean>? = newDatas

  override fun getOldListSize(): Int {
    return mOldDatas?.size ?: 0
  }

  override fun getNewListSize(): Int {
    return mNewDatas?.size ?: 0
  }

  override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
    return mOldDatas?.get(oldItemPosition)?.name.equals(mNewDatas?.get(newItemPosition)?.name)
  }

  override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
    var beanOld = mOldDatas?.get(oldItemPosition)
    var beanNew = mNewDatas?.get(newItemPosition)
    if (!beanOld?.desc.equals(beanNew?.desc)) {
      return false
    }
    return true
  }

}