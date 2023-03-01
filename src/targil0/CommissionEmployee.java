package targil0;

public class CommissionEmployee extends Employee {

	float GROSS_SALES;
	int COMMISION;
	
	
	//constructors
	CommissionEmployee() { this("plony","almony",0,0,0);}

	CommissionEmployee(String f_name, String l_name,int id,float g_sales,int com) {
    	
	     super(f_name,l_name,id);
	     this.setGrossSales(g_sales);;
	     this.setCommision(com);;
	}
	
	
    //setters    
    public void setGrossSales(float g_sales) { 
    	if(g_sales >= 0) {GROSS_SALES = g_sales;} else {throw new IllegalArgumentException(" invalid gross sales! "); }
    }
  
    public void setCommision(int com) {
    	if(com >= 0) {COMMISION = com; } else {throw new IllegalArgumentException(" invalid commision! "); }
    }
  
  
    //getters
    public float getGrossSales() { return GROSS_SALES; }
  
    public int getCommision() {return COMMISION; }
    
    
    // functions 
    @Override
    public  boolean equals(Object o) {
    	
    	CommissionEmployee ce = (CommissionEmployee)o;
        return super.equals(o) && (GROSS_SALES== ce.GROSS_SALES) && (COMMISION == ce.COMMISION);
    }
    
    @Override
    public String toString() { return super.toString() + " Gross Slaes: " + GROSS_SALES + " Commision: " + COMMISION; }
	
	
	@Override
	public double earnings() {
		
		return (double)(((double)COMMISION * 0.01) * GROSS_SALES);
	}

}
