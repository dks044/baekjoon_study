package study;

import java.util.*;

public class Main {
    static class Document {
        int index;
        int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int[] tests = new int[testCase];
        
        for (int i = 0; i < testCase; i++) {
            int docCount = sc.nextInt(); // 문서 개수
            int findDoc = sc.nextInt(); // 찾고자 하는 문서의 인덱스
            Queue<Document> queue = new LinkedList<>();

            for (int j = 0; j < docCount; j++) {
                int priority = sc.nextInt();
                queue.add(new Document(j, priority));
            }

            int printCount = 0;

            while (!queue.isEmpty()) {
                Document currentDoc = queue.poll();
                boolean hasHigherPriority = false;

                for (Document doc : queue) {
                    if (doc.priority > currentDoc.priority) {
                        hasHigherPriority = true;
                        break;
                    }
                }

                if (hasHigherPriority) {
                    queue.add(currentDoc);
                } else {
                    printCount++;
                    if (currentDoc.index == findDoc) {
                    	tests[i] = printCount;
                        break;
                    }
                }
            }
        }
        for(int i : tests) {
        	System.out.println(i);
        }
    }
}
