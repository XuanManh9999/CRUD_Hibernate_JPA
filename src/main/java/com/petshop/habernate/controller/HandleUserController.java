package com.petshop.habernate.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.petshop.habernate.dao.User;
import com.petshop.habernate.dao.HandleHibernate;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HandleUserController", urlPatterns = {"/HandleUserController", "/update", "/delete", "/insert", "/handle-update", "", "/Habernate_war_exploded", "/order-by-id"})
public class HandleUserController extends HttpServlet {
    public HandleUserController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HandleHibernate handle = new HandleHibernate();
        String url = req.getServletPath();
         if (url.equals("/delete")) {
            // get ID
            String ID = req.getParameter("delete");
            handle.delete(Integer.parseInt(ID));
            resp.sendRedirect("HandleUserController");
        }else {
            ArrayList<User> listUser = handle.select();
            req.setAttribute("list-user", listUser);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();
        HandleHibernate handle = new HandleHibernate();
        System.out.println(url);
        if (url.equals("/update")) {
            String ID = req.getParameter("updateID");
            String name = req.getParameter("updateName");
            String email = req.getParameter("updateEmail");
            String password = req.getParameter("updatePassword");
            req.setAttribute("Message", "Handle Update");
            req.setAttribute("ID_Update", ID);
            req.setAttribute("Name_Update", name);
            req.setAttribute("Email_Update", email);
            req.setAttribute("Password_Update", password);
            req.getRequestDispatcher("/Habernate_war_exploded").forward(req, resp);
        } else if (url.equals("/insert")) {
            User user1 = new User();
            String ID = req.getParameter("id");
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            user1.setId(Integer.parseInt(ID));
            user1.setName(name);
            user1.setEmail(email);
            user1.setPassword(password);
            handle.insert(user1);
            resp.sendRedirect("HandleUserController");
        }else if (url.equals("/handle-update")) {
            User user1 = new User();
            String ID = req.getParameter("id");
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            user1.setId(Integer.parseInt(ID));
            user1.setName(name);
            user1.setEmail(email);
            user1.setPassword(password);
            handle.update(user1);
            req.getRequestDispatcher("/Habernate_war_exploded").forward(req, resp);
        }else if (url.equals("/order-by-id")) {
            ArrayList<User> listUser = handle.orderById();
            req.setAttribute("list-user", listUser);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
        else {
            ArrayList<User> listUser = handle.select();
            req.setAttribute("list-user", listUser);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
