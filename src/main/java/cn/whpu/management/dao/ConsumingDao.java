package cn.whpu.management.dao;

import cn.whpu.management.entity.Consuming_Info;
import cn.whpu.management.entity.Project_Info;

import java.util.List;

/**
 * Created by Fiona on 2016/11/9.
 */
public interface ConsumingDao {

    public void addProject(Project_Info project);

    public void addConsuming(Consuming_Info consuming);

    public Project_Info getProjectInfo();
}
