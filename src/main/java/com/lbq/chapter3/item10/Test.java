package com.lbq.chapter3.item10;
/**
 * 尽管Object是一个具体类，但设计它主要是为了扩展。它所有非final方法(equals、hashCode、toString、clone和finalize)都有明确的通用约定，因为它们设计成是要被覆盖(override)的。
 * 任何一个类，它在覆盖这些方法的时候，都有责任遵守这些通用约定；如果不能做到这一点，其他依赖于这些约定的类(例如HashMap和HashSet)就无法结合该类一起正常运作。
 * 而Comparable.compareTo虽然不是Object方法，但是本章也将对它进行讨论，因为它具有类似的特征。
 * @author 14378
 *
 */
public class Test {

}
