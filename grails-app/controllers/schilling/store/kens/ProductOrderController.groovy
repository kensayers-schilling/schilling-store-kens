package schilling.store.kens

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProductOrderController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ProductOrder.list(params), model:[productOrderCount: ProductOrder.count()]
    }

    def report() {
        respond ProductOrder.list(), model:[productOrderCount: ProductOrder.count()]
    }

    def show(ProductOrder productOrder) {
        respond productOrder
    }

    def create() {
        respond new ProductOrder(params)
    }

    @Transactional
    def save(ProductOrder productOrder) {
        if (productOrder == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (productOrder.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond productOrder.errors, view:'create'
            return
        }

        productOrder.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'productOrder.label', default: 'ProductOrder'), productOrder.id])
                redirect productOrder
            }
            '*' { respond productOrder, [status: CREATED] }
        }
    }

    def edit(ProductOrder productOrder) {
        respond productOrder
    }

    @Transactional
    def update(ProductOrder productOrder) {
        if (productOrder == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (productOrder.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond productOrder.errors, view:'edit'
            return
        }

        productOrder.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'productOrder.label', default: 'ProductOrder'), productOrder.id])
                redirect productOrder
            }
            '*'{ respond productOrder, [status: OK] }
        }
    }

    @Transactional
    def delete(ProductOrder productOrder) {

        if (productOrder == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        productOrder.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'productOrder.label', default: 'ProductOrder'), productOrder.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'productOrder.label', default: 'ProductOrder'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
