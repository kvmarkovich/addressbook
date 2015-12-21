package ua.dp.markos.addressbook.entity;

import java.io.Serializable;

/**
 * Created by kmarkovych on 22.10.2015.
 */
public class Address implements Serializable {
    protected Long id;
    protected String city;
    protected String street;
    protected int house;
    protected int apartment;
    protected boolean isHome;

    public Address() {
    }

    public Address(String city, String street, int house, int apartment, boolean isHome) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.isHome = isHome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
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

        Address address = (Address) o;

        if (apartment != address.apartment) return false;
        if (house != address.house) return false;
        if (isHome != address.isHome) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + house;
        result = 31 * result + apartment;
        result = 31 * result + (isHome ? 1 : 0);
        return result;
    }
}
