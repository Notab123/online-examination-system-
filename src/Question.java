import java.util.Objects;

public class Question {
    private int id;
    private String text;
    private String answer;

    public Question(int id, String text, String answer) {
        this.id = id;
        this.text = text;
        this.answer = answer;
    }

    public int getId() { return id; }
    public String getText() { return text; }
    public String getAnswer() { return answer; }

    public boolean checkAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(answer);
    }

    public void display() {
        System.out.println("Q" + id + ": " + text);
    }

    @Override
    public String toString() {
        return "Question{id=" + id + ", text='" + text + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}