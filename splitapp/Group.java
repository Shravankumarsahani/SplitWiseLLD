package splitapp;

import java.util.List;

public class Group {
   private int grpId;
   private String des;
   private List<User>users;
   public Group(int grpId,String grpDes,List<User>u) {
	   this.des=grpDes;
	   this.grpId=grpId;
	   this.users=u;
   }
public void addExpense(User paidBy,int exId, String des, int Amount) {
	// TODO Auto-generated method stub
	   Expense ex=new Expense(paidBy,des,exId,Amount,users,"SPLIT_EQUALLY");
	   
}
}
