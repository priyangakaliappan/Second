var timeOut = 10;


var idleTime = 0; //here we define idle time
$("document").ready(function(){
	/* here we can call function timercount() own desire time */
	var idleInterval = setInterval("timercount()", 60000); 
	// define time 1 second = 1000, for 1 min 60x1000=60000
	/* this function check the mouse event if mouse move or 
	click then it set idleTime the value 0 */
	$(this).mousemove(function (e) {
		idleTime = 0;		
	});
	/* this function check the keyboard event
	if any key press by key board then it set idleTime the value 0 */
	$(this).keypress(function (e) {
		idleTime = 0;		
	});
});

function timercount() {
	idleTime = idleTime + 1;
	
	/* this function check target time equals to current time
	 if yes then call logout function */	
	if (idleTime == timeOut) { 
		var autoLogoutFlag = false;
		
		$.ajax({
			async:false,
			type:'post',
			url : "../auth/getSessionStatus",
			success : function(res) {
				if($.trim(res) == 'true'){
					autoLogoutFlag = true;
				}else{
					//do nothing
				}
				
				
			}
		});
		
		if(autoLogoutFlag){
			logout();
		}
	}
}

 /* It calls the logout method */
function logout(){
	window.location.href = "../auth/doLogout";	
}