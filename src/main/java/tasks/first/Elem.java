package tasks.first;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class Elem {
	Integer id;
	HashSet<Elem> elems = new HashSet<>();

	public Elem(Integer id){
		this.id = id;
	}

	public Elem(Integer id, Collection<Elem> elems){
		this.id = id;
		this.elems = new HashSet<>(elems);
	}

	public void addElem(Elem elem){
		elems.add(elem);
	}

	public Integer getId() {
		return id;
	}

	public HashSet<Elem> getElems() {
		return elems;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Elem elem = (Elem) o;
		return Objects.equals(id, elem.id) &&
				Objects.equals(elems, elem.elems);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}
