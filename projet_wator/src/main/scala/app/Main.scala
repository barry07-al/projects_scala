package app

import app.utils.{Tunas, Sharks}
import app.beans.{Tuna, Shark}

import scalafx.application.JFXApp3
import scalafx.geometry.Rectangle2D
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.scene.paint.Color.*
import scalafx.animation.Timeline
import scalafx.util.Duration
import scalafx.animation.KeyFrame
import scalafx.scene.shape.Circle
import scalafx.stage.Screen
import scalafx.beans.property.ObjectProperty
import org.w3c.dom.css.Rect
import scalafx.scene.shape.Rectangle

object Main extends JFXApp3 {

  val sizeAgent:    Int    = 10
  val nTunas:       Int    = 100
  val tunaColor:    Color  = Green
  
  
  
  override def start(): Unit = {
    val screenBounds: Rectangle2D             = Screen.primary.visualBounds
    val (boardWidth, boardHeight): (Int, Int) = (screenBounds.width.intValue, screenBounds.height.intValue)
    val tunasState = ObjectProperty(new Tunas(nTunas, boardWidth, boardHeight))

    stage = new JFXApp3.PrimaryStage {
      title.value = "Simulation de Wator Game"
      width = boardWidth
      height = boardHeight
      scene = new Scene {
        fill = Black
        content = tunasState.value.tunas.map(tuna => drawAgent(tuna, tunaColor))
        tunasState.value.tunas.filter
        
      }
    }
  }

  def drawAgent(tuna: Tuna, color: Color) = {
    new Rectangle {
      fill = color
      x = tuna.position._1.toInt
      y = tuna.position._2.toInt
      width = sizeAgent
      height = sizeAgent
    }
  }

  def nombreImpairs(liste: List[Int]): List[Int] = {
    // recursive function
    liste match {
      case Nil => Nil
      case x :: xs if x % 2 != 0 => x :: nombreImpairs(xs)
      case _ :: xs => nombreImpairs(xs)
    }
    
  }
}
