import java.util.*;

public class GaleShapleyProblem {

    public static void main(String[] args) {
        String[] cities = {"Atlanta", "Boston", "Chicago", "Denver", "El Paso"};
        String[] students = {"Vanessa", "Wyatt", "Xena", "Yousef", "Zelda"};

        Map<String, List<String>> citiesPreferences = new HashMap<>();
        citiesPreferences.put("Atlanta", Arrays.asList("Wyatt", "Xena", "Yousef", "Zelda", "Vanessa"));
        citiesPreferences.put("Boston", Arrays.asList("Xena", "Yousef", "Zelda", "Vanessa", "Wyatt"));
        citiesPreferences.put("Chicago", Arrays.asList("Zelda", "Vanessa", "Yousef", "Wyatt", "Xena"));
        citiesPreferences.put("Denver", Arrays.asList("Xena", "Vanessa", "Wyatt", "Yousef", "Zelda"));
        citiesPreferences.put("El Paso", Arrays.asList("Vanessa", "Zelda", "Wyatt", "Xena", "Yousef"));

        Map<String, List<String>> studentsPreferences = new HashMap<>();
        studentsPreferences.put("Vanessa", Arrays.asList("Atlanta", "Boston", "Chicago", "El Paso", "Denver"));
        studentsPreferences.put("Wyatt", Arrays.asList("Boston", "Atlanta", "Denver", "El Paso", "Chicago"));
        studentsPreferences.put("Xena", Arrays.asList("Chicago", "Boston", "El Paso", "Atlanta", "Denver"));
        studentsPreferences.put("Yousef", Arrays.asList("Denver", "El Paso", "Atlanta", "Boston", "Chicago"));
        studentsPreferences.put("Zelda", Arrays.asList("El Paso", "Atlanta", "Boston", "Chicago", "Denver"));

        Map<String, String> engagedPairs = findStablematches(cities, students, citiesPreferences, studentsPreferences);

        System.out.println("Stable matches:");
        for (String student : students) {
            System.out.println(student + " is engaged to " + engagedPairs.get(student));
        }
    }

    public static Map<String, String> findStablematches(String[] cities, String[] students,
                                                         Map<String, List<String>> citiesPrefs,
                                                         Map<String, List<String>> studentsPrefs) {
        Map<String, String> engagedPairs = new HashMap<>();
        Queue<String> freecities = new LinkedList<>(Arrays.asList(cities));

        while (!freecities.isEmpty()) {
            String city = freecities.poll();
            List<String> preferences = citiesPrefs.get(city);
            for (String student : preferences) {
                if (!engagedPairs.containsKey(student)) {
                    engagedPairs.put(student, city);
                    break;
                } else {
                    String currentPartner = engagedPairs.get(student);
                    List<String> studentPrefs = studentsPrefs.get(student);
                    if (studentPrefs.indexOf(city) < studentPrefs.indexOf(currentPartner)) {
                        freecities.add(currentPartner);
                        engagedPairs.put(student, city);
                        break;
                    }
                }
            }
        }

        return engagedPairs;
    }
}