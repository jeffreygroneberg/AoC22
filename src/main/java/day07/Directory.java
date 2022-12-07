package day07;

import java.util.*;

public class Directory implements Comparable {
    private Directory parent;
    private String name;
    private Set<File> files = new LinkedHashSet<>();
    private Set<Directory> directories = new LinkedHashSet<>();
    private int calculatedSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<File> getFiles() {
        return files;
    }

    public void setFiles(Set<File> files) {
        this.files = files;
    }

    public Set<Directory> getDirectories() {
        return directories;
    }

    public void setDirectories(Set<Directory> directories) {
        this.directories = directories;
    }

    public int getCalculatedSize() {
        return calculatedSize;
    }

    public void setCalculatedSize(int calculatedSize) {
        this.calculatedSize = calculatedSize;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    @Override
    public int compareTo(Object o) {
        Directory other = (Directory) o;

        if (this.getCalculatedSize() > other.getCalculatedSize()) {
            return 1;
        } else if (this.getCalculatedSize() < other.getCalculatedSize()) {
            return -1;
        } else {
            return 0;
        }
    }

}
