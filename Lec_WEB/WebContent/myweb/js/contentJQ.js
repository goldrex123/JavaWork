$(document).ready(function () {
    var slide = $('.card')
    $(slide).first().addClass('active-img');
    $(slide).last().addClass('small').addClass('prev');
    $(slide).last().prev('.card').addClass('smaller prevSmall');
    $(slide).first().next('.card').addClass('small next');
    $(slide).first().next('.card').next('.card').addClass('smaller nextSmall');



    $('.next-btn').click(function (e) {
        e.preventDefault();
        var Active = $('.active-img'),
            Prev = $('.prev'),
            Next = $('.next'),
            SmallPrev = $('.prevSmall'),
            SmallNext = $('.nextSmall');

        $(Active).addClass('small prev ').removeClass('active-img');
        $(Next).addClass('active-img').removeClass('small next');
        $(Prev).addClass('smaller prevSmall ').removeClass('small prev ');
        $(SmallNext).addClass('small next').removeClass('smaller nextSmall ');
        $(SmallPrev).removeClass('prevSmall').addClass('nextSmall');

    });
    $('.prev-btn').click(function (e) {
        e.preventDefault();
        var Active = $('.active-img'),
            Prev = $('.prev'),
            Next = $('.next'),
            SmallPrev = $('.prevSmall'),
            SmallNext = $('.nextSmall');

        $(Active).removeClass('active-img').addClass('small next');
        $(Prev).removeClass('small prev').addClass('active-img');
        $(Next).removeClass('small next').addClass('smaller nextSmall');
        $(SmallPrev).addClass('small prev').removeClass('smaller prevSmall');
        $(SmallNext).removeClass('nextSmall').addClass('prevSmall');

    });

    $('.card').click(function(e){
        e.preventDefault();
        // var Active = $('.active-img'),
        //     Prev = $('.prev'),
        //     Next = $('.next'),
        //     SmallPrev = $('.prevSmall'),
        //     SmallNext = $('.nextSmall');

        
        // $(this).addClass('active-img')
        for(i=0; i< $('.card').length; i++){
            if($(this).hasClass('active-img')){
                break;
            } else {
                var str = $(this).attr('class');
                console.log(str);
                
                $(this).addClass('active-img');
                $(this).css('transform', 'translated(100,0,0)');
                $('.active-img').removeClass('active-img').addClass(str);
            }
        }
       
    });

});