package interview.challenge.people.internal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PersonTest {

	@Test
	public void testSetId() throws Exception {
		Long id = 10L;
		Person person = new Person();
		person.setId(id);
		Assert.assertEquals(id, person.getId());
	}

	@Test
	public void testSetFirstName() throws Exception {
		String firstName = "Or";
		Person person = new Person();
		person.setFirstName(firstName);
		Assert.assertEquals(firstName, person.getFirstName());
	}

	@Test
	public void testSetLastName() throws Exception {
		String lastName = "Bartal";
		Person person = new Person();
		person.setLastName(lastName);
		Assert.assertEquals(lastName, person.getLastName());
	}

	@Test
	public void testSetAge() throws Exception {
		Integer age = 10;
		Person person = new Person();
		person.setAge(age);
		Assert.assertEquals(age, person.getAge());
	}

	@Test
	public void testEqualsWithNulld() throws Exception {
		Person person1 = new Person();
		Person person2 = new Person();
		Assert.assertEquals(person1, person2);
	}

	@Test
	public void testEqualsWithEqualsNonNullId() throws Exception {
		Long id = 8L;
		Person person1 = new Person();
		person1.setId(id);
		Person person2 = new Person();
		person2.setId(id);
		Assert.assertEquals(person1, person2);
	}

	@Test
	public void testEqualsWithUnEqualsNonNullId() throws Exception {
		Long id1 = 8L, id2 = 9L;
		Person person1 = new Person();
		person1.setId(id1);
		Person person2 = new Person();
		person2.setId(id2);
		Assert.assertNotEquals(person1, person2);
	}

	@Test
	public void testEqualsWithUnEqualsNonNullAndNullId() throws Exception {
		Long id1 = 8L, id2 = null;
		Person person1 = new Person();
		person1.setId(id1);
		Person person2 = new Person();
		person2.setId(id2);
		Assert.assertNotEquals(person1, person2);
	}

	@Test
	public void testToString() throws Exception {
		Long id = 976L;
		String firstName = "Syed";
		String lastName = "Saqib";
		Integer age = 37;

		Person person = new Person();
		person.setId(id);
		person.setAge(age);
		person.setFirstName(firstName);
		person.setLastName(lastName);

		String expected = "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ "]";
		String actual = person.toString();
		Assert.assertEquals(expected, actual);
	}

}
