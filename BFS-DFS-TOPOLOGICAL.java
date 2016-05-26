import java.util.*;
import java.io.*;
import java.math.BigInteger; 
class BFS-DFS-TOPOLOGICAL{
	static class graph{
		 int vertex;
		 LinkedList<Integer> adj[];
		 boolean visited[];
		 int count=0;
		 public graph(int v){
			 vertex = v;
			 adj = new LinkedList[v];
			 for(int i=0;i<v;i++){
				 adj[i] = new LinkedList();
			 }
			 visited = new boolean[vertex];
		 }
		 void addEdge(int u,int v){
			 adj[u].add(v);
			 //adj[v].add(u);
		 }
		
		 void BFS(int s){
			  
			 Queue <Integer >q = new LinkedList<>();
			 q.offer(s);
			 visited[s]=true;
			 while(!q.isEmpty()){
				 s = q.poll();
				 System.out.print(s+" ");
				 Iterator <Integer> i = adj[s].listIterator();
				 while(i.hasNext()){
					 int n = i.next();
					 if(visited[n]==false){
						 visited[n] = true;
						 q.offer(n);
					 }
					 //else{return 0;}
				 }
			 }
			
		}
		void display(){
			for(int i=0;i<vertex;i++){
				System.out.println(adj[i]);
			}
		}
		void DFSS(int s){
			boolean visited[] = new boolean[vertex];
			Stack<Integer> stack = new Stack<Integer>();
			visited[s]= true;
			stack.push(s);
			while(!stack.isEmpty()){
				s = stack.pop();
				System.out.print(s+" ");
				Iterator<Integer> i = adj[s].listIterator();
				while(i.hasNext()){
					int n = i.next();
					if(!visited[n]){
						visited[n]  = true;
						stack.push(n);
					}
				}
			}
		}
		 void DFSUtil(int v,boolean visited[]){
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");
 
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
 
    // The function to do DFS traversal. It uses recursive DFSUtil()
		void DFS(int v){
        // Mark all the vertices as not visited(set as
        // false by default in java)
			boolean visited[] = new boolean[vertex];
		        // Call the recursive helper function to print DFS traversal
			DFSUtil(v, visited);
		}
		
		void toposort(){
			boolean visited[] = new boolean[vertex];
			Stack st = new Stack();
			for(int i=0;i<vertex;i++){
				visited[i] = false;
			}
			for(int i=0;i<vertex;i++){
				if(!visited[i]){
					topoUTIL(i,visited,st);
				}
			}
			System.out.println("topooooo-----");
			while(!st.isEmpty()){
				System.out.println( st.pop()+" - ");
			}
		}
		void topoUTIL(int s,boolean[] visited, Stack st){
			visited[s] = true;
			int n;
			Iterator<Integer> i = adj[s].listIterator();
			while(i.hasNext()){
				n = i.next();
				if(!visited[n]){
					topoUTIL(n,visited,st);
				}
			}
			st.push(s);
		}
	 }
	 
	 
	 public static void main(String lol[]){
		Scanner in = new Scanner(System.in);
		graph g = new graph(6);
		g.addEdge(5,0); 
		g.addEdge(5,2); 
		g.addEdge(4,0);
		g.addEdge(4,1); 		
		g.addEdge(2,3); 
		g.addEdge(3,1); 
		g.display();
		System.out.println(" ");
		g.BFS(5);
		System.out.println(" ");
		g.DFS(5);
		
		g.toposort();
	 }
 }