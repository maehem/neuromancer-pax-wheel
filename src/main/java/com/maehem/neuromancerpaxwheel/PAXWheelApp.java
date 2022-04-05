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

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 * 
 * @author Mark J. Koch  twitter: @markjkoch
 */
public class PAXWheelApp extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Neuromancer PAX Wheel");
        PAXWidget paxWidget = new PAXWidget();
        var scene = new Scene(new StackPane(paxWidget));
        stage.setScene(scene);
        stage.show();
        stage.setMinHeight(100);
        stage.setMinWidth(240);
        paxWidget.updateButtonFont();
    }

    public static void main(String[] args) {
        launch();
    }

}