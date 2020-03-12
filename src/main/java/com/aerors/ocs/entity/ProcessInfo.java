package com.aerors.ocs.entity;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * processInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="process_info")

public class ProcessInfo  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 6595259870494516204L;
	private Integer id;
     private String processid;
     private String outprocessid;
     private String type;
     private String operator;
     private String priority;
     private String satelliteid;
     private String sensorid;
     private String orbitid;
     private String plevel;
     private String begintime;
     private String endtime;
     private String status;
     private String tasknum;
     private String pauseflag;
     private String pauseitem;
     private byte[] process;
     private byte[] prcessbean;
     private byte[] processparameter;
     private byte[] processreport;
     private String varval1;
     private String varval2;
     private String level;


    // Constructors

    /** default constructor */
    public ProcessInfo() {
    }

	/** minimal constructor */
    public ProcessInfo(String processid) {
        this.processid = processid;
    }
    
    /** full constructor */
    public ProcessInfo(String processid, String outprocessid, String type, String operator, String priority, String satelliteid, String sensorid, String orbitid, String plevel, String begintime, String endtime, String status, String tasknum, String pauseflag, String pauseitem, byte[] process,byte[] prcessbean, byte[] processparameter, byte[] processreport, String varval1, String varval2,String level) {
        this.processid = processid;
        this.outprocessid = outprocessid;
        this.type = type;
        this.operator = operator;
        this.priority = priority;
        this.satelliteid = satelliteid;
        this.sensorid = sensorid;
        this.orbitid = orbitid;
        this.plevel = plevel;
        this.begintime = begintime;
        this.endtime = endtime;
        this.status = status;
        this.tasknum = tasknum;
        this.pauseflag = pauseflag;
        this.pauseitem = pauseitem;
        this.process=process;
        this.prcessbean = prcessbean;
        this.processparameter = processparameter;
        this.processreport = processreport;
        this.varval1 = varval1;
        this.varval2 = varval2;
        this.level = level;
    }

   
    // Property accessors
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="PROCESSID", unique=true, nullable=false, length=255)

    public String getProcessid() {
        return this.processid;
    }
    
    public void setProcessid(String processid) {
        this.processid = processid;
    }
    
    @Column(name="OUTPROCESSID", length=255)

    public String getOutprocessid() {
        return this.outprocessid;
    }
    
    public void setOutprocessid(String outprocessid) {
        this.outprocessid = outprocessid;
    }
    
    @Column(name="TYPE_", length=45)

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    @Column(name="OPERATOR_", length=45)

    public String getOperator() {
        return this.operator;
    }
    
    public void setOperator(String operator) {
        this.operator = operator;
    }
    
    @Column(name="PRIORITY", length=45)

    public String getPriority() {
        return this.priority;
    }
    
    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    @Column(name="SATELLITEID", length=45)

    public String getSatelliteid() {
        return this.satelliteid;
    }
    
    public void setSatelliteid(String satelliteid) {
        this.satelliteid = satelliteid;
    }
    
    @Column(name="SENSORID", length=45)

    public String getSensorid() {
        return this.sensorid;
    }
    
    public void setSensorid(String sensorid) {
        this.sensorid = sensorid;
    }
    
    @Column(name="ORBITID", length=100)

    public String getOrbitid() {
        return this.orbitid;
    }
    
    public void setOrbitid(String orbitid) {
        this.orbitid = orbitid;
    }
    
    @Column(name="PLEVEL", length=45)

    public String getPlevel() {
        return this.plevel;
    }
    
    public void setPlevel(String plevel) {
        this.plevel = plevel;
    }
    
    @Column(name="BEGINTIME", length=45)

    public String getBegintime() {
        return this.begintime;
    }
    
    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }
    
    @Column(name="ENDTIME", length=45)

    public String getEndtime() {
        return this.endtime;
    }
    
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
    
    @Column(name="STATUS", length=45)

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Column(name="TASKNUM", length=45)

    public String getTasknum() {
        return this.tasknum;
    }
    
    public void setTasknum(String tasknum) {
        this.tasknum = tasknum;
    }
    
    @Column(name="PAUSEFLAG", length=45)

    public String getPauseflag() {
        return this.pauseflag;
    }
    
    public void setPauseflag(String pauseflag) {
        this.pauseflag = pauseflag;
    }
    
    @Column(name="PAUSEITEM", length=45)

    public String getPauseitem() {
        return this.pauseitem;
    }
    
    public void setPauseitem(String pauseitem) {
        this.pauseitem = pauseitem;
    }
    
    public void setProcess(byte[] process) {
		this.process = process;
	}
    @Column(name="PROCESS")
	public byte[] getProcess() {
		return process;
	}

	@Column(name="PRCESSBEAN")

    public byte[] getPrcessbean() {
        return this.prcessbean;
    }
    
    public void setPrcessbean(byte[] prcessbean) {
        this.prcessbean = prcessbean;
    }
    
    @Column(name="PROCESSPARAMETER")

    public byte[] getProcessparameter() {
        return this.processparameter;
    }
    
    public void setProcessparameter(byte[] processparameter) {
        this.processparameter = processparameter;
    }
    
    @Column(name="PROCESSREPORT")

    public byte[] getProcessreport() {
        return this.processreport;
    }
    
    public void setProcessreport(byte[] processreport) {
        this.processreport = processreport;
    }
    
    @Column(name="VARVAL1", length=45)

    public String getVarval1() {
        return this.varval1;
    }
    
    public void setVarval1(String varval1) {
        this.varval1 = varval1;
    }
    
    @Column(name="VARVAL2", length=45)

    public String getVarval2() {
        return this.varval2;
    }
    
    public void setVarval2(String varval2) {
        this.varval2 = varval2;
    }
    @Column(name = "LEVEL_", length = 45)
	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
}