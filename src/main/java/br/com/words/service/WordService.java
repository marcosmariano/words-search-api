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
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class WordService {
	
	private List<Object> files;
	private final String path = "words-amostra";
        
	private final	String extensionFile = ".csv";
	
	public void validationFiles() {
		this.files = new ArrayList<>();
		
		File caminho = new File(this.path);
		boolean caminhoValido = caminho.exists();
		boolean eDiretorio = caminho.isDirectory();
		
		if(caminhoValido && eDiretorio){
			String[] conteudo = caminho.list();
			for (String arquivo : conteudo) {
				if(arquivo.contains(this.extensionFile)){
					this.files.add(arquivo);
				}
			}
		}
	}
	
	public  Integer searchWord(String param) {
		new ArrayList<>();
		validationFiles();
		 AtomicInteger i = new AtomicInteger();
		 AtomicInteger count = new AtomicInteger();
		
		this.files.forEach(arquivo->{
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(this.path+"/"+arquivo.toString())));
				
				try {
					while((reader.readLine()) != null) {
						i.set(0);
						reader.lines().forEach(linha -> {
							i.getAndIncrement();
							System.out.println("Arquivo "+arquivo.toString()+" Linha "+i);
							if(linha.contentEquals(param)) {
								count.getAndIncrement();
								System.out.println(count);
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
		
		return count.get();
	}
}
