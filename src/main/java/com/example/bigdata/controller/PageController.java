package com.example.bigdata.controller;

import com.example.bigdata.dao.BarDao;
import com.example.bigdata.dao.LineDao;
import com.example.bigdata.dao.ScreenDao;
import com.example.bigdata.mapper.BarMapper;
import com.example.bigdata.mapper.LineMapper;
import com.example.bigdata.mapper.ScreenMapper;
import com.example.bigdata.pojo.Bar;
import com.example.bigdata.pojo.Line;
import com.example.bigdata.pojo.Screen;
import com.example.bigdata.service.CreateOptionService;
import com.example.bigdata.service.CreateScreenService;
import com.example.bigdata.service.IOService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    ScreenMapper screenMapper;

    @Autowired
    LineMapper lineMapper;

    @Autowired
    BarMapper barMapper;

    @Autowired
    BarDao barDao;

    @Autowired
    LineDao lineDao;


    @Autowired
    CreateScreenService createScreenService;

    @Autowired
    ScreenDao screenDao;

    @Autowired
    IOService ioService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 进入某个大屏
     * @param screen_id
     * @return
     */
    @RequestMapping("/screen/{screen_id}")
    public String screen(@PathVariable String screen_id) {
        return "screen" + screen_id;

        //return "screen" + screen_id +".html";
    }

    /**
     * 进入某个模板
     * @param screen_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/template7/{screen_id}")
    public String template7(@PathVariable String screen_id, Model model) {
        List<Bar> bars = barMapper.findByScreenId(Integer.parseInt(screen_id));
        List<Line> lines = lineMapper.findByScreenId(Integer.parseInt(screen_id));

        if(bars!=null) {
            model.addAttribute("bars", new Gson().toJson(bars));
        }

        if(lines!=null) {
            model.addAttribute("lines", new Gson().toJson(lines));
        }
        return "template7";
    }


    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/menu")
    public String menu() { return "menu"; }

    /**
     * 大屏管理页面
     * @return
     */
    @RequestMapping("/manager")
    public String manager(Model m) {
        List<Screen> screens = screenMapper.findAll();
        m.addAttribute("screens", screens);

        return "manager";
    }


    /**
     * 大屏设置页面
     * @param screenId 大屏编号
     * @return
     */
    @RequestMapping("/setting")
    public String setting(int screenId, Model model) {
        Screen screen = screenMapper.findById(screenId);
        model.addAttribute("screen", screen);
        return "setting";
    }

    @RequestMapping("/delete_screen")
    public String delete_screen(int screenId) {
        screenDao.deleteScreen(screenId);
        return "redirect:/manager";
    }


/*    @RequestMapping("/template1")
    public String template() {return "template7"; }*/

    /**
     * 处理创建大屏
     * @param request
     * @return
     */
    @RequestMapping("/create_screen")
    public String handleCreateScreen(HttpServletRequest request) {
        //String screen_id = request.getParameter("screen_id");
        String screen_name = request.getParameter("screen_name");
        String screen_blocks = request.getParameter("screen_blocks");
        screenDao.createScreen(screen_name, String.valueOf(7));
        int screen_id = screenMapper.findLargestScreenId();
        return "redirect:/manager";
    }


    /**
     * 处理设置屏幕可视化option
     */
    @RequestMapping("/setting_screen")
    public String handleCreateOption(HttpServletRequest request) {

        return "redirect:/manager";
    }

    @RequestMapping("/setting_screen/bar")
    public String handleCreateBarOption(HttpServletRequest request) {
        String screen_id = request.getParameter("screen_id");
        String option_id = request.getParameter("option_id");
        String title = request.getParameter("title");
        String color = request.getParameter("color");
        String unit = request.getParameter("unit");
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        String width = request.getParameter("width");

        Bar bar = new Bar(Integer.parseInt(screen_id), Integer.parseInt(option_id), title, color, unit, x, y, width);
        barDao.createBar(bar);
        return "redirect:/manager";
    }


    @RequestMapping("/setting_screen/line")
    public String handleCreateLineOption(HttpServletRequest request) {
        String screen_id = request.getParameter("zscreen_id");
        String option_id = request.getParameter("zoption_id");
        String title = request.getParameter("ztitle");
        String color = request.getParameter("zcolor");
        String unit = request.getParameter("zunit");
        String x = request.getParameter("zx");
        String y = request.getParameter("zy");

        Line line = new Line(Integer.parseInt(screen_id), Integer.parseInt(option_id), title, color, unit, x, y);
        lineDao.createLine(line);
        return "redirect:/manager";
    }


}
