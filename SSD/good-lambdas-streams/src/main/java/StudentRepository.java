import java.util.*;
import java.util.stream.Collectors;

public class StudentRepository {
    private Collection<Student> students;

    public StudentRepository(Collection<Student> students) {
        this.students = new ArrayList<>(students);
    }

    public List<String> getStudentEmailsSortedByAgeUnderTheAgeOf(int age) {
        return students.stream()
                .filter(student -> student.getAge() < age )
                .sorted(Comparator.comparingInt( student -> student.getAge()))
                .map(Student::getEmail)
                .collect(Collectors.toList());
    }

    /**
     * @return returns the sorted list of distinct names.
     *
     * SIDE EFFECT: makes all student names uppercase
     */
    public List<String> makeStudentNamesUppercaseAndReturnThemAsSortedDistinctList() {
        // Modify student names in place
        students.forEach(student -> student.setName(student.getName().toUpperCase()));

        // Return the sorted distinct list of uppercase names
        return students.stream()
                .map(Student::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public Set<String> getNonNullUniversities() {

        return students.stream()
                .filter(student -> student.getUniversity()!=null )
                .map(Student::getUniversity)
                .collect(Collectors.toSet());
     }

    public Map<String, Student> getStudentsMappedByEmail() {
        return students.stream()
                .collect(Collectors.toMap(Student::getEmail, student -> student));
    }

    public Map<String, List<Student>> getOverageStudentsGroupedByUniversity() {
        return students.stream()
                .filter(student -> student.getUniversity()!=null)
                .filter(Student::isOverage)
                .collect(Collectors.groupingBy(Student::getUniversity));
    }

    public Optional<Student> getTheStudentWithTheNthShortestEmail(int n) {
        return students.stream()
                .sorted(Comparator.comparingInt(student -> student.getEmail().length() ))
                .skip(n-1)
                .findFirst();
    }

    public Optional<String> getTheNameOfTheSecondOldestStudent() {
        return students.stream()
                .sorted(Comparator.comparingInt(Student::getAge).reversed())
                .skip(1)
                .map(Student::getName)
                .findFirst();
    }

    public OptionalDouble getAverageAgeOfNStudentsInUniversity(int n, String university) {
        return students.stream()
                .filter(student -> student.getUniversity()!=null && student.getUniversity().equals(university) )
                .limit(n)
                .mapToInt(Student::getAge)
                .average();
    }

    public long countStudentsWithNamesLongerThan(int n) {

        return students.stream()
                .filter( student -> student.getName().length() > n )
                .count();
    }

    // Students in no university (university == null) are considered to be in the same university
    public double countNumberOfStudentsWithAtLeastNColleaguesInDifferentUniversity(int n) {

        return students.stream()
                .filter(student -> student.getColleagues().stream()
                        .map(Student::getUniversity)
                        .filter(univ -> !isInUniversity(student, univ))
                        .count() >= n)
                .count();
    }

    public List<Student> getStudentsWithAtLeastOneColleagueWithDifferentEmailDomain() {

        return students.stream()
                .filter(student -> student.getColleagues().stream()
                        .map(Student::getEmail)
                        .map(StudentRepository::getEmailDomain)
                        .anyMatch(domain -> getEmailDomain(student.getEmail()).equals(domain)))
                .collect(Collectors.toList());
    }

    private static String getEmailDomain(String email) {
        if(email.indexOf('@') == -1) {
            return "";
        }
        return email.substring(email.indexOf('@') + 1);
    }


    private static boolean isInUniversity(Student student, String university) {
        if (university == null)
            return student.getUniversity() == null;
        return university.equals(student.getUniversity());
    }
}
