package br.com.words.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class FileServiceImpl implements FileService{
	
	private List<Object> files;
	private final String path = "words-amostra";
        
	private final	String extensionFile = ".csv";
	
	private void validationFiles() {
		this.files = new ArrayList<>();
		
		File file = new File(this.path);
		
		if(file.exists() && file.isDirectory()){
			files = Arrays.stream(file.list())
					.filter(f -> f.contains(extensionFile))
					.collect(Collectors.toList());
		}
	}
	
	public  Integer countWord(String param) {
		new ArrayList<>();
		validationFiles();
		 AtomicInteger i = new AtomicInteger();
		 AtomicInteger count = new AtomicInteger();
		
		this.files.forEach(file->{
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(this.path+"/"+file.toString())));

					while((reader.readLine()) != null) {
						i.set(0);
						reader.lines().forEach(line -> {
							i.getAndIncrement();
							System.out.println("File "+file+" Line "+i);
							if(line.contentEquals(param)) {
								count.getAndIncrement();
								System.out.println(count);
								}
						});
					}
					reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		return count.get();
	}
}
