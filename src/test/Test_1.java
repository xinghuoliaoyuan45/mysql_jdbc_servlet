package test;

import java.util.List;
import java.util.Map;

import dao.PersonDao;
import entity.Person;

public class Test_1 {

	public static void main(String[] args) throws Exception {
		PersonDao dao=new PersonDao();
	//dao.add(new Person("生命一号",2,"补充大脑营养"));
//		dao.add(new Person("生命一号",3,"提高记忆力"));
//		dao.add(new Person("生命一号",4,"喝酒"));
	//	Long count= dao.personCount();
//		System.out.println(count);
		Map<Integer,Person>  persons=dao.findAll();
     for (Map.Entry<Integer, Person> entry : persons.entrySet())
     {   
    	 System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
     }
//       //System.out.println(""+person.size()); 
		//Person person1=dao.findById(1);
		//dao.update(new Person(10,"生命2号",2,"Dbtuils"));
	//	dao.delete(7);
		//Person s=dao.findById(10);
		//System.out.println(s.toString());
       
        
	}

}



