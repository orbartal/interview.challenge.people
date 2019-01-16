package interview.challenge.people.web;

import org.junit.Assert;
import org.junit.Test;

public class PersonDtoTest {
	
	@Test
	public void testSetId() throws Exception {
		Long id = 10L;
		PersonDto person = new PersonDto();
		person.setId(id);
		Assert.assertEquals(id, person.getId());
	}

	@Test
	public void testSetFirstName() throws Exception {
		String firstName = "Or";
		PersonDto person = new PersonDto();
		person.setFirstName(firstName);
		Assert.assertEquals(firstName, person.getFirstName());
	}

	@Test
	public void testSetLastName() throws Exception {
		String lastName = "Bartal";
		PersonDto person = new PersonDto();
		person.setLastName(lastName);
		Assert.assertEquals(lastName, person.getLastName());
	}

	@Test
	public void testSetAge() throws Exception {
		Integer age = 10;
		PersonDto person = new PersonDto();
		person.setAge(age);
		Assert.assertEquals(age, person.getAge());
	}

	@Test
	public void testEqualsWithNulld() throws Exception {
		PersonDto person1 = new PersonDto();
		PersonDto person2 = new PersonDto();
		Assert.assertEquals(person1, person2);
	}

	@Test
	public void testEqualsWithEqualsNonNullId() throws Exception {
		Long id = 8L;
		PersonDto person1 = new PersonDto();
		person1.setId(id);
		PersonDto person2 = new PersonDto();
		person2.setId(id);
		Assert.assertEquals(person1, person2);
	}

	@Test
	public void testEqualsWithUnEqualsNonNullId() throws Exception {
		Long id1 = 8L, id2 = 9L;
		PersonDto person1 = new PersonDto();
		person1.setId(id1);
		PersonDto person2 = new PersonDto();
		person2.setId(id2);
		Assert.assertNotEquals(person1, person2);
	}

	@Test
	public void testEqualsWithUnEqualsNonNullAndNullId() throws Exception {
		Long id1 = 8L, id2 = null;
		PersonDto person1 = new PersonDto();
		person1.setId(id1);
		PersonDto person2 = new PersonDto();
		person2.setId(id2);
		Assert.assertNotEquals(person1, person2);
	}

	@Test
	public void testToString() throws Exception {
		Long id = 976L;
		String firstName = "Syed";
		String lastName = "Saqib";
		Integer age = 37;

		PersonDto person = new PersonDto();
		person.setId(id);
		person.setAge(age);
		person.setFirstName(firstName);
		person.setLastName(lastName);

		String expected = "PersonDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + "]";
		String actual = person.toString();
		Assert.assertEquals(expected, actual);
	}


}
