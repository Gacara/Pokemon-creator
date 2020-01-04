package com.example.poke.view

import com.example.poke.model.CustomModel

interface CustomListeners {

    fun onUpdate(item : CustomModel, position: Int)

    fun onDelete(item : CustomModel, position: Int)

}
