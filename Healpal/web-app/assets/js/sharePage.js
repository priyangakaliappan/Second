$("document").ready(function(){
$(".pin_ico").click(function(){
		 var link = window.location.href;
		 if($(".img-banner").prop('src')!="" && $(".img-banner").prop('src')!=null && $(".img-banner").prop('src')!='undefined'){
			 var imgPath =$('.img-banner').prop('src'); 
		 }
		 else{
			 var imgPath =$('.img-ban').prop('src');
		 }		
		 $(this).attr('href','https://pinterest.com/pin/create/button/?url='+link+'&media='+imgPath)
		 javascript:window.open($(this).attr('href'),'', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');
		 return false;
	 });

	
});

function fb_share(e){
	 if($(".img-banner").prop('src')!="" && $(".img-banner").prop('src')!=null){
		var imgPath =$('.img-banner').prop('src');
	 }
	 else{
		 var imgPath ="https://healpal.me/assets/new-design/img/logo2.jpg";//$('.img-ban').prop('src'); 
	 }
		var link = window.location.href;
		//var description = $('.bjqs-caption:visible span:eq(2)').text(); //$(".right-gray-cont").find('p:first').text();
		var url = "http://www.facebook.com/sharer.php?u="+link+"&picture="+imgPath;
		javascript:window.open(url,'', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');
		return false;
	}