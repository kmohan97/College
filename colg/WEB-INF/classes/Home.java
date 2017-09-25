import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Home extends HttpServlet
{
public void init()
{
}
/*public void init()
{
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
ps=cn.prepareStatement("Select * from banking where name=(?) and pass=(?)");
}catch(Exception ee)
{ee.printStackTrace();
}
}*/
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
PrintWriter out=res.getWriter();
res.setContentType("text/html");

String s1=req.getParameter("log");

if(s1.equals("admin")){
RequestDispatcher rd=req.getRequestDispatcher("admin.html");
rd.include(req,res);
}else if(s1.equals("clerk"))
{
RequestDispatcher rd=req.getRequestDispatcher("clerk.html");
rd.include(req,res);
}else if(s1.equals("accountant"))
{
RequestDispatcher rd=req.getRequestDispatcher("acc.html");
rd.include(req,res);
}else if(s1.equals("helllo")){
RequestDispatcher rd=req.getRequestDispatcher("home.html");
rd.include(req,res);

}
else{
RequestDispatcher rd=req.getRequestDispatcher("library.html");
rd.include(req,res);
}
}
}