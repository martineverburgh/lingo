package nl.ITAcademy.project.LINGO;

import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONcreator {

        public static void main(String[] args) {

            JSONObject obj = new JSONObject();

            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Martine\\Desktop\\5-letterwoorden.txt"))) {
                String line;
                int i = 1;
                while ((line = br.readLine()) != null) {
                    obj.put(i, line);
                    i++;
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }

            try (FileWriter file = new FileWriter("woordenlijsten/5-letterwoorden.json")) {

                file.write(obj.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.print(obj);

        }

    }

