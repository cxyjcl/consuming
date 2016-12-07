
$("#login-a").click(function () {
    $("#login").show();
    $("#forget").hide();
});
$("#forget-a").click(function () {
    $("#forget").show();
    $("#login").hide();
});
$("#change").click(function(){
    $("#verify_img").attr("src","http://localhost:8080/verifyCode?time="+new Date().getTime());
})
$("#submitButton").click(function(){
    var userValue=$("#username").val();
    var wordValue=$("#password").val();
    var codeValue=$("#verifyCode").val();
    var strcheck=/[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im;
    if(userValue==""){
        $("#errorMessage").html("用户名不得为空");
    }
    else if(wordValue==""){
        $("#errorMessage").html("密码不得为空");
    }
    else if(codeValue==""){
        $("#errorMessage").html("验证码不得为空");
    }
    else if(strcheck.test(userValue)){
        $("#errorMessage").html("用户名不能包含空格\\<>等非法字符");
    }
    else if(strcheck.test(wordValue)){
        $("#errorMessage").html("密码不能包含空格\\<>等非法字符");
    }
    else if(strcheck.test(codeValue)){
        $("#errorMessage").html("验证码不能包含空格\\<>等非法字符");
    }
    else{
        $("#errorMessage").html("请稍等....");
        var _data={
            'username':userValue,
            'password':wordValue,
            'verifyCode':codeValue
        };
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url:"http://localhost:8080/user/login.do",
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            data:JSON.stringify(_data),
            success:function(data){
                console.log(data);
                console.log(data.content);
                if(data.code!="10000"){
                    $("#errorMessage").html(data.content);
                    $("#verify_img").attr("src","http://localhost:8080/verifyCode?time="+new Date().getTime());
                }else{
                    window.location.href="http://localhost:8080/view/component/default.html"
                }
            }
        });
    }
});
$("#findButton").click(function(){
    var findUser = $("#find_user").val();
    var wordValue=$("#new_password").val();
    var rewordValue=$("#renew_password").val();
    var forgetCode =$("#forget_code").val();
    console.log(forgetCode);
    var strcheck=/[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im;
    console.log(findUser);
    if(findUser==""){
        $("#findErrorMessage").html("用户名不能为空!");
    }
    else if(strcheck.test(findUser)){
        $("#findErrorMessage").html("用户名不能包含空格\\<>等非法字符");
    }
    else if(wordValue!=rewordValue){
        $("#findErrorMessage").html("密码不一致");
    }
    else if(strcheck.test(rewordValue)||strcheck.test(wordValue)){
        $("#findErrorMessage").html("密码不能包含空格\\<>等非法字符");
    }
    else if(forgetCode==""){
        $("#findErrorMessage").html("验证码不能为空!");
    }
    else if(strcheck.test(forgetCode)){
        $("#findErrorMessage").html("验证码不能包含空格\\<>等非法字符");
    }
    else if(rewordValue==""||wordValue==""){
        $("#findErrorMessage").html("密码不得为空");
    }
    else{
        $("#findErrorMessage").html("请稍等....");
        var _data={
            'forgetCode':forgetCode,
            'username':findUser,
            'newPassword':wordValue,
        }
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            contentType: "application/json",
            url:"http://localhost:8080/user/forgetPassword.do",
            dataType: "json",
            async:true,
            type: "POST",
            data:JSON.stringify(_data),
            success:function(data){
                console.log(data.content);
                $("#findErrorMessage").html(data.content);
            }
        });
    }
})
var intDiff = parseInt(60);//倒计时总秒数量
function timer(intDiff){
    $("#send").attr('disabled',"true");
    var time=window.setInterval(function(){
        if(intDiff > 0){
            $("#send").html(intDiff+"s后再发送");
            intDiff--;
         }
        else{
            $("#send").removeAttr("disabled");
            $("#send").html("发送验证码");
            clearInterval(time);
        }
    }, 1000);
}
$("#send").click(function(){
    var findUser = $("#find_user").val();
    var strcheck=/[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im;
    var content ="您好,您的验证码是";
    var _data={
        'username':findUser,
        'content':content
    };
    console.log(findUser);
    if(findUser==""){
        $("#findErrorMessage").html("用户名不能为空!");
    }
    else if(strcheck.test(findUser)){
        $("#findErrorMessage").html("用户名不能包含空格\\<>等非法字符");
    }
    else{
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url:"http://localhost:8080/user/sendEmail.do",
            async:true,
            contentType: "application/json",
            dataType: "json",
            type: "POST",
            data:JSON.stringify(_data),
            success:function(data){
                timer(intDiff);
                $("#findErrorMessage").html(data.content);
            }
        });
    }
});