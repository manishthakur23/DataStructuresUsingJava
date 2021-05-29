package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import Graph.Graph.GraphType;

public class TropologicalSort {
	
	public List<Integer> sort(Graph graph) throws Exception{
		
		HashMap<Integer, Integer> indegreeMap = new HashMap<Integer, Integer>();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 0 ; i < graph.getNumberVertix(); i++) {
			int indegree = 0;
			indegree = graph.getIndegree(i);
			indegreeMap.put(i, indegree);
			if(indegree == 0) {
				queue.add(i);				
			}			
		}
		
		List<Integer> sortedList = new ArrayList<>();
		while(!queue.isEmpty()) {
			int v = queue.pollLast();
			sortedList.add(v);
			List<Integer> adjacentVertixList = graph.getAdjacentVertices(v);
			for (Integer adjacentVertix : adjacentVertixList) {
				int updatedIndegree = indegreeMap.get(adjacentVertix) - 1;
				indegreeMap.remove(adjacentVertix);
				indegreeMap.put(adjacentVertix, updatedIndegree);
				
				if(updatedIndegree == 0) {
					queue.add(adjacentVertix);
				}
			}
			
		}
		if(sortedList.size() != graph.getNumberVertix()) {
			throw new Exception("The graph is cyclic");
		}
		
		return sortedList;
	}

	public static void main(String[] args) throws Exception {
		
		AdjacentMatrixGraph adjMatrix = new AdjacentMatrixGraph(5, GraphType.DIRECTED);
		adjMatrix.addEdge(0, 1);
		adjMatrix.addEdge(0, 3);
		adjMatrix.addEdge(1, 2);
		adjMatrix.addEdge(1, 4);		
		adjMatrix.addEdge(3, 4);
		adjMatrix.addEdge(4, 2);
		
		// TODO Auto-generated method stub
		
		TropologicalSort tpsort = new TropologicalSort();
		List<Integer> sortedList = tpsort.sort(adjMatrix);
		
		for (Integer vertix : sortedList) {
			System.err.print(vertix+",");
			
		}
				

	}

}
