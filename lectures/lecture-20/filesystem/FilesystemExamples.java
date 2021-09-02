import tester.*;
import java.util.List;

interface FolderContent {
    boolean containsFile(String name);
    int countFiles();
    boolean containsString(String toFind);
    int totalSize();
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
    public int countFiles() {
        return 1;
    }
    public boolean containsString(String toFind) {
        return this.contents.contains(toFind);
    }
    public int totalSize() {
        return this.contents.length();
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
    public int countFiles() {
        int total = 0;

        for (FolderContent fc: this.contents) {
            total += fc.countFiles();
        }

        return total;
    }
    public boolean containsString(String name) {
        for (FolderContent fc: this.contents) {
            if (fc.containsString(name)) {
                return true;
            }
        }

        return false;
    }
    public int totalSize() {
        int total = 0;

        for (FolderContent fc: this.contents) {
            total += fc.totalSize();
        }

        return total;
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
    public boolean containsFile(String name) {
        //Search list of files for match
        for (File file: this.files) {
            if (file.containsFile(name)) {
                return true;
            }
        }

        //Search list of folders for match
        for (Folder2 folder: this.folders) {
            if (folder.containsFile(name)) {
                return true;
            }
        }

        return false;
    }

    int countFiles() {
        int total = this.files.size();

        //Search list of folders for match
        for (Folder2 folder: this.folders) {
            total += folder.countFiles();
        }

        return total;
    }

    public boolean containsString(String name) {
        //Search list of files for match
        for (File file: this.files) {
            if (file.containsString(name)) {
                return true;
            }
        }

        //Search list of folders for match
        for (Folder2 folder: this.folders) {
            if (folder.containsString(name)) {
                return true;
            }
        }

        return false;
    }

    public int totalSize() {
        int total = 0;
        
        //Search list of files for match
        for (File file: this.files) {
           total += file.totalSize();
        }

        //Search list of folders for match
        for (Folder2 folder: this.folders) {
            total += folder.totalSize();
        }

        return total;
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

        t.checkExpect(filesystemF2.containsFile("haiku.txt"), true);
        t.checkExpect(filesystemF2.containsFile("notthere.txt"), false);
        t.checkExpect(dictionaries2.containsFile("haiku.txt"), false);
        t.checkExpect(textfiles2.containsFile("FilesystemExamples.java"), false);
    }

    // Challenge: implement and test countFiles, which takes no arguments and
    // returns the total number of File objects contained within a Folder1/Folder2
    // and all of its subfolders
    void testCountFile(Tester t) {
        t.checkExpect(filesystemF1.countFiles(), 3);
        t.checkExpect(dictionaries.countFiles(), 0);
        t.checkExpect(textfiles.countFiles(), 2);

        t.checkExpect(filesystemF2.countFiles(), 3);
        t.checkExpect(dictionaries2.countFiles(), 0);
        t.checkExpect(textfiles2.countFiles(), 2);
    }

    // Challenge: implement and test containsString, which takes a string to
    // search for in a directory and returns true if any file found in that
    // directory contains a file whose contents contains that string
    void testContainsString(Tester t) {
        t.checkExpect(filesystemF1.containsString("cat"), true);
        t.checkExpect(dictionaries.containsString("cat"), false);
        t.checkExpect(textfiles.containsString("cat"), true);
        t.checkExpect(poems.containsString("cat"), false);

        t.checkExpect(filesystemF2.containsString("cat"), true);
        t.checkExpect(dictionaries2.containsString("cat"), false);
        t.checkExpect(textfiles2.containsString("cat"), true);
        t.checkExpect(poems2.containsString("cat"), false);
    }

    // Challenge: implement and test totalSize, which takes no arguments and
    // returns the total count of characters in all the files in that directory
    // structure.
    void testTotalSize(Tester t) {
        t.checkExpect(filesystemF1.totalSize(), 30); //11 + 19
        t.checkExpect(dictionaries.totalSize(), 0);
        t.checkExpect(textfiles.totalSize(), 19);
        t.checkExpect(poems.totalSize(), 0);

        t.checkExpect(filesystemF2.totalSize(), 30);
        t.checkExpect(dictionaries2.totalSize(), 0);
        t.checkExpect(textfiles2.totalSize(), 19);
        t.checkExpect(poems2.totalSize(), 0);
    }
}
