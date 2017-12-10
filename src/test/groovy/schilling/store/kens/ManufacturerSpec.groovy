package schilling.store.kens

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ManufacturerSpec extends Specification implements DomainUnitTest<Manufacturer> {

    Manufacturer aManufacturer
    def setup() {
        aManufacturer = new Manufacturer()
    }

    def cleanup() {
    }

    void "test null name"() {
        given: "name is null"

        expect:"fix me"
            aManufacturer.validate(['name']) == false
    }

    void "test empty name"() {
        given: "name is empty"
            aManufacturer.name = ''
        expect: "invalid"
            aManufacturer.validate(['name']) == false
    }

    void "test valid name"() {
        given: "name is set"
            aManufacturer.name = "Manny Facturing"
        expect: "valid"
            aManufacturer.validate(['name'])
    }
}
