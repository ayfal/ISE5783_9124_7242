package targil0;

public class HourlyEmployee extends Employee {
	
	int HOURS;
    float WAGE; 
    
   

    
  //constructors
    HourlyEmployee() { this("plony","almony",0,0,0);}

    HourlyEmployee(String f_name, String l_name,int id,int hours,float wage) {
       super(f_name,l_name,id);
       this.setHours(hours);;
       this.setWage(wage);;
    }


    
    //setters    
     public void setHours(int hours) { if(hours >= 0) {HOURS = hours;} else {throw new IllegalArgumentException(" invalid hours! "); }}
    
     public void setWage(float wage) { if(wage >= 0) {WAGE = wage;} else {throw new IllegalArgumentException(" invalid wage! "); }}
    
   
      
    //getters
    public int getHours() { return HOURS; }
    
    public float getWage() {return WAGE; }
    

    // functions 
    @Override
    public  boolean equals(Object o) {
    	
        HourlyEmployee he = (HourlyEmployee)o;
        return super.equals(o) && (HOURS== he.HOURS) && (WAGE == he.WAGE);
    }
    
    @Override
    public String toString() { return super.toString() + " Hours: " + HOURS + " Wage: " + WAGE; }

    
    public double earnings() { return (double)(WAGE*HOURS); }

}
