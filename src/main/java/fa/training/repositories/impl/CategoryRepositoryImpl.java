package fa.training.repositories.impl;

import fa.training.entities.Category;
import fa.training.repositories.CategoryRepository;
import org.hibernate.Session;

import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {

    private final Session session;

    public CategoryRepositoryImpl(Session session) {
        this.session = session;
    }

    @Override
    public void save(Category category) {
        session.persist(category);
    }

    @Override
    public Category findById(Long id) {
        return session.find(Category.class, id);
    }

    @Override
    public List<Category> findAll() {
        return session.createQuery("FROM Category", Category.class).list();
    }

    @Override
    public void update(Category category) {
        session.merge(category);
    }

    @Override
    public void delete(Long id) {
        Category category = session.find(Category.class, id);
        if (category != null) {
            session.remove(category);
        }
    }
}
