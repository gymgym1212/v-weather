var option3 = {
    backgroundColor:'rgba(0,0,0,0)',
    title: {

    },
    legend: {
        itemWidth: 12,
        itemHeight: 12,
        orient:'vertical',
        right:'2%',
        bottom:'2%',
        data: ['PM2_5', 'PM10'],
        textStyle: {
            color: '#fff'
        }
    },

        radar: {
        radius: '60%',
        splitNumber: 6,
            name: {
                textStyle: {
                    color: '#fff',
                    backgroundColor: '#999',
                    borderRadius: 3,
                    padding: [3, 5]
                }
            },
        axisLine: {
            lineStyle: {
                color: '#fff',
                opacity: .3
            }
        },
        splitLine: {
            lineStyle: {
                color: [
                    'rgba(238, 197, 102, 0.1)', 'rgba(238, 197, 102, 0.2)',
                    'rgba(238, 197, 102, 0.4)', 'rgba(238, 197, 102, 0.6)',
                    'rgba(238, 197, 102, 0.8)', 'rgba(238, 197, 102, .1)'
                ].reverse()
            }
        },
        splitArea: {
            areaStyle: {
                color: [
                    'rgba(238, 197, 102, 0.1)', 'rgba(238, 197, 102, 0.2)',
                    'rgba(238, 197, 102, 0.4)', 'rgba(238, 197, 102, 0.6)',
                    'rgba(238, 197, 102, 0.8)', 'rgba(238, 197, 102, 1)'
                ].reverse()
            }
        },
        indicator: [{
            name: '金华',
            max: 100
        }, {
            name: '杭州',
            max: 100
        }, {
            name: '舟山',
            max: 100
        }, {
            name: '温州',
            max: 100
        }, {
            name: '宁波',
            max: 100
        }, {
            name: '台州',
            max: 100
        }, {
            name: '嘉兴',
            max: 100
        }, {
            name: '丽水',
            max: 100
        }, {
            name: '湖州',
            max: 100
        }, {
            name: '衢州',
            max: 100
        }, {
            name: '绍兴',
            max: 100
        }
        ]
    },
    series: [{
        name: 'PM2_5&PM10',
        type: 'radar',
        symbolSize: 0,
        areaStyle: {
            normal: {
                shadowBlur: 13,
                shadowColor: 'rgba(0,0,0,0.01)',
                shadowOffsetX: 0,
                shadowOffsetY: 10,
                opacity: 0.2
            }
        },
        data: [{
            value: [56, 70, 57, 43, 55, 75,82,57,88,54,44],
            name: 'PM2_5',
        }, {
            value: [88, 75, 63, 57, 64, 46,78,48,84,62,44],
            name: 'PM10',
        }]
    }],
    color: ['#ffff00','#ff3333'],
    // backgroundColor: {
    //     type: 'radial',
    //     x: 0.4,
    //     y: 0.4,
    //     r: 0.35,
    //     colorStops: [{
    //         offset: 0,
    //         color: '#895355' // 0% 处的颜色
    //     }, {
    //         offset: .4,
    //         color: '#593640' // 100% 处的颜色
    //     }, {
    //         offset: 1,
    //         color: '#39273d' // 100% 处的颜色
    //     }],
    //     globalCoord: false // 缺省为 false
    // }
};
function ajax_rader() {
    axios.all([
        //金华
        axios.get('/getAqi?cityId=1253'),
        //杭州
        axios.get('/getAqi?cityId=1185'),
        //舟山
        axios.get('/getAqi?cityId=1269'),
        //温州
        axios.get('/getAqi?cityId=1220'),
        //宁波
        axios.get('/getAqi?cityId=1208'),
        //台州
        axios.get('/getAqi?cityId=1194'),
        //嘉兴
        axios.get('/getAqi?cityId=1233'),
        //丽水
        axios.get('/getAqi?cityId=1275'),
        //湖州
        axios.get('/getAqi?cityId=1241'),
        //衢州
        axios.get('/getAqi?cityId=1262'),
        //绍兴
        axios.get('/getAqi?cityId=1246'),

    ])
        .then(axios.spread(function (resp1, resp2, resp3, resp4, resp5, resp6, resp7, resp8, resp9, resp10, resp11) {
            let pm2_5=[];
            let pm10=[];
            for(let i=0;i<11;i++){
                pm2_5.push(arguments[i].data.aqi.pm25);
                pm10.push(arguments[i].data.aqi.pm10);
            }
            view3.option.series[0].data[0].value = pm2_5;
            view3.option.series[0].data[1].value = pm10;
            view3.chart.setOption(view3.option);

        }));


}
