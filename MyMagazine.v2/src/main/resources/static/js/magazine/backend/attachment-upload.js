$(document).ready(function () {
    $("#btnUpload").click(function () {
        var type = "file";          //后台接收时需要的参数名称，自定义即可
        var id = "inputUploadFile";            //即input的id，用来寻找值
        var formData = new FormData();
        formData.append(type, $("#" + id)[0].files[0]);    //生成一对表单属性
        $.ajax({
            type: "POST",           //因为是传输文件，所以必须是post
            url: '/admin/attachment/upload',         //对应的后台处理类的地址
            data: formData,
            processData: false,
            contentType: false,//contentType: 'application/json; charset=utf-8',//contentType: false,
            success: function (data) {
                //console.log(data.code);
                //console.log(data.message);
                if (200 == data.code) {//SUCCESS
                    swal({
                        title:"SUCCESS",
                        text:data.message,
                        type:"success",
                        showCancelButton: true,
                        confirmButtonText: "Return"
                    }).then(function () {
                        //swal("Deleted!", "Your imaginary file has been deleted.", "success");
                        window.location.href = "/admin/attachment";
                    });
                } else {//Still Error
                    swal({
                        title: "FAILURE",
                        text: data.message,
                        type: "warning",
                        showConfirmButton:false,
                        showCancelButton: true,
                        cancelButtonText:"Cancel"
                    });
                    /*swal({
                        title: "FAILURE",
                        text: data.message,
                        timer: 2000
                    });*/
                }
            },
            error: function (data) {
                swal({
                    title: "FAILURE",
                    text: data.message,
                    type: "warning",
                    showConfirmButton:false,
                    showCancelButton: true,
                    cancelButtonText:"Cancel"
                });
                //console.log(data.code);
                //console.log(data.message);
                //console.log("FAILURE.");
                // $("#h2DialogTitle").text("FAILURE");
                // $("#pDialogContent").text(data.message);
                // $("#divDialogBackground").attr("class", "modal-dialog modals-default nk-red");
                // $("#btnDialogReturn").css({"display": "none"});
                // $("#divDialog").attr("class", "modal fade in").css({"display": "block", "paddding": "17px"});
            }
        });
    });

    /*$("#btnDialogCancel").click(function () {
        $("#divDialog").attr("class", "modal fade").css({"display": "block", "paddding": "17px"});
    });
    $("#btnDialogClose").click(function () {
        $("#divDialog").attr("class", "modal fade").css({"display": "block", "paddding": "17px"});
    });
    $("#btnDialogReturn").click(function () {
        window.location.href = "/admin/attachment";
    });*/
});

// function dd() {
//     console.log(22);
//     alert("btnUploadFrom");
// }