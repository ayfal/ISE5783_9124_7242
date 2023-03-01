package targil0;

public abstract class Employee {
	
	String FIRST_NAME;
    String LAST_NAME; 
    int ID;

    
  //constructors
    public Employee()  { this("plony","almony",0); }
    
    public Employee(String f_name, String l_name, int id) {
    	
    	FIRST_NAME = f_name;
    	LAST_NAME = l_name;
        this.setId(id);;
    }
    
    
    //setters

    public void setFirstName(String f_name) { FIRST_NAME = f_name; }

    public void setLastName(String l_name) {LAST_NAME = l_name; }
    
    public void setId(int id) { if(id >= 0) {ID = id;} else {throw new IllegalArgumentException(" invalid id! "); }  }
    
    
    //getters

    public String getFirstName() {  return FIRST_NAME; }
    
    public String getLastName() { return LAST_NAME; }

    public int getId() { return ID; }
    
    
    // functions 
    @Override
    public  String toString(){ 
    	
        return  "First Name: " + FIRST_NAME + " Last Name: " + LAST_NAME + " ID: " + ID;
    }
    
    @Override
    public  boolean equals(Object o){
    	
        Employee e = (Employee)o;
        return (ID == e.ID) && (FIRST_NAME == e.FIRST_NAME) && (LAST_NAME == e.LAST_NAME);
    }
    
    
    public abstract double earnings();

}
