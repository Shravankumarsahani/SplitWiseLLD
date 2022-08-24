package splitapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SplitwiseApplication {
     private static Map<Integer,User>idVsUser= new HashMap<Integer,User>();
     private static Map<Integer,Group>idVsGroup=new HashMap<Integer,Group>();
     private static int expId=0;
     public static Scanner s;
     public static void main(String[] args) {
    	  SplitwiseApplication app= new SplitwiseApplication();
    	  User u1=new User("shravan",1,"9670267667","shravansdr2531@gmail.com");
    	  User u2=new User("Rishabh",2,"9670267667","shravansdr2531@gmail.com");
    	  User u3=new User("Mayank",3,"9670267667","shravansdr2531@gmail.com");
    	  User u4=new User("Sparsh",4,"9670267667","shravansdr2531@gmail.com");
    	  List<User>list=new ArrayList<User>();
    	  list.add(u1);
    	  list.add(u2);
    	  list.add(u3);
    	  list.add(u4);
    	  Group grp=new Group(1,"goa trip",list);
    	  idVsUser.put(1, u1);
    	  idVsUser.put(2, u2);
    	  idVsUser.put(3, u3);
    	  idVsUser.put(4, u4);
    	  idVsGroup.put(1, grp);
    	   s=new Scanner(System.in);
    	   while(true) {
    		   System.out.println("Enter the operation\n"+"1 add User\n"+"2 add Group\n"+"3 add group expense\n"+ "4 add no group expense\n"+"5 show user details\n");
    	       int op=s.nextInt();
    		   switch(op) {
    		   case 1:
   				addUser();
   				break;
   			case 2:
   				addGroup();
   				break;
   			case 3:
   				addGroupExpense();
   				break;	
   			case 4:
   				addNonGroupExpense();
   				break;
   			case 5:
   				showUserOweDetails();
   				break;	
    		   }
    	   }
     }
	private static void showUserOweDetails() {
		// TODO Auto-generated method stub
	    System.out.println("enter user id for which u wanted to see owesDetails");
	    s.nextLine();
	    String[] str=s.nextLine().trim().split(" ");
	    User u=idVsUser.get(Integer.parseInt(str[0]));
	    u.showOweDetails();
	}
	private static void addNonGroupExpense() {
		// TODO Auto-generated method stub
		System.out.println("enter the non group expense details:\n");
		s.nextLine();
		String[] str=s.nextLine().trim().split(" ");
		User paidBy=idVsUser.get(Integer.parseInt(str[0]));
		int paidAmount=Integer.parseInt(str[1]);
		String des=str[2];
		List<User>nonGroupUser=new ArrayList<User>();
		int count=0;
		nonGroupUser.add(paidBy);
		for(String a:str) {
			count++;
			if(count<=3)
				continue;
			nonGroupUser.add(idVsUser.get(Integer.parseInt(a)));
		}
		Expense ex=new Expense(paidBy,des,expId++,paidAmount,nonGroupUser,"SPLIT_EQUALLY");
	}
	private static void addGroup() {
		// TODO Auto-generated method stub
		
	}
	private static void addGroupExpense() {
		System.out.println("enter the group expense details:\n");
		s.nextLine();
		String[] str = s.nextLine().trim().split(" ");
		Group g= idVsGroup.get(Integer.parseInt(str[0]));
		g.addExpense(idVsUser.get(Integer.parseInt(str[1])),expId++,str[2],Integer.parseInt(str[3]));
		// TODO Auto-generated method stub
		
	}
	private static void addUser() {
		// TODO Auto-generated method stub
		
	}
}
