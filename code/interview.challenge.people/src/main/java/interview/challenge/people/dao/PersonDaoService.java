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
	private ConverterPersonToPersonEntity converterPersonToPersonEntity;

	public PersonDaoService(PersonRepository personRepository,
			ConverterPersonEntityToPerson converterPersonEntityToPerson,
			ConverterPersonToPersonEntity converterPersonToPersonEntity) {
		this.personRepository = personRepository;
		this.converterPersonEntityToPerson = converterPersonEntityToPerson;
		this.converterPersonToPersonEntity = converterPersonToPersonEntity;
	}

	@Override
	public List<Person> getAll() {
		List<PersonEntity> entites = Lists.newArrayList(personRepository.findAll());
		return entites.stream().map(this::toPerson).collect(Collectors.toList());
	}
	
	@Override
	public void create(Person person) {
		PersonEntity entity = toPersonEntity(person);
		personRepository.save(entity);
	}
	
	@Override
	public void delete(Long id) {
		personRepository.delete(id);
	}

	private Person toPerson(PersonEntity source) {
		return converterPersonEntityToPerson.convert(source);
	}
	
	private PersonEntity toPersonEntity(Person source) {
		return converterPersonToPersonEntity.convert(source);
	}

}
