package Graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Queue;



public class AdjacentMatrixGraph implements Graph{

	int [][] adjacentMatrix;
	int numVertices = 0;
	GraphType graphType = GraphType.DIRECTED;
	
	public AdjacentMatrixGraph(int numVertices,GraphType graphType ) {
		// TODO Auto-generated constructor stub
		this.graphType = graphType;
		this.numVertices = numVertices;
		adjacentMatrix = new int[numVertices][numVertices];
		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				adjacentMatrix[i][j] = 0;
			}			
		}
	}

	@Override
	public void addEdge(int v1, int v2) throws Exception {
		// TODO Auto-generated method stub
		if(v1>= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0) {
			throw new Exception("Invalid vertices");
		}		
		adjacentMatrix[v1][v2] = 1;
		if(graphType == GraphType.UNDIRECTED) {
			adjacentMatrix[v2][v1] = 1;
		}
	}

	@Override
	public List<Integer> getAdjacentVertices(int v) throws Exception {
		// TODO Auto-generated method stub
		if(v>=numVertices || v < 0) {
			throw new Exception("Invalid Vertices");
			}
		List<Integer> adjacentVertices = new ArrayList<Integer>(); 
		for (int i = 0; i < numVertices; i++) {
			if(adjacentMatrix[v][i] == 1) {
				
				adjacentVertices.add(i);
			}
		}
		
		Collections.sort(adjacentVertices);
		return adjacentVertices;
	}
	
	public static void depthFirstTraverse(Graph graph, int [] visited , int currentVertice) throws Exception {
		if(visited[currentVertice] == 1) {
			return;
		}
		
		visited[currentVertice] = 1;
		List<Integer> adjacentList = graph.getAdjacentVertices(currentVertice);
		for (int vertice : adjacentList) {
			depthFirstTraverse(graph, visited, vertice);
			
		}
		System.out.println(currentVertice+"->");
	}
	
	public static void breadthFirstTraversal( Graph graph, int [] visited , int currentVertex) {
		
		
		
	}
	@Override
	public int getIndegree(int v)throws Exception {
		int indegree = 0;
		if(v <0 || v>numVertices) {
			throw new IllegalArgumentException("Invalid Vertix");
		}
		
		for(int i = 0; i < numVertices; i ++) {
			if(adjacentMatrix[i][v] != 0) {
				indegree++;
			}
		}
		return indegree;
	}
	
	@Override
	public int getNumberVertix() {
		return numVertices;
	}
	
	// 0-->1-->2
	// |   |
	// v   v	
	// 3-->4
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AdjacentMatrixGraph adjMatrix = new AdjacentMatrixGraph(5, GraphType.DIRECTED);
		adjMatrix.addEdge(0, 1);
		adjMatrix.addEdge(0, 3);
		adjMatrix.addEdge(1, 2);
		adjMatrix.addEdge(1, 4);
		
		adjMatrix.addEdge(3, 4);
		
		
		System.out.println(" Adjacent vertices of 1 :: "+adjMatrix.getAdjacentVertices(0));
		
		System.out.println("Depth First traversal");
		int [] visited = new int[10];
		depthFirstTraverse(adjMatrix, visited, 0);

	}

}
