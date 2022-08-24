package splitapp;

import java.util.List;

public class Expense {
    
	private int exId;
	private List<User>users;
	private String des;
	private User paidBy;
	private int Amount;
	private String splitStrategy;
	public Expense(User paidBy,String des,int exId,int Amount,List<User>users,String splitStrategy) {
		this.exId=exId;
		this.des=des;
		this.paidBy=paidBy;
		this.Amount=Amount;
		this.users=users;
		this.splitStrategy=splitStrategy;
		splitBill();
	}
	private void splitBill() {
		// TODO Auto-generated method stub
		if(splitStrategy=="SPLIT_EQUALLY") {
			splitEqually();
		}
	}
	private void splitEqually() {
		// TODO Auto-generated method stub
		int part=Amount/users.size();
		for(int i=0;i<users.size();i++) {
			if(users.get(i)==paidBy)
				 continue;
			paidBy.addAmount(users.get(i),part);
			users.get(i).addAmount(paidBy,-part);
		}
	}
}
