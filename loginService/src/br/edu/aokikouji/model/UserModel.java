package br.edu.aokikouji.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name="loginservice")
@Table(name="tb_loginservice")
public class UserModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 25930685961478501L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_login")
	@NotNull
	private Integer id_login;
	
	@NotNull
	@Column(name="username")
	private String userName;
	
	@NotNull
	@Column(name="password")
	private String password;

	public UserModel(){
		
	}
	
	public UserModel(String username, String password){
		this.userName = username;
		this.password = password;
	}
	
	public Integer getId_login() {
		return id_login;
	}

	public void setId_login(Integer id_login) {
		this.id_login = id_login;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
