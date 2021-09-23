import java.util.*;

class Program {
  public static int productSum(List<Object> array) {
    return productSumHelper(array, 1);
  }
  
  public static int productSumHelper(List<Object> array, int multiplier) {
    int sum = 0;
    for (Object el : array) {
      if (el instanceof ArrayList) {
        @SuppressWarnings("unchecked")
        ArrayList<Object> ls = (ArrayList<Object>) el;
        sum += productSumHelper(ls, multiplier + 1);
      }
      else {
        sum += (int) el;
      }
    }
    return sum * multiplier;
  }
}

//scala

import java.util._

//remove if not needed
import scala.collection.JavaConversions._

object Program {

  def productSum(array: List[Any]): Int = productSumHelper(array, 1)

  def productSumHelper(array: List[Any], multiplier: Int): Int = {
    var sum: Int = 0
    for (el <- array) {
      if (el.isInstanceOf[List[Any]]) {
        val ls: List[Any] = el.asInstanceOf[List[Any]]
        sum += productSumHelper(ls, multiplier + 1)
      } else {
        sum += el.toInt
      }
    }
    sum * multiplier
  }

}
