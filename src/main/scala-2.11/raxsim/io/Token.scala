package raxsim.io

/**
 * All inputs are entered into a system for a reason. Therefore all inputs
 * must have at least one value. All inputs must be defined here so the compiler helps with
 * checking whether pattern matching is exhaustive.
 */
trait Token

/**
 * @deprecated
 */
case class EmptyToken() extends Token

/**
 * @deprecated
 */
object EmptyToken{
  def emptyTokenIndexedSeq = IndexedSeq[Token](EmptyToken())
}