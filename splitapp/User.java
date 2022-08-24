package splitapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
     private String userName;
     private int userId;
     private String mobileNumber;
     private int oweAmount;
     //private int owedAmount;
     private String email;
     private Map<User,Integer>userVsAmount=new HashMap<User,Integer>();
     private List<Group>listOfGroup;
     public User(String userName,int userId,String mobileNumber,String email) {
    	    this.userName=userName;
    	    this.userId=userId;
    	    this.mobileNumber=mobileNumber;
    	    this.email=email;
    	    this.oweAmount=0;
    	    //this.owedAmount=0;
    	    this.listOfGroup=new ArrayList<Group>();
     }
     public String toString() {
    	return "user ID" +userId+" Name "+userName;
     }
	public void addAmount(User user, int part) {
		// TODO Auto-generated method stub
		int x=0;
		if(userVsAmount.containsKey(user))
		x=userVsAmount.get(user);
		userVsAmount.put(user, part+x);
		oweAmount+=part;
	}
	public void showOweDetails() {
		// TODO Auto-generated method stub
		System.out.println("user total owe amount"+oweAmount+"\n");
		for(Map.Entry<User, Integer>e:userVsAmount.entrySet()) {
			System.out.println(e.getKey().toString()+" and Amont"+e.getValue()+ "\n");
		}
	}
}
