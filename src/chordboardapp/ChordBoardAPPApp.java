/*
 * ChordBoardAPPApp.java
 */

package chordboardapp;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import trie.Trie;
import trie.maintenance.Populate;

/**
 * The main class of the application.
 */
public class ChordBoardAPPApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new ChordBoardAPPView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of ChordBoardAPPApp
     */
    public static ChordBoardAPPApp getApplication() {
        return Application.getInstance(ChordBoardAPPApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        Trie trie = new Trie();
        
        Populate.populate("freqList.txt");
        Populate.fuzzyPopulate("freqList.txt");
        launch(ChordBoardAPPApp.class, args);
        
    }
}
