package document;

import java.util.ArrayList;
import java.util.List;

import document.element.TextElement;

public class Document {
  
  private List<TextElement> content;
  
  public Document() {
    content = new ArrayList<>();
  }

  public void add(TextElement e) {
    content.add(e);
  }

  public int countWords(){
    int count = 0;
    for (int i=0; i<content.size(); i++){
      TextElement T = content.get(i);
      count += T.getText().split(" ").length;
    }
    return count;
  }

  public String toText(DocumentVisitor visitor){
    String res = "";
    for (int i=0; i<content.size(); i++){
      TextElement T = content.get(i);
      res += T.accept(visitor);
    }
    return res.trim();
  }
}
