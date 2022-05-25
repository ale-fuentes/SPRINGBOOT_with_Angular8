package com.alefuuuu.sites.repo;

import com.alefuuuu.sites.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ale Fuentes (https://github.com/ale-fuentes)
 * @version 1.0
 * @since 25/05/2022
 */
public interface SiteRepo extends JpaRepository<Site, Long> {
    Site findByIpAddress(String ipAddress);
}
