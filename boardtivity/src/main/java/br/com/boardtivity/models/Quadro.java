package br.com.boardtivity.models;

 public class Quadro {
	
	private String token;
    private String idBoard;
    
	public Quadro(String token, String idBoard) {
		super();
		this.token = token;
		this.idBoard = idBoard;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getIdBoard() {
		return idBoard;
	}
	public void setIdBoard(String idBoard) {
		this.idBoard = idBoard;
	}
	
    
}
