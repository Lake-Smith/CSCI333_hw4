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
		
		int num = RM.randomzedQuickselect(A, 0, A.length-1, 4);
		System.out.println(num);
		
		
	}
	
	private int[] countingSort(int[] A, int[] B, int k) {
		int[] C = new int[k+1];
		for(int i = 0; i < C.length; i++) {
			C[i] = 0;
		}
		//System.out.println(Arrays.toString(C));
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
	
	private int randomzedQuickselect(int[] A, int p, int r, int i) {
		int total = 0;
		if (p == r) {
				total = A[p];
		}
		int z = randomInt(p, r);
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
	
	private void swap(int[] A, int x, int y) {
		int temp = A[x];
		A[x] = A[y];
		A[y] = temp;
		//return A;
	}
	
	private int randomInt(int p, int r) {
		Random rand = new Random();
		int num = (rand.nextInt(r-1) + p) - 1;
		System.out.println(num);
		return num;
	}
	
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
