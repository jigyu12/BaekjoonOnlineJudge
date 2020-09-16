package N번째큰수_2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String[] ar = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                int num = Integer.parseInt(ar[j]);
                if(pq.isEmpty()){
                    pq.add(num);
                    continue;
                }
                if(pq.size() < n){
                    pq.add(num);
                    continue;
                }

                if(pq.peek() < num){
                    pq.poll();
                    pq.add(num);
                }
            }
        }

        System.out.println(pq.poll());
    }
}
