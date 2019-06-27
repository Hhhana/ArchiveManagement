package com.zte.archive.controller;

import com.google.gson.Gson;
import com.zte.archive.model.Archive;
import com.zte.archive.model.Destroy;
import com.zte.archive.model.Find;
import com.zte.archive.model.Lose;
import com.zte.archive.service.FindService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:helloboy
 * Date:2019-06-25 15:07
 * Description:<描述>
 */
@Controller
@RequestMapping("/find")
public class FindController {
    @Autowired(required=false)
    private FindService findService;


    //查询档案首页
    @RequestMapping("/searchIndex")
    public String index(){
        return "search";
    }

    //找回登记页面
    @RequestMapping("/findIndex")
    public String register(){
        return "findIndex2";
    }

    @RequestMapping("/searchByTime")
    public String findByTime(HttpServletRequest req,HttpServletResponse resp)throws IOException {
        String getStartTime = req.getParameter("startTime");
        String getEndTime = req.getParameter("endTime");
        System.out.print("开始时间:" + getStartTime +"    " + "结束时间:" + getEndTime);
        List<Find> find = findService.queryAllFind(getStartTime,getEndTime);
        List<Lose> lose = findService.queryAllLose(getStartTime, getEndTime);
        List<Destroy> destroy = findService.queryAllDestroy(getStartTime, getEndTime);

        //Json格式返回
        Map<String,List> map = new HashMap<>();
        map.put("find",find);
        map.put("lose",lose);
        map.put("destroy",destroy);

        Gson gson = new Gson();
        String json = gson.toJson(map);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        req.setAttribute("map",map);
        System.out.print(json);

        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
        out.close();


        return "searchResult";
    }


    @RequestMapping("/checkState")
    public void checkState(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        //获取页面的ArchiveId
        String archiveId = req.getParameter("archiveId");

        String rtn = null;  //提示框
        resp.setCharacterEncoding("UTF-8"); //设置页面的编码格式
        resp.setContentType("text/plain charset=UTF-8");  //设置返回数据的文本类型为text

        //判断状态
        Archive archive = findService.queryAllArchive(archiveId);
        PrintWriter out = resp.getWriter();
        if (archive != null){
            //判断状态state是否为丢失
            out.println(archive.getState());
            if (archive.getState().equals("丢失")) {
                rtn = "丢失";
            } else {
                rtn = "正常状态";
            }
        }
        out.print(rtn);
        out.close();

    }


    @RequestMapping("/findRegister")
    public String findRegister(HttpServletRequest req,HttpServletResponse resp) throws IOException, SQLException, InvocationTargetException, IllegalAccessException {
        String archiveId = req.getParameter("archiveId");
        Archive archive = findService.queryAllArchive(archiveId);
        if (archive != null) {
            if (archive.getState().equals("丢失")) {
                //更新Archive表
                try {
                    findService.updateArchive(archiveId);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                //将该档案记录插入Find表
                //使用apache下一个工具类，将值进行拷贝,只要parameterMap中的key与blog中对应的属性一致，那么其key对应的值就能够注入到这个bean的对应属性中
                Find find = new Find();
                System.out.print("参数值" + req.getParameterMap());
                BeanUtils.populate(find, req.getParameterMap());
                findService.insertFind(find);
                System.out.print("Find表更新了一条数据!");

            }else {
                String err = "该记录状态为"+archive.getState() + ",未丢失的档案不能进行找回登记!";
                req.setAttribute("error",err);
                System.out.print("该记录状态为"+archive.getState() + ",未丢失的档案不能进行找回登记!");
            }
        }
        return "findResult";

    }


}

