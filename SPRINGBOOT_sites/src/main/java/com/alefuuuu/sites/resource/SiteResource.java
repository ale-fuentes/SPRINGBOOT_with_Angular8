package com.alefuuuu.sites.resource;

import com.alefuuuu.sites.enumaration.Status;
import com.alefuuuu.sites.model.Response;
import com.alefuuuu.sites.model.Site;
import com.alefuuuu.sites.service.implementation.SiteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

/**
 * @author Ale Fuentes (https://github.com/ale-fuentes)
 * @version 1.0
 * @since 25/05/2022
 */
@RestController
@RequestMapping("/site")
@RequiredArgsConstructor
public class SiteResource {

    private final SiteServiceImpl siteService;

    @GetMapping("/list")
    public ResponseEntity<Response> getSites(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("sites", siteService.list(10)))
                        .message("Sites retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/ping/{ipAddress}")
    public ResponseEntity<Response> pingSite(@PathVariable("ipAddress") String ipAddress) throws IOException {
        Site site = siteService.ping(ipAddress);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("site", site))
                        .message(site.getStatus() == Status.SERVER_UP ? "Ping success" : "Ping filed")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveSite(@RequestBody @Valid Site site)  {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("site", siteService.create(site)))
                        .message("Site created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getSite(@PathVariable("id") Long id) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("site", siteService.get(id)))
                        .message("Site retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteSite(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("site", siteService.delete(id)))
                        .message("Site deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping(path = "/image/{filename}", produces = IMAGE_PNG_VALUE)
    public byte[] getSiteImage(@PathVariable("filename") String filename) throws IOException {
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/Downloads/images/" + filename));
    }

}
