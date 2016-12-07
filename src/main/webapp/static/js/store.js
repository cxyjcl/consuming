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
    if($("#select_method").val()=="仅按年份"){
        $("#by_name").css('display','none');
    }
    else if($("#select_method").val()=="按年份+院系"){
        $("#by_name").css('display','block');
        $("#by_consuming_name").css('display','none');
        $("#by_equipmenter_name").css('display','none');
        $("#by_project_name").css('display','none');
    }
    else if($("#select_method").val()=="按耗品名称（含年份+院系）"){
        $("#by_name").css('display','block');
        $("#by_consuming_name").css('display','block');
        $("#by_equipmenter_name").css('display','none');
        $("#by_project_name").css('display','none');
    }
    else if($("#select_method").val()=="按实验员（含年份+院系）"){
        $("#by_name").css('display','block');
        $("#by_consuming_name").css('display','none');
        $("#by_equipmenter_name").css('display','block');
        $("#by_project_name").css('display','none');
    }
    else{
        $("#by_name").css('display','block');
        $("#by_consuming_name").css('display','none');
        $("#by_equipmenter_name").css('display','none');
        $("#by_project_name").css('display','block')
    }
});
$("#audit_more,#find_more").click(function(){
    location.href="more.html"
});