package pe.edu.upeu.general;

import java.util.List;

public interface Generic<T> {
	int create(T t);
	int update(T t);
	int delete(int id);
	T read(int id);
	List<T> readAll();
}
