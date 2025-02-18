import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.http.Cookie;

@WebServlet("/setRecentlyAddedLensCookie")
public class CookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set cookie with maxAge
        Cookie cookie = new Cookie("showRecentLensInfo", "true");
        cookie.setMaxAge(500);
        response.addCookie(cookie);

        String latestBrand = fetchLatestBrandFromDatabase();

        // Display the latest brand
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Recently Added Lens Brand</h1>");
        out.println("<p>" + latestBrand + "</p>");
    }

    private String fetchLatestBrandFromDatabase() {
        String latestBrand = null;
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/lensdb";
        String USER = "root";
        String PASS = "";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "SELECT brand FROM lens_info ORDER BY id DESC LIMIT 1";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                latestBrand = rs.getString("brand");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return latestBrand;
    }
}