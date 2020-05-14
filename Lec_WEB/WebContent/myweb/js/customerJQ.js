

$(document).ready(function(){

    $(".questionBtn").click(function(){
        var ximg = $(" .ximg",this);
        var ex = $('+ .explainDiv .explain',this);
        
        
        if(ex.css('display') == 'none'){
            var state = true;
        } else{
            var state = false;
        }
        
        if(state){
            ximg.css('transform', 'rotate(0deg)');
            state = false;
        } else {
            ximg.css('transform', 'rotate(45deg)');
            state = true;
        }
        ex.css('margin-bottom', '10px');
        ex.slideToggle("fast");
        $('.explain').not(ex).css('display', 'none');
        
        $(".explainDiv").css('margin-top', 0)
    });
});