package cn.whpu.management.entity;

/**
 * Created by Fiona on 2016/11/6.
 */
public class Consuming_Info {
    private int consuming_info_id;
    private String consuming;
    private String standard;
    private String pack;
    private String brand;
    private String unit;
    private int num;
    private String classify;
    private boolean is_danger = false;
    private double single_price;
    private double sum_price;
    private int project_info_id;

    public int getConsuming_info_id() {
        return consuming_info_id;
    }

    public void setConsuming_info_id(int consuming_info_id) {
        this.consuming_info_id = consuming_info_id;
    }

    public String getConsuming() {
        return consuming;
    }

    public void setConsuming(String consuming) {
        this.consuming = consuming;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public boolean is_danger() {
        return is_danger;
    }

    public void setIs_danger(boolean is_danger) {
        this.is_danger = is_danger;
    }

    public double getSingle_price() {
        return single_price;
    }

    public void setSingle_price(double single_price) {
        this.single_price = single_price;
    }

    public double getSum_price() {
        return sum_price;
    }

    public void setSum_price(double sum_price) {
        this.sum_price = sum_price;
    }

    public int getProject_info_id() {
        return project_info_id;
    }

    public void setProject_info_id(int project_info_id) {
        this.project_info_id = project_info_id;
    }

    @Override
    public String toString() {
        return "Consuming_Info{" +
                "consuming_info_id=" + consuming_info_id +
                ", consuming='" + consuming + '\'' +
                ", standard='" + standard + '\'' +
                ", pack='" + pack + '\'' +
                ", brand='" + brand + '\'' +
                ", unit='" + unit + '\'' +
                ", num=" + num +
                ", classify='" + classify + '\'' +
                ", is_danger=" + is_danger +
                ", single_price=" + single_price +
                ", sum_price=" + sum_price +
                ", project_info_id=" + project_info_id +
                '}';
    }
}
