package project.wgtech.limited.item

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 *
 * "성검전설3 TRIALS of MANA (한국어판)": {
"data_source": "nintendo",
"game_name": "성검전설3 TRIALS of MANA (한국어판)",
"game_detail_url": "https://store.nintendo.co.kr/70010000025168",
"game_device": "Nintendo Switch",
"game_methods": ["PK", "DL"],
"releaseDate": "2020.04.24 (현재 미리 다운로드 가능)SQUARE ENIX",
"thumbnail_video": [],
"thumbnail_url": "https://www.nintendo.co.kr/images/renew/software/switch/img_sw_list_trials_of_mana.jpg",
"game_image_thumb": ["https://store.nintendo.co.kr/media/catalog/product/cache/e97e30f46ad3af2c4402aa864120074b/4/1/41b4ce33c0e4548f7a66ae334d4568d5079c9846dce230ad766e1ee3cee4a165.jpg", "https://store.nintendo.co.kr/media/catalog/product/cache/e97e30f46ad3af2c4402aa864120074b/1/1/11c3fad31cf290a65539456c67827e4715220d29ffba683dd48c608c084a3c0d.jpg", "https://store.nintendo.co.kr/media/catalog/product/cache/e97e30f46ad3af2c4402aa864120074b/4/8/48b6b19293354b2d6df1b7846f64c8155a3b16ac2f8b9aef23259b6bc8d76263.jpg", "https://store.nintendo.co.kr/media/catalog/product/cache/e97e30f46ad3af2c4402aa864120074b/0/6/06c0a1bb02e57d81137aace33ed9d5728b41a897e341e2097ed0f914f9594354.jpg", "https://store.nintendo.co.kr/media/catalog/product/cache/e97e30f46ad3af2c4402aa864120074b/e/5/e584b338cf252463af040090b3d543499b5fb875b4db26a0871761afc88f5029.jpg", "https://store.nintendo.co.kr/media/catalog/product/cache/e97e30f46ad3af2c4402aa864120074b/9/8/98836a2c8a3855fbb7ab83ef12fa41b4b0084d663b915bc638adace8056ae107.jpg", "https://store.nintendo.co.kr/media/catalog/product/cache/e97e30f46ad3af2c4402aa864120074b/f/f/ffb0b36208021f871bab1e470a9a42f1f6287542fe2d168a114788a7d0251e87.jpg"],
"game_image_raw": ["https://store.nintendo.co.kr/media/catalog/product/cache/14e5d81868ac859844dff5ea3cdb33f6/4/1/41b4ce33c0e4548f7a66ae334d4568d5079c9846dce230ad766e1ee3cee4a165.jpg", "https://store.nintendo.co.kr/media/catalog/product/cache/14e5d81868ac859844dff5ea3cdb33f6/1/1/11c3fad31cf290a65539456c67827e4715220d29ffba683dd48c608c084a3c0d.jpg", "https://store.nintendo.co.kr/media/catalog/product/cache/14e5d81868ac859844dff5ea3cdb33f6/4/8/48b6b19293354b2d6df1b7846f64c8155a3b16ac2f8b9aef23259b6bc8d76263.jpg", "https://store.nintendo.co.kr/media/catalog/product/cache/14e5d81868ac859844dff5ea3cdb33f6/0/6/06c0a1bb02e57d81137aace33ed9d5728b41a897e341e2097ed0f914f9594354.jpg", "https://store.nintendo.co.kr/media/catalog/product/cache/14e5d81868ac859844dff5ea3cdb33f6/e/5/e584b338cf252463af040090b3d543499b5fb875b4db26a0871761afc88f5029.jpg", "https://store.nintendo.co.kr/media/catalog/product/cache/14e5d81868ac859844dff5ea3cdb33f6/9/8/98836a2c8a3855fbb7ab83ef12fa41b4b0084d663b915bc638adace8056ae107.jpg", "https://store.nintendo.co.kr/media/catalog/product/cache/14e5d81868ac859844dff5ea3cdb33f6/f/f/ffb0b36208021f871bab1e470a9a42f1f6287542fe2d168a114788a7d0251e87.jpg"],
"game_image_full": ["https://store.nintendo.co.kr/media/catalog/product/cache/ecd051e9670bd57df35c8f0b122d8aea/4/1/41b4ce33c0e4548f7a66ae334d4568d5079c9846dce230ad766e1ee3cee4a165.jpg", "https://store.nintendo.co.kr/media/catalog/product/cache/ecd051e9670bd57df35c8f0b122d8aea/1/1/11c3fad31cf290a65539456c67827e4715220d29ffba683dd48c608c084a3c0d.jpg", "https://store.nintendo.co.kr/media/catalog/product/cache/ecd051e9670bd57df35c8f0b122d8aea/4/8/48b6b19293354b2d6df1b7846f64c8155a3b16ac2f8b9aef23259b6bc8d76263.jpg", "https://store.nintendo.co.kr/media/catalog/product/cache/ecd051e9670bd57df35c8f0b122d8aea/0/6/06c0a1bb02e57d81137aace33ed9d5728b41a897e341e2097ed0f914f9594354.jpg", "https://store.nintendo.co.kr/media/catalog/product/cache/ecd051e9670bd57df35c8f0b122d8aea/e/5/e584b338cf252463af040090b3d543499b5fb875b4db26a0871761afc88f5029.jpg", "https://store.nintendo.co.kr/media/catalog/product/cache/ecd051e9670bd57df35c8f0b122d8aea/9/8/98836a2c8a3855fbb7ab83ef12fa41b4b0084d663b915bc638adace8056ae107.jpg", "https://store.nintendo.co.kr/media/catalog/product/cache/ecd051e9670bd57df35c8f0b122d8aea/f/f/ffb0b36208021f871bab1e470a9a42f1f6287542fe2d168a114788a7d0251e87.jpg"],
"review": "",
"discount": 0,
"price": 59800,
"product_attribute": [
["대응 기종", "Nintendo Switch"],
["장르", "액션, RPG"],
["발매일", "2020. 4. 24."],
["메이커", "SQUARE ENIX"],
["플레이 인원수", "1명"],
["대응 언어", "한국어, 중국어"],
["필요한 용량", "10.5GB"],
["대응 컨트롤러", "Nintendo Switch Pro 컨트롤러"],
["플레이 모드", "TV 모드, 테이블 모드, 휴대 모드"],
["GRAC", "등급분류번호： GC-CC-NV-191129-004등급분류일자： 2019.11.29제작・배급업 신고번호： 제 2010-000017 호 , 제 2010-000021 호\n© 1995, 2020 SQUARE ENIX CO., LTD. All Rights Reserved."]
],
"language": "한국어 대응",
"game_pusblisher": "SQUARE ENIX",
"game_description": ["미리 다운로드(예약구입) 상품입니다.", "각자의 운명, 각자의 선택다시 시작되는 트라이앵글 스토리", "6명의 캐릭터 중에서 어떤 주인공과 동료를 선택하고 조합하냐에 따라 이야기 전개가 바뀌는 \"트라이앵글 스토리\".『성검전설3 TRIALS of MANA』는 일본에서 1995년에 발매됐던 『Trials of Mana』를 3D로 리메이크한 작품입니다.이번 작품에서는 향상된 그래픽과 재구축된 배틀 시스템뿐만 아니라, 캐릭터 보이스와 사이드 토크를 추가하고 어레인지 음악을 수록하는 등『Trials of Mana』를 현대에 걸맞게 풀 리메이크!마나의 힘을 이용해 세계 정복을 노리는 세력들 사이의 싸움에 휩쓸려, 필사적으로 운명에 저항하는 소년·소녀들의 여행과 시련을 담은 이야기가 선명하게 다시 태어납니다.", "[다운로드판 조기 구매 특전]라비의 액세서리레벨 10까지 배틀에서 획득하는 EXP가 증가됩니다.기간: 2020년 3월 18일~2020년 5월 23일"]
}
 *
 */

data class Item constructor(
    val id: Int?,

    @SerializedName("data_source")
    @Expose
    val type: String?,

    @SerializedName("game_name")
    @Expose
    val title: String?,

    @SerializedName("game_detail_url")
    @Expose
    val url: String?,

    @SerializedName("game_device")
    val device: String?,

    @SerializedName("game_methods")
    val methods: List<String>?,

    @SerializedName("game_methods")
    @Expose
    val method: ArrayList<String>?,

    @SerializedName("release_date")
    @Expose
    val date: String?,

    val language: String?,

    @SerializedName("game_image_thumb")
    @Expose
    val thumbnailUrl: ArrayList<String>?,

    @SerializedName("price")
    @Expose
    val price: Int?,

    @SerializedName("game_pusblisher")
    @Expose
    val seller: String?,

    val description: String?,

    @SerializedName("product_attribute")
    @Expose
    val attributes: List<List<String>>?,

    val imageUrls: List<String>? ): Serializable {

    data class Builder(
        var id: Int? = null,
        var title: String? = null,
        var url: String? = null,
        var type: String? = null,
        var type2: String? = null,
        var device: String? = null,
        var methods: List<String>? = null,
        var method: ArrayList<String>? = null,
        var date: String? = null,
        var language: String? = null,
        var thumbnailUrl: ArrayList<String>? = null,
        var price: Int? = 0,
        var seller: String? = null,
        var description: String? = null,
        var attributes: List<List<String>>? = null,
        var imageUrls: List<String>? = null) {

        fun id(itemId: Int) = apply { id = itemId }
        fun title(itemTitle: String) = apply { title = itemTitle }
        fun description(itemDesc: String) = apply { description = itemDesc }
        fun date(itemDate: String) = apply { date = itemDate }
        fun imageUrls(itemImageUrls: List<String>) = apply { imageUrls = itemImageUrls }
        fun price(itemPrice: Int) = apply { price = itemPrice }
        fun build() = Item(id, type, title, url, device, methods, method, date, language, thumbnailUrl, price, seller, description, attributes, imageUrls)
        override fun toString(): String {
            return "Item(id=$id, " +
                    "title=$title, " +
                    "url=$url, " +
                    "type=$type, " +
                    "type2=$type2, " +
                    "method=$method, " +
                    "date=$date, " +
                    "language=$language, " +
                    "thumbnailUrl=$thumbnailUrl, " +
                    "price=$price, " +
                    "seller=$seller, " +
                    "description=$description, " +
                    "attributes=$attributes, " +
                    "imageUrls=$imageUrls)"
        }


    }
}