import java.util.ArrayList;

public class Exam {
    private int id;
    private String name;
    private ArrayList<Question> questions;
    private ArrayList<Candidate> candidates;

    public Exam() {
        this.id = 0;
        this.name = "";
        this.questions = new ArrayList<>();
        this.candidates = new ArrayList<>();
    }

    public Exam(int id, String name) {
        this.id = id;
        this.name = name;
        this.questions = new ArrayList<>();
        this.candidates = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public ArrayList<Candidate> getCandidates() {
        return candidates;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void addCandidate(Candidate c) {
        candidates.add(c);
    }

    public void displayQuestions() {
        System.out.println("\nQuestions");
        for (Question q : questions) {
            q.display();
        }
    }

    public void displayCandidates() {
        System.out.println("\nCandidates");
        for (Candidate c : candidates) {
            c.display();
        }
    }

    public int getPassedCount() {
        int count = 0;
        for (Candidate c : candidates) {
            if (c.isPassed()) {
                count++;
            }
        }
        return count;
    }
}
