/*
 * Copyright 2017 JoinFaces.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.persapiens.algorithms.graph;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author marcelo
 */
@Getter
@Setter
public class Graph {

	private List<VertexAndAdjacencyList> vertexesAndAdjacencyList = new ArrayList<>();

	public void add(Vertex vertex, Vertex[] adjacencyList) {
		vertexesAndAdjacencyList.add(VertexAndAdjacencyList.builder()
			.vertex(vertex)
			.adjacencyList(adjacencyList)
			.build());
	}
	
	public Vertex[] getVertexes() {
		Vertex[] result = new Vertex[vertexesAndAdjacencyList.size()];
		for (int index = 0; index < vertexesAndAdjacencyList.size(); index++) {
			result[index] = vertexesAndAdjacencyList.get(index).getVertex();
		}
		return result;
	}
	
	public Vertex[] getAdjacencyList(Vertex u) {
		return getAdjacencyList(indexOf(u));
	}
	
	public Vertex[] getAdjacencyList(int index) {
		Vertex[] result = null;
		if (index != -1) {
			result = vertexesAndAdjacencyList.get(index).getAdjacencyList();
		}
		return result;
	}

	private int indexOf(Vertex u) {
		int result = -1;
		for (int index = 0; index < vertexesAndAdjacencyList.size(); index++) {
			if (vertexesAndAdjacencyList.get(index).getVertex().equals(u)) {
				result = index;
			}
		}
		return result;
	}
}
