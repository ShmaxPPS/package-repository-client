package ru.cg.webbpm.repository_client.service;

import org.springframework.stereotype.Service;
import ru.cg.webbpm.repository_client.model.Entry;
import ru.cg.webbpm.repository_client.model.Version;

@Service
public class NexusRepositoryService implements RepositoryService {
    @Override
    public Entry simpleEntry() {
        return new Entry("Nexus", 322);
    }

    @Override
    public Version version(int major, int minor, int patch) {
        return new Version(major, minor, patch);
    }
}
