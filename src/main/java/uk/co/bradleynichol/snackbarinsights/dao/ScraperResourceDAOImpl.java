package uk.co.bradleynichol.snackbarinsights.dao;

import org.springframework.stereotype.Repository;
import uk.co.bradleynichol.snackbarinsights.entity.ScraperResource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
        scraperResource.setUrl(resource.getUrl());
        scraperResource.setxPath(resource.getxPath());
        entityManager.flush();
    }

    @Override
    public void deleteResource(String resourceId) {
        entityManager.remove(getResourceById(resourceId));
    }
}
