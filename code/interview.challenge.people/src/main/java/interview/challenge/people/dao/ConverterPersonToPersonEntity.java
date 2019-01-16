package interview.challenge.people.dao;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import interview.challenge.people.internal.Person;

@Service("ConverterPersonToPersonEntity")
public class ConverterPersonToPersonEntity implements Converter<Person, PersonEntity> {

	@Override
	public PersonEntity convert(Person source) {
		if (source == null) {
			return null;
		}
		PersonEntity target = new PersonEntity();
		target.setId(source.getId());
		target.setAge(source.getAge());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		return target;
	}

}
