package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph<T> {
	
	/*
	 * LINK DE APOYO: https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
	 */
	
	
	// Number of vertices in the graph
	public static int V = 0;
	public int[][] weightMatrix;
	public HashMap<T, ArrayList<T>> vertices;
	public ArrayList<T> weights = new ArrayList<>();
	
	public Graph(int numVert) {
		V = numVert;
		weightMatrix = new int[V][V];
    	costMatrixweight();
    	vertices = new HashMap<>();
	}
	
	
	public void add(T v1, T v2, int weight) {
		int i = 0;
		int j=0;
		
		for(T v: weights) {
			if(v.equals(v1)) {
				break;
			}
			i++;
		}
		
		for(T v: weights) {
			if(v.equals(v2)) {
				break; 
			}
			j++;
		}
		weightMatrix[i][j] = weight;
		weightMatrix[j][i] = weight;
	}

	
	 public void addVertex(T data) {
         vertices.put(data, new ArrayList<>());
         weights.add(data);
     }
	
	
	 public void costMatrixweight() {
     	for(int i=0;i<weightMatrix.length;i++) {
     		for(int j=0;j<weightMatrix[0].length;j++) {
     			if(i==j) {
     				weightMatrix[i][j] = 0;
     			}else {
     				weightMatrix[i][j]=Integer.MAX_VALUE;
     			}
     		}
     	}
     }
	
	
	public String prim(int graph[][]) {
		// Array to store constructed MST
		int parent[] = new int[V];

		// Key values used to pick minimum weight edge in cut
		int key[] = new int[V];

		// To represent set of vertices included in MST
		Boolean mstSet[] = new Boolean[V];

		// Initialize all keys as INFINITE
		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		key[0] = 0; // Make key 0 so that this vertex is picked as first vertex
		
		parent[0] = -1; // First node is always root of MST

		// The MST will have V vertices
		for (int count = 0; count < V - 1; count++) {
			
			// Pick the minimum key vertex from the set of vertices / not yet included in MST
			int u = minKey(key, mstSet);

			// Add the picked vertex to the MST Set
			mstSet[u] = true;

			// Update key value and parent index of the adjacent
			// vertices of the picked vertex. Consider only those
			// vertices which are not yet included in MST
			for (int v = 0; v < V; v++)

				// graph[u][v] is non zero only for adjacent vertices of m
				// mstSet[v] is false for vertices not yet included in MST
				// Update the key only if graph[u][v] is smaller than key[v]
				if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
		}

		return print(parent, graph);
	}
	
	public int minKey(int key[], Boolean mstSet[]) {
	
		int min = Integer.MAX_VALUE;
		int min_index = -1;

		for (int v = 0; v < V; v++)
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}

		return min_index;
	}
	
	
	// A utility function to print the constructed MST stored in
	// parent[]
	public String print(int parent[], int graph[][]){
		
		String info = "";
		int totalCost = 0;
		
		info = "Edge \tWeight\n";
		for (int i = 1; i < V; i++) {
			info += (parent[i]+1) + " - " + (i+1) + "\t" + graph[i][parent[i]] + "\n";
			totalCost += graph[i][parent[i]];
		}
			
		info += "OVERALL WEIGHT: " + totalCost;
		
		return info;
	}


}
