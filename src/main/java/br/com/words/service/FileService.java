package br.com.words.service;

import java.util.List;

public interface FileService {
    public  Long countWord(String param);
    public List<Object> getValidFiles();
}
