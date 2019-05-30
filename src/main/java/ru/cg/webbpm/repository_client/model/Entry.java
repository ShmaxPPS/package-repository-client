package ru.cg.webbpm.repository_client.model;

public class Entry {
    private String id;
    private long count;

    public Entry() {}

    public Entry(String id, long count) {
        this.id = id;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
