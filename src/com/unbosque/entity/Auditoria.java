package com.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the auditoria database table.
 * 
 */
@Entity
@NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a")
public class Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, length = 5)
	private int id;
	@Column(name = "userId", nullable = false, length = 8)
	private String userId;
	@Column(name = "operationCrud", nullable = false, length = 20)
	private String operationCrud;
	@Column(name = "tableName", nullable = false, length = 30)
	private String tableName;
	@Column(name = "tableId", nullable = false, length = 20)
	private int tableId;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate", nullable = false)
	private Date createDate;
	@Column(name = "addressIP", nullable = false, length = 70)
	private String addressIP;

	public Auditoria() {
	}

	public Auditoria(int id, String userId, String operationCrud, String tableName, int tableId, Date createDate,
			String addressIP) {
		super();
		this.id = id;
		this.userId = userId;
		this.operationCrud = operationCrud;
		this.tableName = tableName;
		this.tableId = tableId;
		this.createDate = createDate;
		this.addressIP = addressIP;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOperationCrud() {
		return operationCrud;
	}

	public void setOperationCrud(String operationCrud) {
		this.operationCrud = operationCrud;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getAddressIP() {
		return addressIP;
	}

	public void setAddressIP(String addressIP) {
		this.addressIP = addressIP;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}