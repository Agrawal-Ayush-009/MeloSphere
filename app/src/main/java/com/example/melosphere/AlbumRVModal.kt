package com.example.melosphere

data class AlbumRVModal(
    var album_type: String,
    var artistName: String,
    var external_ids: String,
    var external_urls: String,
    var href: String,
    var id: String,
    var imageUrl: String,
    var label: String,
    var name: String,
    var popularity: Int,
    var release_date: String,
    var total_tracks: Int,
    var type: String
)
