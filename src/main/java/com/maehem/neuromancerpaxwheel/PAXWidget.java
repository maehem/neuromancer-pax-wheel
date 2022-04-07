/*
    Licensed to the Apache Software Foundation (ASF) under one or more 
    contributor license agreements.  See the NOTICE file distributed with this
    work for additional information regarding copyright ownership.  The ASF 
    licenses this file to you under the Apache License, Version 2.0 
    (the "License"); you may not use this file except in compliance with the 
    License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software 
    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
    WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the 
    License for the specific language governing permissions and limitations 
    under the License.
*/
package com.maehem.neuromancerpaxwheel;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * Neuromancer PAX Code Wheel - Java Implementation
 * 
 * Resources used to research and create this app:
 * 
 *  Neuromancer PAX Verification Code Wheel (Online!)
 *      http://www.mlsite.net/neuro/
 * 
 *  Neuromancer Verification Codes Compiled By Ultra Magnus
 *      https://www.digitpress.com/library/manuals/c64/neuromancer_codes.txt
 * 
 * 
 * @author Mark J. Koch  twitter: @markjkoch
 */
public class PAXWidget extends VBox {

    private final ComboBox cb1 = new ComboBox(FXCollections.observableArrayList(PAXCodes.COL1));
    private final ComboBox cb2 = new ComboBox(FXCollections.observableArrayList(PAXCodes.COL2));
    private final ComboBox cb3 = new ComboBox(FXCollections.observableArrayList(PAXCodes.COL3));
    private final Label code = new Label("999999");
    
    private final static int CB_FONT_SCALE = 30; // Fraction of window width
    private final static int CODE_FONT_SCALE = 6; // Fraction of window width
    private final static double UI_GAP = 10.0;
    
    public PAXWidget() {
        cb1.getSelectionModel().select(0);
        cb2.getSelectionModel().select(0);
        cb3.getSelectionModel().select(0);
        
        code.setStyle("-fx-font-size:20");        
        setMinHeight(140);
        setAlignment(Pos.CENTER);

        getChildren().addAll(
                new HBox(UI_GAP, cb1, cb2, cb3), 
                code
        );

        // Cause ComboBox buttons to resize with window size.
        HBox.setHgrow(cb1, Priority.ALWAYS);
        HBox.setHgrow(cb2, Priority.ALWAYS);
        HBox.setHgrow(cb3, Priority.ALWAYS);        
        cb1.setMaxWidth(9999);
        cb2.setMaxWidth(9999);
        cb3.setMaxWidth(9999);
        
        
        // Whenever one of the ConboBox changes, update the displayed code.
        cb1.setOnAction((t) -> { updateCode(); });
        cb2.setOnAction((t) -> { updateCode(); });
        cb3.setOnAction((t) -> { updateCode(); });
        
        widthProperty().addListener((o) -> {
            updateButtonFont();
        });
        
        updateCode();
        updateButtonFont();
    }

    private void updateCode() {
        code.setText(PAXCodes.calculateCode(
            cb1.getSelectionModel().getSelectedIndex(), 
            cb2.getSelectionModel().getSelectedIndex(), 
            cb3.getSelectionModel().getSelectedIndex()
        ));

    }
    
    protected final void updateButtonFont() {
        double cbFontSize = getWidth()/CB_FONT_SCALE;
        double codeFontSize = getWidth()/CODE_FONT_SCALE;
        cb1.setStyle("-fx-font-size:" + cbFontSize);   
        cb2.setStyle("-fx-font-size:" + cbFontSize);   
        cb3.setStyle("-fx-font-size:" + cbFontSize);           
        code.setStyle("-fx-font-size:" + codeFontSize); 
        layout();
    }
}
