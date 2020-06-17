var viewItem = "uid=0&depth=1"; 

$(document).ready(function(){
	// 게시판 목록 1페이지 로딩
	loadPage();
	
	
	$("#first").change(function(){
		console.log($('#first option:selected').val());
		if($('#first option:selected').val() == '선택하세요---'){
			$('#second').attr('disabled', true);
			$('#second').html("");
			$('#third').attr('disabled', true);
			$('#third').html("");
			return ;
		}
		viewItem = "uid="+$('#first option:selected').attr('data-uid')+"&depth="+(parseInt($('#first option:selected').attr('data-depth'))+1);
		console.log(viewItem);
		loadPage();
	});
	
	$("#second").change(function(){
		if($('#second option:selected').val() == '선택하세요---'){
			$('#third').attr('disabled', true);
			$('#third').html("");
			return ;
		}
		viewItem = "uid="+$('#second option:selected').attr('data-uid')+"&depth="+(parseInt($('#second option:selected').attr('data-depth'))+1);
		console.log(viewItem);
		loadPage();
	});
});

function loadPage(){
	$.ajax({
		url : "cate_list.ajax",
		type : "POST",
		data : viewItem,
		cache : false,
		success : function(data, status){
			if(status == "success"){
				console.log(data);
				updateList(data);
			}
		}
	})
}

function updateList(jsonObj){
	result = "<option>선택하세요---</option>"; 
	
	if(jsonObj.status == "OK"){
		
		var count = jsonObj.count;
		
		var i;
		var items = jsonObj.data;   // 배열
		
		for(i = 0; i < count; i++){
			$('.cate span:nth-child('+ items[0].depth + ') select').attr("disabled", false);
			result += "<option class= 'optionf' data-uid='"+ items[i].uid+"' data-depth='"+ items[i].depth+"'>" + items[i].name + "</option>"
			
		} 
		$('.cate span:nth-child('+ items[0].depth + ') select').html(result);
		$('.cate span:nth-child('+ (items[0].depth + 1) + ') select').attr("disabled", true);
		$('.cate span:nth-child('+ (items[0].depth + 1) + ') select').html("");
		return true;
	} else {
		alert(jsonObj.message);
		return false;
	}
	return false;
} 