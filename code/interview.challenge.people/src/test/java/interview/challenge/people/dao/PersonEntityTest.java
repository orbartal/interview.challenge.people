package interview.challenge.people.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PersonEntityTest {

	@Test
	public void testSetId() throws Exception {
		Long id = 10L;
		PersonEntity person = new PersonEntity();
		person.setId(id);
		Assert.assertEquals(id, person.getId());
	}

	@Test
	public void testSetFirstName() throws Exception {
		String firstName = "Or";
		PersonEntity person = new PersonEntity();
		person.setFirstName(firstName);
		Assert.assertEquals(firstName, person.getFirstName());
	}

	@Test
	public void testSetLastName() throws Exception {
		String lastName = "Bartal";
		PersonEntity person = new PersonEntity();
		person.setLastName(lastName);
		Assert.assertEquals(lastName, person.getLastName());
	}

	@Test
	public void testSetAge() throws Exception {
		Integer age = 10;
		PersonEntity person = new PersonEntity();
		person.setAge(age);
		Assert.assertEquals(age, person.getAge());
	}

	@Test
	public void testEqualsWithNulld() throws Exception {
		PersonEntity person1 = new PersonEntity();
		PersonEntity person2 = new PersonEntity();
		Assert.assertEquals(person1, person2);
	}

	@Test
	public void testEqualsWithEqualsNonNullId() throws Exception {
		Long id = 8L;
		PersonEntity person1 = new PersonEntity();
		person1.setId(id);
		PersonEntity person2 = new PersonEntity();
		person2.setId(id);
		Assert.assertEquals(person1, person2);
	}

	@Test
	public void testEqualsWithUnEqualsNonNullId() throws Exception {
		Long id1 = 8L, id2 = 9L;
		PersonEntity person1 = new PersonEntity();
		person1.setId(id1);
		PersonEntity person2 = new PersonEntity();
		person2.setId(id2);
		Assert.assertNotEquals(person1, person2);
	}

	@Test
	public void testEqualsWithUnEqualsNonNullAndNullId() throws Exception {
		Long id1 = 8L, id2 = null;
		PersonEntity person1 = new PersonEntity();
		person1.setId(id1);
		PersonEntity person2 = new PersonEntity();
		person2.setId(id2);
		Assert.assertNotEquals(person1, person2);
	}

	@Test
	public void testToString() throws Exception {
		Long id = 976L;
		String firstName = "Syed";
		String lastName = "Saqib";
		Integer age = 37;

		PersonEntity person = new PersonEntity();
		person.setId(id);
		person.setAge(age);
		person.setFirstName(firstName);
		person.setLastName(lastName);

		String expected = "PersonEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + "]";
		String actual = person.toString();
		Assert.assertEquals(expected, actual);
	}

}
