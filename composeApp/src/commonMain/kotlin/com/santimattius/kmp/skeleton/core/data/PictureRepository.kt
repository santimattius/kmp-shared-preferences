package com.santimattius.kmp.skeleton.core.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import com.santimattius.kmp.skeleton.core.domain.Picture as DomainPicture

private fun Picture.asDomain(): DomainPicture {
    return DomainPicture(this.id, this.author, this.downloadURL)
}

class PictureRepository(
    private val client: HttpClient,
) {
    suspend fun random() = runCatching {
        val response = client.get("/random")
        response.body<Picture>().asDomain()
    }
}