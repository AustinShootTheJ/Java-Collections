package com.example.collections;

import java.util.HashMap;
import java.util.Map;

// Maps serve as an updated form of the dictionary concept. Each map will have a key and a definition.
// We set values using put and retrieve them using get. Old values are overriden if a key is put twice.

public class MapProgram {
    public static void main(String[] args) {
       Map<String, String> languages = new HashMap<>();
       languages.put("Java", "a compiled high level, object-oriented, platform independant language");
       languages.put("Python", "definition of python");
       languages.put("Algol", "a family of algorithmic languages");
       languages.put("BASIC", "BASIC definition");
       languages.put("Lisp", "Therein lies madness");



        // while values in maps are overriden, the following code will still print out the old value prior to replacing it.
        // the code will still be replaced but we will know what was there previously and can use this to determine if a
        // value is being added for the first time.
        System.out.println(languages.put("Java", "this course is about java"));
        System.out.println(languages.get("Java"));

        // You can always do error checking and prevent this feature by using an if-else.
        if(languages.containsKey("Java")){
            System.out.println("Java is already in the map");
        }else{
            languages.put("Java", "new java definition");
        }

        System.out.println("=======================================");

        // how to remove values.
        languages.remove("Lisp");
        if(languages.remove("Algol", "a family of algorithmic languages")){
            System.out.println("Algol removed");
        }else{
            System.out.println("algol not removed");
        }
        // loop to show our keys and values.

        System.out.println(languages.replace("Lisp","A functional programing language with imperative features"));
        // this will not replace because there is not scala key. We would need to use a put
        System.out.println(languages.replace("Scala", "this will not be replaced"));
        for(String key: languages.keySet()){
            System.out.println(key + " : " + languages.get(key));
        }



    }
}
