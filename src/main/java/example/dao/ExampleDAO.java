package example.dao;

import example.objects.ExampleObject;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ExampleDAO
{
	private SessionFactory sessionFactory;

	public ExampleDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = true)
	public List<ExampleObject> get()
	{
		return sessionFactory.getCurrentSession().
				createQuery("from example_object").list();
	}

	@Transactional(readOnly = true)
	public ExampleObject get(String id)
	{
		ExampleObject object =
				(ExampleObject) sessionFactory.getCurrentSession().
						load(ExampleObject.class, Long.valueOf(id));
		Hibernate.initialize(object);
		return object;
	}

	@Transactional
	public void add(ExampleObject object)
	{
		if (object != null)
		{
			sessionFactory.getCurrentSession().save(object);
		}
	}
}
