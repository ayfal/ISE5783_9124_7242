package targil0;

public class Payroll {

	public static void main(String[] args) {
		
		try {
			HourlyEmployee he = new HourlyEmployee("Ariel","David",111,10,100);
			CommissionEmployee ce = new CommissionEmployee("Malachi","David",222,234567,3);
			BasePlusCommissionEmployee bpce = new BasePlusCommissionEmployee("Meitav","David",333,1234,11, 1000);
		
		
			Employee[] e_array = {he,ce,bpce};
	    
			for  (Employee e : e_array) {
				
				System.out.println(e);
			
				if( e.getId() == bpce.getId() ){ System.out.println("weakly salary: " + e.earnings()*1.1); } 
			 
				else { System.out.println("weakly salary: " + e.earnings() + "\n" );}
			}
			
		}catch(IllegalArgumentException e) {
			System.out.println(e);
		}
	}
}
