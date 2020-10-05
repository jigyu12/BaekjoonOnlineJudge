package 후보추천하기_1713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {

    static class Student implements Comparable<Student>{
        int num;
        int uploadTime;
        int recommendCount;

        public Student(int num, int uploadTime, int recommendCount) {
            this.num = num;
            this.uploadTime = uploadTime;
            this.recommendCount = recommendCount;
        }

        @Override
        public int compareTo(Student o) {
            if(this.recommendCount == o.recommendCount){
                return this.uploadTime - o.uploadTime;
            }
            return this.recommendCount - o.recommendCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int totalCount = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        LinkedList<Student> photoFrame = new LinkedList<Student>();

        for(int time = 0; time < input.length; time++){
            int recommendNum = Integer.parseInt(input[time]);
            if(isUploadPhotoFrame(photoFrame, recommendNum)){
                continue;
            }
            if(photoFrame.size() >= n){
                Collections.sort(photoFrame);
                photoFrame.remove(0);
            }

            photoFrame.add(new Student(recommendNum,time,1));
        }

        Collections.sort(photoFrame, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.num - o2.num;
            }
        });

        StringBuilder answer = new StringBuilder();
        for(Student student : photoFrame){
            answer.append(student.num);
            answer.append(" ");
        }

        System.out.println(answer.toString().trim());
    }

    private static boolean isUploadPhotoFrame(LinkedList<Student> photoFrame, int recommendNum) {
        for(Student student: photoFrame){
            if(student.num == recommendNum){
                student.recommendCount++;
                return true;
            }
        }

        return false;
    }
}
