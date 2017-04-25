package chapt4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Directed graph implementation. Adjacency list representation 
 * This is a personal implementation using hashmaps and hashsets. This is not just because
 * I love them... but also they are pretty handful, since nodes can be picked up fast from the
 * list of nodes and using the hashset for modeling the adjecent nodes also speeds up
 * the implementation process by managing any already existing edge. 
 * 
 * 
 * @author giulianacarullo
 *
 */
public class DGraph<G> {
	/* you would probably find the following code into a generic graph impl
	 * 
	protected class Node<G> {
		G el;
		
		ArrayList<Node<G>> aNodes = new ArrayList<>();
		
		protected void addAdjacentNode(Node<G> el) {
			aNodes.add(el);
		}
	}*/
	
	//Instance Variables
	HashMap<G, HashSet<G>> graph = new HashMap<>();
	
	/*
	 * Proper signaling of edge cases would be useful for real implementation
	 * (e.g., the node already exists) 
	 */
	public void addNode(G node) {
		if(!graph.containsKey(node)) {
			graph.put(node, new HashSet<>());
		}
		
	}
	
	/*
	 * Proper signaling of edge cases would be useful for real implementation
	 * (e.g., the node(s) does not exist) 
	 */
	public void addEdge(G from, G to) throws Exception {
		if(graph.containsKey(from) && graph.containsKey(to)) {
			HashSet<G> adj = graph.get(from);
			adj.add(to);
		}
		else
			throw new Exception("uops, you gave me nodes that do not exist");
	}
	
	public HashSet getAdjacent(G node) throws Exception {
		if(graph.containsKey(node)) {
			HashSet<G> adj = graph.get(node);
			return adj;
		}
		else
			throw new Exception("uops, you gave me a node that does not exist");
	}
	
	public boolean areAdjacent(G from, G to) throws Exception {
		if(graph.containsKey(from) && graph.containsKey(to)) {
			HashSet<G> adj = graph.get(from);
			for(G el: adj) 
				if(el.equals(to))
					return true;
			return false;
		}
		else
			throw new Exception("uops, you gave me nodes that do not exist");
	}
	
	public Set<G> getNodes() {
		return graph.keySet();
	}
	
	
}
