
function ajax_block5() {
    let city_id = getCurrentCityId();

    axios.get('/current_weather?cityId='+city_id).then(function(response) {
        var o = response.data;
        document.getElementById("5_shidu").innerHTML = o.condition.humidity;
        document.getElementById("5_yali").innerHTML = o.condition.pressure;
        document.getElementById("5_tigan").innerHTML = o.condition.realFeel;
        document.getElementById("5_wendu").innerHTML = o.condition.temp;
        document.getElementById("5_fengxiang").innerHTML = o.condition.windDir;
        document.getElementById("5_fengji").innerHTML = o.condition.windLevel;
        document.getElementById("5_fengsu").innerHTML = o.condition.windSpeed
        var rise = o.condition.sunRise.split(" ");
        var down = o.condition.sunSet.split(" ");
        document.getElementById("5_richu").innerHTML = rise[1];
        document.getElementById("5_riluo").innerHTML = down[1];
    });

}