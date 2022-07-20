package br.com.words.resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.words.service.WordService;




@RestController
public class ProductResource {
	
	//Seta o parametro na api rest para fazer a busca
	@RequestMapping(value = "/word/{param}", method = RequestMethod.GET)
    public String setParam(@PathVariable("param") String param, Model model) {
		WordService ws = new WordService(param);
		String retorno = param+" se repete "+ws.searchWord()+" vezes";
		return retorno;
    }

}
