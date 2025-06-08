import java.util.HashMap;

public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int fib(int num) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		return fibHelper(map,num);
	}

	public static int fibHelper(HashMap<Integer, Integer> map, int num) {
		if (num == 0) {
			return 0;
		}

		if (num == 1) {
			return 1;
 		}
		if (map.containsKey(num)) {
			return map.get(num);
		}	

		int value = fibHelper(map, num - 1) + fibHelper(map, num - 2);
		map.put(num, value);
		return value;
 	}
	
	public static int minCostClimbingStairs(int[] cost) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (cost.length == 0) {
			return 0;
		}
		if (cost.length == 1) {
			return cost[0];
		}
		return Math.min(minCostClimbingStairsHelper(cost, cost.length - 1, map), minCostClimbingStairsHelper(cost, cost.length - 2, map));
	}

		public static int minCostClimbingStairsHelper(int[] cost, int num, HashMap<Integer, Integer> map) {
			if (num < 0) {
				return 0;
			}
			
			if (num >= cost.length) {
			return 0;
		}

		if (map.containsKey(num)) {
			return map.get(num);
		}

		int finalCost = cost[num] + Math.min(minCostClimbingStairsHelper(cost, num - 1, map), minCostClimbingStairsHelper(cost, num - 2, map));
		map.put(num, finalCost);
		return finalCost;
		}


}