$("document").ready(function(){
	 var name ='imc';
	 var post_url = window.location.href;
	 var dec_url = decodeURIComponent(post_url);
	 name = name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
	 var regexS = "[\\?&]"+name+"=([^&#]*)";
	 var regex = new RegExp( regexS );
	 var results = regex.exec(dec_url);
	 var sliderno;
	 var replace
	 if(results != null){
		 
		 var resultImg =results[1].substring(results[1].lastIndexOf("/") +1)
		 var first = $('.bjqs li:first');
		 
		 var marker;
		 for(var i=0; i<$(".bjqs li").length;i++){
			 var imagePath = $('.bjqs li:eq('+i+') img').attr('src');
			 var image = imagePath.substring(imagePath.lastIndexOf("/")+1);
			
			 if(resultImg == image ||resultImg == 'rate.jpg' )	{
				 	replace = $('.bjqs li:eq('+i+')');
				 	marker = $('.bjqs-markers li:eq('+i+')');
			 }
		 }
		 $('.bjqs li:eq(0)').css("display","");
		 replace.css("display","list-item");
		 $('.bjqs-markers li').removeClass("active-marker");
		 marker.addClass("active-marker");
		}
	 
	 $(".bjqs-controls li").click(function(){
		 replace.css("display","");
	 })
	 $(".bjqs-markers li").click(function(){
		replace.css("display","");
	 })
	 
	 $(".pin-share").click(function(){
		 
		 var link = window.location.href;
		 var imgPath =$('.bjqs > li:visible img').prop('src');
		 var description = $('.bjqs-caption:visible span:eq(2)').text();
		 $(this).attr('href','https://pinterest.com/pin/create/button/?url='+link+'&media='+imgPath+'&description='+description)
		 javascript:window.open($(this).attr('href'),'', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');
		 return false;
	 });
 });

function fb_share(e){
	 
	var link = getLink();
	var imgPath =$('.bjqs > li:visible img').prop('src');
	var description = $('.bjqs-caption:visible span:eq(2)').text(); //$(".right-gray-cont").find('p:first').text();
	var url = "http://www.facebook.com/sharer.php?u="+link+"&picture="+imgPath+"&description="+description;
	javascript:window.open(url,'', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');
	return false;
}
function google_share(){
//	var first = $('.bjqs li:first');
//	var last =$('.bjqs li:visible');
//	first.appendTo(first.parent());
//	last.prependTo(last.parent());
	var link = "https://plus.google.com/share?url="+window.location.href;
	javascript:window.open(link,'', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');
	return false;
}
function twitter_share(){
	var link = getLink();
	var url = "https://twitter.com/home?status="+link;
	javascript:window.open(url,'', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');
	return false;
}

function linkedin_share(){
	
	var link = getLink();
	var url = "http://www.linkedin.com/shareArticle?mini=true&url="+link+"&title=Healpal LinkedIn";
	javascript:window.open(url,'', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');
	return false;
}
function getLink(){
	
	var link;
	var imgPath =$('.bjqs > li:visible img').prop('src');
	var treatment = $(".right-gray-cont h2#title").text().trim(); // to get title for browser cancer treatment
	if(treatment!=null && treatment!="" && treatment !="undefined"){
		var location = window.location.href+'&imc='+imgPath;
		return link = encodeURIComponent(location);
	}
	else{ return link = window.location.href+'?imc='+imgPath;}
}




