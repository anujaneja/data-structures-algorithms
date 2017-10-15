# Data Structure Algorithms
	Arrays
		1. Sliding Window Algorithm:-
			Sliding Window Maximum/Minimum (Maximum/Minimum of all subarrays of size k). 
			Method 1: Using DQeue to maintain the max/min element as the first element of k size Dqeue.
				Ref:- http://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
				Complexity: Time- O(n), space: O(k)
			Method 2: Using Quick Sort piovt element is the max of the batch. 
				Complexity:- O(nlogn)
			Method 3: Using Heap to get the max/min element for a window.
			
