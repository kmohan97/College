import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class Clerk extends HttpServlet
{
Connection cn;
PreparedStatement ps;
Statement s;
public void init()
{
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
//ps=cn.prepareStatement("Insert into rank values(?,?,?,?,?)");
//s=cn.createStatement();

//ps=cn.prepareStatement(" Select * from admin where name = (?) and pass = (?)");
s=cn.createStatement();
}catch(Exception ee)
{
ee.printStackTrace();
}
}

public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();

try{

String name=req.getParameter("t1");
String pass=req.getParameter("t2");

//ps.setString(1,name);
//ps.setString(2,pass);
//ps.executeUpdate();
ResultSet rs=s.executeQuery("Select * from admin where name='" + name + "' and pass='" + pass+ "'");
if(rs.next())
{
Cookie ck=new Cookie("name",name);
res.addCookie(ck);
RequestDispatcher rd2=req.getRequestDispatcher("clerk1.html");
rd2.include(req,res);

}else{
out.println("<center>Error"+" "+name+" "+pass+" "+cn);


RequestDispatcher rd=req.getRequestDispatcher("clerk.html");
rd.include(req,res);
}
}catch(Exception ee)
{
ee.printStackTrace();
}
}

}





