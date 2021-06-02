package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

import Graph.Graph.GraphType;

public class ShortestPathAlgorithm {
	
	public HashMap<Integer, DistanceInfo> buildDistanceTable( Graph graph , int source) throws Exception{
		HashMap<Integer, DistanceInfo> distanceMap =  new HashMap<Integer, DistanceInfo>();
		for(int i = 0 ; i<graph.getNumberVertix() ; i ++) {
			distanceMap.put(i, new DistanceInfo());
		}
		
		distanceMap.get(source).setDistance(0);
		distanceMap.get(source).setLastVertix(source);
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		
		while(!queue.isEmpty()) {
			int currentVertix = queue.pollLast();
			for(int i : graph.getAdjacentVertices(currentVertix)){
				int currentDistance = distanceMap.get(i).getDistance();
				if(currentDistance == -1) {
					currentDistance = 1 + distanceMap.get(currentVertix).getDistance();
					distanceMap.get(i).setDistance(currentDistance);
					distanceMap.get(i).setLastVertix(currentVertix);
				}
				
				if(!graph.getAdjacentVertices(i).isEmpty()) {
					queue.add(i);
				}				
			}
		}
		
		return distanceMap;
		
	}
	
	public void findShortestPath( Graph graph, int source, int destination) throws Exception {
		HashMap<Integer, DistanceInfo> distanceMap = buildDistanceTable(graph, source);
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(destination);
		int previousVertix =  distanceMap.get(destination).getLastVertix();
		
		while(previousVertix != -1 && previousVertix != source) {
			stack.push(previousVertix);
			previousVertix = distanceMap.get(previousVertix).getLastVertix();
		}
		
		if(previousVertix == -1) {
			System.out.println("No path present");
		}else {
			System.out.println("Shortest Path ::");
			System.out.print(source);
			while(!stack.isEmpty()) {
				System.out.print("-->"+stack.pop());
			}
		}		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		AdjacentMatrixGraph adjMatrix = new AdjacentMatrixGraph(5, GraphType.DIRECTED);
		adjMatrix.addEdge(0, 1);
		adjMatrix.addEdge(0, 3);
		adjMatrix.addEdge(1, 2);
		adjMatrix.addEdge(1, 4);		
		adjMatrix.addEdge(3, 4);
		
		int destination = 2;
		int source = 0;
		ShortestPathAlgorithm st = new ShortestPathAlgorithm();
		
		System.out.println("Shortest Path from "+source+" to "+destination+" ::");
		st.findShortestPath(adjMatrix, source, destination);

	}

}
