package interview.challenge.people.dao;

import org.springframework.core.convert.converter.Converter;

import interview.challenge.people.internal.Person;

public class ConverterPersonEntityToPerson implements Converter<PersonEntity, Person> {

	@Override
	public Person convert(PersonEntity source) {
		if (source == null) {
			return null;
		}
		Person target = new Person();
		target.setId(source.getId());
		target.setAge(source.getAge());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		return target;
	}

}
