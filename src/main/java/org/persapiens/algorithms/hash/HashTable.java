package org.persapiens.algorithms.hash;

import org.persapiens.algorithms.list.DoubleLinkedList;

/**
 *
 * @author marcelo fernandes
 */
public class HashTable implements Table <Integer> {
	
	private HashMethod hashMethod;	
	
	private DoubleLinkedList<Integer>[] T;

	public HashTable(HashMethod hashMethod) {
		this.hashMethod = hashMethod;
		this.T = new DoubleLinkedList[this.hashMethod.getM()];
	}

	public int hash(int key) {
		return this.hashMethod.hash(key);
	}
	
	@Override
	public Integer search(int key) {
		Integer result = null;
		 
		// calcula o slot da chave
		DoubleLinkedList<Integer> list = T[hash(key)];
		
		if (list != null) {			
			// pesquisa o elemento dentro do slot implentado pela lista ligada
			result = list.search(key);
		}
		return result;
	}

	@Override
	public void insert(Integer element) {
		int hash = hash(element);
		DoubleLinkedList<Integer> list = T[hash];
		if (list == null) {
			list = new DoubleLinkedList<>();
			T[hash] = list;
		}
		list.insert(element);
	}

	@Override
	public void delete(Integer element) {
		int hash = hash(element);
		DoubleLinkedList<Integer> list = T[hash];
		if (list != null) {
			list.delete(list.search(element));
			if (list.isEmpty()) {
				T[hash] = null;
			}
		}
	}
	
}
