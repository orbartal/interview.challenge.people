package interview.challenge.people.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
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
	
	@ExceptionHandler(Exception.class)
	public void handle(HttpServletRequest request, Exception e) throws Exception {
		throw e;
	}

}
