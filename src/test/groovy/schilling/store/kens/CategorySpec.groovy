package schilling.store.kens

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CategorySpec extends Specification implements DomainUnitTest<Category> {

    Category aCategory

    def setup() {
        aCategory = new Category()
    }

    def cleanup() {
    }

    void "test null name"() {
        expect:"invalid"
            !aCategory.validate(['name'])
    }
    void "test blank name"() {
        given: "name is empty"
            aCategory.name = ''
        expect: "invalid"
            !aCategory.validate(['name'])
    }
    void "test valid name"() {
        given: "a name is set"
            aCategory.name = 'A Valid Name'
        expect: "valid"
            aCategory.validate(['name'])
    }
}
