package com.raywenderlich.webapp

import com.raywenderlich.model.EPSession
import com.raywenderlich.redirect
import io.ktor.application.call
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.routing.Route
import io.ktor.sessions.clear
import io.ktor.sessions.sessions

const val SIGNOUT = "/signout"

@Location(SIGNOUT)
class Signout

fun Route.signout() {
    get<Signout> {
        call.sessions.clear<EPSession>()
        call.redirect(Signin())
    }
}