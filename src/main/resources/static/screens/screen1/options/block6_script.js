option6 = {
    backgroundColor:'rgba(0,0,0,0)',
    title: {
        text: '未来一周气温变化',
        top: 20,
        textStyle: {
            color: 'white'
        }
    },

    legend: {
        data:['最高气温','最低气温'],
        textStyle: {
            color: 'white'
        }
    },
    xAxis:  {
        type: 'category',
        data: ['D1','D2','D3','D4','D5','D6','D7','D8','D9','D10','D11','D12','D13','D14','D15'],
        // axisLine: {
        //     show: true,
        //     // lineStyle: {
        //     //     width: 1,
        //     //   //  color: 'white'
        //     // }
        // },
        // axisTick: {
        //     show: false
        // },
        //boundaryGap : false,
        // axisLabel: {
        //     textStyle: {
        //        // color: 'white'//坐标值得具体的颜色
        //     }
        // }
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    yAxis: {
        type: 'value',
        // splitLine : {
        //     show: false
        // },
        // splitLine: {
        //     show: false
        // },
        // axisLine: {
        //     show: true,
        //     // lineStyle: {
        //     //     width: 1,
        //     //     //color: 'white'
        //     // }
        // },
        axisLabel: {
            formatter: '{value} °C',
            // textStyle: {
            //    // color: 'white'//坐标值得具体的颜色
            // }
        },
        splitArea:{
            show:true,
            areaStyle:{
                color:['rgba(250,250,250,0.1)','rgba(200,200,200,0)'],
            }
        }
    },
    series: [
        {
            name:'最高气温',
            type:'line',
            stack: 'one',
            label: {
                show: true,
                position: 'top',
                formatter: '{c}'
            },
            symbolSize: 6,
            // itemStyle: {
            //     normal: {
            //        // color: "#ff704d",
            //     },
            // },
            lineStyle:{
                normal:{
                    width:2,
                }

            },
            data:['11','12','13','11','5','9','7','12','15','7','14','9','10','12','9'],
            markPoint: {
                data: [
                    {type: 'max', name: '最大值',itemStyle:{
                            // normal:{
                            //     //color:'#ff3333',
                            // },
                        }},
                    {type: 'min', name: '最小值',itemStyle:{
                            // normal:{
                            //     //color:'#ff3333',
                            // },
                        }},
                ],
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ],lineStyle:{
                    normal:{
                        width:2,
                    }
                }
            }
        },
        {
            name:'最低气温',
            type:'line',
            // stack: 'two',
            symbolSize: 6,
            lineStyle:{
                normal:{
                    width:2,
                }
            },
            label: {
                show: true,
                position: 'top',
                formatter: '{c}'
            },
            // itemStyle: {
            //     normal: {
            //         color: "rgba(252,230,48)",
            //     }
            // },
            data:[1, -2, 6, 5, 3, 2, 0, -2, 3, 6, 3, 2, 0,-2,2],
            markPoint: {
                data: [
                    {type: 'max', name: '最大值',itemStyle:{
                            // normal:{
                            //    // color:'#ffbf00',
                            // },
                        }},
                    {type: 'min', name: '最小值',itemStyle:{
                            // normal:{
                            //     //color:'#ffbf00',
                            // },
                        }}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ],
                lineStyle:{
                    normal:{
                        width:2,
                    }
                }
            }
        }

    ]
};

function ajax_block6() {
    let city_id = getCurrentCityId();
    var day=[];
    var high=[];
    axios.get('/fifth_day_info?cityId='+city_id).then(function(response) {

        let o = response.data;
        for(let i=0;i<15;i++){
            day.push(o[i].tempDay);
            high.push(o[i].tempNight);
        }



        console.log(response.data[0]);
        view6.option.series[0].data = day;
        view6.option.series[1].data = high;
        view6.chart.setOption(view6.option);
    });
}
