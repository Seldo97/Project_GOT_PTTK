$(document).ready(function(){
    $(".container").fadeIn(300);
    $("#form").slideDown();
});

$(document).ready(function(){
    $(".flash-msg").slideToggle(500).delay(3800).slideToggle(500);
});

$(document).ready(function(){
    $("#toggleButton").click(function(){
        $("#trasaForm").slideToggle();
    });
});

$(document).ready(function(){
    $("#toggleButton").click(function(){
        $("#zdjeciaForm").slideToggle();
    });
});