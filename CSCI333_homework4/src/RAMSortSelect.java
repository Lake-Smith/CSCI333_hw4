import java.util.Arrays;
import java.util.Random;

/**
 * 
 * @author Lake Smith
 *
 */
public class RAMSortSelect {
	
	public static void main(String[] args) {
		int[] A = new int[] {4,5,2,3,7,2,8,1};
		int[] B = new int[A.length];
		System.out.println(Arrays.toString(A));
		RAMSortSelect RM = new RAMSortSelect();
		RM.countingSort(A, B , 8);
		System.out.println(Arrays.toString(B));
		
		int num = RM.RQS(A, 4);
		System.out.println("The number is at index:"  + num);
		
		
	}
	
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
	
	public int RQS(int[] A, int i) {
		int B[] = Arrays.copyOf(A, A.length);
		int total = randomzedQuickselect(B, 0, B.length-1, i);
		return total;
	}
	
	private int randomzedQuickselect(int[] A, int p, int r, int i) {
		int total = 0;
		if (p == r) {
			total = A[p];
		}
		//picks random number between p and r
		//System.out.println("p = " + p + "r = " + r);
		int z = randomInt(p, r);
		//System.out.println(z);
		//swaps A[z] with A[r]
		swap(A, r , z);
		int q = partition(A, p, r);
		int k = q - p;
		if(i == k) {
			total = A[q];
		}else if(i < k) {
			total = randomzedQuickselect(A, p, q-1, i);
		}else {
			total = randomzedQuickselect(A, q+1, r, i-k);
		}
		
		return total;
	}
	
	private void swap(int[] A, int z, int r) {
		int temp = A[z];
		A[z] = A[r];
		A[r] = temp;
		//return A;
	}
	
	private int randomInt(int p, int r) {
		//Random rand = new Random();
		int min = p;
		int max = r;
		int num = (int)Math.floor(Math.random()*(max-min+ 1)+min);
		//System.out.println("num = " + ((r-p + 1)+p) );
		return num;
	}
	
	private int partition(int[] A, int p, int r) {
		int x = A[r];
		int i = p - 1;
		for(int j = p; j < r-1; j++) {
			if(A[j] <= x) {
				i = i + 1;
				swap(A, i,j);
			}
		}
		swap(A, i+1,r);
		//System.out.println(i);

		return i+1;
	}
	
	
	
}
