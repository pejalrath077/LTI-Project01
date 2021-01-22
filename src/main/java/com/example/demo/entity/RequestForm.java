package com.example.demo.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

@Repository
@Document(collection = "iFulfill")
public class RequestForm {

	@Id
	private int id;
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

	public RequestForm() {

	}

	public RequestForm(String system, String issues, String reportedDate, String criticality, String pendingWith,
			String status, String verifiedBy, String targetDate, String closureDate, String remark, String reportedBy) {
		this.system = system;
		this.issues = issues;
		this.reportedDate = reportedDate;
		this.criticality = criticality;
		this.pendingWith = pendingWith;
		this.status = status;
		this.verifiedBy = verifiedBy;
		this.targetDate = targetDate;
		this.closureDate = closureDate;
		this.remark = remark;
		this.reportedBy = reportedBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "RequestForm [id=" + id + ", system=" + system + ", issues=" + issues + ", reportedDate=" + reportedDate
				+ ", criticality=" + criticality + ", pendingWith=" + pendingWith + ", status=" + status + ", verifiedBy="
				+ verifiedBy + ", targetDate=" + targetDate + ", closureDate=" + closureDate + ", remark=" + remark
				+ ", reportedBy=" + reportedBy + "]";
	}
}
