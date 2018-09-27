'use strict';

/**
 * append() - 在被选元素的结尾插入内容
 * prepend() - 在被选元素的开头插入内容
 * after() - 在被选元素之后插入内容
 * before() - 在被选元素之前插入内容
 */
function onLoadMore() {
    $.ajax({
        url: "/admin//contacts/load",
        async: true,
        data: {'count': 'value1', 'size': 'value2'},
        type: "GET",
        success: function (data) {
            var strcount = $("#aContactsCount").text();
            var intcount = parseInt(strcount);
            $("#aContactsCount").text(intcount + data.length);
            jQuery.each(data, function (i, item) {
                //console.log(item.username + "," + item.email + "," + item.avatar);
                $("#divContactsRow").append("<div class='col-md-2 col-sm-4'><div class='contacts__item'><a href='' class='contacts__img'><img src='" + item.avatar + "' alt=''></a><div class='contacts__info'><strong>" + item.username + "</strong><small>" + item.email + "</small></div><button class='contacts__btn btn btn--icon-text btn--light'><i class='zmdi zmdi-account-box-mail zmdi-hc-fw'></i>Unfollow</button></div></div>");
            });
        },
        error: function (e) {
            alert(e);
        }
    });
}