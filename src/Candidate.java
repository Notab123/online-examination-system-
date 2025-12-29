public class Candidate extends Person {
    private int score;

    public Candidate(int id, String name, int score) {
        super(id, name);
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isPassed() {
        return score >= 60;
    }

    @Override
    public void display() {
        System.out.println("Candidate [ID: " + getId() + ", Name: " + getName() + ", Score: " + score + "]");
    }

    @Override
    public String toString() {
        return "Candidate{id=" + getId() + ", name='" + getName() + "', score=" + score + "}";
    }
}