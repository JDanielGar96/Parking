package com.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the auditoria database table.
 * 
 */
@Entity
@NamedQuery(name="Auditoria.findAll", query="SELECT a FROM Auditoria a")
public class Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String addressIP;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private String operationCrud;

	private int tableId;

	private String tableName;

	private String userId;

	public Auditoria() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressIP() {
		return this.addressIP;
	}

	public void setAddressIP(String addressIP) {
		this.addressIP = addressIP;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getOperationCrud() {
		return this.operationCrud;
	}

	public void setOperationCrud(String operationCrud) {
		this.operationCrud = operationCrud;
	}

	public int getTableId() {
		return this.tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}