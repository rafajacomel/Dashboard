package com.ibm.fsp.archive.dashboardbackend.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * Entity that represents table cpp.fix
 * 
 */
@Entity
@Table(name = "fix", schema = "cpp")
public class Fix {
	
	protected Fix() {
	}
	
	public Fix(String fspid) {
		super();
		this.fspid = fspid;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "FSPID") 
	private String fspid;
	
	@Column(name = "FIXID") 
	private String fixid;
	
	@Column(name = "FIXIDQUALIFIER") 
	private String fixidqualifier;
	
	@Column(name = "STATUS") 
	private String status;
	
	@Column(name = "STATUSREASON") 
	private String statusreason;
	
	@Column(name = "SERVICETYPE") 
	private String servicetype;
	
	@Column(name = "FIXNAME") 
	private String fixname;
	
	@Column(name = "FIXABSTRACT") 
	private String fixabstract;
	
	@Column(name = "COMPONENTID") 
	private String componentid;
	
	@Column(name = "COMPONENTNAME") 
	private String componentname;
	
	@Column(name = "BASETYPE") 
	private String basetype;
	
	@Column(name = "FIXTYPE") 
	private String fixtype;
	
	@Column(name = "THIRDPARTYFIX") 
	private String thirdpartyfix;
	
	@Column(name = "ORDERABLEGROUPID") 
	private String orderablegroupid;
	
	@Column(name = "EXTINFOURL") 
	private String extinfourl;
	
	@Column(name = "BRANDNAME") 
	private String brandname;
	
	@Column(name = "FIXVRMF") 
	private String fixvrmf;
	
	@Column(name = "NORMFIXVRMF") 
	private Long normfixvrmf;
	
	@Column(name = "LEVEL") 
	private String level;
	
	@Column(name = "SERVICELEVEL") 
	private String servicelevel;
	
	@Column(name = "GROUPLEVEL") 
	private String grouplevel;
	
	@Column(name = "LOAD") 
	private String load;
	
	@Column(name = "RELEASEALIAS") 
	private String releasealias;
	
	@Column(name = "TMLVERSION") 
	private String tmlversion;
	
	@Column(name = "REPLACECOUNT") 
	private Integer replacecount;
	
	@Column(name = "AC_RESTRICTIONLIST") 
	private String ac_restrictionlist;
	
	@Column(name = "FIXSIZE") 
	private Long fixsize;
	
	@Column(name = "TSCREATED") 
	private Date tscreated;
	
	@Column(name = "TSCHANGED") 
	private Date tschanged;
	
	@Column(name = "CHANGEDBY") 
	private String changedby;
	
	@Column(name = "SUBMITTER") 
	private String submitter;

	public String getFspid() {
		return fspid;
	}

	public void setFspid(String fspid) {
		this.fspid = fspid;
	}

	public String getFixid() {
		return fixid;
	}

	public void setFixid(String fixid) {
		this.fixid = fixid;
	}

	public String getFixidqualifier() {
		return fixidqualifier;
	}

	public void setFixidqualifier(String fixidqualifier) {
		this.fixidqualifier = fixidqualifier;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusreason() {
		return statusreason;
	}

	public void setStatusreason(String statusreason) {
		this.statusreason = statusreason;
	}

	public String getServicetype() {
		return servicetype;
	}

	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}

	public String getFixname() {
		return fixname;
	}

	public void setFixname(String fixname) {
		this.fixname = fixname;
	}

	public String getFixabstract() {
		return fixabstract;
	}

	public void setFixabstract(String fixabstract) {
		this.fixabstract = fixabstract;
	}

	public String getComponentid() {
		return componentid;
	}

	public void setComponentid(String componentid) {
		this.componentid = componentid;
	}

	public String getComponentname() {
		return componentname;
	}

	public void setComponentname(String componentname) {
		this.componentname = componentname;
	}

	public String getBasetype() {
		return basetype;
	}

	public void setBasetype(String basetype) {
		this.basetype = basetype;
	}

	public String getFixtype() {
		return fixtype;
	}

	public void setFixtype(String fixtype) {
		this.fixtype = fixtype;
	}

	public String getThirdpartyfix() {
		return thirdpartyfix;
	}

	public void setThirdpartyfix(String thirdpartyfix) {
		this.thirdpartyfix = thirdpartyfix;
	}

	public String getOrderablegroupid() {
		return orderablegroupid;
	}

	public void setOrderablegroupid(String orderablegroupid) {
		this.orderablegroupid = orderablegroupid;
	}

	public String getExtinfourl() {
		return extinfourl;
	}

	public void setExtinfourl(String extinfourl) {
		this.extinfourl = extinfourl;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getFixvrmf() {
		return fixvrmf;
	}

	public void setFixvrmf(String fixvrmf) {
		this.fixvrmf = fixvrmf;
	}

	public Long getNormfixvrmf() {
		return normfixvrmf;
	}

	public void setNormfixvrmf(Long normfixvrmf) {
		this.normfixvrmf = normfixvrmf;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getServicelevel() {
		return servicelevel;
	}

	public void setServicelevel(String servicelevel) {
		this.servicelevel = servicelevel;
	}

	public String getGrouplevel() {
		return grouplevel;
	}

	public void setGrouplevel(String grouplevel) {
		this.grouplevel = grouplevel;
	}

	public String getLoad() {
		return load;
	}

	public void setLoad(String load) {
		this.load = load;
	}

	public String getReleasealias() {
		return releasealias;
	}

	public void setReleasealias(String releasealias) {
		this.releasealias = releasealias;
	}

	public String getTmlversion() {
		return tmlversion;
	}

	public void setTmlversion(String tmlversion) {
		this.tmlversion = tmlversion;
	}

	public Integer getReplacecount() {
		return replacecount;
	}

	public void setReplacecount(Integer replacecount) {
		this.replacecount = replacecount;
	}

	public String getAc_restrictionlist() {
		return ac_restrictionlist;
	}

	public void setAc_restrictionlist(String ac_restrictionlist) {
		this.ac_restrictionlist = ac_restrictionlist;
	}

	public Long getFixsize() {
		return fixsize;
	}

	public void setFixsize(Long fixsize) {
		this.fixsize = fixsize;
	}

	public Date getTscreated() {
		return tscreated;
	}

	public void setTscreated(Date tscreated) {
		this.tscreated = tscreated;
	}

	public Date getTschanged() {
		return tschanged;
	}

	public void setTschanged(Date tschanged) {
		this.tschanged = tschanged;
	}

	public String getChangedby() {
		return changedby;
	}

	public void setChangedby(String changedby) {
		this.changedby = changedby;
	}

	public String getSubmitter() {
		return submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}

	
	
	
	
}


