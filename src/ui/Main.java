package ui;

import java.util.Scanner;

import model.Graph;

public class Main {

	public static Scanner LECTOR;
	private static Graph<Integer> graph;
	
	public static void main(String[] args) {
		LECTOR = new Scanner(System.in);
		
		System.out.println("***************************");
	    System.out.println("*      SEGUIMIENTO 16	  *");
	    System.out.println("*                         *");	
        System.out.println("*           PRIM          *");
	    System.out.println("***************************");
	    System.out.println("");
		
		
		System.out.println("Write the number of vertices (AS INTEGER)");
		int numV = LECTOR.nextInt();
		
		graph = new Graph<>(numV);
		
		for(int m = 0; m < numV; m++) {
			System.out.println("Write the vertex #" + (m+1));
			int v = LECTOR.nextInt();
			graph.addVertex(v);
		}
		
		int continueOption = 0;
		System.out.println("");
		System.out.println("---------------------");
		System.out.println("  Vertex Connection  ");
		System.out.println("---------------------\n");

		
		do {
			System.out.println("Write the FIRST vertex");
			int v1 = LECTOR.nextInt();
			
			System.out.println("Write the SECOND vertex");
			int v2 = LECTOR.nextInt();
			
			System.out.println("Write the weight between (" + v1 + " & " + v2 + ")");
			int weight = LECTOR.nextInt();
			
			graph.add(v1, v2, weight);
			
			System.out.println("");
			System.out.println("Do you want to keep connecting");
			System.out.println(" [1] Yes");
			System.out.println(" [2] No");
			continueOption = LECTOR.nextInt();
			LECTOR.nextLine();
			
		} while (continueOption != 2);		
		
		System.out.println(graph.prim(graph.weightMatrix));
	}
}
