package tree_in_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrudForTree {

	public static List<AllOrgDTO> addToTree(AllOrgDTO emp ,List<AllOrgDTO> items){

		for(AllOrgDTO boss : items){
		if(boss.getEmpId().equals(emp.getBossId())  && !boss.getEmpId().equals(emp.getEmpId())
				) {
			if(!boss.getChilds().contains(emp)) {
				boss.getChilds().add(emp);
	   		}
     		break;

		}else {
			
		if(boss.getChilds().size()>0) {
			
			addToTree(emp,boss.getChilds());
		
	            
		}
		} }
		return items;
	                      }
	
	
	public static List<AllOrgDTO> removeFromTree(AllOrgDTO emp ,List<AllOrgDTO> items){

		for(AllOrgDTO boss : items){
			  	if(boss.getEmpName().equals(emp.getEmpName())) { 
			    	  items.remove(boss);
			    	  return items;
			    }else {
					 if(boss.getChilds().size()>0) {
				          removeFromTree(emp,boss.getChilds());
				          } 
			    
	            }
	          	}
			
			
	       return items;
		       
	                      }
	

         public static int total_Child_Under_a_element(AllOrgDTO node) {
		        int count = 0;
		        for (AllOrgDTO child : node.getChilds()) {
		            count += 1 + total_Child_Under_a_element(child);
		            }
		        return count;
		    }
         
         
         public static List<AllOrgDTO>  makeATree(List<AllOrgDTO> lst){
        	 Map<String,AllOrgDTO> result = new HashMap<String,AllOrgDTO>();
     		
     		for(AllOrgDTO emp : lst) {
     			if(emp.getEmpId().equals(emp.getBossId())) {
     				emp.setBossId("inv"+emp.getBossId());
     			}
     		     result.put(emp.getEmpId(), emp);
     		}
     		
     		
     		for(AllOrgDTO emp : lst) {
     		if(result.containsKey(emp.getBossId())){
     		String key = emp.getBossId();
     		AllOrgDTO boss = result.get(emp.getBossId());
     		if(!boss.getEmpId().equals(emp.getEmpId())) {
        		result.remove(emp.getEmpId());
         		boss.addChild(emp);
         		result.put(key, boss);	
     		}
 
     		}}

     		   lst = new ArrayList<>();
     		   for(String key : result.keySet()){
     		   AllOrgDTO emp = result.get(key);
     		    lst.add(emp); }
     		   
     		List<String> keyToRemove = new ArrayList<>();

     	
     		for(AllOrgDTO emp : lst) {
     		   
     		for(String parentKey : result.keySet()) {
     		        AllOrgDTO parent = result.get(parentKey);
     		        
     		        if(!parent.getEmpId().equals(emp.getEmpId())) {
     		List<AllOrgDTO> childs = parent.getChilds();
     		if(childs.size()>0) {
     		int total_child_before_adding__emp_as_child = total_Child_Under_a_element(parent);
     		childs = addToTree(emp,childs);
     		parent.setChilds(childs);
     		int total_child_after_adding__emp_as_child = total_Child_Under_a_element(parent);
     		if(total_child_after_adding__emp_as_child>total_child_before_adding__emp_as_child) {
     			keyToRemove.add(emp.getEmpId());
     		    result.put(parentKey, parent);
     		      
     		     } 
     		  }
     	       }
     		   }
     		}
     		
     		lst.clear();


     	for(String key : result.keySet()) {
     		if(!keyToRemove.contains(key)) {
         		lst.add(result.get(key));
     		}
     		}
     	
            return lst;
         }
	    

		public static void main(String[] args) {
		List<AllOrgDTO> lst = new ArrayList<>();
		lst.add(new AllOrgDTO("M","100","100"));
		lst.add(new AllOrgDTO("K","33","52"));
		lst.add(new AllOrgDTO("L","37","52"));
		lst.add(new AllOrgDTO("D","20","100"));
		lst.add(new AllOrgDTO("A","10","20"));
		lst.add(new AllOrgDTO("N","203","458"));
		lst.add(new AllOrgDTO("J","52","16"));
		lst.add(new AllOrgDTO("B","11","20"));
		lst.add(new AllOrgDTO("C","12","20"));
		lst.add(new AllOrgDTO("E","13","10"));
		lst.add(new AllOrgDTO("F","14","10"));
		lst.add(new AllOrgDTO("G","15","10"));    
		lst.add(new AllOrgDTO("H","16","11"));
		lst.add(new AllOrgDTO("I","51","16"));
		
		
		lst = makeATree(lst);
		
		// add a element as a child to a certain position of the tree
		// now i will add a element under I
		
		AllOrgDTO child = new AllOrgDTO("child-of-E","childE-ID","203");
		lst = addToTree(child,lst);
		
		System.out.println("after adding a child to the tree the final tree is=");
		
	     for(AllOrgDTO dto : lst){
		   System.out.println(dto); 
               }
	     
	     // remove a element from certain position of the tree
	     // now we will remove our added item
	     
			lst = removeFromTree(child,lst);
			
			System.out.println("after Deleting the child from the tree the final tree is=");
				for(AllOrgDTO dto : lst){
			   System.out.println(dto); 
	               }
	     

		}



}
