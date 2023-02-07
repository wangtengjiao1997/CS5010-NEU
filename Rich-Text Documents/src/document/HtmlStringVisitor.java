package document;

import java.util.List;

import document.element.BasicText;
import document.element.BoldText;
import document.element.Heading;
import document.element.HyperText;
import document.element.ItalicText;
import document.element.Paragraph;

public class HtmlStringVisitor implements DocumentVisitor{
  @Override
  public Object visitBasicText(BasicText current) {
    return current.getText().trim()+"\n";
  }

  @Override
  public Object visitBoldText(BoldText current) {
    return "<b>"+current.getText().trim()+"</b>\n";
  }

  @Override
  public Object visitHeading(Heading current) {
    return "<h"+current.getLevel()+">"+current.getText().trim()+"</h"+current.getLevel()+">\n";
  }

  @Override
  public Object visitHyperText(HyperText current) {
    return "<a href=\""+current.getUrl()+"\">"+current.getText().trim()+"</a>\n";
  }

  @Override
  public Object visitItalicText(ItalicText current) {
    return "<i>"+current.getText().trim()+"</i>\n";
  }

  @Override
  public Object visitParagraph(Paragraph current) {
    StringBuilder result = new StringBuilder("<p>");
    List<BasicText> content =current.getContent();
    for (BasicText element : content) {
      result.append(element.accept(this));
    }
    return result+"</p>\n";
  }
}
