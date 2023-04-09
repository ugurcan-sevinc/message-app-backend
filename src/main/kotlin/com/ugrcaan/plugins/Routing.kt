package com.ugrcaan.plugins

import com.ugrcaan.room.RoomController
import com.ugrcaan.routes.chatSocket
import com.ugrcaan.routes.getAllMessages
import io.ktor.server.routing.*
import io.ktor.server.application.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val roomController by inject<RoomController>()
    install(Routing) {
        chatSocket(roomController = roomController)
        getAllMessages(roomController = roomController)
    }
}
