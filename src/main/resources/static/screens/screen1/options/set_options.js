//option1
//var myChart1 = echarts.init(document.getElementById('block1'));
//myChart1.setOption(option1);
//view1.init();



//option2

//option3
var myChart3 = echarts.init(document.getElementById('block3'),'dark');
myChart3.setOption(option3);
var view3 = new View(myChart3, option3);
view3.init();
//option4
var myChart4 = echarts.init(document.getElementById('block4'));
myChart4.setOption(option4);
var view4 = new View(myChart4, option4);
view4.init();


//option6
var myChart6 = echarts.init(document.getElementById('block6'),'dark');
myChart6.setOption(option6);
var view6 = new View(myChart6, option6);
view6.init();

//option7
var myChart7 = echarts.init(document.getElementById('block7'),'dark');
myChart7.setOption(option7);
var view7 = new View(myChart7, option7);
view7.init();
//getAirIndex('杭州市');


//定时器写在这里 ajax function写在对应的option里



/*
setInterval(function () {
    sendAjax();
}, 5000);
*/

