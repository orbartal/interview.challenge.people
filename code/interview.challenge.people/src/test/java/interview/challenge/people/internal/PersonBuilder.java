package interview.challenge.people.internal;

public class PersonBuilder {

	private Long id = null;
	private String firstName = null;
	private String lastName = null;
	private Integer age = null;

	public PersonBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public PersonBuilder withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public PersonBuilder withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public PersonBuilder withAge(Integer age) {
		this.age = age;
		return this;
	}

	public void reset() {
		id = null;
		firstName = null;
		lastName = null;
		age = null;
	}

	public Person build() {
		Person person = new Person();
		person.setId(id);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setAge(age);
		return person;
	}

}
