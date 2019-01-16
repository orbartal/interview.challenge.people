package interview.challenge.people.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interview.challenge.people.internal.Person;
import interview.challenge.people.internal.PersonBuilder;

public class ConverterPersonEntityToPersonTest {

	private ConverterPersonEntityToPerson fixure = new ConverterPersonEntityToPerson();

	@Before
	public void setup() {
		fixure = new ConverterPersonEntityToPerson();
	}

	@Test
	public void testConvertFromNull() throws Exception {
		Assert.assertNull(fixure.convert(null));
	}

	@Test
	public void testConvertFromNonNull() throws Exception {
		// setup
		Long id = 976L;
		String firstName = "Syed";
		String lastName = "Saqib";
		Integer age = 37;
		Person expected = new PersonBuilder().withId(id).withAge(age).withFirstName(firstName).withLastName(lastName)
				.build();
		PersonEntity input = new PersonEntityBuilder().withId(id).withAge(age).withFirstName(firstName)
				.withLastName(lastName).build();
		// execute
		Person actual = fixure.convert(input);
		// verify
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getAge(), actual.getAge());
		Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
		Assert.assertEquals(expected.getLastName(), actual.getLastName());
	}

}
