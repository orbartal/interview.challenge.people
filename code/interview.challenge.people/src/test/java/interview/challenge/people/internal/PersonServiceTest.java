package interview.challenge.people.internal;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

	@Mock
	private IPersonDaoService personeDaoService;

	@InjectMocks
	private PersonService personeService;

	@Test
	public void testGetAll() throws Exception {
		// setup
		Person persone1 = new PersonBuilder().withId(768L).build();
		Person persone2 = new PersonBuilder().withId(90L).build();
		Person persone3 = new PersonBuilder().withId(947L).build();
		List<Person> expected = Lists.newArrayList(persone1, persone2, persone3);
		Mockito.when(personeDaoService.getAll()).thenReturn(expected);
		// execute
		List<Person> actual = personeService.getAll();
		// verify
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCreate() throws Exception {
		Person persone1 = new PersonBuilder().withId(768L).build();
		personeService.create(persone1);
		Assert.assertNull(persone1.getId());
		Mockito.verify(personeDaoService).create(persone1);
	}

}
