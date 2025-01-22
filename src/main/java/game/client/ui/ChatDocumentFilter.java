/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.client.ui;

import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author pi
 */
public class ChatDocumentFilter extends DocumentFilter {

    private final JTextPane textPane;

    public ChatDocumentFilter(JTextPane textPane) {
        this.textPane = textPane;
    }
    
    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException{
        System.out.print("replace");

        int lastEditablePosition = this.getLastEditablePosition();
        if(offset >= lastEditablePosition)
            super.replace(fb, offset, length, text, attrs);
    }
    
    @Override
    public void insertString(FilterBypass fb, int offset, String text, AttributeSet attrs) throws BadLocationException{
        
        System.out.print("insertString");
            super.insertString(fb, offset, text, attrs);
    }
    
    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException{
        System.out.print("remove");
        if(textPane.getText().length() == length && offset == 0){
            super.remove(fb, offset, length);
            return;
        }
        
        int lastEditablePosition = this.getLastEditablePosition()+ChatLobbyPanel.YOU.length();
        
        if(offset >= lastEditablePosition)
            super.remove(fb, offset, length);
    }

    private int getLastEditablePosition() {
        String text = textPane.getText();
        int lastNewLineIndex = text.lastIndexOf("\n");
        return lastNewLineIndex + 1;
    }
    
}
