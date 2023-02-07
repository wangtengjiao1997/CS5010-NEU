package document;

import document.element.BasicText;
import document.element.BoldText;
import document.element.Heading;
import document.element.HyperText;
import document.element.ItalicText;
import document.element.Paragraph;

public class WordCountVisitor implements DocumentVisitor{
  @Override
  public Object visitBasicText(BasicText current) {
    return current.getText().split(" ").length;
  }

  @Override
  public Object visitBoldText(BoldText current) {
    return current.getText().split(" ").length;
  }

  @Override
  public Object visitHeading(Heading current) {
    return current.getText().split(" ").length;
  }

  @Override
  public Object visitHyperText(HyperText current) {
    return current.getText().split(" ").length;
  }

  @Override
  public Object visitItalicText(ItalicText current) {
    return current.getText().split(" ").length;
  }

  @Override
  public Object visitParagraph(Paragraph current) {
    return current.getText().split(" ").length;
  }
}
