package com.ugrcaan.data

import com.ugrcaan.data.model.Message

interface MessageDataSource {

    suspend fun getAllMessages() : List<Message>

    suspend fun insertMessage(message: Message)


}