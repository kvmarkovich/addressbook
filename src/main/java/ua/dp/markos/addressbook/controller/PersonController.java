package ua.dp.markos.addressbook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.dp.markos.addressbook.dao.IPersonDao;
import ua.dp.markos.addressbook.entity.Address;
import ua.dp.markos.addressbook.entity.Person;
import ua.dp.markos.addressbook.util.PersonContainer;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by kmarkovych on 23.10.2015.
 */
@Controller
@EnableAutoConfiguration
public class PersonController {

    private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    IPersonDao fishDao;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), true);
        binder.registerCustomEditor(Date.class, editor);
//        binder.registerCustomEditor(IFishType.class, new com.sun.beans.editors.EnumEditor(FishType.class));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("fishes", fishDao.findAll());
        return mav;
    }

    @RequestMapping(
            value = "/xml",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    PersonContainer xml() {
        List<Person> all = (List<Person>) fishDao.findAll();
        return new PersonContainer(all);
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        Person person = new Person();
        person.setDateOfBirth(new Date());
        ModelAndView modelAndView = new ModelAndView("add", "fish", person);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute(value = "person") @Valid Person person, BindingResult bindingResultFish) {
        LOG.info("Person to string: " + person.toString());
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResultFish.hasErrors()) {
            modelAndView.setViewName("add");
            modelAndView.getModel().put("person", person);
        } else {
            fishDao.save(person);
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/add", params = {"addAddress"})
    public String addAddress(final Person person, final BindingResult bindingResult) {
        person.getAddresses().add(new Address());
        return "add";
    }
}
