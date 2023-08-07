package in.prasoon.binding;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EmployeeBinding
{
	private String empId;
	private String empName;
	private String empAddress;
	private String empEmail;
	private String empMobile;
	private String empGender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date empDOB;
	private Boolean empMarriedStatus;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpMobile() {
		return empMobile;
	}
	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}
	public String getEmpGender() {
		return empGender;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	public Date getEmpDOB() {
		return empDOB;
	}
	public void setEmpDOB(Date empDOB) {
		this.empDOB = empDOB;
	}
	public Boolean getEmpMarriedStatus() {
		return empMarriedStatus;
	}
	public void setEmpMarriedStatus(Boolean empMarriedStatus) {
		this.empMarriedStatus = empMarriedStatus;
	}
	@Override
	public String toString() {
		return "EmployeeBinding [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", empEmail="
				+ empEmail + ", empMobile=" + empMobile + ", empGender=" + empGender + ", empDOB=" + empDOB
				+ ", empMarriedStatus=" + empMarriedStatus + "]";
	}
	public EmployeeBinding(String empId, String empName, String empAddress, String empEmail, String empMobile,
			String empGender, Date empDOB, Boolean empMarriedStatus) {
		
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
		this.empEmail = empEmail;
		this.empMobile = empMobile;
		this.empGender = empGender;
		this.empDOB = empDOB;
		this.empMarriedStatus = empMarriedStatus;
	}
	public EmployeeBinding() {
	
	}
	
	
	
	
}
