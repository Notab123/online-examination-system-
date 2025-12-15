public class Candidate {
    private int id;
    private String name;
    private int score;

    public Candidate() {
        this.id = 0;
        this.name = "";
        this.score = 0;
    }

    public Candidate(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Score: " + score);
    }

    public boolean isPassed() {
        return score >= 60;
    }
}
