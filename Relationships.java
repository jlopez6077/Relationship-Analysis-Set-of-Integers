package main;

import java.util.LinkedList;

public class Relationships {

	public static void main(String[] args) {
		int[] set = {1,2,3,4};
		int[][] r1 = {{1,1},{1,2},{2,1},{2,2},{3,4},{4,1},{4,4}};
		int[][] r2 = {{1,1},{1,2},{2,1}};
		int[][] r3 = {{1,1},{1,2},{1,4},{2,1},{2,2},{3,3},{4,1},{4,4}};
		int[][] r4 = {{2,1},{3,1},{3,2},{4,1},{4,2},{4,3}};
		int[][] r5 = {{1,1},{1,2},{1,3},{1,4},{2,2},{2,3},{2,4},{3,3},{3,4},{4,4}};
		int[][] r6 = {{3,4}};
		
		int[][] R = {{1,1},{2,2},{2,3},{3,2},{3,3},{4,4},{4,1}};
		int[][] S = {{1,1},{1,2},{2,1},{2,2},{3,3},{4,4}};
		
		int[][] temp = R;
		
		System.out.println("R\n");
		System.out.println(reflexive(temp,set)+"\n");
		System.out.println(symmetric(temp)+"\n");
		System.out.println(transitive(temp)+"\n");
	}
	
	public static boolean transitive(int[][] a) {
		int n = a.length;
		System.out.print("(x,y) | (y,z) | (x,z)\n----------------------\n");
		
		for(int i = 0; i < n; i++) {
			int x,y,z = 0;
			LinkedList<Integer> list = new LinkedList<Integer>(); 
			boolean contains = false;
			
			x = a[i][0];
			y = a[i][1];
			System.out.print("("+x+","+y+")   ");
			
			//find all elements where y = x
			for(int j = 0; j < n; j++) {
				if(a[j][0] == y && j!=i)
					list.add(j);
			}
			while(!list.isEmpty()) {
				contains = false;
				z = a[list.remove()][1];
				System.out.print("("+y+","+z+")   ");
				for(int k = 0; k < n; k++) {
					if(a[k][0] == x && a[k][1] == z) {
						contains = true;
						System.out.print("("+x+","+z+")   ");
						break;
					}
				}
				if(!contains) {
					System.out.print("STOP\nTransitive ");
					return false;
				}
				if(!list.isEmpty())
					System.out.print("\n("+x+","+y+")   ");
			}
			System.out.println("\n----------------------");
		}
		System.out.print("Transitive ");
		return true;
	}
	
	public static boolean symmetric(int[][] a) {
		int n = a.length;
		System.out.println("V (a,b)ER, (b,a)ER");
		for(int i = 0; i < n; i++) {
			int x,y;
			boolean sym = false;
			
			x = a[i][0];
			y = a[i][1];
			
			for(int j = 0; j < n; j++) {
				if(a[j][0] == y && a[j][1] == x) {
					sym = true;
					System.out.println("("+a[i][0]+","+a[i][1]+")ER    ("+a[i][1]+","+a[i][0]+")ER true");
					break;
				}		
			}
			if(!sym) {
				System.out.print("("+a[i][0]+","+a[i][1]+")ER    ("+a[i][1]+","+a[i][0]+")ER X\nSymmetric ");
				return false;
			}
		}
		System.out.print("Symmetric ");
		return true;
	}
	
	public static boolean reflexive(int[][] a, int[] set) {
		int n = set.length;
		System.out.println("(a,a)ER for every aER");
		for(int i = 0; i < n; i++) {
			boolean reflex = false;
			for(int j = 0; j < a.length; j++) {
				if(a[j][0] == set[i] && a[j][1] == set[i]) {
					reflex = true;
					break;					
				}
			}
			if(!reflex) {
				System.out.print("("+set[i]+","+set[i]+")ER X\nReflexive ");
				return false;
			}
		}
		
		System.out.print("Reflexive ");
		return true;
	}
}
