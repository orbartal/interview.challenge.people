package interview.challenge.people.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import interview.challenge.people.internal.Person;
import interview.challenge.people.internal.PersoneService;

@Service("PersonWebService")
public class PersonWebService {

	private PersoneService personeService;
	private ConverterPersonToPersonDto converterPersonToPersonDto;
	
	

	public PersonWebService(PersoneService personeService, ConverterPersonToPersonDto converterPersonToPersonDto) {
		this.personeService = personeService;
		this.converterPersonToPersonDto = converterPersonToPersonDto;
	}

	public List<PersonDto> getAll() {
		return personeService.getAll().stream().map(this::toPersonDto).collect(Collectors.toList());
	}

	private PersonDto toPersonDto(Person source) {
		return converterPersonToPersonDto.convert(source);
	}

}
