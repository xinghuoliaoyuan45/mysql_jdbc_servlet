package test;

import java.util.List;
import java.util.Map;

import dao.PersonDao;
import entity.Person;

public class Test_1 {

	public static void main(String[] args) throws Exception {
		PersonDao dao=new PersonDao();
	//dao.add(new Person("����һ��",2,"�������Ӫ��"));
//		dao.add(new Person("����һ��",3,"��߼�����"));
//		dao.add(new Person("����һ��",4,"�Ⱦ�"));
	//	Long count= dao.personCount();
//		System.out.println(count);
		Map<Integer,Person>  persons=dao.findAll();
     for (Map.Entry<Integer, Person> entry : persons.entrySet())
     {   
    	 System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
     }
//       //System.out.println(""+person.size()); 
		//Person person1=dao.findById(1);
		//dao.update(new Person(10,"����2��",2,"Dbtuils"));
	//	dao.delete(7);
		//Person s=dao.findById(10);
		//System.out.println(s.toString());
       
        
	}

}



