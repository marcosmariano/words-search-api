package br.com.words.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FileServiceImpl implements FileService {

    @Value("${file.path}")
    private  String path;

    @Value("${file.extension}")
    private  String extensionFile;

    public List<Object> getValidFiles() {
        List<Object> files = new ArrayList<>();

        File file = new File(this.path);

        if (file.exists() && file.isDirectory()) {
            files = Arrays.stream(Objects.requireNonNull(file.list()))
                    .filter(f -> f.contains(extensionFile))
                    .collect(Collectors.toList());
        }

        return files;
    }

    private BufferedReader accessFile(Object file) throws FileNotFoundException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(path + "/" + file.toString())));
        return  reader;
    }

    public List<String> getWords(List<Object> files)
    {
        List<String> words = new ArrayList<>();
        files.parallelStream().forEach(file -> {
            try {
                BufferedReader reader = accessFile(file);
                words.addAll(reader.lines().collect(Collectors.toList()));
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return words;
    }

    public Long countWord(String param) {
        if(param != null)
           return getWords(getValidFiles())
                    .stream()
                    .filter(l -> l.contains(param.trim().toLowerCase(Locale.ROOT)))
                    .count();

        return 0L;
    }
}
