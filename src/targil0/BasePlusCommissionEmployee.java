package targil0;

public class BasePlusCommissionEmployee extends CommissionEmployee {
	
	float BASE_SALARY;
	
	
	//constructors
	BasePlusCommissionEmployee() { this("plony","almony",0,0,0,0);}

	BasePlusCommissionEmployee(String f_name, String l_name,int id,float g_sales,int com, float b_salary) {
    	
	     super(f_name,l_name,id,g_sales,com);
	     this.setBaseSalary(b_salary);;
	}
	

    //setters    
    public void setBaseSalary(float b_salary) {
    	if(b_salary >= 0) {BASE_SALARY = b_salary; } else {throw new IllegalArgumentException(" invalid base salary! "); }
    	}
  
    //getters
    public float getBaseSalary() { return BASE_SALARY; }
    
    
   // functions 
    @Override
    public  boolean equals(Object o) {
    	
    	BasePlusCommissionEmployee bpce = (BasePlusCommissionEmployee)o;
        return super.equals(o) && (BASE_SALARY == bpce.BASE_SALARY);
    }
    
    @Override
    public String toString() { return super.toString() + " Base Salary: " + BASE_SALARY; }
    
  
    @Override
	public double earnings() {
		
		return (double)(super.earnings() + BASE_SALARY);
	}

}
