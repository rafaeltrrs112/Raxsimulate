package raxsim.io

/**
 * All inputs can be outputted, but not all outputs can be inputted
 * into a model.
 */
trait Input[T] extends Output[T] {
  override val value: T
}
trait Output[T] extends Token{
  val value : T
}
