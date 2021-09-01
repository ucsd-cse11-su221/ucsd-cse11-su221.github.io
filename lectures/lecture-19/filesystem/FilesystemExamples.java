import tester.*;
import java.util.List;

interface FolderContent {
    boolean containsFile(String name);
}


class File implements FolderContent {
    String name;
    String contents;
    File(String name, String contents) {
        this.name = name;
        this.contents = contents;
    }
    public boolean containsFile(String name) {
        return this.name.equals(name);
    }
}


class Folder1 implements FolderContent {
    String name;
    List<FolderContent> contents;
    Folder1(String name, List<FolderContent> contents) {
        this.name = name;
        this.contents = contents;
    }
    public boolean containsFile(String name) {
        for (FolderContent fc: this.contents) {
            if (fc.containsFile(name)) {
                return true;
            }
        }

        return false;
    }
}


class Folder2 {
    String name;
    List<File> files;
    List<Folder2> folders;
    Folder2(String name, List<File> files, List<Folder2> folders) {
        this.name = name;
        this.files = files;
        this.folders = folders;
    }
}



class FilesystemExamples {

    File filesystemExamplesJava = new File("FilesystemExamples.java", "<java code>");
    File wordsTxt = new File("words.txt", "hello\ngoodbye\na\ncat");
    File haikuTxt = new File("haiku.txt", "");
    
    //Filesystem - Folder1
    Folder1 dictionaries = new Folder1("dictionaries", List.of());
    Folder1 poems = new Folder1("poems", List.of(haikuTxt));
    Folder1 textfiles = new Folder1(
        "textfiles",
        List.of(dictionaries, poems, wordsTxt)
    );
    Folder1 filesystemF1 = new Folder1(
        "filesystem", 
        List.of(filesystemExamplesJava, textfiles)
    );

    //Filesystem - Folder2
    Folder2 dictionaries2 = new Folder2("dictionaries", List.of(), List.of());
    Folder2 poems2 = new Folder2("poems", List.of(haikuTxt), List.of());
    Folder2 textfiles2 = new Folder2(
        "textfiles", 
        List.of(wordsTxt), 
        List.of(dictionaries2, poems2)
    );
    Folder2 filesystemF2 = new Folder2(
        "filesystem", 
        List.of(filesystemExamplesJava), 
        List.of(textfiles2)
    );


    void testContainsFile(Tester t) {
        t.checkExpect(filesystemF1.containsFile("haiku.txt"), true);
        t.checkExpect(filesystemF1.containsFile("notthere.txt"), false);
        t.checkExpect(dictionaries.containsFile("haiku.txt"), false);
        t.checkExpect(textfiles.containsFile("FilesystemExamples.java"), false);
    }

}
