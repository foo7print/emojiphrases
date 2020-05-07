package com.raywenderlich.api

import com.raywenderlich.*
import com.raywenderlich.model.*
import com.raywenderlich.repository.*
import io.ktor.application.*
import io.ktor.locations.Location
import io.ktor.locations.post
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

const val PHRASE_ENDPOINT = "$API_VERSION/phrase"

@Location(PHRASE_ENDPOINT)
class Phrase

fun Route.phrase(db: Repository) {
    post<Phrase> {
        val request = call.receive<Request>()
        val phrase = db.add("", request.emoji, request.phrase)
        call.respond(phrase)
    }
}