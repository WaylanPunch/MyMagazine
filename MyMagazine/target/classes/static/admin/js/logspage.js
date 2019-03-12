'use strict';

$(document).ready(function () {
    getlogslist();
});

function getlogslist() {
    $("#page-loader").css({ "opacity": "0.8", "display": "flow" });//opacity: 0.0984771; display: none;
    $.ajax({
        url: "/admin/logs/list",
        async: true,
        data: {'count': 'value1', 'size': 'value2'},
        type: "GET",
        success: function (data) {
            if (200 == data.code) {
                var resultmap = data.data;
                var users = resultmap["logs"];

                var size = users.length;
                // if (0 != $("#aContactsCount").text().length) {
                //     var strcount = $("#aContactsCount").text();
                //     var intcount = parseInt(strcount);
                //     $("#aContactsCount").text(intcount + size);
                // } else {
                $("#aContactsCount").text(size);
                //}

                $("#divConnectedRow").html("");
                jQuery.each(users, function (i, item) {
                    //console.log(item.username + "," + item.email + "," + item.avatar);
                    $("#divConnectedRow").append("<div class='col-md-2 col-sm-4'><div class='contacts__item'><a href='' class='contacts__img'><img src='" + item.avatar + "' alt=''></a><div class='contacts__info'><strong>" + item.username + "</strong><small>" + item.email + "</small></div><button class='contacts__btn btn btn--icon-text btn--light'><i class='zmdi zmdi-account-box-mail zmdi-hc-fw'></i>Unfollow</button></div></div>");
                });
            }
            //delay(3000);
            $("#page-loader").css({ "opacity": "0.0984771", "display": "none" });
        },
        error: function (e) {
            $("#page-loader").css({ "opacity": "0.0984771", "display": "none" });
            alert(e);
        }
    });
}
