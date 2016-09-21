package hu.codecool.sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuChecker {

	public static boolean isTableValid(int[][] gameField){
		return areRowsValid(gameField) && areColumnsValid(gameField) && areBlocksValid(gameField);
	}
	
	private static boolean areRowsValid(int[][] gameField){
		for (int[] row : gameField) {
			if (containsDuplicates(row)) return false;
		}
		return true;
	}

	private static boolean areColumnsValid(int[][] gameField){
		int[][] rotated = rotateMatrix(gameField);
		return areRowsValid(rotated);
	}

	private static boolean areBlocksValid(int[][] gameField){
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int[] block = getBlock(gameField, j, i);
				if (containsDuplicates(block)) return false;
			}
		}
		return true;
	}

	private static boolean containsDuplicates(int[] arr){
		Integer[] a = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			a[i] = arr[i];
		}
	    Set<Integer> hashSet = new HashSet<Integer>(Arrays.asList(a));
	    return hashSet.size() != arr.length;
	}
	
	private static int[][] rotateMatrix(int[][] gameField){
		int[][] temp = new int[gameField.length][gameField[0].length];
		for(int i = 0; i < gameField.length; i++){
			for (int j = 0; j < temp[i].length; j++) {
				temp[j][i] = gameField[i][j];
			}
		}
		return temp;
	}
	
	private static int[] getBlock(int[][] gameField, int blockRowIndex, int blockColIndex){
		int[] result = new int[9];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				result[i * 3 +j] = gameField[blockRowIndex * 3 + i][blockColIndex * 3 +j];
			}
		}
		return result;
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
	        
	        System.out.println(SudokuChecker.isTableValid(gameField));
		
	}

}
