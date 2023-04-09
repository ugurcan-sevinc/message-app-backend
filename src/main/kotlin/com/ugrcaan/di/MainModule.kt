package com.ugrcaan.di

import com.ugrcaan.data.MessageDataSource
import com.ugrcaan.data.MessageDataSourceImpl
import com.ugrcaan.room.RoomController
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {
    single {
        KMongo
            .createClient()
            .coroutine
            .getDatabase("message_db_yt")
    }

    single<MessageDataSource>(){
        MessageDataSourceImpl(get())
    }

    single{
        RoomController(get())
    }


}