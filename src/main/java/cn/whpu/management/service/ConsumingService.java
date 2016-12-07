package cn.whpu.management.service;

import cn.whpu.management.entity.Consuming_Info;
import cn.whpu.management.entity.Project_Info;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Fiona on 2016/11/8.
 */

public interface ConsumingService {

    public boolean readExcel(File file, int id) throws IOException;

    public int addProject(Project_Info project, int id);

    public void addConsuming(List<Consuming_Info> consuming,int projectId);

    }
