package myappgrails

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class GradesSpec extends Specification implements DomainUnitTest<Grades> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
