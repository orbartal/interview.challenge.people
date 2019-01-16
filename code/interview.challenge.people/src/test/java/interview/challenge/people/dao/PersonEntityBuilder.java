package interview.challenge.people.dao;

import interview.challenge.people.dao.PersonEntity;

public class PersonEntityBuilder {
	
	private Long id = null;
	private String firstName = null;
	private String lastName = null;
	private Integer age = null;

	public PersonEntityBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public PersonEntityBuilder withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public PersonEntityBuilder withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public PersonEntityBuilder withAge(Integer age) {
		this.age = age;
		return this;
	}

	public void reset() {
		id = null;
		firstName = null;
		lastName = null;
		age = null;
	}

	public PersonEntity build() {
		PersonEntity person = new PersonEntity();
		person.setId(id);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setAge(age);
		return person;
	}

}
