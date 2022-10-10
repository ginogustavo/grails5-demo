// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-3.5.1.min
//= require popper.min
//= require bootstrap
//= require_self


$("#grade1, #grade2, #grade3, #finalGrade").change(function(){
    const g1 = parseFloat($("#grade1").val()) *0.23;
    const g2 = parseFloat($("#grade2").val()) *0.23;
    const g3 = parseFloat($("#grade3").val()) *0.23;
    const fg = parseFloat($("#finalGrade").val()) *0.31;

    const result = g1+g2+g3+fg;
    $("#testGrade").val(result.toFixed(2).toString().replace(".","," ))
})