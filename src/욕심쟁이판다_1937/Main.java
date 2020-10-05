package 욕심쟁이판다_1937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int map[][];
    static int life[][];

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n+2][n+2];
        life = new int[n+2][n+2];

        for(int i = 0; i <= n+1; i++){
            Arrays.fill(map[i],10000000);
        }

        for(int i = 1; i <= n; i++){
            String[] input = br.readLine().split(" ");
            Arrays.fill(life[i],1);
            for(int j = 1; j <= n; j++){
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        int answer = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                life[i][j] = findLongestDays(i,j);
                answer = answer > life[i][j] ? answer : life[i][j];
            }
        }

//        for(int i = 1; i <= n; i++){
//            for(int j = 1; j <= n; j++){
//                System.out.print(life[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(answer);
    }

    private static int findLongestDays(int i, int j) {

        if(life[i][j] > 1){
            return life[i][j];
        }


        int ret = 0;
        for(int d = 0; d < 4; d++){
            int liveMaxDay = 0;
            if(map[i+dx[d]][j+dy[d]] < map[i][j]
                    && life[i+dx[d]][j+dy[d]] == 1){
                liveMaxDay = findLongestDays(i+dx[d],j+dy[d]);
            }
            else if(map[i+dx[d]][j+dy[d]] < map[i][j]
                    && life[i+dx[d]][j+dy[d]] > 1){
                liveMaxDay = life[i+dx[d]][j+dy[d]];
            }

            if(ret < liveMaxDay){
                ret = liveMaxDay;
            }
        }

        return life[i][j] = ret + 1;
    }
}
