package com.example.bigdata.service;


import com.example.bigdata.pojo.Screen;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

@Service
public class IOService {
    public static final String SCREENS_PATH =  "src/main/resources/static/screens/";

    public static final String TEMPLATES_PATH = "src/main/resources/templates/";

    public static final String TEMPLATE_PATH = "src/main/resources/templates/template";

    public static final String SCREEN_PATH = "src/main/resources/templates/screen";

    public static final String TEST = "src/main/resources/templates/screen20.html";

    public void get() {
        //String path = SCREENS_PATH + "15.html";
        File f = new File(TEST);
        System.out.println(f.exists());
    }
    /**
     * 根据screen_blocks创建模板
     * @param screen_id
     * @param screen_blocks
     */
    public void createTemplate(String screen_id, String screen_blocks) {
        String template_id = "1";
        String template_path = TEMPLATE_PATH + template_id + ".html";
        String dest_path = TEMPLATES_PATH + "screen" + screen_id + ".html";
        File template = new File(template_path);
        File dest = new File(dest_path);

        try {
            Files.copy(template.toPath(), dest.toPath());
        }catch (Exception e) {
            e.printStackTrace();
        }

        createTemplateDir(screen_id);

        createTemplateJSFile(screen_id, Integer.parseInt(screen_blocks));

        createTemplateRest(screen_id, Integer.parseInt(screen_blocks));
    }

    /**
     * 创建模板在static相应的目录
     * @param screen_id
     *
     */
    public void createTemplateDir(String screen_id) {
        File f1 = new File(SCREENS_PATH + "screen"+ screen_id + "/pivot.txt");
        if(!f1.getParentFile().exists()) {
            f1.getParentFile().mkdirs();
        }

        

        File f2 = new File(SCREENS_PATH + "screen"+ screen_id + "/options/pivot.txt");
        if(!f2.getParentFile().exists()) {
            f2.getParentFile().mkdirs();
        }
    }

    public void createTemplateJSFile(String screen_id, int screen_blocks) {
        String options_path = SCREENS_PATH + "screen" + screen_id + "/options/";

        for(int i = 1; i <= screen_blocks; i++) {
            String block_script_path = options_path + "block" + i + "_script.js";
            File block_script = new File(block_script_path);
            try{
                block_script.createNewFile();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void createTemplateRest(String screen_id, int screen_blocks) {
        String screen_path = SCREEN_PATH + screen_id + ".html";
        File screen = new File(screen_path);

        try (
                // 创建文件字符流
                FileWriter fw = new FileWriter(screen, true);
                // 缓存流必须建立在一个存在的流的基础上
                PrintWriter pw = new PrintWriter(fw, true);
        ) {
            for(int i = 1; i <= screen_blocks; i++) {
                pw.print("<script type=\"text/javascript\" th:src=\"@{/static/screens/screen" + screen_id + "/options/block" + i+ "_script.js}\"></script>\n");
            }

            pw.print("<script type=\"text/javascript\" th:src=\"@{/static/screens/screen" + screen_id + "/options/set_options.js}\"></script>\n");
            pw.print("<script type=\"text/javascript\" th:src=\"@{/static/screens/screen" + screen_id + "/options/set_datas.js}\"></script>\n");
            pw.print("</body>\n");
            pw.print("</html>\n");
            pw.flush();
            pw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
