import java.util.*;
import java.io.*;
 
 class a{
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
			 adj[v].add(u);
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
		void DFS(int s){
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
	 }
	 
	 public static void main(String lol[]){
		Scanner in = new Scanner(System.in);
		graph g = new graph(8);
		g.addEdge(0,1); 
		g.addEdge(0,5);
		g.addEdge(5,4);
		g.addEdge(5,6);
		g.addEdge(0,7);
		g.addEdge(7,6);
		g.addEdge(1,2);
		g.addEdge(2,3);
		
		g.BFS(5);
		
		g.DFS(5);
	 }
 }