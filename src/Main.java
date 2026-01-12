import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();

        System.out.println("--- 1. INSERT DATA ---");
        db.addCandidate(new Candidate(1, "Aldiyar", 85));
        db.addCandidate(new Candidate(2, "Aisha", 55));
        db.addCandidate(new Candidate(3, "Kanat", 90));

        System.out.println("\n--- 2. READ DATA ---");
        ArrayList<Candidate> candidates = db.getAllCandidates();
        for (Candidate c : candidates) {
            c.display();
        }

        System.out.println("\n--- 3. UPDATE DATA ---");
        // Изменим баллы Аиши (ID 2) с 55 на 70
        db.updateCandidateScore(2, 70);

        // Проверим изменение
        ArrayList<Candidate> updatedList = db.getAllCandidates();
        for (Candidate c : updatedList) {
            if (c.getId() == 2) System.out.println("Updated Aisha: " + c);
        }

        System.out.println("\n--- 4. DELETE DATA ---");
        // Удалим Алдияра (ID 1)
        db.deleteCandidate(1);

        System.out.println("\n--- FINAL LIST FROM DB ---");
        for (Candidate c : db.getAllCandidates()) {
            c.display();
        }
    }
}