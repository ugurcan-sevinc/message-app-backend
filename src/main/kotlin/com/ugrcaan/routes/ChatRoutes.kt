package com.ugrcaan.routes

import com.ugrcaan.room.MemberAlreadyExistsException
import com.ugrcaan.room.RoomController
import com.ugrcaan.sessions.ChatSession
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import kotlinx.coroutines.channels.consumeEach

fun Route.chatSocket(roomController: RoomController){
    webSocket(path = "/chat-socket") {
        val session = call.sessions.get<ChatSession>()
        val username = call.parameters["username"] // Extract the username from the query parameters
        if(username.isNullOrEmpty()){
            close(CloseReason(CloseReason.Codes.VIOLATED_POLICY, message = "No Username"))
            return@webSocket
        }
        try {
            session?.sessionsId?.let {
                roomController.onJoin(
                    username = username,
                    sessionId = it, // Retrieve sessionId from the ChatSession object
                    socket = this
                )
            }
            print(username)
            incoming.consumeEach { frame ->
                if(frame is Frame.Text) {
                    roomController.sendMessage(
                        senderUsername = username,
                        message = frame.readText()
                    )
                }
            }

        } catch (e: MemberAlreadyExistsException){
            call.respond(HttpStatusCode.Conflict)
        } catch (e: Exception){
            e.printStackTrace()
        } finally {
            roomController.tryDisconnect(username)
        }
    }
}

fun Route.getAllMessages(roomController: RoomController){
    get(path = "/messages"){
        call.respond(
            HttpStatusCode.OK,
            roomController.getAllMessages()
        )
    }
}
