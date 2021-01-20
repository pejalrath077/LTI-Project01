package com.example.demo.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


//@Entity
//@Table(name="testdb")
@Data
@Document(collection = "Ifull")
public class RequestForm {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int srNo;
	
	private String system;
	private String issues;
    private String reportedDate;
	private String criticality;
	private String pendingWith;
	private String status;
	private String verifiedBy;
	private String targetDate;
	private String closureDate;
	private String remark;
	private String reportedBy;

	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getIssues() {
		return issues;
	}
	public void setIssues(String issues) {
		this.issues = issues;
	}
	public String getReportedDate() {
		return reportedDate;
	}
	public void setReportedDate() {
		LocalDateTime time = LocalDateTime.now();
		this.reportedDate = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH).format(time) ;
	}
	public String getCriticality() {
		return criticality;
	}
	public void setCriticality(String criticality) {
		this.criticality = criticality;
	}
	public String getPendingWith() {
		return pendingWith;
	}
	public void setPendingWith(String pendingWith) {
		this.pendingWith = pendingWith;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getVerifiedBy() {
		return verifiedBy;
	}
	public void setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
	}
	public String getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(String targetDate) {
	
		this.targetDate = targetDate;
	}
	public String getClosureDate() {
		return closureDate;
	}
	public void setClosureDate() {
		LocalDateTime time = LocalDateTime.now();
		this.closureDate = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH).format(time);
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getReportedBy() {
		return reportedBy;
	}
	public void setReportedBy(String reportedBy) {
		this.reportedBy = reportedBy;
	}
	@Override
	public String toString() {
		return "RequestForm [srNo=" + srNo + ", system=" + system + ", issues=" + issues + ", reportedDate="
				+ reportedDate + ", criticality=" + criticality + ", pendingWith=" + pendingWith + ", status=" + status
				+ ", verifiedBy=" + verifiedBy + ", targetDate=" + targetDate + ", closureDate=" + closureDate
				+ ", remark=" + remark + ", reportedBy=" + reportedBy + "]";
	}
	
	
}
