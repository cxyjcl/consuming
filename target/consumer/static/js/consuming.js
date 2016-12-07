var page_index = 0;
var page_count = 0;
$('#one').click(function () {
    $('.one-submit').css('display', 'block');
    $('.batch-submit').css('display', 'none');
    $('.Declaration-rejection').css('display', 'none');
    $('.edit-draft').css('display', 'none');
})
$('#batch').click(function () {
    $('.one-submit').css('display', 'none');
    $('.batch-submit').css('display', 'block');
    $('.Declaration-rejection').css('display', 'none');
    $('.edit-draft').css('display', 'none');
})
$('#rejection').click(function () {
    $('.one-submit').css('display', 'none');
    $('.batch-submit').css('display', 'none');
    $('.Declaration-rejection').css('display', 'block');
    $('.edit-draft').css('display', 'none');
    $.ajax({
        traditional: true,
        contentType: "application/json",
        dataType: "json",
        type: "POST",
        url:"http://localhost:8080/consuming/reject.do",
        success: function(data){
            $("#rejection-table").append("<tr><td>"+datai+"</td>" +
                "<td>实验员</td><td>实验课程</td><td>实验项目</td><td class='large-th'>项目计划学时</td>" +
                "<td>实验组数</td><td>实验人数</td><td>采购方式</td><td class='large-th'>需要到货时间</td>" +
                "<td class='large-th'>备注</td><td>院系驳回</td><td>设备处驳回</td><td><a class='btn  w-70 other-btn'>再次申报</a></td>" +
                "<td><a class='btn  w-70 other-btn'>删除</a></td></tr>");
            $("#pagination").pagination({pageIndex:page_index, pageCount: page_count});
        },
        error: function () {
            alert("查询数据库失败！");
        }
    });
})
$('#draft').click(function () {
    $('.one-submit').css('display', 'none');
    $('.batch-submit').css('display', 'none');
    $('.Declaration-rejection').css('display', 'none');
    $('.edit-draft').css('display', 'block');
})
$('#one-add').click(function (){
    $('#info').append("<div><div class='text-left'> <div class='input-text'>耗材名称<span class='red'>*</span>：</div> <div><input type='text' class='input w-90' list='consuming_name' name='consuming'/></div> </div> <div class='text-left'> <div class='input-text'>规格：</div> <div><input type='text' class='input w-90' name='standard'/></div> </div> <div class='text-left'> <div class='input-text'>包装：</div> <div><input type='text' class='input w-90' name='pack'/></div> </div> <div class='text-left'> <div class='input-text'>产地品牌：</div> <div><input type='text' class='input w-90' name='brand'/></div> </div> <div class='text-left'> <div class='input-text'>最小单位：</div> <div><input type='text' class='input w-90' name='unit'/></div> </div> <div class='text-left'> <div class='input-text'>数量<span class='red'>*</span>：</div> <div><input type='text' class='input w-90' name='num'/></div> </div> <div class='text-left'> <div class='input-text'>分类：</div> <div><input type='text' class='input w-90' list='classification' name='classify'/></div> </div> <div class='text-left'> <div class='input-text'>危险品：</div> <div class='text-block'> <input type='checkbox' name='is_danger' class='check'/></div> </div> <div class='text-left'> <div class='input-text'>&nbsp;</div><a class='btn w-70 remove' onclick='list_remove()'>移除</a> </div> <div class='clear'></div> </div>");
})
function list_remove(e){
	e=e||event;
	e.target.parentNode.parentNode.remove();
}

$("#submit_btn").click(function(){
    var o=[]
    var consuming=document.getElementsByName("consuming");
    var standard=document.getElementsByName("standard");
    var pack=document.getElementsByName("pack");
    var brand=document.getElementsByName("brand");
    var unit=document.getElementsByName("unit");
    var num=document.getElementsByName("num");
    var classify=document.getElementsByName("classify");
    var is_danger=document.getElementsByName("is_danger");

    var experiment_project=$("#experiment_project").val();
    var need_time=$("#need_time").val();
    var purchase_method=$("#purchase_method").val();
    var subpackage=$("#subpackage").val();
    var experimenter=$("#experimenter").val();
    var lesson=$("#lesson").val();
    var plan=$("#plan").val();
    var group=$("#group").val();
    var people=$("#people").val();
    var remark=$("#remark").val();

    var pro = {
        experiment_project:experiment_project,
        need_time:need_time,
        purchase_method:purchase_method,
        subpackage:subpackage,
        experimenter:experimenter,
        lesson:lesson,
        plan:plan,
        group:group,
        people:people,
        remark:remark
    }


    for (var  i=0;i<consuming.length;i++){
        var temp = {
            consuming :consuming[i].value,
            standard : standard[i].value,
            pack : pack[i].value,
            brand : brand[i].value,
            unit : unit[i].value,
            num : num[i].value,
            classify : classify[i].value,
            check : is_danger[i].checked
        }
        o[i]=temp;
    }
    var _data={
        'project':pro,
        'consuming':o
    }
    console.log(JSON.stringify(_data));
    $.ajax({
        traditional: true,
        contentType: "application/json",
        dataType: "json",
        type: "POST",
        url:"http://localhost:8080/consuming/consuming.do?username="+$("#username").html(),
        data:JSON.stringify(_data),
        success: function(data) {
            alert("发送成功！");
        },
        error: function (data) {
            alert("插入数据库失败！");
        }
    });
});

$("#upload").click(function (){
    var filePath=$("#excel").val();
    if(filePath.indexOf("xls")!=-1){
        $("#excel_form").attr("action", "http://localhost:8080/consuming/upload.do");
        $("#excel_form").submit();
    }else{
        alert("您未上传文件，或者您上传文件类型非xls！");
    }
})

$("#download").click(function () {
    window.open("http://localhost:8080/consuming/download.do");
    // $.ajax({
    //     type: "Post",
    //     url: "http://localhost:8080/consuming/download.do",
    //     error: function () {
    //         alert("下载失败！");
    //     }
    // })
})

//
// $("#upload").click(function () {
//     var formData = new FormData();
//     formData.append("excel", $("#excel").files[0]);
//     $.ajax({
//         url: "http://localhost:8080/consuming/upload.do",
//         type: "POST",
//         data: formData,
//         /**
//          *必须false才会自动加上正确的Content-Type
//          */
//         cache: false,
//         contentType: false,
//         /**
//          * 必须false才会避开jQuery对 formdata 的默认处理
//          * XMLHttpRequest会对 formdata 进行正确的处理
//          */
//         processData: false,
//         success: function (data) {
//             if (data.status == "true") {
//                 alert("上传成功！");
//             }
//             if (data.status == "error") {
//                 alert(data.msg);
//             }
//         },
//         error: function () {
//             alert("上传失败！");
//         }
//     });
// });