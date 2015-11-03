package ua.dp.markos.addressbook.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import ua.dp.markos.addressbook.LegaSeaSpringApplication;
import ua.dp.markos.addressbook.dao.IAddressDao;
import ua.dp.markos.addressbook.dao.IPersonDao;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LegaSeaSpringApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@DirtiesContext
public class PersonControllerTest {

    @Value("${local.server.port}")
    private int port;

    private RestTemplate restTemplate = new TestRestTemplate();

    @Autowired
    IPersonDao fishDao;
    @Autowired
    IAddressDao fishAddressDao;

    PeopleForTests peopleForTests = new PeopleForTests();

    @Before
    public void setUp() throws Exception {
        fishDao.save(peopleForTests.person);
    }


    @Test
    public void testIndex() throws Exception {
        ResponseEntity<String> entity = this.restTemplate
                .getForEntity("http://localhost:" + this.port + "/", String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertTrue("Wrong body (title doesn't match):\n" + entity.getBody(),
                entity.getBody().contains("<title>LegaSea Home</title>"));
        assertFalse("Wrong body (found layout:fragment):\n" + entity.getBody(),
                entity.getBody().contains("layout:fragment"));

    }

    @Test
    public void testXml() throws Exception {
        ResponseEntity<String> entity = this.restTemplate
                .getForEntity("http://localhost:" + this.port + "/xml", String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals("Wrong Content Type!",
                "[application/xml;charset=UTF-8]", String.valueOf(entity.getHeaders().get(HttpHeaders.CONTENT_TYPE)));
        String body = entity.getBody();
        assertTrue("Wrong XML format:\n" + body,
                body.contains("<?xml version=\"1.0\" encoding=\"UTF-8\""));
        assertTrue("XML doesn't contain any fishes:\n" + body,
                body.contains("<fish>"));
        assertTrue("XML doesn't contain requested fish first name:\n" + body,
                body.contains("<firstName>" + peopleForTests.person.getFirstName()));
        assertTrue("XML doesn't contain requested fishes address:\n" + body,
                body.contains("<addresses>"));
        assertTrue("XML doesn't contain requested ocean in address:\n" + body,
                body.contains("<ocean>" + peopleForTests.FIRST_ADDRESS.getOcean()));

    }

    @Test
    public void testXMLEncoder() throws Exception {

    }
}