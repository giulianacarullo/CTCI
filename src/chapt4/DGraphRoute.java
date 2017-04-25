package chapt4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * Given a directed graph, design an algorithm to find out whether there 
 * is a route between two nodes.
 * 
 * @author giulianacarullo
 *
 */

public class DGraphRoute {
	
	
	public static void main(String[] args) throws Exception {
		DGraph<CustomNode<Integer>> graph = new DGraph<>();
		CustomNode one = new CustomNode(1, State.Unvisited);
		CustomNode two = new CustomNode(2, State.Unvisited);
		CustomNode three = new CustomNode(3, State.Unvisited);
		CustomNode four = new CustomNode(4, State.Unvisited);
		
		graph.addNode(one);
		graph.addNode(two);
		graph.addNode(three);
		graph.addNode(four);
		graph.addEdge(one, two);
		graph.addEdge(one, three);
		graph.addEdge(three, two);
		graph.addEdge(three, four);
		graph.addEdge(two, four);
		System.out.println("Route exist: " + isRoute(graph, one, four));
		//resetting visited status to unvisited. 
		resetVisit(graph);
				
		System.out.println("Route should not exist, false expected: " 
							+ isRoute(graph, two, three));
		
		CustomNode five = new CustomNode(5, State.Unvisited);
		CustomNode six = new CustomNode(6, State.Unvisited);
		graph.addNode(five);
		graph.addNode(six);
		graph.addEdge(two, five);
		graph.addEdge(five, six);
		
		//resetting visited status to unvisited. 
		resetVisit(graph);
		
		System.out.println("Route exist: " + isRoute(graph, one, six));
	}
	
	public static enum State{
		Visited, Unvisited;
	}
	
	public static class CustomNode<G> {
		G el;
		State state;
		protected CustomNode(G el, State state) {
			this.el = el;
			this.state = state;
		}
	}
	public static boolean isRoute(DGraph graph, CustomNode from, CustomNode to) throws Exception {
		LinkedList<CustomNode<Integer>> list = new LinkedList<>(graph.getAdjacent(from));
		from.state = State.Visited;
		while(!list.isEmpty()) {
			CustomNode<Integer> node = list.removeFirst();
			if(node.el.equals(to.el)) 
				return true;
			if(node.state == State.Unvisited) { //if the node has been not visited yet
				node.state = State.Visited;     //visiting it
				list.addAll(graph.getAdjacent(node)); //adding adjacent nodes to the list
			}
		}
		return false;
	}
	private static void resetVisit(DGraph graph) {
		Set nodes = graph.getNodes();
		Iterator it = nodes.iterator();
		while(it.hasNext()){ 
			CustomNode<Integer> e = (CustomNode<Integer>) it.next();
			e.state = State.Unvisited;
		}
		
	}

}
