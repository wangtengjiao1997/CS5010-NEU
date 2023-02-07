package document;

import java.util.List;

import document.element.BasicText;
import document.element.BoldText;
import document.element.Heading;
import document.element.HyperText;
import document.element.ItalicText;
import document.element.Paragraph;

public class MarkdownStringVisitor implements DocumentVisitor{
  @Override
  public Object visitBasicText(BasicText current) {
    return current.getText().trim()+"\n";
  }

  @Override
  public Object visitBoldText(BoldText current) {
    return "**"+current.getText().trim()+"**"+"\n";
  }

  @Override
  public Object visitHeading(Heading current) {
    return "#".repeat(current.getLevel())+" "+current.getText().trim()+"\n";
  }

  @Override
  public Object visitHyperText(HyperText current) {
    return "["+current.getText().trim()+"]("+current.getUrl()+")"+"\n";
  }

  @Override
  public Object visitItalicText(ItalicText current) {
    return "*"+current.getText().trim()+"*"+"\n";
  }

  @Override
  public Object visitParagraph(Paragraph current) {
    StringBuilder result = new StringBuilder("");
    result.append("\n");
    List<BasicText> content =current.getContent();
    for (BasicText element : content) {
      result.append(element.accept(this));
    }
    return result+"\n";
  }

}
