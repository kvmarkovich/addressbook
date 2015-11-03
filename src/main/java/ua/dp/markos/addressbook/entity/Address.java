package ua.dp.markos.addressbook.entity;

import java.io.Serializable;

/**
 * Created by kmarkovych on 22.10.2015.
 */
public class Address implements Serializable {
    protected Long id;
    protected String ocean;
    protected String reef;
    protected int dept;
    protected boolean isHome;

    public Address() {
    }

    public Address(String ocean, String reef, int dept, boolean isHome) {
        this.ocean = ocean;
        this.reef = reef;
        this.dept = dept;
        this.isHome = isHome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOcean() {
        return ocean;
    }

    public void setOcean(String ocean) {
        this.ocean = ocean;
    }

    public String getReef() {
        return reef;
    }

    public void setReef(String reef) {
        this.reef = reef;
    }

    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }

    public boolean getIsHome() {
        return isHome;
    }

    public void setHome(boolean isHome) {
        this.isHome = isHome;
    }


    public boolean isHome() {
        return isHome;
    }

    public void setIsHome(boolean isHome) {
        this.isHome = isHome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address that = (Address) o;

        if (dept != that.dept) return false;
        if (isHome != that.isHome) return false;
        if (ocean != null ? !ocean.equals(that.ocean) : that.ocean != null) return false;
        if (reef != null ? !reef.equals(that.reef) : that.reef != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ocean != null ? ocean.hashCode() : 0;
        result = 31 * result + (reef != null ? reef.hashCode() : 0);
        result = 31 * result + dept;
        result = 31 * result + (isHome ? 1 : 0);
        return result;
    }
}
