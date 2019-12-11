package dao;

import bean.Person;

import java.util.ArrayList;

public interface PersonDao {
    //计算条数
    public int count();
    //展示所有信息
    public ArrayList<Person> getPersonList(int pn, int ps);

    //修改通讯录信息
    public boolean update(Person person);

    //删除信息
    public boolean deletePerson(int id);

    //根据姓名查询信息
    public ArrayList<Person> queryByName(String name);

    //插入信息
    public boolean addPerson(Person person);

    public Person queryById(int id);
}
