function checkPassword(str){var re=/(?=.*\d)(?=.*[A-Z]).{6,}/;return re.test(str);}
function validate(){$('#create-account').val($("#loginPath").val());$("#res").html("");$("#res1").html("");$("#res").removeClass('alert alert-danger');$("#res1").removeClass('alert alert-danger');var emailed=/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;var email=$("#email").val();var username=$("#username").val();var pwd=$("#pwd").val();if(email==null||email==""){$("#res").show();$("#res").addClass('alert alert-danger');$("#res").html("Please enter Email");return false;}
else if(emailed.test(email)==false){$("#res").show();$("#res").addClass('alert alert-danger');$("#res").html("Enter valid Email Address");return false;}
else if(username==null||username==""){$("#res").show();$("#res").addClass('alert alert-danger');$("#res").html("Please enter Username");return false;}
else if(pwd==null||pwd==""){$("#res").show();$("#res").addClass('alert alert-danger');$("#res").html("Please enter Password");return false;}
else if(pwd.length<6)
{$("#res").show();$("#res").addClass('alert alert-danger');$("#res").html("Password should be atleast 6 characters long");return false;}}
$("document").ready(function(){$("#res,#Err,#res1").html("");});