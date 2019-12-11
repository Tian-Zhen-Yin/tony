function checkLogin() {
    var username=document.getElementsByName("userid").value;
    var userpwd=document.getElementsByName("password").value;
    var vegName=/^[a-zA-Z0-9]+$/;
    if(!vegName.test(username)){
        alert("用户名错误，请重新输入");
        document.getElementsByName("userid").focus();
        return false;
    }
    var regPwd=/^\w{6,}$/;
    if(!regPwd.test(userpwd)){
        alert("密码输入错误，请重新输入");
        document.getElementsByName("password").select();
        return false;
    }
    return true;

}