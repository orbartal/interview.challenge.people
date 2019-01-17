package interview.challenge.people.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController {

	private PersonWebService personWebService;

	public PersonController(PersonWebService personWebService) {
		this.personWebService = personWebService;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<PersonDto> getAll() {
		return personWebService.getAll();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public void create(@RequestBody PersonDto input) {
		personWebService.create(input);
	}
	
	//https://stackoverflow.com/questions/25375046/passing-data-in-the-body-of-a-delete-request
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Long delete(@PathVariable("id") Long id) {
		personWebService.delete(id);
		return id;
	}
	
	@ExceptionHandler(Exception.class)
	public void handle(HttpServletRequest request, Exception e) throws Exception {
		throw e;
	}

}
