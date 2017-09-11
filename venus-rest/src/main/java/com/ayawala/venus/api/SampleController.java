package com.ayawala.venus.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ayawala.venus.config.VenusConfiguration;

@RestController
@RequestMapping("api")
class SampleController {

    private VenusConfiguration venusConfiguration;

    public SampleController(final VenusConfiguration venusConfiguration) {
        this.venusConfiguration = venusConfiguration;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sample1")
    public @ResponseBody String sample1() {
        return venusConfiguration.getMessage();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sample2")
    public @ResponseBody String sample2(@RequestParam(value = "name") String name) {
        return "Hello, " + name;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sample3/{name}")
    public @ResponseBody String sample3(@PathVariable String name) {
        return "Hello, " + name;
    }
}