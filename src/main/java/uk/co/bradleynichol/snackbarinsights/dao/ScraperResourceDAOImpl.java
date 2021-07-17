package uk.co.bradleynichol.snackbarinsights.dao;

import org.springframework.stereotype.Repository;
import uk.co.bradleynichol.snackbarinsights.entity.ScraperResource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ScraperResourceDAOImpl implements DAO<ScraperResource> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(ScraperResource resource) {
        entityManager.persist(resource);
    }

    @Override
    public ScraperResource findById(String resourceId) {
        return entityManager.find(ScraperResource.class, resourceId);
    }

    @Override
    public void update(ScraperResource resource) {
        ScraperResource scraperResource = findById(resource.getId());
        scraperResource.setPath(resource.getPath());
        scraperResource.setxPath(resource.getxPath());
        entityManager.flush();
    }

    @Override
    public void delete(String resourceId) {
        entityManager.remove(findById(resourceId));
    }

    @Override
    public List<ScraperResource> findAll() {
        return entityManager.createQuery("from ScraperResource", ScraperResource.class).getResultList();
    }
}
