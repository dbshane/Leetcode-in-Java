
public class GasStation
{
	// property of starting point i: if j != i, the car can't travel from j to i.
	// (proof by contradiction: if the car can travel from j to i, since from i can travel to any point,
	// j can also be a valid starting point, which is contradict the "unique" requirement. 
	
	// if the car can travel from i to j but not j+1, any gas station in between i and j (inclusive) can't be
	// the starting point, j+1 is a potential starting point.

	// this problem is to find a point i, that no point in prior can travel to i, and i can travel to length-1.
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0, start = 0, total = 0, rest = 0;
        while (i < gas.length)
        {
            rest += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (rest < 0)
            {
                start = i+1;
                rest = 0;
            }
            i++;
        }
        if (total < 0) return -1;
        else return start;
    }
    public static void main(String[] args)
	{
		int[] gas = {5};
		int[] cost = {4};
		System.out.println(canCompleteCircuit(gas, cost));
	}
    
}
