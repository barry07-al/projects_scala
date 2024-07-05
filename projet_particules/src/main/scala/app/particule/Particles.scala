package app.particule

import scalafx.scene.paint.Color
import app.direction.DirectionUtils
import scala.util.Random

class Particles(val particles: Array[Particule]) {

  def this(numberOfParticles: Int, particleRadius: Int) = {
    this(Array.fill(numberOfParticles)(
      new Particule(
        particleRadius,
        (new Random().nextInt(1200), new Random().nextInt(1200)),
        Color(new Random().nextDouble(), new Random().nextDouble(), new Random().nextDouble(), 1.0),
        DirectionUtils.randomDirection()
      )
    ))
  }

  def getParticles(): Array[Particule] = particles

  def update(): Particles = {
    new Particles(particles.map(_.updatePosition(1200, 1200, particles)))
  }
}
