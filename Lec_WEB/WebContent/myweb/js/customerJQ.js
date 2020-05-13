$(document).ready(function(){
    $(".questionBtn").click(function(){
        var str = "$("+ this + ") ~ " + span;
        console.log(str);
        $(str).css({display : "inline-block"})
        $(".explainDiv").css({margin: 0})
    });
});