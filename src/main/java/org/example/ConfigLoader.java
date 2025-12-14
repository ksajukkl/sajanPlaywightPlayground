package org.example;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConfigLoader {
    String dir = System.getProperty("user.dir") + "/src/test";
    public Config loadFiles() throws IOException {
        Config mergedFiles = null;
        List<String> files= findConfigFiles(Paths.get(dir));
        if(files.size()!=0){
            for(String val : files){
                if(mergedFiles==null) {
                    mergedFiles = ConfigFactory.parseFileAnySyntax(new File(val)).resolve();
                } else {
                    mergedFiles = mergedFiles.withFallback(ConfigFactory.parseFileAnySyntax(new File(val)).resolve());
                }
            }
        }
        System.out.println("Files loaded Successfully");

        return mergedFiles;
    }

    public List<String> findConfigFiles(Path path) throws IOException {
        File directory=new File(dir);
        try (Stream<Path> walk = Files.walk(path)){
                return walk
                        .filter(Files::isRegularFile)
                        .map(Path::toString)
                        .filter(f->f.endsWith(".json")|| f.endsWith(".conf") || f.endsWith(".properties"))
                        .collect(Collectors.toList());
            }
    }
}
