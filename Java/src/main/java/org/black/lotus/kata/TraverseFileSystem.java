package org.black.lotus.kata;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import org.black.lotus.marker.Amazon;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.Medium;

@Amazon
@Medium
@Important
public class TraverseFileSystem {

  public static void main(String... args) {
    TraverseFileSystem traverseFileSystem = new TraverseFileSystem();
    traverseFileSystem.visitFiles("/Users/chenguo/Workspace/git-lab/");
  }

  public void visitFiles(String path) {
    try {
      List<String> filesEndsWithTxt =
          Files.walk(Paths.get(path), FileVisitOption.FOLLOW_LINKS)
              .map(Path::toString)
              .filter(p -> p.endsWith(".txt"))
              .collect(Collectors.toList());
      filesEndsWithTxt.forEach(System.out::println);
    } catch (IOException e) {

      e.printStackTrace();
    }
  }
}
