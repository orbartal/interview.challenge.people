package interview.challenge.people.web;

import org.springframework.core.convert.converter.Converter;

import interview.challenge.people.internal.Person;

public class ConverterPersonDtoToPerson implements Converter<PersonDto, Person> {

	@Override
	public Person convert(PersonDto source) {
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
