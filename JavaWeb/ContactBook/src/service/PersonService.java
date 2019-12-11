package service;

import bean.Person;
import util.Page;

import java.util.ArrayList;

public interface PersonService {
    public Page showPerson(int pn,int ps);
    public boolean addPerson(Person person);
    public boolean deletePerson(int id);
    public boolean modifyPerson(Person person);
    public ArrayList<Person> queryByName(String name);
    public Person queryById(int id);

}
