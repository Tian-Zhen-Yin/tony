package controller;

import bean.Person;
import com.google.gson.Gson;
import service.PersonService;
import service.impl.PersonServiceImpl;
import util.Page;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class PersonServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String method=req.getParameter("method");
        if(method==null||method==""){
            method="showPerson";
        }
        PersonService service=new PersonServiceImpl();
        if(method.equals("showPerson")){
            int pn=Integer.parseInt(req.getParameter("pn"));
            int ps=Integer.parseInt(req.getParameter("ps"));
            Page page=service.showPerson(pn,ps);
            Gson gson=new Gson();
            String json=gson.toJson(page);
            res.getWriter().print(json);
        }else if(method.equals("addPerson")){
            String name=req.getParameter("name");
            String sex=req.getParameter("sex");
            String phone=req.getParameter("phone");
            String address=req.getParameter("address");
            Person person=new Person();
            person.setName(name);
            person.setSex(sex);
            person.setPhone(phone);
            person.setAddress(address);
            res.getWriter().print(service.addPerson(person));
        }else if(method.equals("deletePerson")){
            int id=Integer.parseInt(req.getParameter("id"));
            res.getWriter().print(service.deletePerson(id));

        }else if(method.equals("updatePerson")){
            String id=req.getParameter("id");
            String name=req.getParameter("name");
            String sex=req.getParameter("sex");
            String phone=req.getParameter("phone");
            String address=req.getParameter("address");
            Person person=new Person();
            person.setId(Integer.parseInt(id));
            person.setName(name);
            person.setSex(sex);
            person.setPhone(phone);
            person.setAddress(address);
            boolean flag=service.modifyPerson(person);
            res.getWriter().print(flag);
        }else if(method.equals("queryById")){
            String id=req.getParameter("id");
            Person person=service.queryById(Integer.parseInt(id));
            Gson gson=new Gson();
            String json=gson.toJson(person);
            res.getWriter().print(json);
        }
        else if(method.equals("queryByName")){
            String name=req.getParameter("name");
            ArrayList<Person> al=new ArrayList<Person>();
            al=service.queryByName(name);
            Gson gson=new Gson();
            String json=gson.toJson(al);
            res.getWriter().print(json);
        }
    }
}
