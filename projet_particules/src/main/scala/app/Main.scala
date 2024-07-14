package app

import app.particule.{Particule, Particules}
import scalafx.application.JFXApp3
import scalafx.geometry.Rectangle2D
import scalafx.scene.Scene
import scalafx.scene.paint.Color.*
import scalafx.animation.Timeline
import scalafx.util.Duration
import scalafx.animation.KeyFrame
import scalafx.scene.shape.Circle
import scalafx.stage.Screen
import scalafx.beans.property.ObjectProperty

object Main extends JFXApp3 {

  val particleRadius: Int    = 3
  val numberOfParticles: Int = 750
  
  override def start(): Unit = {
    val screenBounds: Rectangle2D             = Screen.primary.visualBounds
    val (boardWidth, boardHeight): (Int, Int) = (screenBounds.width.intValue, screenBounds.height.intValue)
    val particulesState = ObjectProperty(
      new Particules(numberOfParticles, particleRadius, boardWidth, boardHeight)
    )
    stage = new JFXApp3.PrimaryStage {
      title.value = "Simulation de Particules"
      width = boardWidth
      height = boardHeight
      scene = new Scene {
        fill = White
        val particleNodes = particulesState.value.getParticles().map(drawParticule)
        content = particleNodes
        val timeline = new Timeline {
          cycleCount = Timeline.Indefinite
          keyFrames = List(
            KeyFrame(
              Duration(16),
              onFinished = _ => {
                val updatedParticules = particulesState.value.update()
                particulesState.value = updatedParticules
                particleNodes.zip(particulesState.value.getParticles()).foreach {
                  case (node, particle) =>
                    node.centerX = particle.position._1
                    node.centerY = particle.position._2
                }
              }
            )
          )
        }
        timeline.play()
      }
    }
  }

  def drawParticule(p: Particule): Circle = {
    new Circle {
      centerX = p.position._1
      centerY = p.position._2
      radius = p.radius
      fill = p.color
    }
  }
}
