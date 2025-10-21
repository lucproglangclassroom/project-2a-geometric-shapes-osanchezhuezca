package shapes

import Shape.*

object TestFixtures:

  val simpleEllipse = Ellipse(50, 30)

  val simpleRectangle = Rectangle(80, 120)

  val simpleLocation = Location(70, 30, Rectangle(80, 120))

  val basicGroup = Group(List(Ellipse(50, 30), Rectangle(20, 40)))

  val simpleGroup = Group(
    List(
      Location(200, 100, Ellipse(50, 30)),
      Location(400, 300, Rectangle(100, 50))
    )
  )

  val complexGroup =
    Location(50, 100,
      Group(
        List(
          Ellipse(20, 40),
          Location(150, 50,
            Group(
              List(
                Rectangle(50, 30),
                Rectangle(300, 60),
                Location(100, 200, Ellipse(50, 30))
              )
            )
          ),
          Rectangle(100, 200)
        )
      )
    )

end TestFixtures