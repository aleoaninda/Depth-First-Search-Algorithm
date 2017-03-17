import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Graph {
	int[][] graph;
	int vertices;
	int edges;
	
	public Graph(String filename){
		try {
			fileInput(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileInput(String filename) throws IOException{
		BufferedReader bReader = new BufferedReader(new FileReader(new File(filename)));
		String line = bReader.readLine();
		String[] graphParams = line.split(" ");
		vertices = Integer.parseInt(graphParams[0]);
		edges = Integer.parseInt(graphParams[1]);
		initializeGraphInstance(vertices);
		for(line = bReader.readLine(); line != null; line = bReader.readLine()){
			String[] stArray = line.split(" ");
			insert(stArray);
		}
	}
	
	public void insert(String[] stArray){
		initializeSingleNode(stArray[0]);
		for(int i=1; i<stArray.length; i++){
			insertIntoNode(stArray[0], stArray[i]);
		}
	}
	
	public void printGraph(){
		for(int i=0; i<graph.length; i++){
			printNodeChildren(i);
		}
	}

	
	//************************************************
	
	//Module for Array
	//
	public void initializeGraphInstance(int vertices){
		graph = new int[vertices][vertices];
	}
	
	public void initializeSingleNode(String vertex){
	}
	
	public void insertIntoNode(String parent, String child){
		int p = Integer.parseInt(parent);
		int c = Integer.parseInt(child);
		graph[p][c]=1;
	}
	
	public void printNodeChildren(int num){
		System.out.print("Vertex no "+num+" -> ");
		for(int i=0; i<vertices; i++)
			System.out.print(graph[num][i]);
		System.out.println();
	}
	
	public int[] adjacentNodes(int r){
		int row[] = new int[vertices];
		for(int i=0; i<vertices; i++)
			row[i]=graph[r][i];
		return row;
	}
	//*************************************************
}
