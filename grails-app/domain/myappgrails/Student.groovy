package myappgrails

class Student {

    int id
    String email
    String firstName
    String lastName
    String gender
    Date birthday

    static constraints = {
        id(unique: true, nullable: false, blank: false)
        email(unique: true, nullable: false, blank: false, email: true)
        firstName(nullable: false, blank: false)
        lastName(nullable: false, blank: false)
        gender inList:['F', 'M']
        birthday(nullable: false, blank: false)
    }

    static mapping = {
        table 'Student'
        id  column: 'id'
        email column: 'email'
        firstName column: 'firstName'
        lastName column: 'lastName'
        gender column: 'gender'
        birthday column: 'birthday'
    }

    String toStrinng(){

    }
}
