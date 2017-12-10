package schilling.store.kens

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ShoppingCartSpec extends Specification implements DomainUnitTest<ShoppingCart> {

    ShoppingCart aShoppingCart

    def setup() {
        aShoppingCart = new ShoppingCart()
    }

    def cleanup() {
    }

    void "test can add an order"() {
        given: "i add an order"
            aShoppingCart.addToOrders(new ProductOrder())
        expect:"fix me"
            aShoppingCart.orders.size() == 1
    }
}
