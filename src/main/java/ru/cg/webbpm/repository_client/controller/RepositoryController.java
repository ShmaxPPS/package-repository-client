package ru.cg.webbpm.repository_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cg.webbpm.repository_client.model.Entry;
import ru.cg.webbpm.repository_client.model.Version;
import ru.cg.webbpm.repository_client.service.RepositoryService;

@RestController
@RequestMapping("/repository/v1")
public class RepositoryController {

    @Autowired
    private RepositoryService service;

    @RequestMapping(value = "/entry", method = RequestMethod.GET)
    @ResponseBody
    public Entry entry() {
        return service.simpleEntry();
    }

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    @ResponseBody
    public Version version(@RequestParam(name = "major") int major,
                           @RequestParam(name = "minor") int minor,
                           @RequestParam(name = "patch") int patch) {
        return service.version(major, minor, patch);
    }
}
