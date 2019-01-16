package interview.challenge.people.dao;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import interview.challenge.people.internal.IPersonDaoService;
import interview.challenge.people.internal.Person;
import interview.challenge.people.internal.PersonBuilder;
import interview.challenge.people.internal.PersonService;

@RunWith(MockitoJUnitRunner.class)
public class PersonDaoServiceTest {
	
	@Mock
	private PersonRepository personRepository;

	@Mock
	private ConverterPersonEntityToPerson converterPersonEntityToPerson;

	@InjectMocks
	private PersonDaoService fixure;
	
	@Test
	public void testGetAll() throws Exception {
		// setup
		PersonEntity entity1 = new PersonEntityBuilder().withId(768L).build();
		PersonEntity entity2 = new PersonEntityBuilder().withId(90L).build();
		PersonEntity entity3 = new PersonEntityBuilder().withId(947L).build();
		List<PersonEntity> enities = Lists.newArrayList(entity1, entity2, entity3);
		Mockito.when(personRepository.findAll()).thenReturn(enities);
		
		Person persone1 = new PersonBuilder().withId(768L).build();
		Person persone2 = new PersonBuilder().withId(90L).build();
		Person persone3 = new PersonBuilder().withId(947L).build();
		List<Person> expected = Lists.newArrayList(persone1, persone2, persone3);
		for (int i=0; i<3; i++) {
			Mockito.when(converterPersonEntityToPerson.convert(enities.get(i))).thenReturn(expected.get(i));
		}
		// execute
		List<Person> actual = fixure.getAll();
		// verify
		Assert.assertEquals(expected, actual);
		Mockito.verify(personRepository).findAll();
		for (int i=0; i<3; i++) {
			Mockito.verify(converterPersonEntityToPerson).convert(enities.get(i));
		}
	}


}
