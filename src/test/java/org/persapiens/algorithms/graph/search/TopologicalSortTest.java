package org.persapiens.algorithms.graph.search;

import org.persapiens.algorithms.graph.ListGraph;
import org.persapiens.algorithms.graph.Vertex;
import org.persapiens.algorithms.graph.VertexColor;
import static org.assertj.core.api.Assertions.assertThat;
import static org.persapiens.algorithms.graph.Vertex.NIL;
import static org.persapiens.algorithms.graph.VertexColor.BLACK;
import org.persapiens.algorithms.list.DoubleLinkedList;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class TopologicalSortTest {
	public void page613 () {
		DepthFirstSearch depthFirstSearch = new DepthFirstSearch();

		ListGraph graph = new ListGraph();
		
		Vertex undershorts = Vertex.builder().label("undershorts").build();
		Vertex pants = Vertex.builder().label("pants").build();
		Vertex belt = Vertex.builder().label("belt").build();
		Vertex shirt = Vertex.builder().label("shirt").build();
		Vertex tie = Vertex.builder().label("tie").build();
		Vertex jacket = Vertex.builder().label("jacket").build();
		Vertex socks = Vertex.builder().label("socks").build();
		Vertex shoes = Vertex.builder().label("shoes").build();
		Vertex watch = Vertex.builder().label("watch").build();
		graph.add(shirt, GraphUtil.edges(shirt,tie, belt));
		graph.add(tie, GraphUtil.edges(tie,jacket));
		graph.add(jacket, GraphUtil.edges(jacket));
		graph.add(belt, GraphUtil.edges(belt,jacket));
		graph.add(watch, GraphUtil.edges(watch));
		graph.add(undershorts, GraphUtil.edges(undershorts,pants, shoes));
		graph.add(pants, GraphUtil.edges(pants,belt, shoes));
		graph.add(shoes, GraphUtil.edges(shoes));
		graph.add(socks, GraphUtil.edges(socks,shoes));
		
		TopologicalSort topologicalSort = new TopologicalSort();
		depthFirstSearch.addListener(topologicalSort);
		
		depthFirstSearch.search(graph);

		checkVertex(socks, BLACK, 17, 18, NIL);
		checkVertex(undershorts, BLACK, 11, 16, NIL);
		checkVertex(pants, BLACK, 12, 15, undershorts);
		checkVertex(shoes, BLACK, 13, 14, pants);
		checkVertex(watch, BLACK, 9, 10, NIL);
		checkVertex(shirt, BLACK, 1, 8, NIL);
		checkVertex(belt, BLACK, 6, 7, shirt);
		checkVertex(tie, BLACK, 2, 5, shirt);
		checkVertex(jacket, BLACK, 3, 4, tie);
		
		DoubleLinkedList<Vertex> list = topologicalSort.getList();
		assertThat(list.getHead().getKey())
			.isEqualTo(socks);
		list.delete(socks);
		assertThat(list.getHead().getKey())
			.isEqualTo(undershorts);
		list.delete(undershorts);
		assertThat(list.getHead().getKey())
			.isEqualTo(pants);
		list.delete(pants);
		assertThat(list.getHead().getKey())
			.isEqualTo(shoes);
		list.delete(shoes);
		assertThat(list.getHead().getKey())
			.isEqualTo(watch);
		list.delete(watch);
		assertThat(list.getHead().getKey())
			.isEqualTo(shirt);
		list.delete(shirt);
		assertThat(list.getHead().getKey())
			.isEqualTo(belt);
		list.delete(belt);
		assertThat(list.getHead().getKey())
			.isEqualTo(tie);
		list.delete(tie);
		assertThat(list.getHead().getKey())
			.isEqualTo(jacket);
		list.delete(jacket);
		assertThat(list.isEmpty())
			.isTrue();
	}
	
	private void checkVertex(Vertex v, VertexColor color, int d, int f, Vertex parent) {
		assertThat(v.getColor())
			.isEqualTo(color);		
		assertThat(v.getD())
			.isEqualTo(d);		
		assertThat(v.getF())
			.isEqualTo(f);		
		assertThat(v.getParent())
			.isEqualTo(parent);		
	}
}
