package interview.challenge.people.internal;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("PersoneService")
final public class PersoneService implements IPersoneService {

	final private IPersoneDaoService personeDaoService;

	public PersoneService(IPersoneDaoService personeDaoService) {
		this.personeDaoService = personeDaoService;
	}
	
	public List<IPerson> getAll(){
		return personeDaoService.getAll();
	}
	
}
