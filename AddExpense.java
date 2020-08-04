/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(urlPatterns = {"/AddExpense"})
public class AddExpense extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
            try{
            response.setContentType("text/html;charset=UTF-8");
             PrintWriter out = response.getWriter();
          
            System.out.println("hai");
            int usernumber=Integer.parseInt(request.getParameter("number"));
            String username=request.getParameter("name");
            int userage=Integer.parseInt(request.getParameter("age"));
            //Dbconnection dbc=new Dbconnection();
            String record= Dbconnection.connectDB();
            Dbconnection.insertQuery(usernumber,username,userage);
            out.println("<html>");
            out.println("<body>");
            out.println(record+"$$$"+usernumber+" "+username+" "+userage);
            out.println("</body>");
            out.println("</html>");
            
            }
            catch(IOException | SQLException e)
            {
               System.out.println(e); 
            }
        
    }

}
