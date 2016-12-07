package cn.whpu.management.controller;

import cn.whpu.management.entity.Consuming_Info;
import cn.whpu.management.entity.Project_Info;
import cn.whpu.management.exception.Message;
import cn.whpu.management.service.ConsumingService;
import cn.whpu.management.vo.ConsumingInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Fiona on 2016/11/6.
 */
@RestController
@RequestMapping("/consuming")
public class ConsumingController {

    @Resource
    ConsumingService service;
    Map map= new HashMap();
    /**
     *
     * @param consuming
     * @param session
     */
    @RequestMapping(value = "/consuming.do",method = RequestMethod.POST, consumes = "application/json;charset=utf-8", produces = "application/json;charset=utf-8")
    public Map consuming(@RequestBody ConsumingInfo consuming, HttpSession session){
        int id = Integer.parseInt(session.getAttribute("userId").toString());
        int projectId = service.addProject(consuming.getProject(),id);
        service.addConsuming(consuming.getConsuming(),projectId);
        map.put("code", Message._10000.getCode());
        map.put("content",Message._10000.getMessage());
        return map;
    }

    @RequestMapping(value = "/upload.do",method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("excel") MultipartFile excel,HttpSession session){
        int id = Integer.parseInt(session.getAttribute("userId").toString());
        File file = new File("/"+excel.getOriginalFilename());
        try {
            excel.transferTo(file);
            System.out.println(file.getName());
            service.readExcel(file,id);
        } catch (IOException e) {
            file.delete();
            e.printStackTrace();
        }
        return "redirect:/view/component/consuming.html";
    }

    @RequestMapping(value = "/download.do",method = RequestMethod.GET)
    @ResponseBody
    public void upload(HttpServletResponse response,HttpServletRequest request) throws IOException {
        String ctxPath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF\\File\\excel.xls";
        System.out.println(ctxPath);
        response.setContentType("application/x-msdownload;");
        response.setHeader("Content-disposition", "attachment; filename="
                + new String("excel.xls".getBytes("utf-8"), "ISO8859-1"));
        InputStream in = new FileInputStream(new File(ctxPath));
        OutputStream out = new BufferedOutputStream(response.getOutputStream());
        int byteread = 0;
        byte[] buffer = new byte[1024];
        while ((byteread = in.read(buffer)) != -1) {
            out.write(buffer, 0, byteread);
        }
        in.close();
        out.close();
    }

    @RequestMapping(value = "/reject.do",method = RequestMethod.POST)
    @ResponseBody
    public void reject(@RequestParam("username") String username){

    }
}
