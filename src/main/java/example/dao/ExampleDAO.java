package example.dao;

import example.objects.ExampleObject;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ExampleDAO
{
	@Autowired
	SessionFactory sessionFactory_;

	@Transactional(readOnly = true)
	public List<ExampleObject> get()
	{
		return sessionFactory_.getCurrentSession().
				createQuery("from example_object").list();
	}

	@Transactional(readOnly = true)
	public ExampleObject get(String id)
	{
		ExampleObject object =
				(ExampleObject) sessionFactory_.getCurrentSession().
						load(ExampleObject.class, Long.valueOf(id));
		Hibernate.initialize(object);
		return object;
	}

	@Transactional
	public void add(ExampleObject object)
	{
		if (object != null)
		{
			sessionFactory_.getCurrentSession().save(object);
		}
	}
}
