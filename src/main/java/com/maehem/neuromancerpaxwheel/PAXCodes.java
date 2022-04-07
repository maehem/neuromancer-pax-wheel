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

/**
 *
 * @author Mark J. Koch  twitter: @markjkoch
 */

public class PAXCodes {
    /**
     * When calculating the code wheel code, 
     *   1. Select one code each from COL1 and COL2.
     *   2. Add the indexes (0-15) of each together (getting a number from 0 to 30.
     *   3. Divide by 16 and take the remainder  ( r = n % 16 )
     *   4. Use the result (r) (0 - 15)  as the first index into table CODE[r][]
     *   5. Use the COL3 index value (i) as the second index of CODE[r][i]
     * 
     *   code = CODE[ ( COL1.index + COL2.index )%16 ][ COL3.index ]
     * 
     *   code is a String as some codes require a leading zero when typed in
     *   to the game.
     * 
     * @param a Index of the COL1[] list. Wheel outer ring.
     * @param b Index of the COL2[] list. Wheel second-most outer ring.
     * @param c Index of the COL3[] list. Wheel window labels.
     * @return @String code from CODE[][] lookup table
     */
    protected static String calculateCode(int a, int b, int c) {
        return CODE[ c ][ (a+b)%16 ];
    }

    public static final String COL1[] = {
        "Cyberspace",
        "Chatsubo",
        "Night City News",
        "Matt Shaw",
        "Matrix",
        "softwarez",
        "Freeside",
        "Shiva",
        "database",
        "Lawbot",
        "Donut World",
        "Julius Deane",
        "Cheap Hotel",
        "Microsofts",
        "Crazy Edo",
        "Gemeinschaft"        
    };
    
    public static final String COL2[] = {
        "Cyberjack",
        "Ratz",
        "Holographix",
        "Larry Moe",
        "PAX",
        "Skill Chips",
        "Shin's Pawn",
        "Gentleman Loser",
        "Maas Biolabs",
        "Justice Booth",
        "Cyberdeck",
        "Comlink",
        "Icebreaker",
        "ROM Construct",
        "Cowboy",
        "Emperor Norton"
    };
            
    public static final String COL3[] = { 
        "Zion Cluster",
        "Chiba City",
        "Asano Computing",
        "Hitachi-Biotech",
        "Cryptology",
        "Space Colony",
        "Holy Joystick",
        "Bank Of Berne",
        "Spacedock",
        "Ono-Sendai",
        "Marcus Garvey",
        "Bank Of Zurich",
        "Compu-judge",
        "flatline",
        "AI",
        "Fuji Electric"
    };
    
    public static final String CODE[][] = {
        { // Zion Cluster
            "44321","71312","44312","61456","41317","45771","31270","51666",
            "61723","65110","21400","43267","34770","70012","61543","76631" 
        },
        { // Chiba City
            "4300","1337","6124","2174","6162","5150","6040","0703",
            "4327","2730","1777","3347","3601","1316","4120","0072" 
        },
        { // Asano Computing
            "060734","113667","021655","115721","011772","117372","121777","031770",
            "031776","067144","127170","061254","073611","162234","063124","131265" 
        },
        { // Hitachi-Biotech
            "714","236","045","103","775","430","517","725",
            "507","072","321","672","614","473","424","024" 
        },
        { // Cryptology
            "073","61255","01326","61627","71226","42074","22372","00206",
            "71724","23671","34755","67237","74655","50127","36112","61645" 
        },
        { // Space Colony
            "040327","152777","152336","013026","036160","067123","132077","014527",
            "030654","126443","114352","054127","056201","157223","051435","004713"
        },
        { // Holy Joystick
            "700","512","213","167","616","733","313","054",
            "410","300","434","333","673","533","017","254" 
        },
        { // Bank Of Berne
            "7107","5517","0177","3121","6116","5120","0423","3173",
            "5423","1053","0017","5165","6160","5116","0170","4102" 
        },
        { // Spacedock
            "073611","162324","063124","131265","060734","113667","021655","115721",
            "011772","117372","121777","031770","031776","067144","127170","061254" 
        },
        { // Ono-Sendai
            "614","473","424","024","714","236","045","103",
            "775","430","571","725","507","072","321","672" 
        },
        { // Marcus Garvey
            "21400","43267","34770","70012","61543","76631","44321","71312",
            "44312","61456","41317","45771","31270","51666","61723","65110" 
        },
        { // Bank Of Zurich
            "0170","4102","7107","5517","0177","3121","6116","5120",
            "0423","3173","5423","1053","0017","5165","6160","5116" 
        },
        { // Compu-judge
            "673","533","017","254","700","512","213","167",
            "616","733","313","054","410","300","434","333" 
        },
        { // flatline
            "054127","056201","157223","051435","004713","040327","152777","152336",
            "013026","036160","067123","132077","014527","030654","126443","114352" 
        },
        { // AI
            "23671","34755","67237","74655","50127","36112","61645","07362",
            "61255","01326","61627","71226","42074","22372","00206","71724" 
        },
        { // Fuji Electric
            "0703","4327","2730","1777","3347","3601","1316","4120",
            "0072","4300","1337","6124","2174","6162","5150","6040" 
        }
    };
    
}
