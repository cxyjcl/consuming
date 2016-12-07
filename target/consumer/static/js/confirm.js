window.onload=function(){
    resize();
    var year = new Date().getFullYear();
    for(var i=5;i>0;i--)
    {
        $("#select_time").append("<option>" +year + "</option>");
        year = year-1;
    }
};
window.onresize=function(){
    resize();
};

var resize=function(){
    document.getElementById('container').style.width=document.body.clientWidth-200+"px"
};
$("#select_method").change(function(){
    if($("#select_method").val()=="按申报状态"){
        $("#by_status").css('display','block');
        $("#by_name").css('display','none');
        $("#by_consuming_name").css('display','none');
    }
    else if($("#select_method").val()=="按耗品名称"){
        $("#by_status").css('display','none');
        $("#by_consuming_name").css('display','block');
        $("#by_name").css('display','none');
    }
    else {
        $("#by_status").css('display','none');
        $("#by_name").css('display','block');
        $("#by_consuming_name").css('display','none');
    }
});
$("#audit_more,#find_more").click(function(){
    location.href="more.html"
});
$("#audit").click(function () {
    $(".audit").css('display', 'block');
    $(".find").css('display', 'none');
});
$("#find").click(function () {
    $(".audit").css('display', 'none');
    $(".find").css('display', 'block');
});