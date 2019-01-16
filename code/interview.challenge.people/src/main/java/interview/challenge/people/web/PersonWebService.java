package interview.challenge.people.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import interview.challenge.people.internal.Person;
import interview.challenge.people.internal.PersonService;

@Service("PersonWebService")
public class PersonWebService {

	private PersonService personeService;
	private ConverterPersonToPersonDto converterPersonToPersonDto;
	private ConverterPersonDtoToPerson converterPersonDtoToPerson;

	public PersonWebService(PersonService personeService, ConverterPersonToPersonDto converterPersonToPersonDto,
			ConverterPersonDtoToPerson converterPersonDtoToPerson) {
		this.personeService = personeService;
		this.converterPersonToPersonDto = converterPersonToPersonDto;
		this.converterPersonDtoToPerson = converterPersonDtoToPerson;
	}

	public List<PersonDto> getAll() {
		return personeService.getAll().stream().map(this::toPersonDto).collect(Collectors.toList());
	}

	public void create(PersonDto input) {
		Person person = toPerson(input);
		personeService.create(person);
	}

	private PersonDto toPersonDto(Person source) {
		return converterPersonToPersonDto.convert(source);
	}

	private Person toPerson(PersonDto source) {
		return converterPersonDtoToPerson.convert(source);
	}

}
