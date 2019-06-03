package ru.cg.webbpm.repository_client.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.cg.webbpm.repository_client.model.Package;
import ru.cg.webbpm.repository_client.model.nexus.NexusAsset;
import ru.cg.webbpm.repository_client.model.nexus.NexusPackages;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class NexusRepositoryService implements RepositoryService {

    private static final String NEXUS_URL = "http://repo.cg.ru";
    private static final String SEARCH_REQUEST_URL = "/service/rest/v1/search";
    private static final String LOAD_REQUEST_URL = "/repository/packages-releases-local";

    private static final Pattern pattern = Pattern.compile(".+\\.jar", Pattern.DOTALL);

    @Override
    public List<Package> packages() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(NEXUS_URL + SEARCH_REQUEST_URL)
                .queryParam("repository", "packages-releases-local");

        HttpEntity<NexusPackages> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                new HttpEntity<>(headers),
                NexusPackages.class
        );

        return response.getBody().getItems().stream()
                .map(nexusPackage -> {
                    NexusAsset asset = nexusPackage.getAssets().stream()
                            .filter(nexusAsset -> pattern.matcher(nexusAsset.getPath()).matches())
                            .findFirst().get();
                    return new Package(
                            nexusPackage.getGroup(),
                            nexusPackage.getName(),
                            nexusPackage.getVersion(),
                            asset.getPath()
                    );
                })
                .collect(Collectors.toList());
    }

    @Override
    public byte[] upload(String path) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_OCTET_STREAM));
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(NEXUS_URL + LOAD_REQUEST_URL + "/" + path);

        HttpEntity<byte[]> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                new HttpEntity<>(headers),
                byte[].class
        );
        return response.getBody();
    }
}
