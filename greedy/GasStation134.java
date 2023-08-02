package greedy;

public class GasStation134 {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int gasTotal = 0;
    int costTotal = 0;
    
    for (int i = 0; i < gas.length; i++) {
      gasTotal += gas[i];
      costTotal += cost[i];
    }
    
    if (gasTotal < costTotal) {
      return -1;
    }

    int total = 0;
    int res = 0;

    for (int i = 0; i < gas.length; i++) {
      total += gas[i] - cost[i];

      if (total < 0) {
        total = 0;
        res = i + 1;
      }
    }

    return res;
  }
}