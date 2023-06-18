package com.partheeban.utility;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static class CSV {

        public static List<String[]> readAllLines(String filePath) throws Exception {
            return Files.lines(Paths.get(filePath))
                    .map(line -> line.split(","))
                    .collect(Collectors.toList());

        }
    }

}
