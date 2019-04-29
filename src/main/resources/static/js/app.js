

//document.write("<script language=javascript src=\"/static/js/block1_script.js\"></script>");



var stompClient = null;


function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#notice").html("");
}


function connect() {
    var socket = new SockJS('/endpoint-websocket'); //连接上端点(基站)
    
    stompClient = Stomp.over(socket);			//用stom进行包装，规范协议
    stompClient.connect({}, function (frame) {	
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/game_chat', function (result) {
        	console.info(result);
        	showContent(JSON.parse(result.body));
        	controlEnd(JSON.parse(result.body));
        });
    });
}


function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}


function sendName() {
    stompClient.send("/app/v1/chat", {}, JSON.stringify({'content': $("#content").val()}));
}

/**
 * 封装后 String content, Object body, Object view
 */
function sendControl(body, view_id) {
    stompClient.send("/app/v1/chat", {}, JSON.stringify({'content': 'legend', 'body': body, 'view': view_id}));
}

//围绕view1
function sendCity(city_name) {
    stompClient.send("/app/v1/chat", {}, JSON.stringify({'content': 'city', 'view': city_name}));
}

function sendChangeStyle(view_id) {
    stompClient.send("/app/v1/chat", {}, JSON.stringify({'content': 'style', 'view': view_id}));

}

/**
 *
 */
function allAjaxRequest() {
    ajax_rader();
    ajax_map();
    ajax_block2();
    ajax_block4();
    ajax_block5();
    ajax_block6();
    ajax_block7();
}


/**
 * 接收到信息后要做的事情
 * @param msg
 */
function showContent(msg) {
    //http://47.96.3.244/index
    /**
     * msg.view为城市名
     */
    if(msg.content==='city') {
        //切换到某一个城市时执行操作
        clearInterval(timer);
        current_city = msg.view;
        changeRegion(current_city);
        allAjaxRequest();
        //轮询时间设置 目前设置为1天   一小时为3600000   半小时为1800000
        timer = setInterval('allAjaxRequest();', 86400000);
    }

    //切换风格
    if(msg.content==='style') {
        switch (msg.view)
        {
            case 6:
                linshiChangeStyle(view6);
                break;
            case 7:
                linshiChangeStyle(view7);
                break;
            default:
                break;


        }
    }

    //是否显示图标
    if(msg.content==='legend') {
        switch(msg.view)
        {
            case 1:
                linshiDisplayLegend(view1, msg.body);
                break;
            case 2:
                linshiDisplayLegend(view2, msg.body);
                break;
            case 3:
                linshiDisplayLegend(view3, msg.body);
                break;
            case 4:
                linshiDisplayLegend(view4, msg.body);
                break;
            case 5:
                linshiDisplayLegend(view5, msg.body);
                break;
            case 6:
                linshiDisplayLegend(view6, msg.body);
                break;
            case 7:
                linshiDisplayLegend(view7, msg.body);
                break;
            default:
                break;
        }
    }

}


function changeRegion(city_name) {
    for(let i = 0; i < 11; i++) {
        if(view1.option.geo.regions[i].name===city_name) {
            view1.option.geo.regions[i].selected = true;
        }else {
            view1.option.geo.regions[i].selected = false;
        }
    }
    view1.chart.setOption(view1.option);
}



function displayControl(id) {
    if($(id).is(":hidden")){
        $(id).show();    //如果元素为隐藏,则将它显现
    }else{
        $(id).hide();     //如果元素为显现,则将其隐藏
    }
}


function linshiDisplayLegend(view, legend_name) {
    for(let i = 0; i < view.legend_name_arr.length; i++) {
        if(view.legend_name_arr[i]===legend_name) {
            let legend_index = i;
            view.selected[view.legend_name_arr[legend_index]] = view.selected[view.legend_name_arr[legend_index]] !== true;
        }
    }

    view.option.legend.selected = view.selected;
    view.chart.setOption(view.option);
}


function linshiChangeStyle(view) {

    switch (view.option.series[0].type)
    {
        case 'line':
            for(let i = 0; i < view.option.series.length; i++) {
                view.option.series[i].type = 'bar';
            }
            break;
        case 'bar':
            for(let i = 0; i < view.option.series.length; i++) {
                view.option.series[i].type = 'line';
            }
            break;
        default:
            break;
    }
    view.chart.setOption(view.option);

}


function autoConnect() {
    var socket = new SockJS('/endpoint-websocket'); //连接上端点(基站)

    stompClient = Stomp.over(socket);			//用stom进行包装，规范协议
    stompClient.connect({}, function (frame) {
        //setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/game_chat', function (result) {
            console.info(result);
            showContent(JSON.parse(result.body));
        });
    });
}


/**
 *  按钮触发
 */
$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});



