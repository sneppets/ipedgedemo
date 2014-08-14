import com.sneppets.drools.DroolInitialiser;
import com.sneppets.model.Account;


public class AccountTest {
	
	public static void main (String args[]){
		
		DroolInitialiser di = new DroolInitialiser();
		di.initialiseDrools();
		Account account = new Account(200);
		account.withdraw(120);
		account = di.runRulesForAccount(account);
		System.out.println("Account Status : " + account.getStatus());
	}

}
