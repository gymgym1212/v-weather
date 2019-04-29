package com.example.bigdata.nothing;


import com.example.bigdata.pojo.Screen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

public class WriteDirectory {
    public static final String SCREENS_PATH =  "src/main/resources/static/screens/";

    public static void main(String[] args) throws IOException {
        method5();
    }

    public static void method1() {
        /*        String templates_path = "src/main/resources/templates/template7.html";
        String dest_path = "src/main/resources/templates/screen3.html";
        //String path = "src/main/java/com/example/bigdata/nothing/WriteJS.java";
        //String path2 = "src/main/resources/templates/admin.html";
        File template = new File(templates_path);
        File dest = new File(dest_path);
        Files.copy(template.toPath(), dest.toPath());*/
    }

    /**
     * 创建screen 目录
     */
    public static void method2() {
        File file = new File(SCREENS_PATH + "screen3/pivot.txt");
        if(!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
    }

    /**
     * 创建screen/options 目录
     */
    public static void method3() {
        File file = new File(SCREENS_PATH + "screen3/options/pivot.txt");
        if(!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
    }

    /**
     * 创建block_script.js
     * @throws IOException
     */
    public static void method4() throws IOException{
        for( int i = 1; i <= 7; i++) {
            String option_path = SCREENS_PATH + "screen3/options/block" + i + "_script.js";
            File option = new File(option_path);
            option.createNewFile();
        }
    }

    public static void method5() throws IOException{
/*
        String path = "src/main/resources/templates/screen3.html";
        File file = new File(path);

        try (
                // 创建文件字符流
                FileWriter fw = new FileWriter(file, true);
                // 缓存流必须建立在一个存在的流的基础上
                PrintWriter pw = new PrintWriter(fw, true);
        ) {
            pw.print("<script type=\"text/javascript\" th:src=\"@{/static/screens/screen3/options/block1_script.js}\"></script>");
            pw.print("<script type=\"text/javascript\" th:src=\"@{/static/screens/screen3/options/block3_script.js}\"></script>\n");
            pw.print("<script type=\"text/javascript\" th:src=\"@{/static/screens/screen3/options/block4_script.js}\"></script>\n");
            pw.print("<script type=\"text/javascript\" th:src=\"@{/static/screens/screen3/options/block6_script.js}\"></script>\n");
            pw.print("<script type=\"text/javascript\" th:src=\"@{/static/screens/screen3/options/block7_script.js}\"></script>\n");
            pw.print("<script type=\"text/javascript\" th:src=\"@{/static/screens/screen3/options/set_options.js}\"></script>\n");
            pw.print("<script type=\"text/javascript\" th:src=\"@{/static/screens/screen3/options/set_datas.js}\"></script>\n");
            pw.print("</body>\n");
            pw.print("</html>\n");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
*/




/*        <script type="text/javascript" th:src="@{/static/screens/screen1/options/block1_script.js}"></script>
<script type="text/javascript" th:src="@{/static/screens/screen1/options/block3_script.js}"></script>
<script type="text/javascript" th:src="@{/static/screens/screen1/options/block4_script.js}"></script>
<script type="text/javascript" th:src="@{/static/screens/screen1/options/block6_script.js}"></script>
<script type="text/javascript" th:src="@{/static/screens/screen1/options/block7_script.js}"></script>
<script type="text/javascript" th:src="@{/static/screens/screen1/options/set_options.js}"></script>
<script type="text/javascript" th:src="@{/static/screens/screen1/options/set_datas.js}"></script>
<script type="text/javascript" th:src="@{/static/screens/screen1/options/common.js}"></script>*/
    }
}
