package myappgrails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class GradesServiceSpec extends Specification {

    GradesService gradesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Grades(...).save(flush: true, failOnError: true)
        //new Grades(...).save(flush: true, failOnError: true)
        //Grades grades = new Grades(...).save(flush: true, failOnError: true)
        //new Grades(...).save(flush: true, failOnError: true)
        //new Grades(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //grades.id
    }

    void "test get"() {
        setupData()

        expect:
        gradesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Grades> gradesList = gradesService.list(max: 2, offset: 2)

        then:
        gradesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        gradesService.count() == 5
    }

    void "test delete"() {
        Long gradesId = setupData()

        expect:
        gradesService.count() == 5

        when:
        gradesService.delete(gradesId)
        sessionFactory.currentSession.flush()

        then:
        gradesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Grades grades = new Grades()
        gradesService.save(grades)

        then:
        grades.id != null
    }
}
