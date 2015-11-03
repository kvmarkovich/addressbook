package ua.dp.markos.addressbook.controller;

import ua.dp.markos.addressbook.entity.Address;
import ua.dp.markos.addressbook.entity.Person;

import java.util.Date;

/**
 * Created by kmarkovych on 26.10.2015.
 */
public class PeopleForTests {
    public final Address FIRST_ADDRESS = new Address("Pacific", "SomeReef", 20, true);
    public final Person person = new Person("First", "Middle", "Last", new Date(), "M", FIRST_ADDRESS);
}
