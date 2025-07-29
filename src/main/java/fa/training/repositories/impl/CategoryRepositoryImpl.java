package fa.training.repositories.impl;

import fa.training.entities.Category;
import fa.training.repositories.CategoryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {

    private final SessionFactory sessionFactory;

    public CategoryRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Category category) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(category);
            session.getTransaction().commit();
        }
    }

    @Override
    public Category findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Category.class, id);
        }
    }

    @Override
    public List<Category> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Category", Category.class).list();
        }
    }

    @Override
    public void update(Category category) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(category);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Category category = session.find(Category.class, id);
            if (category != null) {
                session.remove(category);
            }
            session.getTransaction().commit();
        }
    }
}
