package uk.co.bradleynichol.snackbarinsights.service;

import uk.co.bradleynichol.snackbarinsights.entity.ScraperResource;

public interface IScraperResourceService {
    boolean addResource(ScraperResource resource);
    ScraperResource getResourceById(String resourceId);
    void updateResource(ScraperResource resource);
    void deleteResource(String resourceId);
}
