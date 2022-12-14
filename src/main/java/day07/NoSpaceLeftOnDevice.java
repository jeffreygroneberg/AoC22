package day07;

import util.Utils;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NoSpaceLeftOnDevice {

    private List<Directory> allDirectories = new ArrayList<>();

    private Directory rootDir;

    public NoSpaceLeftOnDevice(List<String> commands) {
        buildDirectoriesAndFiles(commands);
    }

    public Directory buildDirectoriesAndFiles(List<String> commands) {

        Directory currentDirectory = null;
        rootDir = null;

        for (int i = 0; i < commands.size(); i++) {

            String currentLine = commands.get(i);

            if (currentLine.startsWith("$ cd ..")) {

                leaveDirectory(currentDirectory);
                currentDirectory = currentDirectory.getParent();
                continue;
            }

            if (currentLine.startsWith("$ cd ")) {

                Directory newDirectory = createDirectoryIn(currentDirectory, currentLine);
                currentDirectory = newDirectory;

                if (rootDir == null) rootDir = currentDirectory;
                continue;

            }

            if (!Utils.findIntegers(currentLine).isEmpty()) {
                addFileToDirectory(currentDirectory, currentLine);
            }

        }

        // if we have reached the end we need to calculate the sum of our last visitedDirectory (normally done in cd ..)
        currentDirectory.setCalculatedSize(getTotalSumOfSizeOf(currentDirectory));
        allDirectories.add(currentDirectory);

        // and do not forget our root dir!
        rootDir.setCalculatedSize(getTotalSumOfSizeOf(rootDir));
        allDirectories.add(rootDir);

        Collections.sort(allDirectories);

        return rootDir;

    }

    private Directory addFileToDirectory(Directory currentDirectory, String currentLine) {
        int size = Integer.parseInt(currentLine.split(" ")[0]);
        String name = (currentLine.split(" ")[1]);

        currentDirectory.getFiles().add(new File(name, size));

        return currentDirectory;
    }

    private Directory createDirectoryIn(Directory currentDirectory, String currentLine) {
        // create a new directory and change pointer
        Directory newDirectory = new Directory();
        newDirectory.setParent(currentDirectory);
        newDirectory.setName(currentLine.split(" ")[2]);

        if (currentDirectory != null) currentDirectory.getDirectories().add(newDirectory);

        return newDirectory;
    }

    private Directory leaveDirectory(Directory currentDirectory) {

        currentDirectory.setCalculatedSize(getTotalSumOfSizeOf(currentDirectory));
        allDirectories.add(currentDirectory);
        return currentDirectory;

    }

    private int getTotalSumOfSizeOf(Directory dir) {

        return dir.getFiles().stream().map(File::size).collect(Collectors.summingInt(Integer::intValue)) + dir.getDirectories().stream().map(directory -> getTotalSumOfSizeOf(directory)).collect(Collectors.summingInt(Integer::intValue));

    }

    public int getSumOfSizeForDirectoriesWith(int number, Predicate<Integer> p) {

        return allDirectories.stream().map(Directory::getCalculatedSize).filter(p).limit(number).collect(Collectors.summingInt(Integer::intValue));

    }

    public Optional<Directory> getDirectoryToFreeSpaceOf(int freeSpaceWanted, int hddSize) {

        int currentSpaceUsed = rootDir.getCalculatedSize();
        if (hddSize - currentSpaceUsed > freeSpaceWanted) return Optional.empty();
        return allDirectories.stream().filter(directory -> hddSize - currentSpaceUsed + directory.getCalculatedSize() > freeSpaceWanted).findFirst();

    }

}
