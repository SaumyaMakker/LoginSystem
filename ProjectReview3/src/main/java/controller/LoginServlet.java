package controller;

import dao.UserOperation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        UserOperation usr=new UserOperation();
        int n=usr.loginUser(username,password);
        if (n==1){
            RequestDispatcher rd=req.getRequestDispatcher("Welcome.jsp");
            String msg=username;
            req.setAttribute("msg",msg);
            rd.forward(req,resp);
        }
        else if (n==20500){
            RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
            String msg="Customers can only Login Between 9AM to 6PM";
            req.setAttribute("msg",msg);
            rd.forward(req,resp);
        }
        else if (n==20501){
            RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
            String msg="Guests can only Login Between 9AM to 6PM on Days Monday, Wednesday, Friday";
            req.setAttribute("msg",msg);
            rd.forward(req,resp);
        }
    }
}
