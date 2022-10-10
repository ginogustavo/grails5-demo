package myappgrails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class GradesController {

    GradesService gradesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond gradesService.list(params), model:[gradesCount: gradesService.count()]
    }

    def show(Long id) {
        respond gradesService.get(id)
    }

    def create() {
        respond new Grades(params)
    }

    def save(Grades grades) {
        if (grades == null) {
            notFound()
            return
        }

        try {
            gradesService.save(grades)
        } catch (ValidationException e) {
            respond grades.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'grades.label', default: 'Grades'), grades.id])
                redirect grades
            }
            '*' { respond grades, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond gradesService.get(id)
    }

    def update(Grades grades) {
        if (grades == null) {
            notFound()
            return
        }

        try {
            gradesService.save(grades)
        } catch (ValidationException e) {
            respond grades.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'grades.label', default: 'Grades'), grades.id])
                redirect grades
            }
            '*'{ respond grades, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        gradesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'grades.label', default: 'Grades'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'grades.label', default: 'Grades'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
