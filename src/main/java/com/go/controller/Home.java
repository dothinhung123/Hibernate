package com.go.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.go.config.JdbcConnection;
import com.go.dao.ContactDao;
import com.go.model.Contact;

import java.io.IOException;

import javax.servlet.*;
@WebServlet("/")
public class Home extends HttpServlet{
	private ContactDao contactDao;
public void init() {
	contactDao = new ContactDao();
}
protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
String action =request.getServletPath();
System.out.println(action);
switch(action) {
case "/add":add(request,response);
break;
case "/insert":insert(request,response);
break;
case "/update":update(request,response);
break;
case "/edit":edit(request,response);
break;
case "/delete":delete(request,response);
break;
default : listAll(request,response);
break;
}
	
	
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
doGet(request,response);
}
private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
	Long id = Long.parseLong(request.getParameter("id"));
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	String phone = request.getParameter("phone");
	Contact contact = new Contact();
	contact.setId(id);
	contact.setName(name);
	contact.setEmail(email);
	contact.setAddress(address);
	contact.setPhone(phone);
	contactDao.update(contact);
	response.sendRedirect(request.getContextPath()+"/");
}
private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	String phone = request.getParameter("phone");
	Contact contact = new Contact();
	contact.setName(name);
	contact.setEmail(email);
	contact.setAddress(address);
	contact.setPhone(phone);
	contactDao.add(contact);
	response.sendRedirect(request.getContextPath() + "/");
}
private void listAll(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
	request.setAttribute("contacts", contactDao.getAllContacts());
	for(Contact contact : contactDao.getAllContacts()) {
		System.out.println(contact.getEmail());
	}
	RequestDispatcher rq = request.getRequestDispatcher("table.jsp");
	rq.forward(request, response);
	
}
private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
	Long id = Long.parseLong(request.getParameter("id"));
	contactDao.delete(id);
	response.sendRedirect(request.getContextPath() + "/");
}
private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
	Long id =Long.parseLong(request.getParameter("id"));
	request.setAttribute("contact", contactDao.getById(id));
	RequestDispatcher rq = request.getRequestDispatcher("form.jsp");
	rq.forward(request, response);
	
}
private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
	RequestDispatcher rq = request.getRequestDispatcher("form.jsp");
	rq.forward(request, response);
}

}
