
package store

import java.time.LocalDate
import java.time.temporal.ChronoUnit

enum class ProductCategory { SNACK, BEVERAGE, FOOD, DAILY }

data class Product(
    val name: String,
    val price: Int,
    val category: ProductCategory,
    var stock: Int,
    val idealStock: Int,
    val expiryDate: LocalDate?
) {
    fun stockRate(): Double = stock.toDouble() / idealStock
    fun isLowStock(threshold: Double): Boolean = stockRate() < threshold
    fun daysToExpire(): Long? = expiryDate?.let { ChronoUnit.DAYS.between(LocalDate.now(), it) }
}
