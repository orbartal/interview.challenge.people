package interview.challenge.people.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import interview.challenge.people.internal.IPersonDaoService;
import interview.challenge.people.internal.Person;

@Service("PersonDaoService")
public class PersonDaoService implements IPersonDaoService {

	private PersonRepository personRepository;
	private ConverterPersonEntityToPerson converterPersonEntityToPerson;

	public PersonDaoService(PersonRepository personRepository,
			ConverterPersonEntityToPerson converterPersonEntityToPerson) {
		this.personRepository = personRepository;
		this.converterPersonEntityToPerson = converterPersonEntityToPerson;
	}

	@Override
	public List<Person> getAll() {
		List<PersonEntity> entites = Lists.newArrayList(personRepository.findAll());
		return entites.stream().map(this::toPerson).collect(Collectors.toList());
	}

	private Person toPerson(PersonEntity source) {
		return converterPersonEntityToPerson.convert(source);
	}

}
