$(document).ready(function(){
    $(".container").fadeIn(300);
    $("#form").slideDown();
});

$(document).ready(function(){
    $(".alert").slideToggle(500).delay(3800).slideToggle(500);
});

$(document).ready(function(){
    $("#toggleButton").click(function(){
        $("#trasaForm").slideToggle();
    });
});