package interview.challenge.people.web;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import interview.challenge.people.internal.Person;
import interview.challenge.people.internal.PersonBuilder;
import interview.challenge.people.internal.PersonService;

@RunWith(MockitoJUnitRunner.class)
public class PersonWebServiceTest {

	@Mock
	private PersonService personeService;

	@Mock
	private ConverterPersonToPersonDto converterPersonToPersonDto;

	@Mock
	private ConverterPersonDtoToPerson converterPersonDtoToPerson;

	@InjectMocks
	private PersonWebService fixure;

	@Test
	public void testGetAll() throws Exception {
		// setup
		Person persone1 = new PersonBuilder().withId(768L).build();
		Person persone2 = new PersonBuilder().withId(90L).build();
		Person persone3 = new PersonBuilder().withId(947L).build();
		List<Person> people = Lists.newArrayList(persone1, persone2, persone3);
		Mockito.when(personeService.getAll()).thenReturn(people);

		PersonDto dto1 = new PersonDtoBuilder().withId(768L).build();
		PersonDto dto2 = new PersonDtoBuilder().withId(90L).build();
		PersonDto dto3 = new PersonDtoBuilder().withId(947L).build();
		List<PersonDto> expected = Lists.newArrayList(dto1, dto2, dto3);
		for (int i = 0; i < 3; i++) {
			Mockito.when(converterPersonToPersonDto.convert(people.get(i))).thenReturn(expected.get(i));
		}
		// execute
		List<PersonDto> actual = fixure.getAll();
		// verify
		Assert.assertEquals(expected, actual);
		Mockito.verify(personeService).getAll();
		for (int i = 0; i < 3; i++) {
			Mockito.verify(converterPersonToPersonDto).convert(people.get(i));
		}
	}

	@Test
	public void testCreate() throws Exception {
		// setup
		Long id = 976L;
		String firstName = "Syed";
		String lastName = "Saqib";
		Integer age = 37;
		Person person = new PersonBuilder().withAge(age).withFirstName(firstName).withLastName(lastName).build();
		PersonDto input = new PersonDtoBuilder().withId(id).withAge(age).withFirstName(firstName).withLastName(lastName)
				.build();
		Mockito.when(converterPersonDtoToPerson.convert(input)).thenReturn(person);
		// execute
		fixure.create(input);
		// verify
		Mockito.verify(converterPersonDtoToPerson).convert(input);
		Mockito.verify(personeService).create(person);
	}

	@Test
	public void testDelete() throws Exception {
		Long id = 11L;
		fixure.delete(id);
		Mockito.verify(personeService).delete(id);
	}

}
