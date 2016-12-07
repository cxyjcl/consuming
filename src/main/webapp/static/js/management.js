$("#create_btn").click(function () {
    $("#create").css('display', 'block');
    $("#update").css('display', 'none');
});
$("#update_btn").click(function () {
    $("#create").css('display', 'none');
    $("#update").css('display', 'block');
});