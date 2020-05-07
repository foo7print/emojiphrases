package com.raywenderlich.webapp

import com.raywenderlich.model.EPSession
import com.raywenderlich.repository.Repository
import io.ktor.application.*
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.response.*
import io.ktor.routing.Route
import io.ktor.sessions.get
import io.ktor.sessions.sessions

const val ABOUT = "/about"

@Location(ABOUT)
class About

fun Route.about(db: Repository) {
    get<About> {
        val user = call.sessions.get<EPSession>()?.let { db.user(it.userId) }
        call.respond(FreeMarkerContent("about.ftl", mapOf("user" to user)))
    }
}