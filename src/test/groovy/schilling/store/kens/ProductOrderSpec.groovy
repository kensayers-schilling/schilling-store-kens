package schilling.store.kens

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ProductOrderSpec extends Specification implements DomainUnitTest<ProductOrder> {

    ProductOrder anOrder
    def setup() {
        anOrder = new ProductOrder()
    }

    def cleanup() {
    }

    void "test null quantity"() {
        given: "quantity is null"
        expect:"order is invalid"
            !anOrder.validate(['quantity'])
    }

    void "test valid quantity"() {
        given: "quantity is set"
            anOrder.quantity = 1
        expect: "valid"
            anOrder.validate(['quantity'])
    }

    void "test null product"() {
        given: "product is null"
        expect: "order is invalid"
            !anOrder.validate(['product'])
    }
    void "test valid product"() {
        given: "product is valid"
            anOrder.product = new Product()
        expect: "valid"
            anOrder.validate(['product'])
    }
    void "test total price"() {
        given: "a product costing 3.50 and a quantity of 2"
            anOrder.product = new Product(price:3.50)
            anOrder.quantity = 2
        expect: "total price is 7.00"
            anOrder.totalPrice() == 7.00
    }
}
