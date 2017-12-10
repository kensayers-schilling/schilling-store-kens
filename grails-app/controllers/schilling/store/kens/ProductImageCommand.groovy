package schilling.store.kens

import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile

class ProductImageCommand implements Validateable {
    MultipartFile productImageFile
    Long id
    Integer version

    static constraints = {
        id nullable: false
        version nullable: false
        productImageFile  validator: { val, obj ->
            if ( val == null ) {
                return false
            }
            if ( val.empty ) {
                return false
            }

            ['jpeg', 'jpg', 'png'].any { extension ->
                val.originalFilename?.toLowerCase()?.endsWith(extension)
            }
        }
    }
}