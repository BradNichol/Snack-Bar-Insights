package uk.co.bradleynichol.snackbarinsights.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.bradleynichol.snackbarinsights.dao.ScraperResourceDAO;
import uk.co.bradleynichol.snackbarinsights.dto.ScraperResourceDTO;
import uk.co.bradleynichol.snackbarinsights.entity.ScraperResource;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScraperResourceServiceImpl implements ScraperResourceService {

    private ScraperResourceDAO resourceDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ScraperResourceServiceImpl(ScraperResourceDAO resourceDAO) {
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
    public List<ScraperResourceDTO> getAllResources() {
        return resourceDAO.findAllResources()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ScraperResourceDTO convertToDTO(ScraperResource scraperResource) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(scraperResource, ScraperResourceDTO.class);

    }
}
