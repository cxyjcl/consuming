window.onload=function(){
    resize();
    $.ajax({
        contentType: "application/json",
        dataType: "json",
        type: "POST",
        url:"http://localhost:8080/info/user",
        success: function(data) {
            console.log(data.authorities.length);
            for(var i = 0;i<data.authorities.length;i++) {
                $("#nav-ul").append("<li><a href="+data.authorities[i].url+">"+data.authorities[i].authorityName+"</a></li>")
            }
            $("#username").html(data.userName);
            $("#character").html([data.characterName]);
            $("#department").html([data.department]);
        },
        error: function (data) {
            alert("你未登录！");
         //   window.location.href="http://localhost:8080/view/user/login.html"
        }
    });
};
window.onresize=function(){
    resize();
};

var resize=function(){
    document.getElementById('container').style.width=document.body.clientWidth-200+"px"
};
