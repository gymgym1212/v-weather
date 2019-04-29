
// option7 = {
//     title: {
//         text: '气体浓度',
//         top: 20,
//         textStyle: {
//             color: '#ccc'
//         }
//     },
//     tooltip : {
//         trigger: 'axis',
//         axisPointer : {            // 坐标轴指示器，坐标轴触发有效
//             type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
//         }
//     },
//     legend: {
//         data: ['O3', 'CO','NO2','SO2'],
//         textStyle: {
//             color: 'white'
//         }
//     },
//     grid: {
//         left: '3%',
//         right: '4%',
//         bottom: '3%',
//         containLabel: true
//     },
//     yAxis:  {
//         splitLine : {
//             show: false
//         },
//         splitArea : {
//             show : false
//         },
//         type: 'value',
//         axisLabel: {
//             textStyle: {
//                 color: 'white'//坐标值得具体的颜色
//             }
//         }
//     },
//     xAxis: {
//         type: 'category',
//         data: ['周一','周二','周三','周四','周五','周六','周日'],
//         axisLabel: {
//             textStyle: {
//                 color: 'white'//坐标值得具体的颜色
//             }
//         }
//     },
//     series: [
//         {
//             name: 'O3',
//             type: 'bar',
//             stack: '总量',
//             barWidth: '60%',
//
//             label: {
//                 normal: {
//                     show: true,
//                     position: 'insideRight'
//                 }
//             },
//             data: [10, 20, 31, 32, 23, 32, 24]
//         },
//         {
//             name: 'CO',
//             type: 'bar',
//             stack: '总量',
//             barWidth: '60%',
//
//             label: {
//                 normal: {
//                     show: true,
//                     position: 'insideRight'
//                 }
//             },
//             data: [10, 20, 31, 32, 23, 32, 24]
//         },
//         {
//             name: 'NO2',
//             type: 'bar',
//             stack: '总量',
//             barWidth: '60%',
//             label: {
//                 normal: {
//                     show: true,
//                     position: 'insideRight'
//                 }
//             },
//             data: [10, 20, 31, 32, 23, 32, 24]
//         },
//         {
//             name: 'SO2',
//             type: 'bar',
//             stack: '总量',
//             barWidth: '60%',
//             label: {
//                 normal: {
//                     show: true,
//                     position: 'insideRight'
//                 }
//             },
//             data: []
//         }
//     ]
// };
//
//
// function sendAjax() {
//     axios.get('/json').then(function(response) {
//         let jsonObject = response.data;
//         view7.option.series[3].data = [Math.random() * 100, Math.random() * 100, Math.random() * 100,Math.random() * 100,Math.random() * 100,Math.random() * 100,Math.random() * 100];
//         myChart7.setOption(view7.option);
//     });
// }
//
//
//
var view7_avg = [24];
var view7_current = [];




option7 = {
    backgroundColor:'rgba(0,0,0,0)',
    title : {
        text: '大气成分对比图',
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['平均','实况']
    },
    dataRange: {
        show: false,
        min : 0,
        max : 40,
        calculable : true,
        color: ['#d94e5d','#eac736','#50a3ba'],
        y:'center',
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            data : ['AQI','no2','so2','co*10','o3']
        }
    ],
    yAxis : [
        {
            type : 'value',
            splitLine: {
                show: false
            },
        }
    ],
    series : [
        {
            name:'平均',

            label: {
                show: true,
                position: 'top',
                formatter: '平均\n+{c}'
            },
            type:'bar',
            data: view7_avg,

        },
        {
            name:'实况',
            label: {
                show: true,
                position: 'top',
                formatter: '实况\n{c}'
            },
            type:'bar',
            data:[2.6, 5.9, 9.0, 26.4, 28.7],

        }
    ]
};




/*function ajax_block7() {
    let city_name = current_city;

    url = '/mysql/airindex?city=' + city_name;
    axios.get(url).then(function(response) {
        let jsonObject = response.data;
        view7_avg=[24]
        view7_avg.push(jsonObject.no2);
        view7_avg.push(jsonObject.so2);
        view7_avg.push(jsonObject.co*10);
        view7_avg.push(jsonObject.o3);
        //alert(view7_avg);
        view7.option.series[0].data = view7_avg;
        view7.chart.setOption(view7.option);
    });
}*/


function ajax_block7() {
    let city_id = getCurrentCityId();


    axios.all([
        axios.get('/mysql/airindex?city=' + current_city),

        axios.get('/getAqi?cityId=' + city_id),
    ])
        .then(axios.spread(function (resp1, resp2) {
            //
            let jsonObject = resp1.data;
            view7_avg=[34]
            view7_avg.push(jsonObject.no2);
            view7_avg.push(jsonObject.so2);
            view7_avg.push(jsonObject.co*10);
            view7_avg.push(jsonObject.o3);
            //alert(view7_avg);
            let resp22 = resp2.data;
            view7_current.push(resp22.aqi.value);
            view7_current.push(resp22.aqi.no2);
            view7_current.push(resp22.aqi.so2);
            view7_current.push(resp22.aqi.co);
            view7_current.push(resp22.aqi.o3);
            view7.option.series[0].data = view7_avg;
            view7.option.series[1].data = view7_current;
            view7.chart.setOption(view7.option);

        }));


}

