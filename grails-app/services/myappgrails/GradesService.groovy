package myappgrails

import grails.gorm.services.Service

@Service(Grades)
interface GradesService {

    Grades get(Serializable id)

    List<Grades> list(Map args)

    Long count()

    void delete(Serializable id)

    Grades save(Grades grades)

}