import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class Contact_clerk extends HttpServlet
{
Connection cn;
PreparedStatement ps;
Statement s;
public void init()
{
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
//ps=cn.prepareStatement("Insert into stud11 values(?,?,?,?,?,?,?,?,?)");
//s=cn.createStatement();

ps=cn.prepareStatement(" Select * from stud11 where regd=(?)");
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

ps.setString(1,t1);


//ResultSet rs=s.executeQuery("Select * from stud11 where regd='" +t1+ "'");
ResultSet rs=ps.executeQuery();


ResultSetMetaData rsmd=rs.getMetaData();
if(rs.next())
{
out.println("<html><head><style type='text/css'> </style></head><body><center>");
int i=rsmd.getColumnCount();
int h=1;
out.println("<div id='nam'><table border=1px><tr>");
while(h<=i)
{
out.println("<td>");

out.println(rsmd.getColumnName(h));
h++;
out.println("</td>");
}

out.println("</tr>");

out.println("<tr>");
h=1;

while(h<=i)
{
out.println("<td>");
out.println(rs.getString(h));
out.println("</td>");
h++;
}
out.println("</tr>");


out.println("</table></div>");
out.println("</center></body></html>");








RequestDispatcher rd2=req.getRequestDispatcher("contact_clerk.html");
rd2.include(req,res);

}else{
out.println("Please Renter the data");

RequestDispatcher rd=req.getRequestDispatcher("contact_clerk.html");
rd.include(req,res);
}
}catch(Exception ee)
{
ee.printStackTrace();
}
}

}





