'use strict';

$(document).ready(function () {
    goConnected();
});

function goConnected() {
    //if ("connected" !== $("#inputContactsActive").val()) {
    $("#page-loader").css({ "opacity": "0.8", "display": "flow" });//opacity: 0.0984771; display: none;
        $.ajax({
            url: "/admin/contacts/connected",
            async: true,
            data: {'count': 'value1', 'size': 'value2'},
            type: "GET",
            success: function (data) {
                if (200 == data.code) {
                    var resultmap = data.data;
                    var contacts_active = resultmap["contacts_active"];
                    var users = resultmap["users"];

                    $("#liConnectedActive").addClass("active");
                    $("#liRecommendedActive").removeClass("active");
                    $("#liRequestedActive").removeClass("active");
                    $("#inputContactsActive").val(contacts_active);

                    var size = users.length;
                    // if (0 != $("#aContactsCount").text().length) {
                    //     var strcount = $("#aContactsCount").text();
                    //     var intcount = parseInt(strcount);
                    //     $("#aContactsCount").text(intcount + size);
                    // } else {
                        $("#aContactsCount").text(size);
                    //}
                    //console.log(resultmap["contacts_active"]);

                    $("#divConnectedContent").show();
                    $("#divRecommendedContent").hide();
                    $("#divRequestedContent").hide();
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
    //}
}

/**
 * append() - 在被选元素的结尾插入内容
 * prepend() - 在被选元素的开头插入内容
 * after() - 在被选元素之后插入内容
 * before() - 在被选元素之前插入内容
 */
function onLoadMore() {
    $("#page-loader").css({ "opacity": "0.8", "display": "flow" });
    $.ajax({
        url: "/admin/contacts/load",
        async: true,
        data: {'count': 'value1', 'size': 'value2'},
        type: "GET",
        success: function (data) {
            if (200 == data.code) {
                var resultmap = data.data;
                //var contacts_active = resultmap["contacts_active"];
                var users = resultmap["users"];
                var size = users.length;

                if (0 != $("#aContactsCount").text().length) {
                    var strcount = $("#aContactsCount").text();
                    var intcount = parseInt(strcount);
                    $("#aContactsCount").text(intcount + size);
                } else {
                    $("#aContactsCount").text(size);
                }
                //console.log(resultmap["contacts_active"]);

                //$("#divConnectedRow").html("");
                jQuery.each(users, function (i, item) {
                    //console.log(item.username + "," + item.email + "," + item.avatar);
                    $("#divConnectedRow").append("<div class='col-md-2 col-sm-4'><div class='contacts__item'><a href='' class='contacts__img'><img src='" + item.avatar + "' alt=''></a><div class='contacts__info'><strong>" + item.username + "</strong><small>" + item.email + "</small></div><button class='contacts__btn btn btn--icon-text btn--light'><i class='zmdi zmdi-account-box-mail zmdi-hc-fw'></i>Unfollow</button></div></div>");
                });
            }
            $("#page-loader").css({ "opacity": "0.0984771", "display": "none" });
        },
        error: function (e) {
            $("#page-loader").css({ "opacity": "0.0984771", "display": "none" });
            alert(e);
        }
    });
}

function goRecommended() {
    //if ("recommended" !== $("#inputContactsActive").val()) {
    $("#page-loader").css({ "opacity": "0.8", "display": "flow" });
        $.ajax({
            url: "/admin/contacts/recommended",
            async: true,
            data: {'count': 'value1', 'size': 'value2'},
            type: "GET",
            success: function (data) {
                if (200 == data.code) {
                    var resultmap = data.data;
                    var contacts_active = resultmap["contacts_active"];
                    var users = resultmap["users"];

                    $("#liConnectedActive").removeClass("active");
                    $("#liRecommendedActive").addClass("active");
                    $("#liRequestedActive").removeClass("active");
                    $("#inputContactsActive").val(contacts_active);

                    var size = users.length;
                    // if (0 != $("#aContactsCount").text().length) {
                    //     var strcount = $("#aContactsCount").text();
                    //     var intcount = parseInt(strcount);
                    //     $("#aContactsCount").text(intcount + size);
                    // } else {
                        $("#aContactsCount").text(size);
                    //}
                    //console.log(resultmap["contacts_active"]);

                    $("#divConnectedContent").hide();
                    $("#divRecommendedContent").show();
                    $("#divRequestedContent").hide();
                    $("#divRecommendedRow").html("");
                    jQuery.each(users, function (i, item) {
                        //console.log(item.username + "," + item.email + "," + item.avatar);
                        $("#divRecommendedRow").append("<div class='col-md-2 col-sm-4'><div class='contacts__item'><a href='' class='contacts__img'><img src='" + item.avatar + "' alt=''></a><div class='contacts__info'><strong>" + item.username + "</strong><small>" + item.email + "</small></div><button class='contacts__btn btn btn--icon-text btn--light'><i class='zmdi zmdi-account-add zmdi-hc-fw'></i>Add</button></div></div>");
                    });
                }
                $("#page-loader").css({ "opacity": "0.0984771", "display": "none" });
            },
            error: function (e) {
                $("#page-loader").css({ "opacity": "0.0984771", "display": "none" });
                alert(e);
            }
        });
    //}
}

function onRefresh() {
    $("#page-loader").css({ "opacity": "0.8", "display": "flow" });
    $.ajax({
        url: "/admin/contacts/refresh",
        async: true,
        data: {'count': 'value1', 'size': 'value2'},
        type: "GET",
        success: function (data) {
            if (200 == data.code) {
                var resultmap = data.data;
                //var contacts_active = resultmap["contacts_active"];
                var users = resultmap["users"];
                var size = users.length;

                // if (0 != $("#aContactsCount").text().length) {
                //     var strcount = $("#aContactsCount").text();
                //     var intcount = parseInt(strcount);
                //     $("#aContactsCount").text(intcount + size);
                // } else {
                    $("#aContactsCount").text(size);
                //}
                //console.log(resultmap["contacts_active"]);

                $("#divRecommendedRow").html("");
                jQuery.each(users, function (i, item) {
                    //console.log(item.username + "," + item.email + "," + item.avatar);
                    $("#divRecommendedRow").append("<div class='col-md-2 col-sm-4'><div class='contacts__item'><a href='' class='contacts__img'><img src='" + item.avatar + "' alt=''></a><div class='contacts__info'><strong>" + item.username + "</strong><small>" + item.email + "</small></div><button class='contacts__btn btn btn--icon-text btn--light'><i class='zmdi zmdi-account-add zmdi-hc-fw'></i>Add</button></div></div>");
                });
            }
            $("#page-loader").css({ "opacity": "0.0984771", "display": "none" });
        },
        error: function (e) {
            $("#page-loader").css({ "opacity": "0.0984771", "display": "none" });
            alert(e);
        }
    });
}

function goRequested() {
    //if ("requested" !== $("#inputContactsActive").val()) {
    $("#page-loader").css({ "opacity": "0.8", "display": "flow" });
        $.ajax({
            url: "/admin/contacts/requested",
            async: true,
            data: {'count': 'value1', 'size': 'value2'},
            type: "GET",
            success: function (data) {
                if (200 == data.code) {
                    var resultmap = data.data;
                    var contacts_active = resultmap["contacts_active"];
                    var users = resultmap["users"];

                    $("#liConnectedActive").removeClass("active");
                    $("#liRecommendedActive").removeClass("active");
                    $("#liRequestedActive").addClass("active");
                    $("#inputContactsActive").val(contacts_active);

                    var size = users.length;
                    // if (0 != $("#aContactsCount").text().length) {
                    //     var strcount = $("#aContactsCount").text();
                    //     var intcount = parseInt(strcount);
                    //     $("#aContactsCount").text(intcount + size);
                    // } else {
                    $("#aContactsCount").text(size);
                    //}
                    //console.log(resultmap["contacts_active"]);

                    $("#divConnectedContent").hide();
                    $("#divRecommendedContent").hide();
                    $("#divRequestedContent").show();
                    $("#divRequestedRow").html("");
                    jQuery.each(users, function (i, item) {
                        //console.log(item.username + "," + item.email + "," + item.avatar);
                        $("#divRequestedRow").append("<div class='col-md-2 col-sm-4'><div class='contacts__item'><a href='' class='contacts__img'><img src='" + item.avatar + "' alt=''></a><div class='contacts__info'><strong>" + item.username + "</strong><small>" + item.email + "</small></div><button class='contacts__btn btn btn--icon-text btn--light'><i class='zmdi zmdi-account-add zmdi-hc-fw'></i>Add</button></div></div>");
                    });
                }
                $("#page-loader").css({ "opacity": "0.0984771", "display": "none" });
            },
            error: function (e) {
                $("#page-loader").css({ "opacity": "0.0984771", "display": "none" });
                alert(e);
            }
        });
    //}
}