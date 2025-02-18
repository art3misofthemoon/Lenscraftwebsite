
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insert_lens_servlet")
public class InsertLensServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Database connection parameters
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/lensdb";
        String USER = "root";
        String PASS = "";

        Connection conn = null;
        PreparedStatement pstmt = null;

        // Get form data
        String brand = request.getParameter("brand");
        String type = request.getParameter("type");
        String coating = request.getParameter("coating");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");

        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "INSERT INTO lens_info (brand, type, coating, price, description) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, brand);
            pstmt.setString(2, type);
            pstmt.setString(3, coating);
            pstmt.setDouble(4, price);
            pstmt.setString(5, description);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                out.println("<h2>Lens added successfully!</h2>");
            } else {
                out.println("<h2>Failed to add lens!</h2>");
            }
        } catch (SQLException se) {
            se.printStackTrace();
            out.println("<h2>SQL Error: " + se.getMessage() + "</h2>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
