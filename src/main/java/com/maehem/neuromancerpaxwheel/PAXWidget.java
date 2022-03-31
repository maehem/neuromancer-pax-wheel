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

import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

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

    private final ComboBox cb1 = new ComboBox();
    private final ComboBox cb2 = new ComboBox();
    private final ComboBox cb3 = new ComboBox();
    private final Label code = new Label("999999");
    
    private final static int CB_WIDTH = 140;
    private final static int FONT_SIZE = 40;
    private final static double UI_GAP = 10.0;
    
    public PAXWidget() {
        super(UI_GAP);

        cb1.getItems().addAll((Object[]) PAXCodes.COL1);
        cb1.getSelectionModel().select(0);
        cb1.setPrefWidth(CB_WIDTH);
        
        cb2.getItems().addAll((Object[]) PAXCodes.COL2);
        cb2.getSelectionModel().select(0);
        cb2.setPrefWidth(CB_WIDTH);

        cb3.getItems().addAll((Object[]) PAXCodes.COL3);
        cb3.getSelectionModel().select(0);
        cb3.setPrefWidth(CB_WIDTH);
        
        code.setFont(new Font(FONT_SIZE));
        setAlignment(Pos.CENTER);
        HBox spinners = new HBox(UI_GAP, cb1, cb2, cb3);
        
        getChildren().addAll(spinners, code);
        
        // Whenever one of the ConboBox changes, update the code.
        cb1.setOnAction((t) -> { updateCode(); });
        cb2.setOnAction((t) -> { updateCode(); });
        cb3.setOnAction((t) -> { updateCode(); });
        
        updateCode();
    }

    private void updateCode() {
        code.setText(PAXCodes.calculateCode(
            cb1.getSelectionModel().getSelectedIndex(), 
            cb2.getSelectionModel().getSelectedIndex(), 
            cb3.getSelectionModel().getSelectedIndex()
        ));

    }    
}
