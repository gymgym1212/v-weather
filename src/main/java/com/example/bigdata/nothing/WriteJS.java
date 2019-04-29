package com.example.bigdata.nothing;

import java.io.*;

public class WriteJS {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\cloud\\Desktop\\test.js");
        try (
                // 创建文件字符流
                FileWriter fw = new FileWriter(file);
                // 缓存流必须建立在一个存在的流的基础上
                PrintWriter pw = new PrintWriter(fw);
        ) {
/*            pw.println("garen kill teemo");
            pw.println("teemo revive after 1 minutes");
            pw.println("teemo try to garen, but killed again");*/
            String type = "'line'";

            pw.print("options = {\n" +
                    "    xAxis: {\n" +
                    "        type: 'category',\n" +
                    "        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']\n" +
                    "    },\n" +
                    "    yAxis: {\n" +
                    "        type: 'value'\n" +
                    "    },\n" +
                    "    series: [{\n" +
                    "        data: [120, 200, 150, 80, 70, 110, 130],\n" +
                    "        type:" + type +  "\n" +
                    "    }]\n" +
                    "};\n");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
