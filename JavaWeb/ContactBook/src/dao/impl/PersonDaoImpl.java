package dao.impl;

import bean.Person;
import dao.PersonDao;
import util.BaseDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDaoImpl extends BaseDataBase implements PersonDao {
    ResultSet rs = null;
    String sql = null;
    int a = 0;

    @Override
    public int count() {
        int count = 0;
        try {
            String sql = "select count(*) from person";
            Object[] params = {};
            rs = this.executeQuery(sql, params);
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResource();
        }
        return count;
    }

    @Override
    public ArrayList<Person> getPersonList(int pn, int ps) {
        ArrayList<Person> personArrayList = new ArrayList<Person>();
        rs = null;
        try {
            sql = "select id,name,sex,phone,address from person limit ?,?";
            Object[] params = {pn,ps};
            rs = this.executeQuery(sql, params);

            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt(1));
                person.setName(rs.getString(2));
                person.setSex(rs.getString(3));
                person.setPhone(rs.getString(4));
                person.setAddress(rs.getString(5));
                personArrayList.add(person);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResource();
        }
        return personArrayList;
    }

    @Override
    public boolean update(Person person) {
        a = 0;
        try {
            sql = "update person set name=?,sex=?,phone=?,address=? where id=?";
            Object[] params = {person.getName(), person.getSex(), person.getPhone(), person.getAddress(), person.getId()};
            a = this.executeUpdate(sql, params);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeResource();
        }

        return a > 0 ? true : false;
    }
    @Override
    public boolean deletePerson(int id) {
        a = 0;
        try {
            sql = "delete from person where id=?";
            Object[] params = {id};
            a = this.executeUpdate(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a > 0 ? true : false;
    }
    @Override
    public ArrayList<Person> queryByName(String name) {
        ArrayList<Person> al = new ArrayList<Person>();
        rs = null;
        try {
            sql = "select * from person where name=?";
            Object[] params = {name};
            rs = this.executeQuery(sql, params);
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setPhone(rs.getString("phone"));
                person.setSex(rs.getString("sex"));
                person.setAddress(rs.getString("address"));
                al.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeResource();
        }
        return al;
    }
    @Override
    public boolean addPerson(Person person) {
        a = 0;
        try {
            sql = "insert into person (name,phone,sex,address) values (?,?,?,?)";
            Object[] params = {person.getName(), person.getPhone(), person.getSex(), person.getAddress()};
            a = this.executeUpdate(sql, params);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return a > 0 ? true : false;
    }

    @Override
    public Person queryById(int id) {
        rs=null;
        Person person=new Person();
        try {
            sql="select name,sex,phone,address from person where id=?";
            Object[] params={id};
            rs=this.executeQuery(sql,params);

            while(rs.next()){
                person.setId(id);
                person.setName(rs.getString(1));
                person.setSex(rs.getString(2));
                person.setPhone(rs.getString(3));
                person.setAddress(rs.getString(4));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return person;
    }
}
