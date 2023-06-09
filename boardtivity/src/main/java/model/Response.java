package model;
import java.util.List;

public class Response {
    private int size;
    private int limit;
    private int total;
    private List<Item> data;
    private Links links;
    private String cursor;
    private String type;
    
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Item> getData() {
		return data;
	}
	public void setData(List<Item> data) {
		this.data = data;
	}
	public Links getLinks() {
		return links;
	}
	public void setLinks(Links links) {
		this.links = links;
	}
	public String getCursor() {
		return cursor;
	}
	public void setCursor(String cursor) {
		this.cursor = cursor;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

    
}
