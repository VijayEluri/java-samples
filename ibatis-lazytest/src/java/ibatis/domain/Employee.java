package ibatis.domain;

public class Employee {
    int id;
    String name;
    String dptCd;
    Department dpt;

    public Department getDpt() {
        return dpt;
    }

    public void setDpt(Department dpt) {
        this.dpt = dpt;
    }

    public String getDptCd() {
        return dptCd;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setDptCd(String dptCd) {
        this.dptCd = dptCd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
