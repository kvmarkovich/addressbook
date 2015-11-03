package ua.dp.markos.addressbook.util;

import ua.dp.markos.addressbook.entity.Person;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Container to transfer multiple Fishes
 * Created by kmarkovych on 25.10.2015.
 */
@XmlRootElement
public class PersonContainer implements Serializable{
    List<Person> person;

    public PersonContainer() {
        person = new ArrayList<Person>();
    }

    public PersonContainer(List<Person> person) {
        this.person = person;
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }
}
