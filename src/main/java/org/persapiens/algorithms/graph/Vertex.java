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

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author marcelo
 */
@Getter
@Setter
@ToString(of = {"label", "color", "d", "f"})
@Builder
public class Vertex {
	private VertexColor color;
	
	private String label;
	
	private int d;
	
	private int f;
	
	private Vertex parent;
	
	public static final Vertex NIL = Vertex.builder().build();
}
