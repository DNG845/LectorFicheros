/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lectorficheros;

/**
 *
 * @author danny
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// Lee el archivo.java
public class FileReader {
    public static CircularLinkedList readJavaFile(String filePath) throws 
            IOException {
        CircularLinkedList methodsList = new CircularLinkedList();
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        
        // Patron de diseno para leer el archivo.java
        Pattern pattern = Pattern.compile("(public|protected|private|static|"
                + "\\s) +[\\w<>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;])");
        Matcher matcher = pattern.matcher(content);
        
        while (matcher.find()) {
            String methodName = matcher.group(2);
            String methodBody = extractMethod(content, matcher.start());
            methodsList.insert(new Method(methodName, methodBody));
        }
        
        return methodsList;
    }
    // Extrae los metodos del archivo.java
    private static String extractMethod(String content, int startIndex) {
        int openBraces = 0;
        int closeBraces = 0;
        boolean insideString = false;
        boolean escaping = false;
        int endIndex = startIndex;

        for (int i = startIndex; i < content.length(); i++) {
            char ch = content.charAt(i);
            if (ch == '"' && !escaping) {
                insideString = !insideString;
            }
            if (insideString) {
                escaping = ch == '\\' && !escaping;
                continue;
            }
            if (ch == '{') {
                openBraces++;
            } else if (ch == '}') {
                closeBraces++;
            }
            if (openBraces > 0 && openBraces == closeBraces) {
                endIndex = i;
                break;
            }
        }
        return content.substring(startIndex, endIndex + 1);
    }
}
