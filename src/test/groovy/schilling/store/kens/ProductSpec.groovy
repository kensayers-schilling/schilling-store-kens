package schilling.store.kens

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ProductSpec extends Specification implements DomainUnitTest<Product> {

    def aProduct
    def setup() {
        aProduct = new Product()
    }

    def cleanup() {
    }

    void "test null name is invalid"() {
        given: "a product has no name"
        expect: "that product is invalid without a name"
        aProduct.validate(['name']) == false
    }
    void "test blank name is invalid"() {
        given: "a product has blank name"
            aProduct.name = ''
        expect: "that product is invalid without a name"
            aProduct.validate(['name']) == false
    }
    void "test some name is valid"() {
        given:"i set the name"
            aProduct.name = "A Product"
        expect:"the product is valid now"
            aProduct.validate(['name']) == true
    }

    void "test null category"() {
        given: "the category is null"
        expect: "invalid product"
            !aProduct.validate(['category'])
    }
    void "test valid category"() {
        given: "the category is not null"
            aProduct.category = new Category(name:'Prods')
        expect: "valid product"
            aProduct.validate(['category'])
    }

    void "test invalid product with only name"() {
        given:"i set the name"
            aProduct.name = "A Product"
        expect:
            aProduct.validate() == false
    }

    void "test null manufacturer is invalid"() {
        given: "the manufacturer is null"
        expect:
            aProduct.validate(['manufacturer']) == false
    }
    void "test null description is invalid"() {
        given: "the description is null"
        expect:
            aProduct.validate(['description']) == false
    }
    void "test blank description is invalid"() {
        given: "the description is blank"
            aProduct.description = ''
        expect:
        aProduct.validate(['description']) == false
    }
    void "test valid description"() {
        given: "the description is something"
            aProduct.description = 'description'
        expect:
        aProduct.validate(['description']) == true
    }
    void "test null price"() {
        given: "the price is null"
        expect:
            aProduct.validate(['price']) == false
    }
    void "test valid price"() {
        given: "the prices is set"
            aProduct.price = 24.5
        expect:
            aProduct.validate(['price']) == true
    }
}
