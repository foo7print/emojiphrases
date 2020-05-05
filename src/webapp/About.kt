package com.raywenderlich.webapp

import io.ktor.application.*
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.response.*
import io.ktor.routing.Route

const val ABOUT = "/about"

@Location(ABOUT)
class About

fun Route.about() {
    get<About> {
        call.respond(FreeMarkerContent("about.ftl", null))
    }
}