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
    if($("#select_method").val()=="缺省"){
        $("#by_project_name").css('display','none');
        $("#by_name").css('display','none');
        $("#by_consuming_name").css('display','none');
        $("#by_unit_name").css('display','none');
    }
    else if($("#select_method").val()=="按耗品名称"){
        $("#by_project_name").css('display','none');
        $("#by_consuming_name").css('display','block');
        $("#by_name").css('display','none');
        $("#by_unit_name").css('display','none');
    }
    else if($("#select_method").val()=="按领用人"){
        $("#by_project_name").css('display','none');
        $("#by_consuming_name").css('display','none');
        $("#by_name").css('display','block');
        $("#by_unit_name").css('display','none');
    }
    else if($("#select_method").val()=="按项目名称"){
        $("#by_project_name").css('display','block');
        $("#by_name").css('display','none');
        $("#by_consuming_name").css('display','none');
        $("#by_unit_name").css('display','none');
    }
    else{
        $("#by_project_name").css('display','none');
        $("#by_name").css('display','none');
        $("#by_consuming_name").css('display','none');
        $("#by_unit_name").css('display','block');
    }
});
$("#audit_more,#find_more").click(function(){
    location.href="more.html"
});