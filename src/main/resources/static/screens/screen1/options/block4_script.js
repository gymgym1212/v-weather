var value ;
var city;
var data = [];
function ajax_block4() {
    let city_id = getCurrentCityId();

    axios.get('/current_weather?cityId='+city_id).then(function(response) {
        let value ;
        let city;
        let data = [];

        let o = response.data;
        value = o.condition.humidity;
        data.push(value/100)
        data.push(value/200)
        data.push(value/300)
        city = o.city.name;
        view4.option.series[0].data = data;
        view4.option.series[0].label.normal.formatter =value + '%';
        view4.chart.setOption(view4.option);
    });
}






var option4 = {
    title: {
        text: '相对湿度含量rh',
        x:'center',
        top:10,
        textStyle: {
            fontWeight: 'normal',
            color: 'white',
        }
    },
    legend: {
        data:[],
        textStyle: {
            //color: 'white'
        }
    },
    series: [{
        type: 'liquidFill',
        radius: '65%',
        data: data,
        backgroundStyle: {
            borderWidth: 5,
            borderColor: ' #e5ccff',
            //color: 'rgb(0, 51, 204)'
        },
        outline: {
            // borderDistance: 0,
            itemStyle: {
                borderWidth: 6,
                borderColor: 'rgb(255,0,255,0.6)',
                shadowBlur: 40,
                shadowColor: '#e5ccff'
            }
        },
        label: {
            normal: {
                formatter: 0 + '%rh',
                textStyle: {
                    fontSize: 20
                }
            }
        }
    }]
}

