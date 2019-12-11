package service.impl;

import bean.Person;
import dao.PersonDao;
import dao.impl.PersonDaoImpl;
import service.PersonService;
import util.Page;


import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements PersonService {
    PersonDao personDao=new PersonDaoImpl();


    @Override
    public Page showPerson(int pn, int ps) {
        Page<Person> page = new Page();
        List<Person> al = personDao.getPersonList(pn, ps);
        page.setList(al);
        page.setPageNo(pn);
        page.setPageSize(ps);
        int totalSize = personDao.count();
        int totalPage = totalSize % ps == 0 ? totalSize / ps : totalSize / ps + 1;
        page.setTotalPage(totalPage);
        page.setTotalSize(totalSize);
        return page;
    }

    @Override
    public boolean addPerson(Person person) {
        return personDao.addPerson(person);
    }

    @Override
    public boolean deletePerson(int id) {
        return personDao.deletePerson(id);
    }

    @Override
    public boolean modifyPerson(Person person) {
        return personDao.update(person);
    }

    @Override
    public ArrayList<Person> queryByName(String name) {
        return personDao.queryByName(name);
    }

    @Override
    public Person queryById(int id) {
        Person person=personDao.queryById(id);
        return person;
    }
}
