package model;

import java.io.BufferedReader;
import java.io.FileReader;

public class Usuario {
	private String cod;
	private String password;
	private int contVisitas;
	
	//metodo constructor
	public Usuario(String cod, String password,int contVisitas){
		this.cod=cod;
		this.password=password;
		this.contVisitas=contVisitas;
	}

	//Getter and setter
	public String getCod() {
		return cod;
	}


	public void setCod(String cod) {
		this.cod = cod;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public void incContVisitas(){
		contVisitas=contVisitas+1;
	}
	
	public int getContVisitas(){
		return contVisitas;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getCod();
	}
}
