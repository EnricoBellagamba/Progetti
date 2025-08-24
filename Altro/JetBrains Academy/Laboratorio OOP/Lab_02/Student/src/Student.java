import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Student {
    private final String firstName;
    private final String lastName;
    private final List<Exam> exams;

    public Student(String firstName, String lastName, List<Exam> exams) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.exams = exams;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void registerExam(Exam exam) {
        exams.add(exam);
    }

    public double computeAverageGrade() {
        if (exams.isEmpty()) {
            return 0.0;  // Restituisci 0 se non ci sono esami
        }

        int sum = 0;
        for (Exam exam : exams) {
            sum += exam.getGrade();
        }

        return (double) sum / exams.size();
    }
}