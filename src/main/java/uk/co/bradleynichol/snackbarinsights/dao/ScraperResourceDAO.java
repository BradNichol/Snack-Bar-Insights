package uk.co.bradleynichol.snackbarinsights.dao;

import uk.co.bradleynichol.snackbarinsights.entity.ScraperResource;

import java.util.List;

public interface ScraperResourceDAO {
    void addResource(ScraperResource resource);
    ScraperResource getResourceById(String resourceId);
    void updateResource(ScraperResource resource);
    void deleteResource(String resourceId);
    List<ScraperResource> findAllResources();
}
