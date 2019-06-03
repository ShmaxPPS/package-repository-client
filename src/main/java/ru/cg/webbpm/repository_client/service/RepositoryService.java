package ru.cg.webbpm.repository_client.service;

import ru.cg.webbpm.repository_client.model.Package;

import java.util.List;

public interface RepositoryService {

    List<Package> packages();

    byte[] upload(String path);
}
