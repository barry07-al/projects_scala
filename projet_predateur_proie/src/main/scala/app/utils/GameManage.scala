package app.utils

import app.beans.{Proie, Predateur}
import scalafx.scene.Node

/**
class GameManage(proie: Proie, predateurs: Array[Predateur], boardWidth: Int, boardHeight: Int) {

  def update(): Unit = {
    predateurs.foreach(_.moveTowards(proie.position))
  }


  def getNodes(): Array[Node] = {
    (predateurs :+ proie).map(_.getNode())
  }
  
}
*/