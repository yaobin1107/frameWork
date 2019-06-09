package cn.yb.spring.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Programmer {
    private List<String> cars;
    private Set<String> pets;
    private Map<String, String> infos;//信息
    private Properties mysqlInfo;//mysql数据库连接信息
    private String[] members;//家庭成员

    public String[] getMembers() {
        return members;
    }

    public void setMembers(String[] members) {
        this.members = members;
    }

    public Properties getMysqlInfo() {
        return mysqlInfo;
    }

    public void setMysqlInfo(Properties mysqlInfo) {
        this.mysqlInfo = mysqlInfo;
    }

    public Map<String, String> getInfos() {
        return infos;
    }

    public void setInfos(Map<String, String> infos) {
        this.infos = infos;
    }

    public Set<String> getPets() {
        return pets;
    }

    public void setPets(Set<String> pets) {
        this.pets = pets;
    }

    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }
}
