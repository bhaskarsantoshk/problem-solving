package company.google.fromLCExperiences;

import java.util.*;

public class VisitedFilesAndDirectories {

    // Trie Node class to store the directory structure
    class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();
        boolean isFile = false;
    }

    TrieNode root = new TrieNode();

    // Insert each path into the Trie
    public void insert(String[] path) {
        TrieNode current = root;
        for (String dirOrFile : path) {
            current.children.putIfAbsent(dirOrFile, new TrieNode());
            current = current.children.get(dirOrFile);
        }
        current.isFile = true; // Mark the end as a file
    }

    // DFS function to collect visited files and directories
    public List<String> collectVisited(TrieNode node, String path) {
        List<String> result = new ArrayList<>();

        if (node.isFile) {
            // If it's a file, add the file path to the result
            result.add(path);
            return result;
        }

        // If it's a directory, check if all its children are visited
        boolean allVisited = true;
        List<String> filesInDirectory = new ArrayList<>();
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            String childPath = path.isEmpty() ? entry.getKey() : path + "/" + entry.getKey();
            List<String> subResult = collectVisited(entry.getValue(), childPath);

            if (subResult.size() == 1 && subResult.get(0).equals(childPath)) {
                // It's a fully visited directory, we don't add individual files
                filesInDirectory.clear();
                result.add(childPath);
                break;
            } else {
                allVisited = false;
                result.addAll(subResult);
            }
        }

        return result;
    }

    public List<String> getVisitedFilesAndDirectories(List<String> visitedPaths) {
        // Build the Trie from the visited paths
        for (String path : visitedPaths) {
            String[] splitPath = path.split("/");
            insert(splitPath);
        }

        // Perform DFS to collect visited files and directories
        return collectVisited(root, "");
    }

    public static void main(String[] args) {
        VisitedFilesAndDirectories solution = new VisitedFilesAndDirectories();
        List<String> visitedPaths = Arrays.asList(
                "home/user/docs/file1.txt",
                "home/user/docs/file2.txt",
                "home/user/docs/file3.txt",
                "home/user/photos/file1.png",
                "home/user/photos/file2.png",
                "home/user/music/file1.mp3"
        );

        List<String> result = solution.getVisitedFilesAndDirectories(visitedPaths);
        System.out.println(result);
    }
}
