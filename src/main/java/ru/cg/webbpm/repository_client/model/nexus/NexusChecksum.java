package ru.cg.webbpm.repository_client.model.nexus;

public class NexusChecksum {
    private String sha1;
    private String md5;

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
}
