package interview.challenge.people.internal;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("PersonService")
public class PersonService {

	final private IPersonDaoService personeDaoService;

	public PersonService(IPersonDaoService personeDaoService) {
		this.personeDaoService = personeDaoService;
	}

	public List<Person> getAll() {
		return personeDaoService.getAll();
	}

}
