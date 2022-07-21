package br.com.words.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.words.service.WordService;

@RestController
public class ProductResource {
	@Autowired
	WordService wordService;

	@RequestMapping(value = "/word/{param}", method = RequestMethod.GET)
    public String setParam(@PathVariable("param") String param, Model model) {
		String retorno = param+" se repete "+wordService.searchWord(param)+" vezes";
		return retorno;
    }
}
