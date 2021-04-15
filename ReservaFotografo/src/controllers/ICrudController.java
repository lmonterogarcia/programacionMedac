package controllers;

import java.sql.*;

public interface ICrudController<T> {

	public boolean add(T oObject, Connection oConnection);

	public boolean remove(T oObject, Connection oConnection);

	public boolean update(T oObject, Connection oConnection);

	public T searchByPk(T oObject, Connection oConnection);
    
}
