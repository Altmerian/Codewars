package com.codewars.altmer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PaginationHelperTest {
	private PaginationHelper<Character> paginationHelper;
	private final List<Character> helper = List.of('a', 'b', 'c', 'd', 'e', 'f');

  @BeforeEach
  void setUp() {
	  paginationHelper = new PaginationHelper<>(helper, 4);
  }

	@Test
	public void itemCountPositiveTest() {
		assertThat(paginationHelper.itemCount(), is(6));
	}

	@Test
	public void itemCountNegativeTest() {
		assertThat(paginationHelper.itemCount(), is(not(4)));
	}

	@DisplayName("Page count for 10 elements collection")
	@ParameterizedTest(name = "{0} items per page ==> {1} pages")
	@CsvSource({"3, 4","10, 1","0, 0", "-10, 0"})
	public void pageCountPositiveTest(int itemsPerPage, int pageCount) {
  	PaginationHelper<Integer> paginationHelper = new PaginationHelper<>(
  			List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0), itemsPerPage);
  	assertThat(paginationHelper.pageCount(), is(pageCount));
	}

	@Test
	public void pageCountNegativeTest() {
		assertThat(paginationHelper.pageCount(), is(not(3)));
	}

	@DisplayName("Items count on specified page")
	@ParameterizedTest(name = "{0} page ==> {1} items")
	@CsvSource({"0, 4","1, 2","2, -1", "-10, -1"})
	public void pageItemCountTest(int pageIndex, int itemCount) {
  	assertThat(paginationHelper.pageItemCount(pageIndex), is(itemCount));
	}

	@DisplayName("Zero based page number for item index")
	@ParameterizedTest(name = "collection.get({0}) item is on {1} page")
	@CsvSource({"5, 1","2, 0","20, -1", "-10, -1"})
	public void pageIndexTest(int itemIndex, int pageNumber) {
  	assertThat(paginationHelper.pageIndex(itemIndex), is(pageNumber));
	}
}