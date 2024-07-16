package tree_in_java;

import java.util.ArrayList;
import java.util.List;


public class AllOrgDTO {
private String empName;
private String empId;
private String bossId;
public Boolean underSomeOne=Boolean.FALSE;
private List<AllOrgDTO> childs = new ArrayList<>();
public boolean foundMyBoss=false;
public void addChild(AllOrgDTO x ) {
	this.childs.add(x);
}    

public AllOrgDTO( String empName,
 String empId,
 String bossId){
	this.empName = empName;
	this.empId = empId;
	this.bossId = bossId;
	
}

public String getEmpName() {
	return empName;
}

public void setEmpName(String empName) {
	this.empName = empName;
}

public String getEmpId() {
	return empId;
}

public void setEmpId(String empId) {
	this.empId = empId;
}

public String getBossId() {
	return bossId;
}

public void setBossId(String bossId) {
	this.bossId = bossId;
}

public Boolean getUnderSomeOne() {
	return underSomeOne;
}

public void setUnderSomeOne(Boolean underSomeOne) {
	this.underSomeOne = underSomeOne;
}

public List<AllOrgDTO> getChilds() {
	return childs;
}

public void setChilds(List<AllOrgDTO> childs) {
	this.childs = childs;
}

public boolean isFoundMyBoss() {
	return foundMyBoss;
}

public void setFoundMyBoss(boolean foundMyBoss) {
	this.foundMyBoss = foundMyBoss;
}


}
