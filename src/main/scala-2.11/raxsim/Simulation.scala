package raxsim

import raxsim.io.Token
import raxsim.model.Model

/**
 *
 */
class Simulation(model: Model, inputs: IndexedSeq[IndexedSeq[Token]]) {

  var tickNumber = 0

  def runSimulation(): Unit = inputs.foreach((v) => {

    println("Tick [" + tickNumber + "]")
    println("Model Output: " + model.currentOutput)

    model.stateTransition(v)

    tickNumber += 1

    println(model)
  })
}
