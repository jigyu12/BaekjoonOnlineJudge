package 치즈_2636;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        Queue<Node> remainCheeseQueue = new LinkedList<>();
        Queue<Node> meltCheeseQueue = new LinkedList<>();

        int endTime = 0;
        int remainingCheese = 0;

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);


        int[][] map = new int[n+2][m+2];
        initMap(map);

        for(int i = 1; i <= n; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 1; j <= m; j++){
                map[i][j] = Integer.parseInt(input[j-1]);
                if(map[i][j] == 1){
                    remainCheeseQueue.add(new Node(i,j));
                }
            }
        }

        while(!remainCheeseQueue.isEmpty()){
            endTime++;
            remainingCheese = remainCheeseQueue.size();
            boolean[][] isOutside = new boolean[n+2][m+2];
            findOutsideNode(isOutside, map);
            for(int idx = 0; idx < remainingCheese; idx++){
                Node node = remainCheeseQueue.poll();
                boolean isMelt = false;
                for(int dir = 0; dir < 4; dir++){
                    if(isOutside[node.x+dx[dir]][node.y+dy[dir]]
                            && map[node.x+dx[dir]][node.y+dy[dir]] == 0){
                        meltCheeseQueue.add(node);
                        isMelt = true;
                        break;
                    }
                }
                if(!isMelt){
                    remainCheeseQueue.add(node);
                }
            }

            while(!meltCheeseQueue.isEmpty()){
                Node meltedCheese = meltCheeseQueue.poll();
                map[meltedCheese.x][meltedCheese.y] = 0;
            }

/*            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();*/
        }

        System.out.println(endTime);
        System.out.println(remainingCheese);
    }

    private static void findOutsideNode(boolean[][] isOutside, int[][] map) {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(new Node(1,1));
        isOutside[1][1] = true;
        while(!nodeQueue.isEmpty()){
            Node node = nodeQueue.poll();
            int x = node.x;
            int y = node.y;

            for(int dir = 0; dir < 4; dir++){
                if(!isOutside[x+dx[dir]][y+dy[dir]]
                        && map[x+dx[dir]][y+dy[dir]] == 0){
                    nodeQueue.add(new Node(x+dx[dir],y+dy[dir]));
                    isOutside[x+dx[dir]][y+dy[dir]] = true;
                }
            }
        }
    }

    private static void initMap(int[][] map) {
        for(int i = 0; i < map.length; i++){
            Arrays.fill(map[i],2);
        }
    }
}
