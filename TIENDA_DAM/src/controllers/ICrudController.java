package controllers;

import java.util.List;

public interface ICrudController<T> {
	public List<T> getLista();
	public void setLista(List<T> lLista);
	public boolean add(T oObject);
	public boolean remove(T oObject);
	public boolean update(T oObject);
	public List<T> readAll();
	public int searchPosition(T oObject);	
}
