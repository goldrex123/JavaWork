
function chkForLogin(){
    var frmId = $('.loginForm').find("input[type=text]");
    var frmPw = $('.loginForm').find("input[type=password]");

    if((frmId.val().trim() == "") &&(frmPw.val().trim() == "")){
        $(".formid").text("아이디 입력!");
        $(".formpw").text("password 입력!")

        frmId.focus();
    } else if(frmId.val().trim() == ""){
        $(".formid").text("아이디 입력!")
        $(".formpw").text("");
        frmId.focus();
    } else if(frmPw.val().trim() == ""){
        $(".formpw").text("password 입력!")
        $(".formid").text("");
        frmPw.focus();
    }

    if(!(frmId.val().trim() == "") && !(frmPw.val().trim() == "")){
        alert('로그인성공');

        $(".formid").text("");
        $(".formpw").text("");
    }
}