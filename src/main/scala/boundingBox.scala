package shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    case Rectangle(w, h) =>
      Location(0, 0, Rectangle(w, h))
    case Ellipse(rx, ry) =>
      Location(-rx, -ry, Rectangle(2 * rx, 2 * ry))
    case Location(x, y, shape) =>
      val Location(u, v, rect) = apply(shape)
      Location(x + u, y + v, rect)
    case Group(shapes) if shapes.isEmpty =>
      Location(0, 0, Rectangle(0, 0))
    case Group(shapes) =>
      val boundingBoxes = shapes.map(apply)
      val xMin = boundingBoxes.map(_.x).min
      val yMin = boundingBoxes.map(_.y).min
      val xMax = boundingBoxes.map {
        case Location(x, y, Rectangle(w, _)) => x + w
        case _ => throw new IllegalArgumentException("Unexpected shape in bounding box calculation")
      }.max(using Ordering.Int)
      val yMax = boundingBoxes.map {
        case Location(x, y, Rectangle(_, h)) => y + h
        case _ => throw new IllegalArgumentException("Unexpected shape in bounding box calculation")
      }.max(using Ordering.Int)
      Location(xMin, yMin, Rectangle(xMax - xMin, yMax - yMin))
end boundingBox