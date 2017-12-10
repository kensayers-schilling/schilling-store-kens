package schilling.store.kens

import org.grails.plugins.filterpane.FilterPaneUtils
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProductController {

    def filterPaneService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def filter = {
        if(!params.max) params.max = 10
        render( view:'index',
                model:[ productList: filterPaneService.filter( params, Product ),
                        productCount: filterPaneService.count( params, Product ),
                        filterParams: FilterPaneUtils.extractFilterParams(params),
                        params:params,
                        categoryList:Category.list(),
                        manufacturerList:Manufacturer.list()
                    ] )
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Product.list(params), model:[productCount: Product.count()]
    }

    def filterForBrowse = {
        if(!params.max) params.max = 10
        render( view:'browse',
                model:[ productList: filterPaneService.filter( params, Product ),
                        productCount: filterPaneService.count( params, Product ),
                        filterParams: FilterPaneUtils.extractFilterParams(params),
                        params:params,
                        categoryList:Category.list(),
                        manufacturerList:Manufacturer.list()
                ] )
    }

    def browse(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Product.list(params), model:[productCount: Product.count()]
    }

    def show(Product product) {
        respond product
    }

    def view(Product product) {
        respond product
    }

    def create() {
        respond new Product(params)
    }

    @Transactional(readOnly = true)
    def editImage(Product product) {
        respond product
    }

    @Transactional
    def save(Product product) {
        if (product == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (product.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond product.errors, view:'create'
            return
        }

        product.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'product.label', default: 'Product'), product.id])
                redirect product
            }
            '*' { respond product, [status: CREATED] }
        }
    }

    def uploadProductImage(ProductImageCommand cmd) {
        if (cmd == null) {
            notFound()
            return
        }

        if (cmd.hasErrors()) {
            respond(cmd.errors, model: [product: cmd], view: 'editImage')
            return
        }

        Product product = Product.get(cmd.id)
        if ( !product ) {
            return null
        }
        product.imageBytes = cmd.productImageFile.bytes
        product.imageContentType = cmd.productImageFile.contentType

        if (product == null) {
            notFound()
            return
        }

        if (product.hasErrors()) {
            respond(product.errors, model: [product: product], view: 'editImage')
            return
        }

        product.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'product.label', default: 'Product'), product.id])
                redirect product
            }
            '*' { respond product, [status: OK] }
        }
    }

    @Transactional(readOnly = true)
    def productImage(Product product) {
        if (product == null || product.imageBytes == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }
        render file: product.imageBytes, contentType: product.imageContentType
    }

    def edit(Product product) {
        respond product
    }

    @Transactional
    def update(Product product) {
        if (product == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (product.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond product.errors, view:'edit'
            return
        }

        product.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'product.label', default: 'Product'), product.id])
                redirect product
            }
            '*'{ respond product, [status: OK] }
        }
    }

    @Transactional
    def delete(Product product) {

        if (product == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        product.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'product.label', default: 'Product'), product.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'product.label', default: 'Product'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
