var viewIds = [];
var timer;
var current_city = '杭州市';
viewIds[0] = ['hangzhou', 'jinhua', 'jiaxing'];
viewIds[3] = ['PM2_5', 'PM10'];
viewIds[6] = ['最高气温', '最低气温'];
viewIds[7] = ['平均', '实况'];


function getCurrentCityId() {
    var city_name = current_city;
    var city_id = null;
    switch (city_name) {
        case '杭州市':
            city_id = 1185;
            break;
        case '金华市':
            city_id = 1253;
            break;
        case '衢州市':
            city_id = 1262;
            break;
        case '绍兴市':
            city_id = 1246;
            break;
        case '温州市':
            city_id = 1220;
            break;
        case '嘉兴市':
            city_id = 1233;
            break;
        case '台州市':
            city_id = 1194;
            break;
        case '湖州市':
            city_id = 1241;
            break;
        case '舟山市':
            city_id = 1269;
            break;
        case '丽水市':
            city_id = 1275;
            break;
        case '宁波市':
            city_id = 1208;
            break;
        default:
            break;
    }

    return city_id;
}
