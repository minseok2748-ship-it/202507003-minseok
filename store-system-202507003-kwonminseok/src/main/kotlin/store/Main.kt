
package store

import java.time.LocalDate

fun main() {
    val products = listOf(
        Product("새우깡", 1500, ProductCategory.SNACK, 5, 30, null),
        Product("콜라 500ml", 1500, ProductCategory.BEVERAGE, 8, 25, null),
        Product("김치찌개 도시락", 5500, ProductCategory.FOOD, 3, 20, LocalDate.now().plusDays(2)),
        Product("참치마요 삼각김밥", 1500, ProductCategory.FOOD, 12, 15, LocalDate.now().plusDays(1)),
        Product("딸기 샌드위치", 2800, ProductCategory.FOOD, 2, 10, LocalDate.now())
    )

    val sales = mapOf(
        "새우깡" to 15,
        "콜라 500ml" to 12,
        "참치마요 삼각김밥" to 10
    )

    val manager = InventoryManager(products, sales, 0.3, 3)
    manager.report()
}
