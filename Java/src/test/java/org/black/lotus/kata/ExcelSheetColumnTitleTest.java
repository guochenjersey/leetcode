package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExcelSheetColumnTitleTest {

  @Test
  public void should_find_excel_sheet_column_1() {
    ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();
    String s = excelSheetColumnTitle.convertToTitle(1);
    assertEquals("A", s);
  }

  @Test
  public void should_find_excel_sheet_column_2() {
    ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();
    String s = excelSheetColumnTitle.convertToTitle(28);
    assertEquals("AB", s);
  }

  @Test
  public void should_find_excel_sheet_column_3() {
    ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();
    String s = excelSheetColumnTitle.convertToTitle(27);
    assertEquals("AA", s);
  }

  @Test
  public void should_find_excel_sheet_column_4() {
    ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();
    String s = excelSheetColumnTitle.convertToTitle(701);
    assertEquals("ZY", s);
  }

  @Test
  public void should_find_excel_sheet_column_5() {
    ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();
    String s = excelSheetColumnTitle.convertToTitle(52);
    assertEquals("AZ", s);
  }
}
