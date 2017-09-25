import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class Update_clerk1 extends HttpServlet
{
Connection cn;
PreparedStatement ps;
//Statement s;
public void init()
{
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
//ps=cn.prepareStatement("Insert into stud11 values(?,?,?,?,?,?,?,?,?)");
//s=cn.createStatement();

ps=cn.prepareStatement("UPDATE stud11 SET names=(?),gender=(?),dob=(?),addr=(?),contact=(?),doj=(?),branch=(?),yr=(?) where regd=(?)");
//s=cn.createStatement();
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

String t1=req.getParameter("t1");
String t2=req.getParameter("t2");
String t3=req.getParameter("t3");
String t4=req.getParameter("t4");
String t5=req.getParameter("t5");
String t6=req.getParameter("t6");
String t7=req.getParameter("t7");
String t8=req.getParameter("t8");
String t9=req.getParameter("t9");







ps.setString(1,t2);
ps.setString(2,t3);
ps.setString(3,t4);
ps.setString(4,t5);
ps.setString(5,t6);
ps.setString(6,t7);
ps.setString(7,t8);
ps.setString(8,t9);
ps.setString(9,t1);


//int i=ps.executeUpdate();
boolean bb=ps.execute();

if(bb==false)
{
out.println("<h3 color='red'>Updated Successfully</h3>");
RequestDispatcher rd2=req.getRequestDispatcher("update_clerk.html");
rd2.include(req,res);

}else{
out.println("Please Renter the data");

RequestDispatcher rd=req.getRequestDispatcher("update_clerk.html");
rd.include(req,res);
}
}catch(Exception ee)
{
ee.printStackTrace();
}
}

}





