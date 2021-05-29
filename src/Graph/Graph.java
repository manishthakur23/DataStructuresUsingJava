package Graph;

import java.util.List;

public interface Graph {
	
	enum GraphType{
		DIRECTED,
		UNDIRECTED		
	}
	
	public void addEdge(int v1, int v2) throws Exception;
	
	public List<Integer> getAdjacentVertices(int v) throws Exception; 
	
	public int getNumberVertix();
	public int getIndegree(int v) throws Exception;

}
