$("#update_btn").click(function () {
    $("#update").css('display', 'block');
    $("#create").css('display', 'none');
})
$("#create_btn").click(function () {
    $("#update").css('display', 'none');
    $("#create").css('display', 'block');
})
$("#confirm").click(function (){
    var userValue=$("#username").val();
    var realValue=$("#real_name").val();
    var password=$("#password").val();
    var re_password=$("#re_password").val();
    var email=$("#email").val();
    var strcheck=/[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im;
    var mailcheck=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    if(userValue==""){
        $("#errorMessage").html("用户名不得为空");
    }
    else if(realValue==""){
        $("#errorMessage").html("真实姓名不得为空");
    }
    else if(password!=re_password){
        $("#errorMessage").html("两次密码不一致");
    }
    else if(email==""){
        $("#errorMessage").html("邮箱不得为空");
    }
    else if(strcheck.test(userValue)){
        $("#errorMessage").html("用户名不能包含空格\\<>等非法字符");
    }
    else if(strcheck.test(password)){
        $("#errorMessage").html("密码不能包含空格\\<>等非法字符");
    }
    else if(strcheck.test(re_password)){
        $("#errorMessage").html("密码不能包含空格\\<>等非法字符");
    }
    else if(!mailcheck.test(email)){
        $("#errorMessage").html("邮箱格式不正确");
    }
    else
    {
        $("#errorMessage").html("请稍后！");
        var _data = {
            'username': userValue,
            'password': password,
            'realName': realValue,
            'email' : email,
            'character' :$("#character").val(),
            'department' :$("#department").val()
        };
        $.ajax({
            url: "http://localhost:8080/user/addUser.do",
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(_data),
            success: function (data) {
                $("#errorMessage").html("添加成功！");
            },
            error: function (data) {
                $("#errorMessage").html("添加数据库失败！")
            }
        });
    }
})