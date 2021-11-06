package com.pamela.database.ui.add

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pamela.database.ListItem
import com.pamela.database.Lists


class NewlistViewModel : ViewModel() {

    private var _listItem = MutableLiveData<ListItem>().apply {
        value = ListItem(Lists.size.toLong(), "List Name", mutableListOf())
    }
    var listItem: LiveData<ListItem> = _listItem
    fun setTitle(title:String) {
        _listItem.postValue(ListItem(Lists.size.toLong(), title, _listItem.value!!.elements))
    }
    fun addItem(item:String){
        Log.e("test", item)
        val elements = _listItem.value!!.elements
        elements.add(item)
        _listItem.postValue(ListItem(Lists.size.toLong(), _listItem.value!!.title, elements))
    }
}