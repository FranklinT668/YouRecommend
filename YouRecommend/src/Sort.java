/* Student Information
* -------------------
* Student Name: Zhang, Bowen
* Student Number: 400168985
* Course Code: SE 2XB3
* Lab Section: 01
*
* I attest that the following code being submitted is my own individual
work.
*/

import java.util.ArrayList;

/*Sort Module.*/
public class Sort {
	
	/*Merge portion of the MergeSort based on the number of followers.*/
	/*parameter: Input arraylist of YouTuber arr, leftmost index l, middle index m, rightmost index r.*/
	private void merge_Followers(ArrayList<YouTuber> arr, int l, int m, int r) {
		int n1 = m - l + 1; 
        int n2 = r - m; 
        YouTuber L[] = new YouTuber [n1]; 
        YouTuber R[] = new YouTuber [n2]; 
        for (int i=0; i<n1; ++i) 
            L[i] = arr.get(l + i); 
        for (int j=0; j<n2; ++j) 
            R[j] = arr.get(m + 1+ j); 
        int i = 0, j = 0;  
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i].getFollowers() <= R[j].getFollowers()) 
            { 
                arr.set(k, L[i]); 
                i++; 
            } 
            else
            { 
            	arr.set(k, R[j]);
                j++; 
            } 
            k++; 
        } 
        while (i < n1) 
        { 
        	arr.set(k, L[i]);
            i++; 
            k++; 
        } 
        while (j < n2) 
        { 
        	arr.set(k, R[j]);
            j++; 
            k++; 
		}
	}
	
	/*Recursive Sort portion of the MergeSort based on the number of followers.*/
	/*parameter: Input arraylist of YouTuber arr, leftmost index l, rightmost index r.*/
	private void sort_Followers (ArrayList<YouTuber> arr, int l, int r) {
		if (l < r) {
			int m = (l+r)/2;
			sort_Followers(arr, l, m);
			sort_Followers(arr, m+1, r);
			merge_Followers(arr, l, m, r);
		}
	}
	
	/*Function that calls the MergeSort and returns a sorted arraylist of YouTuber based on the number of followers.*/
	/*parameter: Input arraylist of YouTuber arr.*/
	public static ArrayList<YouTuber> MergeSort_Followers (ArrayList<YouTuber> arr){
		ArrayList<YouTuber> sorted = arr;
		Sort ob = new Sort();
		ob.sort_Followers(sorted, 0, sorted.size()-1);
		ArrayList<YouTuber> rev = new ArrayList<YouTuber>(); 
        for (int i = sorted.size() - 1; i >= 0; i--) { 
        	rev.add(sorted.get(i)); 
        } 
        return rev;
	}
	
	/*Partition portion of the QuickSort based on the number of followers.*/
	/*parameter: Input arraylist of YouTuber arr, leftmost index low, rightmost index high.*/
	private int partition_Followers (ArrayList<YouTuber> arr, int low, int high) {
		YouTuber pivot = arr.get(high);
		int i = low - 1;
		for (int j = low; j<high; j++) {
			if (arr.get(j).getFollowers() < pivot.getFollowers()) {
				i++;
				YouTuber temp = arr.get(i);
				arr.set(i, arr.get(j));
				arr.set(j, temp);
			}
		}
		YouTuber temp = arr.get(i+1);
		arr.set(i+1, arr.get(high));
		arr.set(high, temp);
		return i+1;
	}
	
	/*Recursive Sort portion of the QuickSort based on the number of followers.*/
	/*parameter: Input arraylist of YouTuber arr, leftmost index low, rightmost index high.*/
	private void sort_quick_Followers (ArrayList<YouTuber> arr, int low, int high) {
		if (low < high) {
			int pi = partition_Followers(arr, low, high);
			sort_quick_Followers(arr, low, pi-1);
			sort_quick_Followers(arr, pi+1, high);
		}
	}
	
	/*Function that calls the QuickSort and returns a sorted arraylist of YouTuber based on the number of followers.*/
	/*parameter: Input arraylist of YouTuber arr.*/
	public static ArrayList<YouTuber> QuickSort_Followers (ArrayList<YouTuber> arr){
		ArrayList<YouTuber> sorted = arr;
		Sort ob = new Sort();
		ob.sort_quick_Followers(sorted, 0, sorted.size()-1);
		ArrayList<YouTuber> rev = new ArrayList<YouTuber>(); 
        for (int i = sorted.size() - 1; i >= 0; i--) { 
        	rev.add(sorted.get(i)); 
        } 
        return rev;
	}
	
	/*Merge portion of the MergeSort based on the number of Videos.*/
	/*parameter: Input arraylist of YouTuber arr, leftmost index l, middle index m, rightmost index r.*/
	private void merge_Videos(ArrayList<YouTuber> arr, int l, int m, int r) {
		int n1 = m - l + 1; 
        int n2 = r - m; 
        YouTuber L[] = new YouTuber [n1]; 
        YouTuber R[] = new YouTuber [n2]; 
        for (int i=0; i<n1; ++i) 
            L[i] = arr.get(l + i); 
        for (int j=0; j<n2; ++j) 
            R[j] = arr.get(m + 1+ j); 
        int i = 0, j = 0;  
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i].getVideos() <= R[j].getVideos()) 
            { 
                arr.set(k, L[i]); 
                i++; 
            } 
            else
            { 
            	arr.set(k, R[j]);
                j++; 
            } 
            k++; 
        } 
        while (i < n1) 
        { 
        	arr.set(k, L[i]);
            i++; 
            k++; 
        } 
        while (j < n2) 
        { 
        	arr.set(k, R[j]);
            j++; 
            k++; 
		}
	}
	
	/*Recursive Sort portion of the MergeSort based on the number of Videos.*/
	/*parameter: Input arraylist of YouTuber arr, leftmost index l, rightmost index r.*/
	private void sort_Videos (ArrayList<YouTuber> arr, int l, int r) {
		if (l < r) {
			int m = (l+r)/2;
			sort_Videos(arr, l, m);
			sort_Videos(arr, m+1, r);
			merge_Videos(arr, l, m, r);
		}
	}
	
	/*Function that calls the MergeSort and returns a sorted arraylist of YouTuber based on the number of Videos.*/
	/*parameter: Input arraylist of YouTuber arr.*/
	public static ArrayList<YouTuber> MergeSort_Videos (ArrayList<YouTuber> arr){
		ArrayList<YouTuber> sorted = arr;
		Sort ob = new Sort();
		ob.sort_Videos(sorted, 0, sorted.size()-1);
		ArrayList<YouTuber> rev = new ArrayList<YouTuber>(); 
        for (int i = sorted.size() - 1; i >= 0; i--) { 
        	rev.add(sorted.get(i)); 
        } 
        return rev;
	}
	
	/*Partition portion of the QuickSort based on the number of Videos.*/
	/*parameter: Input arraylist of YouTuber arr, leftmost index low, rightmost index high.*/
	private int partition_Videos (ArrayList<YouTuber> arr, int low, int high) {
		YouTuber pivot = arr.get(high);
		int i = low - 1;
		for (int j = low; j<high; j++) {
			if (arr.get(j).getVideos() < pivot.getVideos()) {
				i++;
				YouTuber temp = arr.get(i);
				arr.set(i, arr.get(j));
				arr.set(j, temp);
			}
		}
		YouTuber temp = arr.get(i+1);
		arr.set(i+1, arr.get(high));
		arr.set(high, temp);
		return i+1;
	}
	
	/*Recursive Sort portion of the QuickSort based on the number of Videos.*/
	/*parameter: Input arraylist of YouTuber arr, leftmost index low, rightmost index high.*/
	private void sort_quick_Videos (ArrayList<YouTuber> arr, int low, int high) {
		if (low < high) {
			int pi = partition_Videos(arr, low, high);
			sort_quick_Videos(arr, low, pi-1);
			sort_quick_Videos(arr, pi+1, high);
		}
	}
	
	/*Function that calls the QuickSort and returns a sorted arraylist of YouTuber based on the number of Videos.*/
	/*parameter: Input arraylist of YouTuber arr.*/
	public static ArrayList<YouTuber> QuickSort_Videos (ArrayList<YouTuber> arr){
		ArrayList<YouTuber> sorted = arr;
		Sort ob = new Sort();
		ob.sort_quick_Videos(sorted, 0, sorted.size()-1);
		ArrayList<YouTuber> rev = new ArrayList<YouTuber>(); 
        for (int i = sorted.size() - 1; i >= 0; i--) { 
        	rev.add(sorted.get(i)); 
        } 
        return rev;
	}
	
}
