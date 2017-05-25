package com.bingley.ee.topic.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des下载资源
 * @since 2017/5/19.
 */

// 为什么运行不起来   我觉得跟路径相关的逻辑有关系
@WebServlet(name = "DownLoadServlet", value = "/helloDownLoad")
public class DownLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决中文命名规则的文件
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("美女.jpg", "utf-8"));

        InputStream in = new FileInputStream(this.getServletContext().getRealPath("1.jpg"));
        OutputStream out = response.getOutputStream();

        byte[] bs = new byte[1024];
        int i = 0;
        while ((i = in.read(bs)) != -1) {
            out.write(bs, 0, i);
        }

        in.close();
        // response中的流没必要关闭
    }
}
