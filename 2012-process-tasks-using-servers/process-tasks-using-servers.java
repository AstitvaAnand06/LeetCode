import java.util.PriorityQueue;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Integer> available = new PriorityQueue<>((a, b) -> {
            int cmp = Integer.compare(servers[a], servers[b]);
            return cmp != 0 ? cmp : Integer.compare(a, b);
        });

        // Each entry: {finishTime, serverIndex}
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        for (int i = 0; i < servers.length; i++) {
            available.offer(i);
        }

        int[] answer = new int[tasks.length];
        long time = 0;

        for (int i = 0; i < tasks.length; i++) {
            time = Math.max(time, i);

            // Release every server that has finished.
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                available.offer((int) busy.poll()[1]);
            }

            // If all servers are busy, wait for the earliest completion.
            if (available.isEmpty()) {
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    available.offer((int) busy.poll()[1]);
                }
            }

            int server = available.poll();
            answer[i] = server;
            busy.offer(new long[]{time + tasks[i], server});
        }

        return answer;
    }
}