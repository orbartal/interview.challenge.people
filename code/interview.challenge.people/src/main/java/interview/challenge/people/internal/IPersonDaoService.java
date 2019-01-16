package interview.challenge.people.internal;

import java.util.List;

public interface IPersonDaoService {

	public List<Person> getAll();

	public void create(Person person);

	public void delete(Long id);

}
