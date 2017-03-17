public class DepthFirstSearch {
	Graph g;
	int[] color; //0=unvisited, 1=visited and enqueued, 2=visited and dequeued
	int[] parent; //source node to be set at vertice+1
	int[] distance; //all initially 0
	static int time=0;
	int[] startTime;
	int[] finishTime;
	
	int sourceV;

	public DepthFirstSearch(Graph gr){
		g=gr;
		initializeVars();
	}
	
	public void initializeVars(){
		color= new int[g.vertices];
		parent= new int[g.vertices];
		distance= new int[g.vertices];
		startTime = new int[g.vertices];
		finishTime = new int[g.vertices];
	}
	
	public void DFS(int source){
		sourceV= source;
		setParent(source, g.vertices+1);
		for(int i=source; i<g.vertices;i++){
			if(hasNotBeenVisited(i)){	//if vertex has not been visited
				DFSVisit(i);
			}
			else if(i==sourceV){	//if source vertex is reached again
				break;	//end of graph traversal
			}
			if(i==g.vertices){	//if the iteration index reaches end of array length
				i=-1;	//on next iteration, it will increment to 0
			}
		}
	}
	
	public void DFSVisit(int currentNode){
		color[currentNode]=1;	//visited but unprocessed
		time++;
		startTime[currentNode]=time;
		int[] adjNodes = g.adjacentNodes(currentNode);
		for(int i=0; i<adjNodes.length; i++){	//for all adjacent nodes of 'vertex'
			if(adjNodes[i]==1 && hasNotBeenVisited(i)){
				setParent(i, currentNode);
				DFSVisit(i);
			}
		}
		color[currentNode]=2;
		finishTime[currentNode]=time+1;
	}
	
	public void setParent(int node ,int p){
		parent[node]= p;
	}
	
	public boolean hasNotBeenVisited(int node){
		if(color[node]==0)
			return true;
		else
			return false;
	}
}
