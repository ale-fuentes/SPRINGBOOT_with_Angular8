package com.alefuuuu.sites.service.implementation;

import com.alefuuuu.sites.enumaration.Status;
import com.alefuuuu.sites.model.Site;
import com.alefuuuu.sites.repo.SiteRepo;
import com.alefuuuu.sites.service.SitesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

/**
 * @author Ale Fuentes (https://github.com/ale-fuentes)
 * @version 1.0
 * @since 25/05/2022
 */
@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class SiteServiceImpl implements SitesService {
    private final SiteRepo siteRepo;

    @Override
    public Site create(Site site) {
        log.info("{} : Saving a new Site: {}", this.getClass().getName().toUpperCase(), site.getName());
        site.setImageUrl(setSiteImageUrl());
        return siteRepo.save(site);
    }

    @Override
    public Site ping(String ipAddress) throws IOException {
        log.info("{} : Pinging to Site IP: {}", this.getClass().getName().toUpperCase(), ipAddress);
        Site site = siteRepo.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        site.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
        siteRepo.save(site);
        return site;
    }

    @Override
    public Collection<Site> list(int limit) {
        log.info("{} : Fetching all sites", this.getClass().getName().toUpperCase());
        return siteRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Site get(Long id) {
        log.info("{} : Fetching to the Site ID: {}", this.getClass().getName().toUpperCase(), id);
        return siteRepo.findById(id).get();
    }

    @Override
    public Site update(Site site) {
        log.info("{} : Updating to the Site: {}", this.getClass().getName().toUpperCase(), site.getName());
        return siteRepo.save(site);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("{} : Deleting to Site ID: {}", this.getClass().getName().toUpperCase(), id);
        siteRepo.deleteById(id);
        return Boolean.TRUE;
    }

    private String setSiteImageUrl() {
        String[] imageSites = {"site1.png", "site2.png", "site3.png", "site4.png" };
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/sites/image/" + imageSites[new Random().nextInt(4)]).toUriString();
    }
}
