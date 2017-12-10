package schilling.store.kens

class Manufacturer {

    String name

    static constraints = {
        name nullable: false, blank: false
    }

    String toString() {
        name
    }
}
