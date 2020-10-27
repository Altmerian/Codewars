package com.codewars.altmer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DRootTest {
  @Test
  public void Test1() {
    assertEquals(7, DRoot.digital_root(16), "Nope!");
  }

  @Test
  public void Test2() {
    assertEquals( 6, DRoot.digital_root(456),"Nope!");
  }

  @Test
  public void Test3() {
    assertEquals( 2, DRoot.digital_root(-493193),"Nope!");
  }
}