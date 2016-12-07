package cn.whpu.management.vo;

import cn.whpu.management.entity.Consuming_Info;
import cn.whpu.management.entity.Project_Info;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Fiona on 2016/11/6.
 */
public class ConsumingInfo {

    private Project_Info project;
    private List<Consuming_Info> consuming;

    public List<Consuming_Info> getConsuming() {
        return consuming;
    }

    public void setConsuming(List<Consuming_Info> consuming) {
        this.consuming = consuming;
    }

    public Project_Info getProject() {
        return project;
    }

    public void setProject(Project_Info project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "ConsumingInfo{" +
                "project=" + project +
                ", consuming=" + consuming +
                '}';
    }
}
