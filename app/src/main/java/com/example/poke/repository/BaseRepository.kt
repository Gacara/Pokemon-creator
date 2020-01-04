package com.example.poke.repository

import com.example.poke.model.CustomModel


interface BaseRepository {

    fun  insert(customModel: CustomModel)

    fun  update(customModel: CustomModel)

    fun  delete(customModel: CustomModel)

    fun  deleteAll()
}