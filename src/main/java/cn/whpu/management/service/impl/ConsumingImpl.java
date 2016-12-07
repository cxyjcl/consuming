package cn.whpu.management.service.impl;

import cn.whpu.management.dao.ConsumingDao;
import cn.whpu.management.dao.UserDao;
import cn.whpu.management.entity.Consuming_Info;
import cn.whpu.management.entity.Project_Info;
import cn.whpu.management.service.ConsumingService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Fiona on 2016/11/8.
 */
@Service
public class ConsumingImpl implements ConsumingService {

    private POIFSFileSystem fs;
    private HSSFWorkbook wb;
    private HSSFSheet sheet;
    private HSSFRow row;
    private HSSFCell cell;
    @Resource
    private ConsumingDao dao;
    @Resource
    private UserDao user;

    @Override
    public boolean readExcel(File file, int id) throws IOException {
        try{
            isCorrect(file);
            excel(id);
        }catch (Exception e){
            wb.close();
            fs.close();
            file.delete();
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public int addProject(Project_Info project, int id) {
        project.setUser_id(id);
        dao.addProject(project);
        return project.getId();
    }

    public void addConsuming(List<Consuming_Info> consuming,int projectId) {
        for(int i =0;i<consuming.size();i++){
            Consuming_Info consumingInfo= consuming.get(i);
            consumingInfo.setProject_info_id(projectId);
            dao.addConsuming(consumingInfo);
        }
    }


    public void isCorrect(File file) throws IOException {
        int i=2;
        fs = new POIFSFileSystem(file);
        //设置要读取的文件路径
        //HSSFWorkbook相当于一个excel文件，HSSFWorkbook是解析excel2007之前的版本（xls）
        wb = new HSSFWorkbook(fs);
        sheet = wb.getSheetAt(0);
        fs = new POIFSFileSystem(new FileInputStream(file));
        row = sheet.getRow(i);
        cell= row.getCell(15);
        while(cell!=null){
            cell.getNumericCellValue();
            row = sheet.getRow(++i);
            cell= row.getCell(15);
        }
    }

    /**
     * step1: 填充project
     * step2: 插入project数据
     * step3: 插入数据
     * @param userId
     */
    public void excel(int userId){
        try {
            int i=1;
            //获得sheet工作簿
            row = sheet.getRow(i);
            Date date = new Date();
            while(row.getCell(0)!=null){
                Project_Info project = new Project_Info();
                Consuming_Info consuming = new Consuming_Info();
                //获得行
                row = sheet.getRow(i);
                //获得行中的列，即单元格
                project.setProject(row.getCell(0).getStringCellValue());
                project.setNeed_time(row.getCell(1).getStringCellValue());
                project.setPurchase_method(row.getCell(2).getStringCellValue());
                project.setSubpackage(row.getCell(3).getStringCellValue());
                project.setExperimenter(row.getCell(4).getStringCellValue());
                project.setLesson(row.getCell(5).getStringCellValue());
                project.setPlan(row.getCell(6).getStringCellValue());
                project.setSubgroup(row.getCell(7).getStringCellValue());
                project.setPeople(row.getCell(8).getStringCellValue());
                project.setRemark(row.getCell(9).getStringCellValue());
                project.setStatus(1);
                project.setDeclare_time(date);
                project.setUser_id(userId);
                consuming.setConsuming(row.getCell(10).getStringCellValue());
                consuming.setStandard(row.getCell(11).getStringCellValue());
                consuming.setPack(row.getCell(12).getStringCellValue());
                consuming.setBrand(row.getCell(13).getStringCellValue());
                consuming.setUnit(row.getCell(14).getStringCellValue());
                consuming.setNum((int)row.getCell(15).getNumericCellValue());
                consuming.setClassify(row.getCell(16).getStringCellValue());
                String str = row.getCell(17).getStringCellValue();
                dao.addProject(project);
                consuming.setProject_info_id(project.getId());
                if(str.equals("危险")){
                    consuming.setIs_danger(true);
                }
                dao.addConsuming(consuming);
                row = sheet.getRow(++i);
            }
            wb.close();
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
