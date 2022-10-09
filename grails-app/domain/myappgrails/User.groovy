package myappgrails

class User {

    String email
    String password
    String firstName
    String lastName
    String gender
    Date birthday

    //Indications to create views
    static constraints = {
        email(unique:true, nullable: false, email:true)
        password(nullable:true, blank:false, password:true)
        firstName(nullable:true, blank:false)
        lastName(nullable:true, blank:false)
        gender inList ['M','F']
        birthday(nullable:false, blank: false)
    }

    //Each attribute will be saved in the persistence (BD in a column)
    // Grails creates the persistence(tables automatically if it does not exist)
    static mapping = {
        table 'User'
        email column: 'email'
        password column: 'password'
        firstName column: 'firstName'
        lastName column: 'lasttName'
        gender column: 'gender'
        birthday column: 'birthday'
    }

}
