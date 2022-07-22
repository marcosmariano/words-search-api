package br.com.words.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
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
            files = Arrays.stream(file.list())
                    .filter(f -> f.contains(extensionFile))
                    .collect(Collectors.toList());
        }

        return files;
    }

    public Long countWord(String param) {
        AtomicReference<Long> count = new AtomicReference<>(0L);

        getValidFiles().parallelStream().forEach(file -> {
            try {
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        new FileInputStream(path + "/" + file.toString())));
                count.set(
                        reader.lines()
                                .collect(Collectors.toList())
                                .parallelStream()
                                .filter(l -> l.contentEquals(param))
                                .count() + count.get());
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return count.get();
    }
}
