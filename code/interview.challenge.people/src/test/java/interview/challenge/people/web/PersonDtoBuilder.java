package interview.challenge.people.web;

public class PersonDtoBuilder {
	
	private Long id = null;
	private String firstName = null;
	private String lastName = null;
	private Integer age = null;
	
	public PersonDtoBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public PersonDtoBuilder withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public PersonDtoBuilder withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public PersonDtoBuilder withAge(Integer age) {
		this.age = age;
		return this;
	}

	public void reset() {
		id = null;
		firstName = null;
		lastName = null;
		age = null;
	}

	public PersonDto build() {
		PersonDto person = new PersonDto();
		person.setId(id);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setAge(age);
		return person;
	}

}
