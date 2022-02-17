package com.sun.alone.diffutildemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

  var datas = ArrayList<TestBean>()
  lateinit var mRv: RecyclerView
  lateinit var mAdapter: DiffAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    initData()
    mRv = findViewById(R.id.rv)
    mRv.layoutManager = LinearLayoutManager(this)
    mAdapter = DiffAdapter(this, datas)
    mRv.adapter = mAdapter
  }

  private fun initData() {
    datas.add(TestBean("李雪婷1", "Android"))
    datas.add(TestBean("李雪婷2", "Java"))
    datas.add(TestBean("李雪婷3", "Python"))
    datas.add(TestBean("李雪婷4", "C"))
    datas.add(TestBean("李雪婷5", "C++"))
    datas.add(TestBean("李雪婷6", "C#"))
    datas.add(TestBean("李雪婷7", "kotlin"))
    datas.add(TestBean("李雪婷8", "js"))
    datas.add(TestBean("李雪婷9", "rn"))
  }

  fun onRefresh(view: View) {
    try {
      var newData = ArrayList<TestBean>()
      for (bean in datas) {
        newData.add(bean.copy())
      }
      newData.add(TestBean("孙昕荣", "forever"))
      newData.get(0).desc = "absjdk"
      var testBean = newData.get(1)
      newData.remove(testBean)
      newData.add(testBean)

      DiffUtil.calculateDiff(DiffUtilCallback(datas, newData), true).dispatchUpdatesTo(mAdapter)
      datas = newData
      mAdapter.datas = datas
    } catch (e: CloneNotSupportedException) {
      e.printStackTrace()
    }
  }
}