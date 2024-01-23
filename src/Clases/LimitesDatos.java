
package Clases;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class LimitesDatos {
    
    
    //limita los caracteres en general
    public static DocumentFilter getFilter(int maxCharacters) {
        return new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (fb.getDocument().getLength() + string.length() <= maxCharacters) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (fb.getDocument().getLength() + text.length() - length <= maxCharacters) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        };
    }

    //Limita los dígitos ingresados
    public static DocumentFilter getIntFilter(int maxDigits) {
        return new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("\\d+") && (fb.getDocument().getLength() + string.length() <= maxDigits)) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d+") && (fb.getDocument().getLength() + text.length() - length <= maxDigits)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        };
    }

    //Limita los dígitos cuando buscamos registrar con dígitos decimales
    public static DocumentFilter getFloatFilter(int maxDigits) {
        return new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("(\\d{0,3}(\\.\\d{0,2})?)|(\\d{1,3})") && (fb.getDocument().getLength() + string.length() <= maxDigits)) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("(\\d{0,3}(\\.\\d{0,2})?)|(\\d{1,3})") && (fb.getDocument().getLength() + text.length() - length <= maxDigits)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        };
    }

}
