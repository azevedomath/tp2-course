package br.unb.cic.oberon

import org.scalatest.FunSuite

class ExpressionTest extends FunSuite {

  test("Evaluating an IntValue should lead to an IntValue") {
    val int10 = new IntValue(10)

    assert(int10.equals(int10.eval()))
  }

  test("Evaluating a BoolValue should lead to a BoolValue") {
    val bt = new BoolValue(true)
    val bf = new BoolValue(false)


    assert(bt.equals(bt.eval()))
    assert(bf.equals(bf.eval()))
  }

  test("Evaluating a AddExp(3, 4) should lead to an IntValue(7)") {
    val int3 = new IntValue(3)
    val int4 = new IntValue(4)
    val int7 = new IntValue(7)

    val sum  = AddExp(int3, int4) 

    assert(int7 == sum.eval())
  }

  test("The Expression Add(true, 3) should be invalid") {
    val t = new BoolValue(true)
    val i = new IntValue(3)

    val sum = AddExp(t, i)

    assert(t.typeCheck())
    assert(i.typeCheck())
    assert(sum.computeType == TError())
    assert(!sum.typeCheck())
  }

  test("The expression And(true, 3) should be invalid") {
    val t = new BoolValue(true)
    val i = new IntValue(3)

    val and = AndExp(t, i)

    assert(t.typeCheck())
    assert(i.typeCheck())
    assert(and.computeType == TError())
    assert(!and.typeCheck())
  }
}

