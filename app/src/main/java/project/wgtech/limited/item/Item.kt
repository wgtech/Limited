package project.wgtech.limited.item

import java.io.Serializable

data class Item constructor(
    val id: Int?,
    val title: String?,
    val url: String?,
    val type: String?,
    val type2: String?,
    val method: ArrayList<String>?,
    val date: String?,
    val language: String?,
    val thumbnailUrl: String?,
    val seller: String?,
    val description: String?,
    val attributes: ArrayList<String>?,
    val imageUrls: ArrayList<String>? ): Serializable {

    data class Builder(
        var id: Int? = null,
        var title: String? = null,
        var url: String? = null,
        var type: String? = null,
        var type2: String? = null,
        var method: ArrayList<String>? = null,
        var date: String? = null,
        var language: String? = null,
        var thumbnailUrl: String? = null,
        var seller: String? = null,
        var description: String? = null,
        var attributes: ArrayList<String>? = null,
        var imageUrls: ArrayList<String>? = null) {

        fun id(itemId: Int) = apply { this.id = itemId }
        fun title(itemTitle: String) = apply { this.title = itemTitle }
        fun description(itemDesc: String) = apply { this.description = itemDesc }
        fun build() = Item(id, title, url, type, type2, method, date, language, thumbnailUrl, seller, description, attributes, imageUrls)
    }
}
