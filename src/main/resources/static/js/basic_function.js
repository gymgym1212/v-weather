function View(chart, option) {
    this.chart = chart;
    this.option = option;
    this.legend_name_arr = null;
    this.selected = {};

    View.prototype.init = function () {
            this.legend_name_arr = this.chart.getOption().legend[0].data;
            //this.legend_name_arr = this.options.legend[0].data;
            for(let i = 0; i < this.legend_name_arr.length; i++) {
                this.selected[this.legend_name_arr[i]] = true;
            }
    };

    View.prototype.init_regions = function () {
            //this.legend_name_arr = this.chart.getOption().geo.regions[0].data;
            //console.log(this.option.geo.regions[0].name);
    };

}


