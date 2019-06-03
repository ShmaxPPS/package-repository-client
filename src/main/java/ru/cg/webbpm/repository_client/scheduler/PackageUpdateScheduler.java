package ru.cg.webbpm.repository_client.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PackageUpdateScheduler {

    @Scheduled(cron = "*/5 * * * * ?")
    public void run() {
        long now = System.currentTimeMillis() / 1000;
        System.out.println(
                "schedule tasks using cron jobs - " + now);
    }

}
