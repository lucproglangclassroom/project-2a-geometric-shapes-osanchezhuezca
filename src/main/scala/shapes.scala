package shapes

/** data Shape = Rectangle(w, h) | Location(x, y, Shape) */
enum Shape derives CanEqual:
  case Rectangle(w: Int, h: Int)
  case Location(x: Int, y: Int, s: Shape)
  case Ellipse(w: Int, h: Int)
  case Group(s: List[Shape])

  def size: Int = this match
    case Rectangle(_, _) => 1
    case Ellipse(_, _)   => 1
    case Location(_, _, shape) => shape.size
    case Group(shapes) => shapes.map(_.size).sum

  def height: Int = this match
    case Rectangle(_, h) => 1
    case Ellipse(_, h)   => 1
    case Location(_, _, shape) => 1 + shape.height
    case Group(shapes) => 1 + shapes.map(_.height).maxOption.getOrElse(0)

  def scale(factor: Double): Shape = this match
    case Rectangle(w, h) =>
      Rectangle((w * factor).toInt, (h * factor).toInt)
    case Ellipse(rx, ry) =>
      Ellipse((rx * factor).toInt, (ry * factor).toInt)
    case Location(x, y, shape) =>
      Location((x * factor).toInt, (y * factor).toInt, shape.scale(factor))
    case Group(shapes) =>
      Group(shapes.map(_.scale(factor)))