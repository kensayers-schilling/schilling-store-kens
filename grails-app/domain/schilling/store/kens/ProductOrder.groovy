package schilling.store.kens

class ProductOrder {

    String number
    Product product
    Integer quantity

    static constraints = {
        number nullable: false
        product nullable: false
        quantity nullable: false
    }

    Double totalPrice() {
        (quantity ?: 0) * (product?.price ?: 0)
    }

    String toString() {
        "Number: $number Order Product: $product Quantity: $quantity Total Cost: ${totalPrice()}"
    }
}
