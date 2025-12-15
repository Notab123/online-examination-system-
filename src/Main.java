public class Main {
    public static void main(String[] args) {
        Exam exam = new Exam(1, "Java Basics");

        Question q1 = new Question(1, "What is a variable?", "container");
        Question q2 = new Question(2, "What is a class?", "blueprint");
        Question q3 = new Question(3, "What is OOP?", "programming");

        exam.addQuestion(q1);
        exam.addQuestion(q2);
        exam.addQuestion(q3);

        Candidate c1 = new Candidate(101, "Aldiyar", 85);
        Candidate c2 = new Candidate(102, "Aisha", 55);
        Candidate c3 = new Candidate(103, "Kanat", 90);

        exam.addCandidate(c1);
        exam.addCandidate(c2);
        exam.addCandidate(c3);

        System.out.println("Exam: " + exam.getName());
        exam.displayQuestions();
        exam.displayCandidates();

        System.out.println("\nComparison");
        System.out.println("c1 score: " + c1.getScore());
        System.out.println("c3 score: " + c3.getScore());
        System.out.println("c1 score > c2 score: " + (c1.getScore() > c2.getScore()));
        System.out.println("\nAnswer Verification");
        System.out.println("Is 'container' correct for Q1? " + q1.checkAnswer("container"));
        System.out.println("Is 'object' correct for Q1? " + q1.checkAnswer("object"));

        System.out.println("\nStatistics");
        System.out.println("Total candidates: " + exam.getCandidates().size());
        System.out.println("Passed: " + exam.getPassedCount());
        System.out.println("Failed: " + (exam.getCandidates().size() - exam.getPassedCount()));
    }
}
