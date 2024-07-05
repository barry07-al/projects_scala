error id: file://<WORKSPACE>/projet_particules/src/main/scala/app/particule/Particles.scala:[505..506) in Input.VirtualFile("file://<WORKSPACE>/projet_particules/src/main/scala/app/particule/Particles.scala", "package app.particule

import scalafx.scene.paint.Color
import scala.util.Random



class Particles(val numberOfParticles: Int, val particleRadius: Int) {

  val rand = new Random()

  private val particles: Array[Particule] = Array.fill(numberOfParticles)(
    new Particule(
      particleRadius,
      (rand.nextInt(1200), rand.nextInt(1200)),
      Color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), 1.0),
      null
    )
  )

  def getParticles: Array[Particule] = particles

  def 

  
}
")
file://<WORKSPACE>/projet_particules/src/main/scala/app/particule/Particles.scala
file://<WORKSPACE>/projet_particules/src/main/scala/app/particule/Particles.scala:26: error: expected identifier; obtained rbrace
}
^
#### Short summary: 

expected identifier; obtained rbrace