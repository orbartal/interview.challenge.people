package interview.challenge.people.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import interview.challenge.people.internal.IPersoneDaoService;
import interview.challenge.people.internal.Person;

@Service("PersoneDaoService")
public class PersoneDaoService implements IPersoneDaoService {

	private PersonRepository personRepository;
	private ConverterPersonEntityToPerson converterPersonEntityToPerson;

	@Override
	public List<Person> getAll() {
		List<PersonEntity> entites = Lists.newArrayList(personRepository.findAll());
		return entites.stream().map(this::toPerson).collect(Collectors.toList());
	}

	private Person toPerson(PersonEntity source) {
		return converterPersonEntityToPerson.convert(source);
	}

}
