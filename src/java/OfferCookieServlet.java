
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

@WebServlet("/offerManager")
public class OfferCookieServlet extends HttpServlet {

    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/lensdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        try {
            // Get offer information from request parameters
            String content = request.getParameter("content");
            String expirationTime = request.getParameter("expiration_time");

            // Store offer information in the database
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO offers (content, expiration_time) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, content);
            pstmt.setString(2, expirationTime);
            pstmt.executeUpdate();

            // Generate offer ID
            ResultSet rs = pstmt.getGeneratedKeys();
            int offerId = 0;
            if (rs.next()) {
                offerId = rs.getInt(1);
            }

            // Store the offer ID in a cookie
            Cookie cookie = new Cookie("offer_id", String.valueOf(offerId));
            cookie.setMaxAge(500);
            response.addCookie(cookie);

            // Redirect back to the same page
            response.sendRedirect(request.getContextPath() + "/offerManager");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        try {
            // Retrieve the most recent offer content from the database
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT content FROM offers ORDER BY offer_id DESC LIMIT 1");

            // If there is a result, print the offer content
            if (rs.next()) {
                String content = rs.getString("content");
                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Offer Details</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Offers</h1>");
                out.println("<p>" + content + "</p>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}