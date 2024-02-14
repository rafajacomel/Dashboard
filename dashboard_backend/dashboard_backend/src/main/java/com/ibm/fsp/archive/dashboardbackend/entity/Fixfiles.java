package com.ibm.fsp.archive.dashboardbackend.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity that represents table cpp.fixfiles
 * 
 */
@Entity
@Table(name = "fixfiles", schema = "cpp")
public class Fixfiles {
	
	protected Fixfiles() {
	}
	
	public Fixfiles(String fspid) {
		super();
		this.fspid = fspid;
	}
	
	@Column(name = "URI") 
	private String uri;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "FSPID") 
	private String fspid;
	
	@Column(name = "SEQUENCENO") 
	private Integer sequenceno;
	
	@Column(name = "FAMILY") 
	private String family;
	
	@Column(name = "DATAINDICATOR") 
	private String dataindicator;
	
	@Column(name = "NLV") 
	private String nlv;
	
	@Column(name = "LANGUAGE") 
	private String language;
	
	@Column(name = "LANGUAGECOUNTRY") 
	private String languagecountry;
	
	@Column(name = "LANGUAGEDIALECT") 
	private String languagedialect;
	
	@Column(name = "DESCRIPTOR") 
	private String descriptor;
	
	@Column(name = "DESCRIPTION") 
	private String description;
	
	@Column(name = "TYPE") 
	private String type;
	
	@Column(name = "SIZE") 
	private Long size;
	
	@Column(name = "SIZEONSERVER") 
	private Long sizeonserver;
	
	@Column(name = "CHECKSUM") 
	private String checksum;
	
	@Column(name = "CHECKSUMALGORITHM") 
	private String checksumalgorithm;
	
	@Column(name = "FILETYPE") 
	private String filetype;
	
	@Column(name = "FILESTATUS") 
	private String filestatus;
	
	@Column(name = "SYMBOLICLINK") 
	private String symboliclink;
	
	@Column(name = "EXTURLAPP") 
	private String exturlapp;
	
	@Column(name = "USAGE") 
	private String usage;
	
	@Column(name = "TSFILEREPLACED") 
	private Date tsfilereplaced;
	
	@Column(name = "TSCREATED") 
	private Date tscreated;
	
	@Column(name = "TSCHANGED") 
	private Date tschanged;
	
	@Column(name = "CHANGEDBY") 
	private String changedby;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getFspid() {
		return fspid;
	}

	public void setFspid(String fspid) {
		this.fspid = fspid;
	}

	public Integer getSequenceno() {
		return sequenceno;
	}

	public void setSequenceno(Integer sequenceno) {
		this.sequenceno = sequenceno;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getDataindicator() {
		return dataindicator;
	}

	public void setDataindicator(String dataindicator) {
		this.dataindicator = dataindicator;
	}

	public String getNlv() {
		return nlv;
	}

	public void setNlv(String nlv) {
		this.nlv = nlv;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLanguagecountry() {
		return languagecountry;
	}

	public void setLanguagecountry(String languagecountry) {
		this.languagecountry = languagecountry;
	}

	public String getLanguagedialect() {
		return languagedialect;
	}

	public void setLanguagedialect(String languagedialect) {
		this.languagedialect = languagedialect;
	}

	public String getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getSizeonserver() {
		return sizeonserver;
	}

	public void setSizeonserver(Long sizeonserver) {
		this.sizeonserver = sizeonserver;
	}

	public String getChecksum() {
		return checksum;
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	public String getChecksumalgorithm() {
		return checksumalgorithm;
	}

	public void setChecksumalgorithm(String checksumalgorithm) {
		this.checksumalgorithm = checksumalgorithm;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String getFilestatus() {
		return filestatus;
	}

	public void setFilestatus(String filestatus) {
		this.filestatus = filestatus;
	}

	public String getSymboliclink() {
		return symboliclink;
	}

	public void setSymboliclink(String symboliclink) {
		this.symboliclink = symboliclink;
	}

	public String getExturlapp() {
		return exturlapp;
	}

	public void setExturlapp(String exturlapp) {
		this.exturlapp = exturlapp;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public Date getTsfilereplaced() {
		return tsfilereplaced;
	}

	public void setTsfilereplaced(Date tsfilereplaced) {
		this.tsfilereplaced = tsfilereplaced;
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
}


