package app

import app.beans.{Proie, Predateur, Coordinate, Grid}
import scalafx.application.JFXApp3
import scalafx.geometry.Rectangle2D
import scalafx.scene.Scene
import scalafx.scene.paint.Color._
import scalafx.stage.Screen
import scalafx.Includes._
import scalafx.animation.{KeyFrame, Timeline}
import scalafx.util.Duration
import scalafx.scene.input.{KeyEvent, KeyCode}
import scalafx.beans.property.ObjectProperty
import scalafx.scene.shape.Circle
import scalafx.beans.property.IntegerProperty
import app.utils.PathFinding

object Main extends JFXApp3 {

  override def start(): Unit = {
    val speed = 700
    val stepSize = 5
    val elementRadius = 10
    //val screenBounds: Rectangle2D = Screen.primary.visualBounds
    //val (boardWidth, boardHeight): (Int, Int) = (screenBounds.width.intValue, screenBounds.height.intValue)
    val (boardWidth, boardHeight) = (500, 500)
    val grid = Grid(boardWidth, boardHeight)
    
    val proieState = ObjectProperty(new Proie(Coordinate(grid.width / 4, grid.height / 4), elementRadius, Blue))
    val predateurState = ObjectProperty(new Predateur(Coordinate(grid.width / 6, grid.height / 6), elementRadius, Red))

    val direction = IntegerProperty(0)

    stage = new JFXApp3.PrimaryStage {
      title.value = "Proie et Prédateurs Simulation"
      width = boardWidth
      height = boardHeight
      scene = new Scene {
        fill = Black
        content = drawContent(proieState, predateurState)
        proieState.onChange { content = drawContent(proieState, predateurState) }
        onKeyPressed = {
          key => key.getCode() match {
            case KeyCode.UP => direction.update(1)
            case KeyCode.DOWN => direction.update(2)
            case KeyCode.LEFT => direction.update(3)
            case KeyCode.RIGHT => direction.update(4)
            case _ => direction.value
          }
        }
      }
    }

    new Timeline {
      keyFrames = List(
        KeyFrame(
          time = Duration(speed),
          onFinished = _ => updatePositions(proieState, direction, predateurState, grid, stepSize)
        )
      )
      cycleCount = Timeline.Indefinite
    }.play()
  }

  def drawProie(proieState: ObjectProperty[Proie]) = {
    new Circle {
      centerX <== proieState.value.position.x
      centerY <== proieState.value.position.y
      radius = proieState.value.rayon
      fill = proieState.value.color
    }
  }

  def drawPredateur(predateurState: ObjectProperty[Predateur]) = {
    new Circle {
      centerX <== predateurState.value.position.x
      centerY <== predateurState.value.position.y
      radius = predateurState.value.radius
      fill = predateurState.value.color
    }
  }

  def drawContent(proieState: ObjectProperty[Proie], predateurState: ObjectProperty[Predateur]) = {
    List(drawProie(proieState), drawPredateur(predateurState))
  }

  def updatePositions(proieState: ObjectProperty[Proie], direction: IntegerProperty, predateurState: ObjectProperty[Predateur], grid: Grid, stepSize: Int) = {
    val proieStatePosition = proieState.value.position
    proieState.value = proieState.value.move(direction.value, grid.width, grid.height, stepSize)
    predateurState.value = predateurState.value.move(proieStatePosition, proieState.value.status, grid, stepSize)
    if (PathFinding.collision_detected(proieState.value.position, predateurState.value.position, proieState.value.rayon.toInt)) {
      // GAME OVER
      println("Game Over")
      System.exit(0)
    }
  }
}
