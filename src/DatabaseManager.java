import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private final String URL = "jdbc:postgresql://localhost:5432/exam_system_db";
    private final String USER = "postgres";
    private final String PASSWORD = "";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void addCandidate(Candidate candidate) {
        String sql = "INSERT INTO candidates(id, name, score) VALUES(?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, candidate.getId());
            pstmt.setString(2, candidate.getName());
            pstmt.setInt(3, candidate.getScore());
            pstmt.executeUpdate();
            System.out.println("Candidate added: " + candidate.getName());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Candidate> getAllCandidates() {
        ArrayList<Candidate> list = new ArrayList<>();
        String sql = "SELECT * FROM candidates";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Candidate c = new Candidate(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("score")
                );
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void updateCandidateScore(int id, int newScore) {
        String sql = "UPDATE candidates SET score = ? WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, newScore);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Candidate ID " + id + " updated.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteCandidate(int id) {
        String sql = "DELETE FROM candidates WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Candidate ID " + id + " deleted.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}