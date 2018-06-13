package problem2;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class sortMarketingByEmployeeName implements Comparator<Marketing>
{
    public int compare(Marketing a, Marketing b)
    {
        return a.productname.compareTo(b.productname); // Consistency with comparator 
    }
}

public class Marketing    implements Comparator<Marketing> {

	
	
	public int compare(Marketing a, Marketing b)
    {	
		Double value=a.salesamount-b.salesamount;
        return value.intValue();
    }
	
	
	
	
	 public static List<Marketing>  listMoreThan1000( List<Marketing> list)
	 {
		 	List<Marketing> lt = new ArrayList<>();
		 	
		 	for (Marketing element : list) {
				
		 		if(element.salesamount>1000) 
		 		{
		 			lt.add(element);
		 		}
			}
			
			return lt;
			
		}

	 
	String employeename, productname; 
	double salesamount;
	public Marketing(String employeename, String productname, double salesamount) {
		 
		this.employeename = employeename;
		this.productname = productname;
		this.salesamount = salesamount;
	}
	
	 
	 
	@Override
	public String toString() {
		return "Marketing [employeename=" + employeename + ", productname=" + productname + ", salesamount="
				+ salesamount + "]";
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 741;
		int result = 1;
		result = prime * result + ((this.employeename == null) ? 0 : this.employeename.hashCode());
		result = prime * result + ((this.productname == null) ? 0 : this.productname.hashCode());		
		long  temp = Double.doubleToLongBits(salesamount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}		
		Marketing other = (Marketing) obj;
		
		return this.salesamount==other.salesamount ; 
	}
	public static void main(String[] args) {
		List< Marketing>  database= new ArrayList<>();
		database.add(new Marketing("Juan Fco","Pepsi",800.9));
		database.add(new Marketing("Fernando","Cocacola",200.9));
		database.add(new Marketing("Romario","Sprite",1600.9));
		database.add(new Marketing("Luis","Sprite",5300.9));
		System.out.printf("The database size of marketing is %s",database.size());		
		database.forEach((v)->System.out.println(v.toString()));
		
		sortMarketingByEmployeeName comparator= new sortMarketingByEmployeeName();
		System.out.println("After Sort");
		
		database.sort(new Marketing(null,null,0));// using interfaces comparator
		
		database.forEach((v)->System.out.println(v.toString()));
		System.out.println("those greater than 1000");
		List< Marketing>  database_greater_that_1000=listMoreThan1000(database);
		database_greater_that_1000.sort(comparator);		
		database_greater_that_1000.forEach((v)->System.out.println(v.toString()));
		
		
	}
	
}
