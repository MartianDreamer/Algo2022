import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadBalancing {
    public static List<Integer> getServerIndex(int n, List<Integer> arrival, List<Integer> burstTime) {
        int processed = 0;
        List<Integer> results = new ArrayList<>(arrival.size());
        for (int i = 0; i < arrival.size(); i ++) {
            results.add(-1);
        }

        Map<Integer, List<Integer>> arrivalTimes = new HashMap<>();
        for (int i = 0; i < arrival.size(); i++) {
            var listRequests = arrivalTimes.computeIfAbsent(arrival.get(i), (k) -> new ArrayList<>());
            listRequests.add(i);
        }
        System.out.println(arrivalTimes);
        int[] availableServers = new int[n];
        Arrays.fill(availableServers, 1);
        for (int current = 1; processed < arrival.size(); current++) {
            var requests = arrivalTimes.get(current);
            if (requests == null) {
                continue;
            }
            processed += requests.size();
            for (var request : requests) {
                for (int i = 0; i < n; i++) {
                    if (availableServers[i] <= current) {
                        availableServers[i] = current + burstTime.get(request);
                        results.set(request, i + 1);
                        break;
                    }
                }
            }
        }
        return results;
    }
}
