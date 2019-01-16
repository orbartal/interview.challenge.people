package interview.challenge.people.internal;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("PersoneService")
final public class PersoneService {

	final private IPersoneDaoService personeDaoService;

	public PersoneService(IPersoneDaoService personeDaoService) {
		this.personeDaoService = personeDaoService;
	}

	public List<Person> getAll() {
		return personeDaoService.getAll();
	}

}
