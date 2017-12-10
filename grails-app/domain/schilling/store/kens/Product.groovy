package schilling.store.kens

class Product {

    String name
    String description
    Manufacturer manufacturer
    Category category
    Double price
    byte[] imageBytes
    String imageContentType

    static constraints = {
        name nullable:false, blank: false
        description nullable:false, blank: false
        manufacturer nullable:false
        category nullable:false
        price nullable:false
        imageBytes nullable: true
        imageContentType nullable: true
    }

    static mapping = {
        imageBytes column: 'image_bytes', sqlType: 'longblob'
    }

    String toString() {
        "$name by $manufacturer price: $price"
    }
}
