
package store

fun List<Product>.findLowStock(threshold: Double) =
    filter { it.isLowStock(threshold) }

fun List<Product>.findExpiringSoon(days: Long) =
    filter { it.daysToExpire()?.let { d -> d <= days } ?: false }
