var myChart1 = echarts.init(document.getElementById('block1'));
var view1 = null;
var uploadedDataURL = "../../../../static/js/zhejiang.json";
var convertData;
var max = 480, min = 9; // todo
var maxSize4Pin = 100, minSize4Pin = 20;
var option1;
var geoCoordMap
myChart1.showLoading();
$.getJSON(uploadedDataURL, function(geoJson) {
    echarts.registerMap('zhejiang', geoJson);
    myChart1.hideLoading();
     geoCoordMap = {
        '杭州市': [119.47,29.90],
        '宁波市': [121.539029,29.736103],
        '温州市': [120.61,27.85],
        '绍兴市': [120.701386,29.74081],
        '湖州市': [119.92,30.70],
        '嘉兴市': [120.78,30.58],
        '金华市': [119.94,29.10],
        '衢州市': [118.80,28.84],
        '舟山市': [122.10,30.07],
        '台州市': [121.08,28.78],
        '丽水市': [119.50,28.07],
    }
    var data = [
        {name: '杭州市', value:199},
        {name: '宁波市', value:39},
        {name: '温州市', value:152},
        {name: '绍兴市', value:299},
        {name: '湖州市', value:480},
        {name: '嘉兴市', value:89},
        {name: '金华市', value:52},
        {name: '衢州市', value:9},
        {name: '舟山市', value:352},
        {name: '台州市', value:99},
        {name: '丽水市', value:39},
    ];


        convertData = function (data) {
        var res = [];
        for (var i = 0; i < data.length; i++) {
            var geoCoord = geoCoordMap[data[i].name];
            if (geoCoord) {
                res.push({
                    name: data[i].name,
                    value: geoCoord.concat(data[i].value)
                });
            }
        }
        console.log(res);
        return res;
    };


     option1 = {
        //backgroundColor: '#020933',
        // title: {
        //     top:20,
        //     text: '“想想再添” - 浙江省',
        //     subtext: '',
        //     x: 'center',
        //     textStyle: {
        //         color: '#ccc'
        //     }
        // },

        visualMap: {
            show: false,
            min: 0,
            max: 900,
            left: 'left',
            top: 'bottom',
            text: ['高', '低'], // 文本，默认为数值文本
            calculable: true,
            seriesIndex: [1],
            inRange: {
                // color: ['#3B5077', '#031525'] // 蓝黑
                // color: ['#ffc0cb', '#800080'] // 红紫
                // color: ['#3C3B3F', '#605C3C'] // 黑绿
                color: ['#0f0c29', '#302b63', '#24243e'] // 黑紫黑
                //color: ['#23074d', '#cc5333'] // 紫红
                // color: ['#00467F', '#A5CC82'] // 蓝绿
                // color: ['#1488CC', '#2B32B2'] // 浅蓝
                // color: ['#00467F', '#A5CC82'] // 蓝绿
                // color: ['#00467F', '#A5CC82'] // 蓝绿
                // color: ['#00467F', '#A5CC82'] // 蓝绿
                // color: ['#00467F', '#A5CC82'] // 蓝绿

            }
        },
        geo: {
            show: true,
            aspectScale:.8,
            zoom:1.1,
            map: 'zhejiang',
            label: {
                normal: {
                    show: false
                },
                emphasis: {
                    show: false,
                }
            },
            regions: [
                {
                    name: '杭州市',
                    selected:true,
                },
                {
                    name: '金华市',
                    selected:false,
                },
                {
                    name: '衢州市',
                    selected:false,
                },
                {
                    name: '湖州市',
                    selected:false,
                },
                {
                    name: '丽水市',
                    selected:false,
                },
                {
                    name: '嘉兴市',
                    selected:false,
                },
                {
                    name: '绍兴市',
                    selected:false,
                },
                {
                    name: '台州市',
                    selected:false,
                },
                {
                    name: '宁波市',
                    selected:false,
                },
                {
                    name: '温州市',
                    selected:false,
                },
                {
                    name: '舟山市',
                    selected:false,
                },
            ],

            itemStyle: {
                normal: {
                    areaColor: 'transparent',
                    borderColor: '#3fdaff',
                    borderWidth: 2,
                    shadowColor: 'rgba(63, 218, 255, 0.5)',
                    shadowBlur: 300
                },
                emphasis: {
                    show:true,
                    areaColor: '#2B91B7',
                }
            }
        },
        series : [
            {
                name: 'light',
                type: 'scatter',
                coordinateSystem: 'geo',
                data: convertData(data),
                symbolSize: function (val) {
                    return 15;
                },
                label: {
                    normal: {
                        formatter: '{b}',
                        position: 'right',
                        show: true
                    },
                    emphasis: {
                        show: true
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#F4E925'
                    }
                }
            },
            {
                type: 'map',
                map: 'zhejiang',
                geoIndex: 0,
                showLegendSymbol: false, // 存在legend时显示
                data: data
            },
            {
                name: 'Top 5',
                type: 'effectScatter',
                coordinateSystem: 'geo',

                data: convertData(data.sort(function (a, b) {
                    return b.value - a.value;
                }).slice(0, 5)),

                // symbolSize: function (val) {
                //     return val[2]/20;
                // },

                showEffectOn: 'render',

                rippleEffect: {
                    scale:15,
                    brushType: 'stroke'
                },
                hoverAnimation: true,
                itemStyle: {
                    normal: {
                        color: '#F4E925',
                        shadowBlur: 20,
                        shadowColor: '#05C3F9'
                    }
                },
                zlevel: 1
            },
            {
                name: '点',
                type: 'scatter',
                coordinateSystem: 'geo',
                symbol: 'pin',
                // symbolSize: function (val) {
                //     var a = (maxSize4Pin - minSize4Pin) / (max - min);
                //     var b = minSize4Pin - a*min;
                //     b = maxSize4Pin - a*max;
                //     return a*val[2]+b;
                // },
                symbolSize:50,
                label: {
                    normal: {

    formatter:function(obj){
        return obj.data.value[2];
    },
                        show: true,
                        textStyle: {
                            color: '#fff',
                            fontSize: 15,
                        }
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#F62157', //标志颜色
                    }
                },
                zlevel: 10,
                data:
                     convertData(data)
            },

        ]
    };
    myChart1.setOption(option1);
    view1 = new View(myChart1, option1);
    //view1.init();
    view1.init_regions();
    //changeRegion(view1);

});


function ajax_map() {
    axios.all([
        //杭州
        axios.get('/getAqi?cityId=1185'),
        //金华
        axios.get('/getAqi?cityId=1253'),
        //衢州
        axios.get('/getAqi?cityId=1262'),
        //绍兴
        axios.get('/getAqi?cityId=1246'),
        //温州
        axios.get('/getAqi?cityId=1220'),
        //嘉兴
        axios.get('/getAqi?cityId=1233'),
        //台州
        axios.get('/getAqi?cityId=1194'),
        //湖州
        axios.get('/getAqi?cityId=1241'),
        //舟山
        axios.get('/getAqi?cityId=1269'),
        //丽水
        axios.get('/getAqi?cityId=1275'),
        //宁波
        axios.get('/getAqi?cityId=1208'),


    ])
        .then(axios.spread(function (resp1, resp2, resp3, resp4, resp5, resp6, resp7, resp8, resp9, resp10, resp11) {
            /*console.log(resp1.data.aqi.value);
            console.log(resp2.data);
            console.log(resp3.data);
            console.log(resp4.data);
            console.log(resp5.data);
            console.log(resp6.data);
            console.log(resp7.data);
            console.log(resp8.data);
            console.log(resp9.data);
            console.log(resp10.data);
            console.log(resp11.data);*/

            let values=[];
            let size;
            for(let i=0;i<11;i++){

                let cname = arguments[i].data.city.name;
                let cvalue = arguments[i].data.aqi.value;
                let o = {name:cname ,value: cvalue};
                values.push(o);

            }

            // view1.option.series[3].symbolSize = function (values) {
            //     var a = (maxSize4Pin - minSize4Pin) / (max - min);
            //     var b = minSize4Pin - a*min;
            //     b = maxSize4Pin - a*max;
            //     return a*values[2]+b;
            // };
            view1.option.series[3].symbolSize =50;
            view1.option.series[3].formatter=function(obj){
                return obj.data.value[2];
            };
            view1.option.series[0].data = convertData(values);
            view1.option.series[1].data = values;
            view1.option.series[2].data = convertData(values.sort(function (a, b) {
                return b.value - a.value;
            }).slice(0, 6));
            view1.option.series[3].data = convertData(values);
            view1.chart.setOption(view1.option);
        }));


}


