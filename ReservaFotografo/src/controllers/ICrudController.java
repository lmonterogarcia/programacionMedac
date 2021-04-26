package controllers;

public interface ICrudController<T> {

	public boolean add(T oObject);

	public boolean remove(T oObject);

	public boolean update(T oObject);

	public T searchByPk(T oObject);
    
}
