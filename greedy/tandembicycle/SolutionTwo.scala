    if(fastest == true) {
        
        if(redSorted(redR) > blueSorted(blueR) && pairs.length < redSorted.length) {
          pairs += ArrayBuffer(redSorted(redR), blueSorted(blueL))
          redR -= 1
          blueL += 1
          mkPairs(redSorted, blueSorted, redL, redR, blueL, blueR)
        }
        else if(pairs.length < redSorted.length) {
          pairs += ArrayBuffer(blueSorted(blueR), redSorted(redL))
          blueR -= 1
          redL += 1
          mkPairs(redSorted, blueSorted, redL, redR, blueL, blueR)
        }
      
      for(pair <- pairs) {
        result += pair(0)
      }
      println(pairs)
      return result
    }

      def sumSpeed(index: Int = 0, result: Int = 0, pairs: collection.mutable.ArrayBuffer[ArrayBuffer[Int]): Int = {
        val index: Int = 0
        result += pairs(index)(0)
        sumSpeed(result, index + 1, pairs)
      }

