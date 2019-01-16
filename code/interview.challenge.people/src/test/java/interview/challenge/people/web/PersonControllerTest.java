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

@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {

	@Mock
	private PersonWebService personWebService;

	@InjectMocks
	private PersonController fixure;

	@Test
	public void testGetAll() throws Exception {
		// setup
		PersonDto persone1 = new PersonDtoBuilder().withId(768L).build();
		PersonDto persone2 = new PersonDtoBuilder().withId(90L).build();
		PersonDto persone3 = new PersonDtoBuilder().withId(947L).build();
		List<PersonDto> expected = Lists.newArrayList(persone1, persone2, persone3);
		Mockito.when(personWebService.getAll()).thenReturn(expected);
		// execute
		List<PersonDto> actual = fixure.getAll();
		// verify
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCreate() throws Exception {
		// setup
		Long id = 976L;
		String firstName = "Syed";
		String lastName = "Saqib";
		Integer age = 37;
		PersonDto input = new PersonDtoBuilder().withId(id).withAge(age).withFirstName(firstName).withLastName(lastName)
				.build();
		// execute
		fixure.create(input);
		// verify
		Mockito.verify(personWebService).create(input);
	}

}
