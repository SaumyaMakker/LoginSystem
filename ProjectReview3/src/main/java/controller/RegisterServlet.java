package controller;

import dao.UserOperation;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
        String role=req.getParameter("role");
        User user=new User(username,password,role);
        UserOperation usr=new UserOperation();
        int status=usr.addUser(user);
        if (status==1){
            RequestDispatcher rd= req.getRequestDispatcher("register.jsp");
            String msg="User Registered Successfully!!!!!";
            req.setAttribute("msg",msg);
            rd.forward(req,resp);
        }
        else{
            RequestDispatcher rd= req.getRequestDispatcher("register.jsp");
            String msg="User Already Registered Successfully with Same Role!!!!!";
            req.setAttribute("msg",msg);
            rd.forward(req,resp);

        }
    }
}
