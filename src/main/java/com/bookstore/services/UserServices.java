package com.bookstore.services;

import com.bookstore.dao.UsersDAO;
import com.bookstore.entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServices {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private EntityManager entityManager;
    private UsersDAO usersDAO;

    public UserServices(EntityManager entityManager, HttpServletRequest request , HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.entityManager = entityManager;
        usersDAO = new UsersDAO(entityManager);
    }

    public void listUser() throws ServletException, IOException {
        listUser(null);
    }
    public void listUser(String message) throws ServletException, IOException {
       List<Users> userList =  usersDAO.listAll();
        request.setAttribute("userList", userList);

        if(message != null) {
            request.setAttribute("message" , message);
        }
        String listUserPage = "user_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listUserPage);
        requestDispatcher.forward(request,response);
    }

    public void createUser() throws ServletException, IOException {
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");
        String password = request.getParameter("password");

        // check whether the email already exists or not, if the email already exists then show a message the user cannot be created because the email
        // must be unique for each user.
        if(isEmailExist(email)){
            String message = "Could not create user. A user with email " + email + " already exists.";
            request.setAttribute("message", message);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
            requestDispatcher.forward(request,response);
        }else {
            Users user = new Users(email , fullName , password);
            usersDAO.create(user);
            listUser("New User created Successfully");
        }

    }

    public void editUser() throws ServletException, IOException {
        Integer userId = Integer.parseInt(request.getParameter("id"));
        Users user = usersDAO.get(userId);

        String editPage = "user_form.jsp";
        request.setAttribute("user", user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
        requestDispatcher.forward(request,response);
    }

    public void updateUser() throws ServletException, IOException {
        Integer userId  = Integer.parseInt(request.getParameter("id"));
        String email  = request.getParameter("email");
        String fullName  = request.getParameter("fullName");
        String password  = request.getParameter("password");

        if(isEmailExist(email)){
            String message = "Could not update user. A user with email " + email + " already exists.";
            request.setAttribute("message", message);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
            requestDispatcher.forward(request,response);
        }else {
            Users users = new Users(userId , email , fullName , password);
            usersDAO.update(users);
            listUser("User Updated Successfully.");
        }
    }

    // check whether the email already exists or not
    public boolean isEmailExist(String email){
        Users userByEmail = usersDAO.findByEmail(email); // this method is used to find the email already exists in the database or not
        if(userByEmail != null) {
            return true;
        }
        return false;
    }

    public void deleteUser() throws ServletException, IOException {
        Integer userId = Integer.valueOf(request.getParameter("id"));
        usersDAO.delete(userId);
        listUser("User has been deleted successfully.");
    }

    public void login() throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean loginResult = usersDAO.checkLogin(email, password);

        if(loginResult){
            Users user = usersDAO.findByEmail(email);
            String fullName = user.getFullName();

            System.out.println("User is authenticated");
            System.out.println(fullName);

            request.getSession().setAttribute("fullName", fullName);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/");
            requestDispatcher.forward(request,response);
        }else{
            String message = "Login Failed. Please Try Again !";
            request.setAttribute("message", message);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
