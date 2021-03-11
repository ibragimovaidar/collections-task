package tasks.first;

import java.util.ArrayList;

public class Graph {
	private ArrayList<Elem> elems = new ArrayList<>();;

	public Graph(boolean[][] matrix){
		for (int i = 0; i < matrix.length; i++) {
			elems.add(new Elem(i));
		}


		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j])
					elems.get(i).addElem(elems.get(j));
			}
		}
	}

	public ArrayList<Elem> getElems(){
		return elems;
	}

}
