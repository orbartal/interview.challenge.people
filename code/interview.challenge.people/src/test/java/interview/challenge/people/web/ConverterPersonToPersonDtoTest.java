package interview.challenge.people.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import interview.challenge.people.internal.Person;
import interview.challenge.people.internal.PersonBuilder;

@RunWith(MockitoJUnitRunner.class)
public class ConverterPersonToPersonDtoTest {

	private ConverterPersonToPersonDto fixture;

	@Before
	public void setup() {
		fixture = new ConverterPersonToPersonDto();
	}

	@Test
	public void testConvertFromNull() throws Exception {
		Assert.assertNull(fixture.convert(null));
	}

	@Test
	public void testConvertFromNonNull() throws Exception {
		// setup
		Long id = 976L;
		String firstName = "Syed";
		String lastName = "Saqib";
		Integer age = 37;
		Person input = new PersonBuilder().withId(id).withAge(age).withFirstName(firstName).withLastName(lastName)
				.build();
		PersonDto expected = new PersonDtoBuilder().withId(id).withAge(age).withFirstName(firstName)
				.withLastName(lastName).build();
		// execute
		PersonDto actual = fixture.convert(input);
		// verify
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getAge(), actual.getAge());
		Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
		Assert.assertEquals(expected.getLastName(), actual.getLastName());
	}

}
