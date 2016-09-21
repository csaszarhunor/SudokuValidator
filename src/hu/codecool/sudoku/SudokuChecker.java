package hu.codecool.sudoku;

import java.util.HashSet;
import java.util.Set;

public class SudokuChecker {
	
	private static boolean distinctValues(int[] arr){
	    Set<Integer> foundNumbers = new HashSet<Integer>();
	    for (int num : arr) {
	        if(foundNumbers.contains(num)){
	            return false;
	        }
	        foundNumbers.add(num);
	    }              
	    return true;          
	}
	
	private static boolean areColumnsValid(int[][] table){
		int[][] temp = new int[table.length][table[0].length];
		for(int i = 0; i < table.length; i++){
			for (int j = 0; j < temp[i].length; j++) {
				temp[j][i] = table[i][j];
			}
		}
		
		for (int i = 0; i < temp.length; i++) {
			distinctValues(temp[i]);
		}
		return true;
	}
	
	public static boolean isValid(int[][] table){
		for (int i = 0; i < table.length; i++) {
			if(!distinctValues(table[i])) return false;
		}
		
		areColumnsValid(table);
		
		return true;
	}
	
	public static void main(String[] args) {

		int[][] gameField = new int[][] {
	        { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, 
	        { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, 
	        { 1, 9, 8, 3, 4, 2, 5, 6, 7 }, 
	        { 8, 5, 9, 7, 6, 1, 4, 2, 3 }, 
	        { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
	        { 7, 1, 3, 9, 2, 4, 8, 5, 6 }, 
	        { 9, 6, 1, 5, 3, 7, 2, 8, 4 }, 
	        { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, 
	        { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
	        
//	        SudokuChecker.check(gameField);
	        System.out.println(SudokuChecker.isValid(gameField));
		
	}

}
