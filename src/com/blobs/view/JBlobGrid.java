package com.blobs.view;

import com.blobs.model.Blob;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 08.06.16.
 */
public class JBlobGrid extends GridLayout {
    private List<JBlob> jBlobList;

    public JBlobGrid(int rows, int cols) {
        super(rows, cols);
        this.jBlobList = new ArrayList<>();
    }

    public void init(Container pane, Blob[] blob) {
        final JPanel jblobGridPanel = new JPanel();
        jblobGridPanel.setBackground(new Color(44, 165, 124));

        jblobGridPanel.setLayout(this);

        for (int i = 0; i < 9; i++) {
            JBlob jBlob = new JStandardBlob(blob[i]);
            jBlob.hideBlob();
            jblobGridPanel.add(jBlob, BorderLayout.CENTER);
            jBlobList.add(jBlob);
        }

        pane.add(jblobGridPanel, BorderLayout.NORTH);
    }

    public void showSlot(Blob blob) {
        JBlob jblob = jBlobList.get(blob.getId());
        jblob.showBlob();
    }

    public void hideSlot(Blob blob) {
        JBlob jblob = jBlobList.get(blob.getId());
        jblob.hideBlob();
    }
}
