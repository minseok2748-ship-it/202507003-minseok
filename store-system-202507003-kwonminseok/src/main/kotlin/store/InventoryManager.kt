
package store

class InventoryManager(
    private val products: List<Product>,
    private val sales: Map<String, Int>,
    private val stockThreshold: Double,
    private val expiryWarningDays: Long
) {
    fun report() {
        println("=== 24시간 학교 편의점 스마트 재고 관리 시스템 ===\n")

        println("🚨 긴급 재고 알림 (재고율 30% 이하)")
        products.findLowStock(stockThreshold).forEach {
            println("- ${it.name}: 현재 ${it.stock}개 / 적정재고 ${it.idealStock}개")
        }

        println("\n⚠ 유통기한 관리 (3일 이내 임박 상품)")
        products.findExpiringSoon(expiryWarningDays).forEach {
            println("- ${it.name}: 유통기한 ${it.daysToExpire()}일 남음")
        }

        println("\n📈 오늘의 베스트셀러")
        sales.entries.sortedByDescending { it.value }.take(5).forEachIndexed { i, e ->
            println("${i + 1}위: ${e.key} (${e.value}개 판매)")
        }
    }
}
