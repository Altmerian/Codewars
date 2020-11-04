package com.codewars.altmer;

import java.util.List;

public class PaginationHelper<I> {

  private final List<I> collection;
  private final int itemsPerPage;

  /**
   * The constructor takes in an array of items and a integer indicating how many items fit within a
   * single page
   */
  public PaginationHelper(List<I> collection, int itemsPerPage) {
    this.collection = collection;
    this.itemsPerPage = itemsPerPage;
  }

  public List<I> getCollection() {
    return collection;
  }

  public int getItemsPerPage() {
    return itemsPerPage;
  }

  /** returns the number of items within the entire collection */
  public int itemCount() {
    return collection.size();
  }

  /** returns the number of pages */
  public int pageCount() {
    if (collection.size() == 0 || itemsPerPage <= 0) {
      return 0;
    }
    return (int) Math.ceil(itemCount() / (float) itemsPerPage);
  }

  /**
   * returns the number of items on the current page. page_index is zero based. this method should
   * return -1 for pageIndex values that are out of range
   */
  public int pageItemCount(int pageIndex) {
    int totalPages = pageCount();
    if (pageIndex < 0 || pageIndex >= totalPages) {
      return -1;
    }
    return (pageIndex == totalPages - 1) ? totalPages % itemsPerPage : itemsPerPage;
  }

  /**
   * determines what page an item is on. Zero based indexes this method should return -1 for
   * itemIndex values that are out of range
   */
  public int pageIndex(int itemIndex) {
    return (itemIndex < 0 || itemIndex >= itemCount()) ? -1 : itemIndex / itemsPerPage;
  }
}
