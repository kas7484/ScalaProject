
object Tester extends App {
   val result1: Int = Proj.countsorted(4,2,1)
   println(result1)

   val result2: String  = Proj.interpolation("world", 23)
   println(result2)

   val result3a: Double = Proj.polynomial(List(4.0,1.0,2.0))
   
   val result3b: Double = Proj.polynomial(Vector(4.0,1.0,2.0))
   
   val result4: Int = Proj.application(1,2,3){(x,y) => x+y}
   
   val result5: Vector[String] = Proj.stringy(3,4)
   
   val result6: Vector[Int] = Proj.modab(3,2, Vector(1,2,3,4,5,6))
   
   val result7: Int = Proj.count(Vector(2,3,4)){x => x%2 == 0}
   
   val result8: Int = Proj.count_tail(Vector(2,3,4)){x => x%2 == 0}

   val result9a: Double = Proj.neumaier(Vector(1.0, 1e100, 1.0, -1e100))

   val result9b: Double = Proj.neumaier(List(1.0, 1e100, 1.0, -1e100))


}
