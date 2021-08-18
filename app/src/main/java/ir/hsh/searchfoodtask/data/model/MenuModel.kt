package ir.hsh.searchfoodtask.data.model
import com.google.gson.annotations.SerializedName


class MenuModel : ArrayList<MenuModelItem>()

data class MenuModelItem(
    @SerializedName("courseType")
    val courseType: CourseType?,
    @SerializedName("cuisineType")
    val cuisineType: CuisineType?,
    @SerializedName("delivery")
    val delivery: Int?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("fee")
    val fee: Int?,
    @SerializedName("gallery")
    val gallery: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("ingredients")
    val ingredients: String?,
    @SerializedName("isAcceptingDelivery")
    val isAcceptingDelivery: Boolean?,
    @SerializedName("isAcceptingPickup")
    val isAcceptingPickup: Boolean?,
    @SerializedName("isAvailable")
    val isAvailable: Boolean?,
    @SerializedName("isCatering")
    val isCatering: Boolean?,
    @SerializedName("isFavorite")
    val isFavorite: Boolean?,
    @SerializedName("maximumCalorie")
    val maximumCalorie: Int?,
    @SerializedName("mealType")
    val mealType: MealType?,
    @SerializedName("menuType")
    val menuType: MenuType?,
    @SerializedName("minimumCalorie")
    val minimumCalorie: Int?,
    @SerializedName("preparation")
    val preparation: Int?,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("rate")
    val rate: Int?,
    @SerializedName("rewards")
    val rewards: List<Any>?,
    @SerializedName("special")
    val special: Special?,
    @SerializedName("subTitle")
    val subTitle: String?,
    @SerializedName("title")
    val title: String?
)

data class CourseType(
    @SerializedName("description")
    val description: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("priority")
    val priority: Int?,
    @SerializedName("title")
    val title: String?
)

data class CuisineType(
    @SerializedName("description")
    val description: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("priority")
    val priority: Int?,
    @SerializedName("title")
    val title: String?
)

data class MealType(
    @SerializedName("description")
    val description: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("priority")
    val priority: Int?,
    @SerializedName("title")
    val title: String?
)

data class MenuType(
    @SerializedName("description")
    val description: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("priority")
    val priority: Int?,
    @SerializedName("title")
    val title: String?
)

data class Special(
    @SerializedName("amount")
    val amount: Int?,
    @SerializedName("beginTime")
    val beginTime: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("limit")
    val limit: Int?,
    @SerializedName("percentage")
    val percentage: Int?,
    @SerializedName("policy")
    val policy: String?,
    @SerializedName("quantity")
    val quantity: Int?,
    @SerializedName("remainingTime")
    val remainingTime: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("transcript")
    val transcript: String?,
    @SerializedName("value")
    val value: Int?,
    @SerializedName("voucher")
    val voucher: String?
)