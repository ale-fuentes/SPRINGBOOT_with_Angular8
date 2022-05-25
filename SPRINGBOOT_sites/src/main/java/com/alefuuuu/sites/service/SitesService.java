package com.alefuuuu.sites.service;

import com.alefuuuu.sites.model.Site;

import java.io.IOException;
import java.util.Collection;

/**
 * @author Ale Fuentes (https://github.com/ale-fuentes)
 * @version 1.0
 * @since 25/05/2022
 */
public interface SitesService {
    Site create(Site site);
    Site ping(String ipAddress) throws IOException;
    Collection<Site> list(int limit);
    Site get(Long id);
    Site update(Site site);
    Boolean delete(Long id);
}
