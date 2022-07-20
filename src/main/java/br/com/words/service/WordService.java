package br.com.words.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class WordService {
	
	private String param = "";
	private List<Object> arquivos = new ArrayList<>();
	private final String path = "words-amostra";
        
	private final	String extensao = ".csv";
	private int i = 0;
	private Integer count = 0;
			
	
	
	public WordService(String param) {
		super();
		this.param = param;
	}
	
	public void verificaArquivos() {
		this.arquivos = new ArrayList<>();
		
		File caminho = new File(this.path);
		boolean caminhoValido = caminho.exists();
		boolean eDiretorio = caminho.isDirectory();
		
		if(caminhoValido && eDiretorio){
			String[] conteudo = caminho.list();
			for (String arquivo : conteudo) {
				if(arquivo.contains(this.extensao)){
					//Adiciona o arquivo na lista de arquivos
					this.arquivos.add(arquivo);
				}
			}
		}
	}
	
	public  Integer searchWord() {
		new ArrayList<>();
		verificaArquivos();
		
		this.arquivos.forEach(arquivo->{
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(this.path+"/"+arquivo.toString())));
				
				try {
					while((reader.readLine()) != null) {
						i=0;
						reader.lines().forEach(linha -> {
							i++;
							System.out.println("Arquivo "+arquivo.toString()+"Linha "+i);
							if(linha.contains(this.param)) {
								this.count ++;
								System.out.println(this.count);
								}
						});
						
					}
					
				} catch (IOException e) {
					System.out.println("ERRO NO WHILE");
				}
				
			} catch (FileNotFoundException e) {
				System.out.println("ERRO NO BUFFERED");
			}	
		});
		
		return this.count;
	}
}
