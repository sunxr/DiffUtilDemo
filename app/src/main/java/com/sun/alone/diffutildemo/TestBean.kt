package com.sun.alone.diffutildemo

data class TestBean(var name: String, var desc: String): Cloneable {
  override fun clone(): TestBean {
    var testBean: TestBean? = null
    try {
      testBean = super.clone() as TestBean
    } catch (e: CloneNotSupportedException) {
      e.printStackTrace()
    }
    return testBean!!
  }
}
