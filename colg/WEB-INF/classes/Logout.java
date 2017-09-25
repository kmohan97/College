import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Logout extends HttpServlet
        {
        public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
                {
                res.setContentType("text/html");
                PrintWriter out=res.getWriter();
		               
		Cookie cc=new Cookie("name"," ");
		cc.setMaxAge(0);
		res.addCookie(cc);
                RequestDispatcher rd=req.getRequestDispatcher("home.html");
		rd.forward(req,res);
		

/*		out.println("<html><body bgcolor='cyan'><font color='red' size='5'><center>");
		out.println("<h6 align='left'><a href='login.html'>Login</a></h6> <br><br>");      

                out.println("<b>Session is Expired.U are sucessfully logout.</b>");
		out.println("<a href='login.html'>Login</a>");      

	          out.println("</center></font></body></html>");
*/
                }
        }


