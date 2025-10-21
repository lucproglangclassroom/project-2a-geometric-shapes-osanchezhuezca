package shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*
import Shape.*

class TestScale extends AnyFunSuite:

  def testScale(description: String, s: Shape, factor: Double, expected: Shape): Unit =
    test(description):
      val result = s.scale(factor)
      assert(result == expected)

  testScale("scale rectangle", simpleRectangle, 2.0, Rectangle(160, 240))
  testScale("scale ellipse", simpleEllipse, 0.5, Ellipse(25, 15))
  testScale("scale location", simpleLocation, 2.0, Location(140, 60, Rectangle(160, 240)))
  testScale("scale group", basicGroup, 2.0, Group(List(Ellipse(100, 60), Rectangle(40, 80))))
  testScale("scale simple group", simpleGroup, 0.5, Group(List(Location(100, 50, Ellipse(25, 15)), Location(200, 150, Rectangle(50, 25)))))
  testScale("scale complex group", complexGroup, 0.5, Location(25, 50, Group(List(Ellipse(10, 20), Location(75, 25, Group(List(Rectangle(25, 15), Rectangle(150, 30), Location(50, 100, Ellipse(25, 15))))), Rectangle(50, 100)))))

end TestScale