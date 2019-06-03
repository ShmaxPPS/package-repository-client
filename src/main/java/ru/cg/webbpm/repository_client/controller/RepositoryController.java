package ru.cg.webbpm.repository_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cg.webbpm.repository_client.model.Package;
import ru.cg.webbpm.repository_client.service.RepositoryService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/repository/v1")
public class RepositoryController {

    @Autowired
    private RepositoryService service;

    @RequestMapping(value = "/packages", method = RequestMethod.GET)
    @ResponseBody
    public List<Package> packages() {
        return service.packages();
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public void upload(@RequestParam(name = "path") String path) throws IOException {
        System.out.println("Start loading");
        Path tempFile = Paths.get("C:/Users/Maxim/Work/upload-test.jar");
        Files.createFile(tempFile);
        Files.write(tempFile, service.upload(path));
        System.out.println("Finish loading");
    }

}
