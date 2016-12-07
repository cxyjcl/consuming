package cn.whpu.management.entity;

import java.util.Date;

/**
 * Created by Fiona on 2016/11/6.
 */
public class Project_Info {

    private int id;
    private String project;
    private String need_time;
    private String purchase_method;
    private String subpackage;
    private String experimenter;
    private String lesson;
    private String plan;
    private String subgroup;
    private String people;
    private Date recipient_time;
    private Date declare_time;
    private int status;
    private String equipment_audit;
    private String auditor_audit;
    private String equipment_notation;
    private String auditor_notation;
    private String remark;
    private int user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getNeed_time() {
        return need_time;
    }

    public void setNeed_time(String need_time) {
        this.need_time = need_time;
    }

    public String getPurchase_method() {
        return purchase_method;
    }

    public void setPurchase_method(String purchase_method) {
        this.purchase_method = purchase_method;
    }

    public String getSubpackage() {
        return subpackage;
    }

    public void setSubpackage(String subpackage) {
        this.subpackage = subpackage;
    }

    public String getExperimenter() {
        return experimenter;
    }

    public void setExperimenter(String experimenter) {
        this.experimenter = experimenter;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public Date getRecipient_time() {
        return recipient_time;
    }

    public void setRecipient_time(Date recipient_time) {
        this.recipient_time = recipient_time;
    }

    public Date getDeclare_time() {
        return declare_time;
    }

    public void setDeclare_time(Date declare_time) {
        this.declare_time = declare_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEquipment_audit() {
        return equipment_audit;
    }

    public void setEquipment_audit(String equipment_audit) {
        this.equipment_audit = equipment_audit;
    }

    public String getAuditor_audit() {
        return auditor_audit;
    }

    public void setAuditor_audit(String auditor_audit) {
        this.auditor_audit = auditor_audit;
    }

    public String getEquipment_notation() {
        return equipment_notation;
    }

    public void setEquipment_notation(String equipment_notation) {
        this.equipment_notation = equipment_notation;
    }

    public String getAuditor_notation() {
        return auditor_notation;
    }

    public void setAuditor_notation(String auditor_notation) {
        this.auditor_notation = auditor_notation;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(String subgroup) {
        this.subgroup = subgroup;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Project_Info{" +
                "id=" + id +
                ", project='" + project + '\'' +
                ", need_time='" + need_time + '\'' +
                ", purchase_method='" + purchase_method + '\'' +
                ", subpackage='" + subpackage + '\'' +
                ", experimenter='" + experimenter + '\'' +
                ", lesson='" + lesson + '\'' +
                ", plan='" + plan + '\'' +
                ", subgroup='" + subgroup + '\'' +
                ", people='" + people + '\'' +
                ", recipient_time=" + recipient_time +
                ", declare_time=" + declare_time +
                ", status=" + status +
                ", equipment_audit='" + equipment_audit + '\'' +
                ", auditor_audit='" + auditor_audit + '\'' +
                ", equipment_notation='" + equipment_notation + '\'' +
                ", auditor_notation='" + auditor_notation + '\'' +
                ", remark='" + remark + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
