
package store

import java.time.LocalDate

class AdvancedProduct(
    name: String, price: Int, category: ProductCategory, stock: Int, idealStock: Int, expiryDate: LocalDate?
) : Product(name, price, category, stock, idealStock, expiryDate)
