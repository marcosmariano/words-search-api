package br.com.words.service;

import java.util.List;

public interface FileService {
    public  Long countWord(String param);
    List<String> getWords(List<Object> files);
    public List<Object> getValidFiles();
}
