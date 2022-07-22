package br.com.words.controller;

import br.com.words.service.FileService;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    FileService fileService;

    @RequestMapping(value = "/word/{param}", method = RequestMethod.GET)
    public String setParam(@PathVariable("param") String param, Model model) {
        return param + " se repete " + fileService.countWord(param) + " vezes";
    }
}
