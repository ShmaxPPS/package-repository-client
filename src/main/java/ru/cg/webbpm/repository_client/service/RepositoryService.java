package ru.cg.webbpm.repository_client.service;

import ru.cg.webbpm.repository_client.model.Entry;
import ru.cg.webbpm.repository_client.model.Version;

public interface RepositoryService {

    Entry simpleEntry();

    Version version(int major, int minor, int patch);
}
