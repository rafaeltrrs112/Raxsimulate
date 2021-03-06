package Asims454.a3

import raxsim.io.{EmptyToken, Token}
import raxsim.model.Model
import raxsim.Simulation

import scala.collection.mutable

/**
 * Memory model for use in Homework 3 assignment.
 *
 */
class XorMemory(modelName : String) extends Model {
  override def name: String = modelName

  private var inMemory : (Option[XORToken], Option[XORToken]) = (Some(XORToken(true)), Some(XORToken(false)))
  private var currentTop : Option[XORToken] = Some(XORToken(false))

  override def currentState  = mutable.Map[String, String](
    ("Next Output : ", currentOutput.toString),
    ("In memory:", inMemory.toString())
  )


  override def currentOutput : Option[IndexedSeq[Token]] = Some(IndexedSeq[XORToken](
    currentTop.getOrElse(XORToken(false)))
  )


  private def pushMemUp(xORToken: XORToken): Unit = {
    //Push top in memory up
    currentTop = inMemory._1
    //Push 2nd in memory up and place new input into the back of the memory
    inMemory = (inMemory _2, Some(xORToken))
  }


  private def emptyPushMemUp() = {
    //Push top in memory up
    currentTop = inMemory._1
    //Push 2nd in memory up and place new input into the back of the memory
    inMemory = (inMemory _2, None)
  }


  /**
   *
   * @param input
   *    A single XorToken input to be stored in memory.
   *
   */
  override def stateTransition(input: IndexedSeq[Token]): Unit = {
    input.foreach{
      case e : EmptyToken => emptyPushMemUp()
      case x : XORToken => pushMemUp(x)
    }
  }

  override def toString  = {
    currentState.toString()
  }

}
object XorList extends App {

  /**
   * Apply method for creating a list of XOR tokens
   * @param xorTokens
   *                   A IndexedSequence of one or more booleans.
   * @return
   *          A IndexedSequence of XOR tokens whose order of boolean values is in the same order as those
   *          inserted as parameters.
   */
  def apply(xorTokens : Boolean*) : IndexedSeq[IndexedSeq[XORToken]] = {
    val xorTokenList = for(value <- xorTokens) yield IndexedSeq(XORToken(value))
    xorTokenList.toIndexedSeq
  }


}