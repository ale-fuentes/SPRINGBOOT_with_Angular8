package com.alefuuuu.sites;

import com.alefuuuu.sites.enumaration.Status;
import com.alefuuuu.sites.model.Site;
import com.alefuuuu.sites.repo.SiteRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.alefuuuu.sites.enumaration.Status.SERVER_UP;

@SpringBootApplication
public class SitesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SitesApplication.class, args);
    }

    @Bean
    CommandLineRunner run(SiteRepo siteRepo) {
        return args -> {
            siteRepo.save(new Site(null, "192.168.1.160", "Windows 11", "16 GB", "Personal PC", "http://localhost:8080/server/image/site1.png", SERVER_UP));
            siteRepo.save(new Site(null, "192.168.1.58", "Ubuntu", "8 GB", "Personal PC", "http://localhost:8080/server/image/site2.png", SERVER_UP));
            siteRepo.save(new Site(null, "192.168.1.21", "Ms Windows 8", "6 GB", "Web Server", "http://localhost:8080/server/image/site3.png", SERVER_UP));
            siteRepo.save(new Site(null, "192.168.1.14", "Red Hat", "64 GB", "Data Server", "http://localhost:8080/server/image/site4.png", SERVER_UP));
        };
    }
}
