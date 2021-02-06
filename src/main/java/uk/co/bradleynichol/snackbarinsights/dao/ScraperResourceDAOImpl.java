package uk.co.bradleynichol.snackbarinsights.dao;

import org.springframework.stereotype.Repository;
import uk.co.bradleynichol.snackbarinsights.entity.ScraperResource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ScraperResourceDAOImpl implements IScraperResourceDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addResource(ScraperResource resource) {
        entityManager.persist(resource);
    }

    @Override
    public ScraperResource getResourceById(String resourceId) {
        return entityManager.find(ScraperResource.class, resourceId);
    }

    @Override
    public void updateResource(ScraperResource resource) {
        ScraperResource scraperResource = getResourceById(resource.getId());
        scraperResource.setPath(resource.getPath());
        scraperResource.setxPath(resource.getxPath());
        entityManager.flush();
    }

    @Override
    public void deleteResource(String resourceId) {
        entityManager.remove(getResourceById(resourceId));
    }

    @Override
    public List<ScraperResource> findAllResources() {
        return entityManager.createQuery("from ScraperResource", ScraperResource.class).getResultList();
    }
}
