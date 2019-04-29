//空气质量指数

function ajax_block2() {
    let city_id = getCurrentCityId();


    axios.get('/aqi?cityId='+city_id).then(function (response) {
        let o = response.data;
        let value = o.aqi.value;
        let condition;
        if (value <= 50) {
            condition = "优";
        } else if (50 < value <= 100) {
            condition = "良";
        } else if (100 < value <= 200) {
            condition = "轻度污染";
        } else if (200 < value <= 300) {
            condition = "中度污染";
        } else if (300 < value) {
            condition = "重度污染";
        }

        document.getElementById("2_AQI").innerHTML = value + condition;
        document.getElementById("2_chengshi").innerHTML = o.city.name;
    });

    //晴天阴天 温度 城市 url：天气实况

    axios.get('/current_weather?cityId='+city_id).then(function (response) {
        let o = response.data;
        document.getElementById("2_wendu_yq").innerHTML = o.condition.temp + "°" + o.condition.condition;
    });


    //block2：生活指数 url：生活指数
    axios.get('/lifearr?cityId='+city_id).then(function (response) {
        let o = response.data;
        console.log('-------------');
        document.getElementById("2_chuxing").innerHTML = o[0].status;
        document.getElementById("2_huazhuang").innerHTML = o[1].status;
        document.getElementById("2_yundong").innerHTML = o[2].status;
        document.getElementById("2_ganmao").innerHTML = o[6].status;
    });


}
