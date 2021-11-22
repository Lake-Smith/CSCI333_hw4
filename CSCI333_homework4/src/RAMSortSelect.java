import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Lake Smith
 *
 */
public class RAMSortSelect {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int i = 0; i < 5; i++) {
			RAMSortSelect RM = new RAMSortSelect();
			System.out.println("Test " + (i + 1) + "\n");
			System.out.println("bellow is your random array:");
			//gets the random length of the array
			int randLength = (int)Math.floor(Math.random()*(20-10+1)+10);
			int A[] = new int[randLength];
			//fills the array with random but increasing numbers
			for(int j = 0; j < randLength; j++) {
				A[j] = (int)Math.floor(Math.random()*(10-0+1)+0);
			}
			System.out.println(Arrays.toString(A) + "\n");
			int[] B = new int[A.length];
			
			Scanner Obj = new Scanner(System.in);
			
			RM.countingSort(A, B , A.length);
			System.out.println("After Counting Sort  ");
			System.out.println(Arrays.toString(B) + "\n");

			
//==================================randomzedQuickselect========================================================
			
			int findIndex = -1;
			System.out.println("please enter an index bellow (must be between 0 and " + A.length + ")");
			
			while(findIndex > A.length-1 || findIndex < 0) {
				findIndex = Obj.nextInt();
				if(findIndex > A.length-1) {
					System.out.println("sorry the array is not long enouph to contain that index");
				}else if(findIndex < 0) {
					System.out.println("sorry the index cannot be smaller than 0");
				}
				
			}
			
			int num = RM.RQS(A, findIndex);
			System.out.println("The number is at index " + findIndex + " is "  + num + "\n");
		}
		
		System.out.println();

	}
	
	/**
	 * 
	 * @param A
	 * @param B
	 * @param k
	 * @return
	 */
	private int[] countingSort(int[] A, int[] B, int k) {
		//creates an array (array C) of length k+1
		int[] C = new int[k+1];
		//sets the value of every item in array c to 0
		for(int i = 0; i < C.length; i++) {
			C[i] = 0;
		}
		//System.out.println(Arrays.toString(C));
		//
		for(int i = 0; i < A.length; i++) {
			C[A[i]]++;
		}
		//System.out.println(Arrays.toString(C));
		for(int i = 1; i < k + 1; i++) {
			C[i] = C[i] + C[i-1];
			//System.out.print("" + C[i] + " ");
		}
		//System.out.println(Arrays.toString(C));
		for(int i = A.length - 1; i > -1; i--) {
			B[C[A[i]]-1] = A[i];
			C[A[i]]--;
		}
		
		
		return B;
	}
	
	/**
	 * 
	 * @param A
	 * @param i
	 * @return
	 */
	public int RQS(int[] A, int i) {
		int B[] = Arrays.copyOf(A, A.length);
		int total = randomzedQuickselect(B, 0, B.length-1, i);
		return total;
	}
	
	/**
	 * 
	 * @param A
	 * @param p
	 * @param r
	 * @param i
	 * @return
	 */
	private int randomzedQuickselect(int[] A, int p, int r, int i) {
		if (p == r) {
			return A[p];
		}
		//picks random number between p and r
		//System.out.println("p = " + p + "r = " + r);
		int z = randomInt(p, r);
		//swaps A[z] with A[r]
		swap(A, r , z);
		int q = partition(A, p, r);
		int k = q - p + 1;
		if(i == k) {
			return A[q];
		}else if(i < k) {
			return randomzedQuickselect(A, p, q-1, i);
		}else {
			return randomzedQuickselect(A, q+1, r, i-k);
		}
		
	}
	
	/**
	 * 
	 * @param A
	 * @param z
	 * @param r
	 */
	private void swap(int[] A, int z, int r) {
		int temp = A[z];
		A[z] = A[r];
		A[r] = temp;
		//return A;
	}
	
	/**
	 * 
	 * @param p
	 * @param r
	 * @return
	 */
	private int randomInt(int p, int r) {
		int num = (int)Math.floor(Math.random()*(r-p+ 1)+p);
		return num;
	}
	
	/**
	 * 
	 * @param A
	 * @param p
	 * @param r
	 * @return
	 */
	private int partition(int[] A, int p, int r) {
		int x = A[r];
		int i = p - 1;
		for(int j = p; j < r; j++) {
		
			if(A[j] <= x) {
				i = i + 1;
				swap(A, i,j);
			}
		}
		swap(A, i+1,r);

		return i+1;
	}
	
	
	
}
