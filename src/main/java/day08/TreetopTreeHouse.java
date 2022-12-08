package day08;

public class TreetopTreeHouse {

    public enum EDGE {

        LEFT(new int[]{-1, 0}), RIGHT(new int[]{1, 0}), UP(new int[]{0, -1}), DOWN(new int[]{0, 1});
        public final int[] mask;

        EDGE(int[] mask) {
            this.mask = mask;
        }

    }

    public boolean isTreeVisibleFromEdge(int treeX, int treeY, int[][] forest, EDGE fromEdge) {

        int highestTree = forest[treeY][treeX];

        for (int x = treeX + fromEdge.mask[0], y = treeY + fromEdge.mask[1]; (y < forest.length) && (y >= 0) && (x < forest[treeY].length) && (x >= 0); x = x + fromEdge.mask[0], y = y + fromEdge.mask[1]) {
            if (highestTree <= forest[y][x]) return false;
        }

        return true;

    }

    public int calculateScenicValueForTreeToEdge(int treeX, int treeY, int[][] forest, EDGE toEdge) {

        int scenicScore = 0;
        for (int x = treeX + toEdge.mask[0], y = treeY + toEdge.mask[1]; (y < forest.length) && (y >= 0) && (x < forest[treeY].length) && (x >= 0); x = x + toEdge.mask[0], y = y + toEdge.mask[1]) {

            scenicScore++;

            if (forest[y][x] >= forest[treeY][treeX]) {
                break;
            }
        }

        return scenicScore;

    }

    public int[][] createScenicTreeMask(int[][] forest, EDGE[] toEdge) {

        // create empty mask as placeholder for result
        int[][] markedForest = new int[forest.length][forest[0].length];

        for (int y = 0; y < forest.length; y++) {
            for (int x = 0; x < forest.length; x++) {

                markedForest[y][x] = 1;

                for (int k = 0; k < toEdge.length; k++) {
                    int calculatedScore = calculateScenicValueForTreeToEdge(x, y, forest, toEdge[k]);
                    markedForest[y][x] = markedForest[y][x] * calculatedScore;

                }

            }
        }

        return markedForest;

    }


    public int[][] createVisibleTreesFromEdgesMask(int[][] forest, EDGE[] fromEdges) {

        // create empty mask
        int[][] markedForest = new int[forest.length][forest[0].length];

        for (int y = 0; y < forest.length; y++) {
            for (int x = 0; x < forest.length; x++) {
                markedForest[y][x] = 0;

                for (int k = 0; k < fromEdges.length; k++) {
                    if (isTreeVisibleFromEdge(x, y, forest, fromEdges[k])) {
                        markedForest[y][x] = 1;
                        break;
                    }
                }

            }
        }

        return markedForest;

    }


}



