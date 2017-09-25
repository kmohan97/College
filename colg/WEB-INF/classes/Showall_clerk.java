import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class Showall_clerk extends HttpServlet
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

ps=cn.prepareStatement(" Select * from stud11");
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

//String t1=req.getParameter("t1");

//ps.setString(1,t1);


//ResultSet rs=s.executeQuery("Select * from stud11 where regd='" +t1+ "'");
ResultSet rs=ps.executeQuery();


ResultSetMetaData rsmd=rs.getMetaData();
if(rs.next())
{
out.println("<html><head><style type='text/css'>#qwe{border:2px solid brown;position:relative;top:20px;color:blue;font-size:30px;background-color:brown;}#ert{border:2px solid green;position:relative;height:400px;top:100px;width:500px;}h4{color:black;}</style></head><body bgcolor=green><br><br><br><marquee id='wer'>CLERK SECTION</marquee><br><br></div><br><br><a href='clerk1.html'><h4>Go Back</h4></a><h1>ALL Details</h1><center><br>");
int i=rsmd.getColumnCount();
int h=1;
out.println("<table border=1px><tr>");
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

while(rs.next())
{
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
}




out.println("</table></div>");
out.println("</center></body></html>");









}else{

RequestDispatcher rd=req.getRequestDispatcher("clerk1.html");
rd.include(req,res);
}
}catch(Exception ee)
{
ee.printStackTrace();
}
}

}





