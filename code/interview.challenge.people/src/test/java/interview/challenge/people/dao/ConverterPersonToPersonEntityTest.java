package interview.challenge.people.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import interview.challenge.people.internal.Person;
import interview.challenge.people.internal.PersonBuilder;

@RunWith(MockitoJUnitRunner.class)
public class ConverterPersonToPersonEntityTest {

	private ConverterPersonToPersonEntity fixure;

	@Before
	public void setup() {
		fixure = new ConverterPersonToPersonEntity();
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
		Person input = new PersonBuilder().withId(id).withAge(age).withFirstName(firstName).withLastName(lastName)
				.build();
		PersonEntity expected = new PersonEntityBuilder().withId(id).withAge(age).withFirstName(firstName)
				.withLastName(lastName).build();
		// execute
		PersonEntity actual = fixure.convert(input);
		// verify
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getAge(), actual.getAge());
		Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
		Assert.assertEquals(expected.getLastName(), actual.getLastName());
	}

}
