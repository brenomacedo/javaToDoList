package utils;

import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

/**
 * Componente de Text FIeld modificado para ter caracteres limitados
 * @author Breno Macêdo e Renan Xerez
 */
public class JTextFieldLimit extends PlainDocument {
  private int limit;

  /**
   * 
   * @param limit
   */
  public JTextFieldLimit(int limit) {
    super();
    this.limit = limit;
  }

  public void insertString(int offset, String  str, AttributeSet attr) throws BadLocationException {
    if (str == null) return;

    if ((getLength() + str.length()) <= limit) {
      super.insertString(offset, str, attr);
    }
  }
}
