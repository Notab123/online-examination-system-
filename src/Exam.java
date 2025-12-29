import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exam {
    private int id;
    private String name;
    private ArrayList<Question> questions;
    private ArrayList<Candidate> candidates;

    public Exam(int id, String name) {
        this.id = id;
        this.name = name;
        this.questions = new ArrayList<>();
        this.candidates = new ArrayList<>();
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void addCandidate(Candidate c) {
        candidates.add(c);
    }

    public void displayAll() {
        System.out.println("\n--- Exam: " + name + " ---");
        System.out.println("Questions:");
        for (Question q : questions) q.display();
        System.out.println("Candidates:");
        for (Candidate c : candidates) c.display();
    }

    public Candidate searchCandidateByName(String name) {
        for (Candidate c : candidates) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public void sortCandidatesByScore() {
        Collections.sort(candidates, Comparator.comparingInt(Candidate::getScore).reversed());
        System.out.println("\n[System]: Candidates sorted by score (Descending).");
    }

    public ArrayList<Candidate> filterPassedCandidates() {
        ArrayList<Candidate> passed = new ArrayList<>();
        for (Candidate c : candidates) {
            if (c.isPassed()) {
                passed.add(c);
            }
        }
        return passed;
    }

    @Override
    public String toString() {
        return "Exam{id=" + id + ", name='" + name + "', totalCandidates=" + candidates.size() + "}";
    }
}