import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Exam exam = new Exam(1, "Java OOP Basics");

        exam.addQuestion(new Question(1, "What is a variable?", "container"));
        exam.addQuestion(new Question(2, "What is parent class?", "superclass"));

        exam.addCandidate(new Candidate(101, "Aldiyar", 85));
        exam.addCandidate(new Candidate(102, "Aisha", 55));
        exam.addCandidate(new Candidate(103, "Kanat", 90));
        exam.addCandidate(new Candidate(104, "Bota", 40));

        exam.displayAll();

        System.out.println("\n--- toString() Demonstration ---");
        System.out.println(exam.toString());
        System.out.println(exam.searchCandidateByName("Aldiyar").toString());

        System.out.println("\n--- Searching ---");
        String searchName = "Kanat";
        Candidate found = exam.searchCandidateByName(searchName);
        if (found != null) {
            System.out.println("Found: " + found.getName() + " with score " + found.getScore());
        } else {
            System.out.println("Candidate " + searchName + " not found.");
        }

        System.out.println("\n--- Sorting ---");
        exam.sortCandidatesByScore();
        exam.displayAll();

        System.out.println("\n--- Filtering (Passed Candidates) ---");
        ArrayList<Candidate> passedOnes = exam.filterPassedCandidates();
        for (Candidate c : passedOnes) {
            System.out.println("Passed: " + c.getName());
        }
    }
}