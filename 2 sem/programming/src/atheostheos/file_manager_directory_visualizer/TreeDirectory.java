package atheostheos.file_manager_directory_visualizer;

import java.io.File;
import java.util.ArrayList;

public class TreeDirectory {
    protected Directory directory;
    public static final String ANSI_RESET = "\u001B[0m";;
    public static final String ANSI_BLUE = "\u001B[34m";

    public TreeDirectory(File file) {
        this.directory = new Directory(file);
    }

    public void show() {
        directory.show(0,0, 0, new ArrayList<Boolean>());
    }


    protected class Directory {
        protected ArrayList<Directory> children;
        protected File file;

        public Directory(File file) {
            if (!file.exists()) throw new IllegalArgumentException("Incorrect filepath");
            children = new ArrayList<>();
            this.file = file;
            File[] subPaths = file.listFiles();
            if (subPaths != null) {
                for (File path: subPaths) {
                        children.add(new Directory(path));
                }
            }
        }

        /*
        public void show(int level, int index, int last, boolean isParentLast) {
            // ── ├ └
            System.out.print(index + " " + isParentLast + ":    ");
            for (int i = 0; i < level-2; i++) {
                System.out.print("|  ");
            }

            if (0 < level - 1) System.out.print(isParentLast ? "   " : "|  ");

            if (level > 0) {
                if (index < last - 1)  System.out.print("├──");
                else System.out.print("└──");
            }

            System.out.printf(("%s\n") , file.getName());
            for (int i = 0; i< children.size(); i++) {
                children.get(i).show(level+1, i, children.size(), index == last - 1);
            }

        }*/

        public void show(int level, int index, int last, ArrayList<Boolean> parentsLast) {
            // ── ├ └

            if (!parentsLast.isEmpty()) {
                for (boolean parentLast : parentsLast) {
                    System.out.print(parentLast ? "    " : "│   ");
                }
            }

            ArrayList<Boolean> newParentsLast = new ArrayList<>(parentsLast);

            if (level > 0) {
                if (index < last - 1)  System.out.print("├──");
                else System.out.print("└──");
                newParentsLast.add(index == last - 1);
            }
            if (children.size() != 0 ) {
                System.out.printf(("%s%s%s\n"), ANSI_BLUE, file.getName(), ANSI_RESET);
            } else {
                System.out.printf(("%s\n"), file.getName());
            }

            for (int i = 0; i< children.size(); i++) {
                children.get(i).show(level+1, i, children.size(), newParentsLast);
            }

        }

    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\coalm\\OneDrive\\Документы\\git\\homework\\2 sem\\programming");

        TreeDirectory directory = new TreeDirectory(file);
        directory.show();
    }
}
