package uk.co.bradleynichol.snackbarinsights.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.bradleynichol.snackbarinsights.dao.IScraperResourceDAO;
import uk.co.bradleynichol.snackbarinsights.entity.ScraperResource;

import java.util.List;

@Service
public class ScraperResourceServiceImpl implements IScraperResourceService {

    private IScraperResourceDAO resourceDAO;

    @Autowired
    public ScraperResourceServiceImpl(IScraperResourceDAO resourceDAO) {
        this.resourceDAO = resourceDAO;
    }

    @Override
    public boolean addResource(ScraperResource resource) {
        resourceDAO.addResource(resource);
        return true;
    }

    @Override
    public ScraperResource getResourceById(String resourceId) {
        return resourceDAO.getResourceById(resourceId);
    }

    @Override
    public void updateResource(ScraperResource resource) {
        resourceDAO.updateResource(resource);
    }

    @Override
    public void deleteResource(String resourceId) {
        resourceDAO.deleteResource(resourceId);
    }

    @Override
    public List<ScraperResource> getAllResources() {
        return resourceDAO.findAllResources();
    }
}
