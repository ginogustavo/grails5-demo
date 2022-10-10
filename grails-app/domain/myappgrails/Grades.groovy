package myappgrails

class Grades {

    Student student
    int id
    float grade1
    float grade2
    float grade3
    float finalGrade
    float testGrade

    static constraints = {
        id(unique:true, nullable:false, blank: false)
        grade1(unique:false, nullable:false, blank: false, number:true, min:0.0f, max:5.0f, scale: 2 )
        grade2(unique:false, nullable:false, blank: false, number:true, min:0.0f, max:5.0f)
        grade3(unique:false, nullable:false, blank: false, number:true, min:0.0f, max:5.0f)
        finalGrade(unique:false, nullable:false, blank: false, number:true, min:0.0f, max:5.0f)
        testGrade(unique:false, nullable:false, blank: false, number:true, min:0.0f, max:5.0f)
    }

    static mapping =  {
        table: 'Grade'
        grade1 column: 'grade1'
        grade2 column: 'grade2'
        grade3 column: 'grade3'
        finalGrade column: 'finalGrade'
        testGrade column: 'testGrade'
    }
}
