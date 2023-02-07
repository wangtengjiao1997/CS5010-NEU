package document;

import document.element.BasicText;
import document.element.BoldText;
import document.element.Heading;
import document.element.HyperText;
import document.element.ItalicText;
import document.element.Paragraph;

public class BasicStringVisitor implements DocumentVisitor{
  @Override
  public Object visitBasicText(BasicText current) {
    return current.getText().trim()+" ";
  }

  @Override
  public Object visitBoldText(BoldText current) {
    return current.getText().trim()+" ";
  }

  @Override
  public Object visitHeading(Heading current) {
    return current.getText().trim()+" ";
  }

  @Override
  public Object visitHyperText(HyperText current) {
    return current.getText().trim()+" ";
  }

  @Override
  public Object visitItalicText(ItalicText current) {
    return current.getText().trim()+" ";
  }

  @Override
  public Object visitParagraph(Paragraph current) {
    return current.getText().trim()+" ";
  }
}
