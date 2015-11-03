package ua.dp.markos.addressbook.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.dp.markos.addressbook.entity.Person;

/**
 * Created by kmarkovych on 23.10.2015.
 */
@Repository
public interface IPersonDao extends CrudRepository<Person, Long> {

}
