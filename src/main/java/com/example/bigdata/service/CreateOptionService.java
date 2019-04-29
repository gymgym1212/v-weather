package com.example.bigdata.service;

import java.io.*;

public class CreateOptionService {
    public static void main(String[] args) {

    }

    public void createBarGraph(int screenId, int optionId) {
        String path = "src/main/resources/static/screens/";
        path = path + "screen" + screenId + "/" + "options/" + "block" + optionId + "_script.js";
        //System.out.println(path);
        File file = new File(path);

        try (
                // 创建文件字符流
                FileWriter fw = new FileWriter(file);
                // 缓存流必须建立在一个存在的流的基础上
                PrintWriter pw = new PrintWriter(fw);
        ) {
            String color = "'#3398DB'";
            String unit = "'降水量'";
            String x = "['周X', '周二', '周三', '周四', '周五', '周六', '周日']";
            String y = "[10, 52, 200, 334, 390, 330, 220]";
            String width = "'60%'";


            pw.print("option" + optionId + " = {\n" +
                    "    color: [" + color + "],\n" +
                    "    tooltip : {\n" +
                    "        trigger: 'axis',\n" +
                    "        axisPointer : {            // 坐标轴指示器，坐标轴触发有效\n" +
                    "            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'\n" +
                    "        }\n" +
                    "    },\n" +
                    "    grid: {\n" +
                    "        left: '3%',\n" +
                    "        right: '4%',\n" +
                    "        bottom: '3%',\n" +
                    "        containLabel: true\n" +
                    "    },\n" +
                    "    xAxis : [\n" +
                    "        {\n" +
                    "            type : 'category',\n" +
                    "            data : "+  x  +",\n" +
                    "            axisTick: {\n" +
                    "                alignWithLabel: true\n" +
                    "            }\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    yAxis : [\n" +
                    "        {\n" +
                    "            type : 'value'\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    series : [\n" +
                    "        {\n" +
                    "            name:"+ unit  + ",\n" +
                    "            type:'bar',\n" +
                    "            barWidth:" + width + ",\n" +
                    "            data:"+ y +"\n" +
                    "        }\n" +
                    "    ]\n" +
                    "};");

            pw.flush();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void testzijie(int screenId, int optionId) {
        String path = "src/main/resources/static/screens/";
        path = path + "screen" + screenId + "/" + "options/" + "block" + optionId + "_script.js";
        //System.out.println(path);
        File file = new File(path);


        try {
            // 准备文件lol2.txt其中的内容是空的
            //File f = new File("d:/lol2.txt");
            // 准备长度是2的字节数组，用88,89初始化，其对应的字符分别是X,Y
            byte[] data = { 88, 89};

            // 创建基于文件的输出流
            FileOutputStream fos = new FileOutputStream(file);
            // 把数据写入到输出流
            fos.write(data);
            // 关闭输出流
            fos.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
