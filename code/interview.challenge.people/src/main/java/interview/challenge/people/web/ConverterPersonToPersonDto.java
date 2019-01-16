package interview.challenge.people.web;

import org.springframework.core.convert.converter.Converter;

import interview.challenge.people.internal.Person;

public class ConverterPersonToPersonDto implements Converter<Person, PersonDto> {

	@Override
	public PersonDto convert(Person source) {
		if (source == null) {
			return null;
		}
		PersonDto target = new PersonDto();
		target.setId(source.getId());
		target.setAge(source.getAge());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		return target;
	}

}
