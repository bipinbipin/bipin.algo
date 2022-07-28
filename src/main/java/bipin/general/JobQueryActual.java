package bipin.general;

import java.util.*;

public class JobQueryActual {

    public static void main(String[] args) {
//        scalableMapSolution();
        inlineSolution();
    }

    private static void inlineSolution() {
        Map<Integer, Integer> descriptionToMatchMap = new HashMap<>();
        for(String query : queries) {

            for (int i = 0; i < descriptions.size(); i++) {
                int hits = 0;
                for(String queryWord : query.split(" ")) {

                    for(String word : descriptions.get(i).trim().split(" ")) {
                        //                    if (query.trim().equalsIgnoreCase(word.toLowerCase().trim())) {
                        if (queryWord.equals(word)) {
                            ++hits;
                        }
                    }
                }
                descriptionToMatchMap.put(i, hits);
            }

            LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();

            descriptionToMatchMap.entrySet()
                    .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(2)
                    .forEachOrdered(x -> {
                        if (x.getValue() > 0) {
                            sortedMap.put(x.getKey(), x.getValue());
                        }
                    });

            System.out.println(sortedMap);

        }

    }

    private static void scalableMapSolution() {
        Map<Integer, Map<String, Integer>> descriptionMap = new HashMap<>();
        // nested loop O(n^2)
        for (int i = 0; i < descriptions.size(); i++) {
            Map<String, Integer> wordCount = new HashMap<>();
            for(String word : descriptions.get(i).split(" ")) {
                if (!wordCount.containsKey(word)) {
                    wordCount.put(word, 1);
                } else {
                    wordCount.put(word, wordCount.get(word) + 1);
                }
            }
            descriptionMap.put(i, wordCount);
        }

        System.out.println(descriptionMap);
        for(String query : queries) {
            for(String queryWord : query.split(" ")) {
                StringBuilder matches = new StringBuilder("Job description ID's matching query term: ");
                matches.append(queryWord).append("\t");
                for (int i = 0; i < descriptionMap.size(); i++) {
                    if (descriptionMap.get(i).containsKey(queryWord)) {
                        matches.append("\t").append(i);
                    }
                }
                System.out.println(matches);
            }
        }
    }


    static List<String> descriptions = new ArrayList<>(
            Arrays.asList("experienced software developer python",
            "experienced developer javascript css html react",
            "technical recruiter junior software"));

    static List<String> queries = new ArrayList<>(
            Arrays.asList("software",
                    "experienced developer",
                    "javascript developer experienced leader",
                    "recruiter",
                    "leader"));

//    static List<Map<Integer, Integer>> expected = ...
//            0 to 2,
//            0 to 1,
//            1 to 0,
//            2 to null,
//            -1 to null

}
