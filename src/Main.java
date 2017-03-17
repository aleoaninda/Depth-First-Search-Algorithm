
public class Main {
	static String filename = "graph.txt";
	public static void main(String[] args) {
		Graph myGraph = new Graph(filename);
		myGraph.printGraph();
		DepthFirstSearch DFSObject = new DepthFirstSearch(myGraph);
		DFSObject.DFS(0);
	}

}
