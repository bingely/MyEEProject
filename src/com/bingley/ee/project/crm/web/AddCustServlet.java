package com.bingley.ee.project.crm.web;

import com.bingley.ee.factory.BasicFactory;
import com.bingley.ee.project.crm.domain.Cust;
import com.bingley.ee.project.crm.service.CustService;

import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des $des$
 * @since 2017/6/3.
 */

// 以下思路是一种面向接口编程

@WebServlet(name = "AddCustServlet", value = "/servlet/AddCustServlet")
public class AddCustServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        CustService service = BasicFactory.getFactory().getInstance(CustService.class);
        try {
            //1.封装数据校验数据
            Cust cust = new Cust();
            BeanUtils.populate(cust, request.getParameterMap());
            //--单独处理爱好（因为爱好有多个，需要搞成”，“隔开的字符串
            String [] prefs = request.getParameterValues("preference");
            StringBuffer buffer = new StringBuffer();
            for(String pref : prefs){
                buffer.append(pref+",");
            }
            String pref = buffer.substring(0, buffer.length()-1);  // 去掉最后的一个 ”，“
            cust.setPreference(pref);
            //2.调用Service中的方法添加客户
            service.addCust(cust);
            //3.重定向回到主页
            response.sendRedirect(request.getContextPath()+"/project/crm/index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
