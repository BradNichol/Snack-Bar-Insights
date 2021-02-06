package uk.co.bradleynichol.snackbarinsights.service;

import uk.co.bradleynichol.snackbarinsights.dto.ScraperResourceDTO;
import uk.co.bradleynichol.snackbarinsights.entity.ScraperResource;

import java.util.List;

public interface IScraperResourceService {
    boolean addResource(ScraperResource resource);
    ScraperResource getResourceById(String resourceId);
    void updateResource(ScraperResource resource);
    void deleteResource(String resourceId);
    List<ScraperResourceDTO> getAllResources();
}
