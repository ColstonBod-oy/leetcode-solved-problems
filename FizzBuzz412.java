import java.util.List;
import java.util.ArrayList;

class FizzBuzz412 {
  private List<String> answer;
    
  public List<String> fizzBuzz(int n) {
    answer = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        answer.add("FizzBuzz");
      }
          
      else if (i % 3 == 0) {
        answer.add("Fizz");
      }

      else if (i % 5 == 0) {
        answer.add("Buzz");
      }

      else {
        answer.add(Integer.toString(i));
      }
    }

    return answer;
  }
}