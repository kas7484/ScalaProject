case class Neumaier(sum: Double, c: Double)

object Proj {

   def countsorted(x: Int, y: Int, z:Int) = {
    var count = 0
    if (x < y) count += 1
    if (y < z) count += 1
    if (x < z) count += 1
    count
   }

   def interpolation(name: String, age: Int): String = {
    if (age >= 21) "hello, " + name.toLowerCase 
    else "howdy, " + name.toLowerCase
   }


   def polynomial(arr: Seq[Double]) = {
      arr.zipWithIndex.foldLeft(0.0) { case (acc, (x, i)) => acc + x * (i + 1) }
   }

   def application(x: Int, y: Int, z: Int)(f: (Int, Int) => Int) = {
      f(f(x, y), z)
   }
   
   def stringy(start: Int, n: Int): Vector[String] =
      Vector.tabulate(n)(i => (start + i).toString)

   def modab(a: Int, b: Int, c: Vector[Int]): Vector[Int] = {
      c.filter(x => x >= a && x % b != 0)
   }

   def count(arr: Vector[Int], f: Int => Boolean): Int = {
      if(arr.isEmpty) 0
      else{
         val countTail = q7_count(arr.tail, f)
         if(f(arr.head)) countTail + 1
         else countTail
      }
   }

   def count_tail(arr: Vector[Int], f: Int => Boolean): Int = {
      @annotation.tailrec
      def loop(arr: Vector[Int], f: Int => Boolean, acc: Int): Int = {
         if (arr.isEmpty) acc
         else if (f(arr.head)) loop(arr.tail, f, acc + 1)
         else loop(arr.tail, f, acc)
      }
   loop(arr, f, 0)
   }


   def neumaier(input: Seq[Double]): Double = {
      case class Neumaier(sum: Double, c: Double)
      input.foldLeft(Neumaier(0.0, 0.0)) { (state, x) =>
         val sum = state.sum + x
         val c = if (math.abs(state.sum) >= math.abs(x))
              state.c + (state.sum - sum) + x
            else
              state.c + (x - sum) + state.sum
         Neumaier(sum, c)
      }.let { case Neumaier(sum, c) => sum + c }
}





}
