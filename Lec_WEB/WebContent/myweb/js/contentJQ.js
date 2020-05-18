$(document).ready(function () {
    var slide = $('.card')
    $(slide).first().addClass('active-img');
    $(slide).last().addClass('small').addClass('prev');
    $(slide).last().prev('.card').addClass('smaller prevSmall');
    $(slide).first().next('.card').addClass('small next');
    $(slide).first().next('.card').next('.card').addClass('smaller nextSmall');


    var url = "../myweb/js/imgData.js"

    $('.logout').click(function(){
        alert('로그아웃 성공!')
    });

    $.ajax({
        url: url,
        type: "GET",
        cache: false,
        success: function(data, status){
            // console.log(status)
            if(status == "success") parseJSON();
        } 
    })

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
        $(SmallPrev).addClass('nextSmall').removeClass('prevSmall');

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
        
        var str = $(this).attr("class");
        $('.active-img').addClass(str).removeClass('active-img')
        $(this).removeClass(str).addClass('card active-img')
        $('.modal').css('display','block')

        $('.imgcontainer').html('<img src="'+ $(' img',this).attr('src')+ '" width=100% height=500px>')
        
        // $.ajax({
        //     url: url,
        //     type: "GET",
        //     cache: false,
        //     success: function(data, status){
        //         // console.log(status)
        //         if(status == "success") parseJSONsa();
        //     } 
        // })
    });

    $('.korean-movie').click(function(){
        $.ajax({
            url: url,
            type: "GET",
            cache: false,
            success: function(data, status){
                // console.log(status)
                if(status == "success") parseJSONMovie();
            } 
        });
    });

    $('.favorite').click(function(){
        $.ajax({
            url: url,
            type: "GET",
            cache: false,
            success: function(data, status){
                // console.log(status)
                if(status == "success") parseJSON();
            } 
        });
    });

    $('.close').click(function(){
        $('.modal').css('display','none')
    });

    var modal = document.getElementById("id01");
    var close = document.getElementsByClassName("close")[0];

    window.onclick = function(event){
        if(event.target == modal){
            modal.style.display = "none";
        }
    }

    $('.view').click(function(){
        alert('즐거운 시청 되십시오');
    })
});

function parseJSON(){
    var row = x.item[0];
    console.log(row)
    var src="";
    var submit = ""
    var advice = ""
	for(i = 0; i < row.img.length; i++){
        src += '<img src="'+ row.img[i]+ '" width=100% height=100%>'
        $(".card").eq(i).html(src);
        src ="";
	}
}

function parseJSONMovie(){
	var row = x.item[1];
    var src="";
	for(i = 0; i < row.img.length; i++){
        src += '<img src="'+row.img[i]+ '" width=100% height=100%>'
        $(".card").eq(i).html(src);
        src ="";
	}
}

// function parseJSONsa(){
// 	var row = x.item[0];
//     var src="";
// 	for(i = 0; i < row.submit.length; i++){
//         src = row.submit[i]
//         $(".submit").text(src);
//         src ="";
// 	}
// }
