package ru.cg.webbpm.repository_client.model.nexus;

import java.util.List;

public class NexusPackages {
    public List<NexusPackage> getItems() {
        return items;
    }

    public void setItems(List<NexusPackage> items) {
        this.items = items;
    }

    private List<NexusPackage> items;
}
