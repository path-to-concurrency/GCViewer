package com.tagtraum.perf.gcviewer.view;

import java.awt.BorderLayout;
import java.beans.PropertyVetoException;
import java.util.Map;

import javax.swing.Action;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import com.tagtraum.perf.gcviewer.view.model.GCPreferences;

/**
 * This is the main window of GCViewer.
 *
 * Date: Jan 30, 2002
 * Time: 4:59:49 PM
 * @author <a href="mailto:hs@tagtraum.com">Hendrik Schreiber</a>
 */
public class GCViewerGui extends JFrame {

    private Map<String, Action> actionMap;
    private JDesktopPane desktopPane;
    private GCViewerGuiToolBar toolBar;
    private GCPreferences preferences;

    private RecentURLsMenu recentURLsMenu;

    public GCViewerGui() {
        super("tagtraum industries incorporated - GCViewer");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        // TODO SWINGWORKER deal with recentURLsMenu
        //recentURLsMenu = new RecentURLsMenu(controller);
        //openURLAction.setRecentURLsModel(recentURLsMenu.getRecentURLsModel());
    }
    
    public void addDocument(GCDocument gcDocument) {
        desktopPane.add(gcDocument);
        gcDocument.setSize(450, 300);
        gcDocument.setVisible(true);
        // TODO SWINGWORKER: handle recentUrls
        //recentURLsMenu.getRecentURLsModel().add(new URL[]{model.getURL()});
        repaint();

        try {
            gcDocument.setSelected(true);
            gcDocument.setMaximum(true);
        } 
        catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }
    
    public Map<String, Action> getActionMap() {
        return actionMap;
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public GCPreferences getPreferences() {
        return preferences;
    }

    public RecentURLsMenu getRecentFilesMenu() {
        return recentURLsMenu;
    }

    public GCDocument getSelectedGCDocument() {
        return (GCDocument)desktopPane.getSelectedFrame();
    }
    
    public GCViewerGuiToolBar getToolBar() {
        return toolBar;
    }
    
    public void setActionMap(Map<String, Action> actionMap) {
        this.actionMap = actionMap;
    }
    
    /**
     * Sets the desktopPane if this gui component - this method should be called exactly once.
     * 
     * @param desktopPane desktopPane to be set
     */
    public void setDesktopPane(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
        getContentPane().add(desktopPane, BorderLayout.CENTER);
    }
    
    public void setPreferences(GCPreferences preferences) {
        this.preferences = preferences;
    }
    
    /**
     * Sets the toolbar of this gui component - this method should be called exactly once.
     * 
     * @param toolBar toolbar to be set
     */
    public void setToolBar(GCViewerGuiToolBar toolBar) {
        this.toolBar = toolBar;
        getContentPane().add(toolBar, BorderLayout.NORTH);
    }
}
