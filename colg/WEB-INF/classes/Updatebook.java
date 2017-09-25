import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class Updatebook extends HttpServlet
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
ps=cn.prepareStatement("Select * from stud13 where bookid=(?)");
//ps=cn.prepareStatement("UPDATE stud11 SET names=(?),gender=(?),dob=(?),addr=(?),contact=(?),doj=(?),branch=(?),yr=(?) where regd=(?)");
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
/*
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

*/
ps.setString(1,t1);
ResultSet rs=ps.executeQuery();
ResultSetMetaData rsmd=rs.getMetaData();
String s[]=new String[5];

if(rs.next())
{
int i=rsmd.getColumnCount();
int h=1;
int j=0;

while(h<=i)
{
s[j]=rs.getString(h);
h++;
j++;
}
out.println("<html><head><style type='text/css'>#qwe{border:2px solid brown;position:relative;top:20px;color:blue;font-size:30px;background-color:brown;}#ert{border:2px solid green;position:relative;height:400px;top:100px;width:500px;}h4{color:black;}</style></head><body bgcolor='green'><form action='updatebook1'><div id='qwe'><marquee id='wer'>LIBRARY SECTION</marquee></div><a href='library1.html'><h4>Go Back</h4></a><h1>Update Book</h1><br><br><center><table border=1px><tr><td>Book Id-</td><td><input type='text' value='"+s[0]+"' name='t1'></td></tr><tr><td>Book Name-</td><td><input type='text'value='"+s[1]+"' name='t2'></td></tr>");
out.println("<tr><td>Branch-</td><td><select name='t3' value='"+s[2]+"'><option value='CSE'>CSE</option><option value='EEE'>EEE</option><option value='MEC'>MEC</option><option value='CHE'>CHE</option><option value='MET'>MET</option></select></td></tr><tr><td>Author-</td><td><input type='text' name='t4' value='"+s[3]+"'></td></tr><tr><td>Price-</td><td><input type='text' name='t5' value='"+s[4]+"'></td></tr></table><center><br><br><input type='submit' value='CLick Me'></form></body></html>");












}else{
out.println("Please Renter the data");

RequestDispatcher rd=req.getRequestDispatcher("updatebook.html");
rd.include(req,res);
}
}catch(Exception ee)
{
ee.printStackTrace();
}
}

}





