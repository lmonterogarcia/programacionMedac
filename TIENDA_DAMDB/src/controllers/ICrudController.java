package controllers;

import java.util.List;
import java.sql.*;

public interface ICrudController<T> {
	public List<T> getLista();

	public void setLista(List<T> lLista);

	public boolean add(T oObject, Connection oConnection);

	public boolean remove(T oObject, Connection oConnection);

	public boolean update(T oObject, Connection oConnection);

	public List<T> readAll();

	public T searchByPk(T oObject, Connection oConnection);
}
