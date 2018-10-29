/*
 * newlookOpening jQuery Library
 * Version: v 0.9.0
 * 
 * http://www.newlook.com/
 * Copyright (c) 2017 NewLook (http://www.newlook.com)
 * Licensed under the MIT License
 */


(function ($) {

    $.fn.newlookOpening = function (options) {
        var settings = $.extend({
            'http': 'http://',
            'host': '',
            'port': '',
            'path': '/',
            'project': '',
            'openingCode': '',
            // 'uid' : '',
        }, options);

        var http = settings.http;
        var host = settings.host;
        var port = settings.port;
        var path = (settings.path == '/') ? '' : settings.path;
        var project = settings.project;
        var openingCode = settings.openingCode;

        var mainHost = http + host + ':' + port + path + project;
        var uid;
        var isShared = false;
        var shakeCount = 0;
        var mySwiper;
        var openingData;
        var prizeData;
        var drawList;
        var shakeFlag = false;

        //shake variable
        var last_update = 0;
        var x = y = z = last_x = last_y = last_z = 0;
        var SHAKE_THRESHOLD = 1000;

        main();

        //Function
        function main() {
            addOpeningEvent();

            uid = randomWord(false, 32);
            console.log(uid);

            if (window.DeviceOrientationEvent) {
                window.addEventListener('devicemotion', devicemotionHandler);
            } else {
                alert("Sorry your browser doesn't support Device Orientation");
            }

            doEventOpeningData();
        }

        function randomWord(randomFlag, min, max) {
            var str = '',
                range = min,
                arr = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'];
            // arr = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];

            if (randomFlag) {
                range = Math.round(Math.random() * (max - min)) + min;
            }
            ;

            for (var i = 0; i < range; i++) {
                var pos = Math.round(Math.random() * (arr.length - 1));
                str += arr[pos];
            }
            return str;
        }

        function initOpeningData(data) {
            openingData = data;
            resetHomePage();
            var startTime = new Date(openingData.startTime);
            var endTime = new Date(openingData.endTime);
            console.log(startTime);
            console.log(endTime);
        }

        function addOpeningEvent() {
            //Event Opening Page
            $('.container-modal .modal-close').on("click", function () {
                $('#prizeModal').fadeOut();
                $('#shakeModal').fadeOut();
                $('#thanksModal').fadeOut();
                shakeFlag = false;
            });
            $('.container-modal .modal-share-btn').on("click", function () {
                $('#shareModal').fadeIn();
                shakeFlag = true;
            });
            $('.container-modal .modal-share-close').on("click", function () {
                $('#shareModal').fadeOut();
                shakeFlag = false;
            });

            $('#shareFriends').on("click", function () {
                callShareFun();
            });
            $('#shakeBtn').on("click", function () {
                if (!shakeFlag) {
                    callShakeFun();
                }
                ;
            });
            $('#bagBtn').on("click", function () {
                window.location.href = 'mybag.html?uid=' + uid;
            });
            $('#ruleBtn').on("click", function () {
                $('#ruleModal').fadeIn();
                shakeFlag = true;
            });
            $('.container-modal-rule .rule-close').on("click", function () {
                $('#ruleModal').fadeOut();
                shakeFlag = false;
            });
        }

        function resetHomePage() {
            // if (!openingData.enabled) {
            // 	$('#shakeModal').fadeIn();
            // }
        }

        function callShareFun() {
            var curTime = new Date().getTime();
            var parameterJSON = JSON.stringify({
                "uid": uid,
                "sharedOccurTime": curTime,
                "event": {
                    "openingCode": openingCode
                }
            });
            doSharedEventsShare(parameterJSON);
        }

        function callShakeFun() {
            shakeFlag = true;
            var haveChance = true;
            console.log(haveChance);
            if (!isShared) {
                if (shakeCount > 0) {
                    haveChance = false;
                    var confirmMsg = confirm("分享给朋友，可以再多摇1次奖哦！");
                    if (confirmMsg) {
                        $('#shareModal').fadeIn();
                        shakeFlag = true;
                    } else {
                        shakeFlag = false;
                    }
                    ;
                }
                ;
            }
            ;

            if (haveChance) {
                var curTime = new Date().getTime();
                var parameterJSON = JSON.stringify({
                    "uid": uid,
                    "occurTime": curTime,
                    "event": {
                        "openingCode": openingCode
                    }
                });
                doCouponsDraw(parameterJSON);
            }
            ;
        }

        function showPrizeModal(data) {
            shakeFlag = true;
            if (!data) {
                $('#thanksModal').fadeIn();
                shakeFlag = true;
            } else {
                prizeData = data;
                //洗脸机 1, 唇膏 2, 50元 3, 5元 4;
                if (data.coupon.oid == 9) {
                    $('#thanksModal').fadeIn();
                    shakeFlag = true;
                } else {
                    $('#prizeModal').fadeIn();
                    shakeFlag = true;
                    $('#prizeName').text(data.coupon.name + '！');
                    $('#prizeImg').removeClass('prize-img1 prize-img2 prize-img3 prize-img4');
                    $('#prizeImg').addClass('prize-img' + data.coupon.oid);
                }
            }
            ;
        }

        function devicemotionHandler(event) {
            var acceleration = event.accelerationIncludingGravity;
            var curTime = new Date().getTime();

            if ((curTime - last_update) > 100) {
                var diffTime = curTime - last_update;
                last_update = curTime;
                x = acceleration.x;
                y = acceleration.y;
                z = acceleration.z;
                var speed = Math.abs(x + y + z - last_x - last_y - last_z) / diffTime * 10000;

                if (!shakeFlag) {
                    if (speed > SHAKE_THRESHOLD) {
                        callShakeFun();
                    }
                }
                ;

                last_x = x;
                last_y = y;
                last_z = z;
            }
            ;
        }

        //Interface Function
        function doEventOpeningData(parameter) {		//根据开业代码获得当前活动信息
            var url = mainHost + '/service/events/' + openingCode;
            $.get(
                url,
                parameter,
                function (json) {
                    console.log(json);
                    if (!json.success) {
                        alert(json.status);
                    } else {
                        if (json.data) {
                            initOpeningData(json.data);
                        }
                        ;
                    }
                }
            );
        }

        function doCouponsDraw(parameter) {			//抽奖
            var url = mainHost + '/service/coupons/draw';
            $.ajax({
                type: "POST",
                url: url,
                data: parameter,
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (json) {
                    console.log(json);
                    showPrizeModal(json.data);
                    shakeCount++;
                },
                error: function (json) {
                    console.log(json);
                    shakeFlag = false;
                    showErrorMessage(json.responseJSON.error);
                }
            });
        }


        function doSharedEventsShare(parameter) {	//分享活动页面
            var url = mainHost + '/service/shared-events/share';
            $.ajax({
                type: "POST",
                url: url,
                data: parameter,
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (json) {
                    console.log(json);
                    isShared = true;
                    alert('分享成功');
                    $('#prizeModal').fadeOut();
                    $('#thanksModal').fadeOut();
                    $('#shareModal').fadeOut();
                    shakeFlag = false;
                },
                error: function (json) {
                    console.log(json);
                    showErrorMessage(json.responseJSON.error);
                }
            });
        }

        //ErrorCode and Exception
        function showErrorMessage(error) {
            if (!error.errorCode) {
                //
            } else {
                switch (error.errorCode) {
                    case '0x010203003':
                        alert('奖券已失效或兑奖时间已过');
                        break;
                    case '0x010203006':
                        alert('今天的摇奖次数已用完');
                        break;
                    case '0x010201001': //uid is required.
                        alert('数据异常，请稍后再试');
                        break;
                    default:
                        alert(error.developerMessage);
                }
            }
            ;
        }
    };

    $.fn.newlookMybag = function (options) {
        var settings = $.extend({
            'http': 'http://',
            'host': '',
            'port': '',
            'path': '/',
            'project': '',
            'openingCode': '',
            // 'uid' : '',
        }, options);

        var http = settings.http;
        var host = settings.host;
        var port = settings.port;
        var path = (settings.path == '/') ? '' : settings.path;
        var project = settings.project;
        var openingCode = settings.openingCode;

        var mainHost = http + host + ':' + port + path + project;
        var uid;
        var isShared = false;
        var shakeCount = 0;
        var mySwiper;
        var openingData;
        var prizeData;
        var drawList;
        var shakeFlag = false;

        mainBybag();

        //Function
        function mainBybag() {
            addMybagEvent();

            uid = getUid();
            console.log(uid);

            resetBagPage();
        }

        function addMybagEvent(argument) {
            //Event Mybag Page
            $('#backBtn1, #emptyBackBtn').on("click", function () {
                window.location.href = 'index.html';
            });

            $('.bag-modal .modal-close').on("click", function () {
                $('#bagModal').fadeOut();
            });
            $('.bag-modal .modal-close2').on("click", function () {
                $('#confirmCover').fadeOut();
            });

            $('#confirmBtn').on("click", function () {
                $('#confirmCover').fadeIn();
            });
            $('#destroyBtn').on("click", function () {
                var oid = $(this).attr('data-id');
                var curTime = new Date().getTime();
                var parameterJSON = JSON.stringify({
                    "oid": oid,
                    "uid": uid,
                    "usedOccurTime": curTime
                });

                doCouponsUse(parameterJSON);
            });
        }

        function getUid() {
            var id;
            var request = getRequest();
            if (request) {
                id = request.uid;
            }
            ;
            return id;
        }

        function getRequest() {
            var url = location.search;
            var theRequest = new Object();
            if (url.indexOf("?") != -1) {
                var str = url.substr(1);
                strs = str.split("&");
                for (var i = 0; i < strs.length; i++) {
                    theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
                }
            } else {
                theRequest = null;
            }
            ;
            return theRequest;
        }

        function resetBagPage() {
            $('#bagLoading').addClass('show');
            $('#bagEmpty').removeClass('show');
            $('#bagList').removeClass('show');

            drawList = null;

            if (uid) {
                doCouponsList();
            } else {
                $('#bagLoading').removeClass('show');
                $('#bagEmpty').addClass('show');
            }
            ;
        }

        function showBagList(data) {
            $('#bagLoading').removeClass('show');

            if (data.length <= 0) {
                $('#bagEmpty').addClass('show');
            } else {
                drawList = data;
                $('#bagList').empty();
                var convertHtml = '';
                for (var i = 0; i < drawList.length; i++) {
                    if (drawList[i].coupon.oid != 9) {
                        var itemHtml = '';
                        var iconStyle = (drawList[i].coupon.oid == 3 || drawList[i].coupon.oid == 4) ? 'coupon' : 'gift';
                        var iconDisableStyle = (drawList[i].used) ? 'icon-disable' : '';
                        var coverStyle = (drawList[i].used) ? 'show' : '';
                        var btnText = (drawList[i].used) ? '已领取' : '点击查看';
                        itemHtml += '<div id="item' + drawList[i].oid + '" class="container-baglist-item">';
                        itemHtml += '<div class="item-icon"><div class="icon-left icon-' + iconStyle + ' ' + iconDisableStyle + '"></div></div>';
                        itemHtml += '<div class="item-box"><div class="item-disalbe-cover ' + coverStyle + '"></div><div class="item-content">';
                        itemHtml += '<div class="item-title">' + drawList[i].coupon.name + '</div>';
                        itemHtml += '<div class="item-img prize-img' + drawList[i].coupon.oid + '"></div>';
                        itemHtml += '<div class="item-btn">' + btnText + '</div>';
                        itemHtml += '</div></div></div>';

                        convertHtml += itemHtml;
                    }
                    ;
                }
                ;

                if (convertHtml == '') {
                    $('#bagEmpty').addClass('show');
                } else {
                    $('#bagList').addClass('show');
                    $('#bagList').html(convertHtml);
                }
                ;

                $('.container-baglist-item .item-btn').on("click", function () {
                    $('#bagModal').fadeIn();
                    var oid = $(this).parent().parent().parent().attr('id').substring(4);
                    showBagModal(oid);
                });
            }
            ;
        }

        function showBagModal(oid) {
            if (!oid) {
                //
            } else {
                var drawItem;
                for (var i = 0; i < drawList.length; i++) {
                    if (drawList[i].oid == oid) {
                        drawItem = drawList[i];
                    }
                    ;
                }
                ;

                $('#bagName').text(drawItem.coupon.name + '！');
                $('#bagImg').removeClass('prize-img1 prize-img2 prize-img3 prize-img4');
                $('#bagImg').addClass('prize-img' + drawItem.coupon.oid);
                $('#destroyBtn').attr('data-id', oid);
            }
            ;
        }

        //Interface Function
        function doCouponsList(parameter) {			//查询当前活动的用户抽到的奖品列表
            var url = mainHost + '/service/coupons/' + openingCode + '?uid=' + uid;

            $.get(
                url,
                parameter,
                function (json) {
                    console.log(json);
                    if (!json.success) {
                        // alert(json.status);
                    } else {
                        showBagList(json.data);
                    }
                }
            );
        }

        function doCouponsUse(parameter) {			//使用奖品
            var url = mainHost + '/service/coupons/use';
            $.ajax({
                type: "PUT",
                url: url,
                data: parameter,
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (json) {
                    console.log(json);
                    $('#bagModal').fadeOut();
                    $('#confirmCover').fadeOut();
                    resetBagPage();
                },
                error: function (json) {
                    console.log(json);
                    showErrorMessage(json.responseJSON.error);
                }
            });
        }
    };

})(jQuery);
