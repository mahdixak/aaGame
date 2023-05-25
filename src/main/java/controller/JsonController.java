package controller;

import model.Avatar;
import model.User;


import java.io.*;

import org.json.JSONException;
import org.json.JSONTokener;
import org.json.simple.JSONArray;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonController {
    private static final String path = "d:/aa/database.json";
    public static void setUserInformationToJson() {
        String path = "d:/aa/dataBase.json";
        JSONObject playerDetails = new JSONObject();
        JSONArray playerList = new JSONArray();
        for (User user : User.allUsers()) {
            playerDetails.put("username", user.getUsername());
            playerDetails.put("password", user.getPassword());
            playerDetails.put("highscore", user.getHighScore());
            playerDetails.put("difficulty", user.getDifficulty().getDifficulty());
            playerDetails.put("avatar",user.getAvatar().getAvatarUrl());
            JSONObject playerObject = new JSONObject();
            playerObject.put("user", playerDetails);
            playerList.add(playerObject);
        }
        try (FileWriter file = new FileWriter(path)) {
            file.write(playerList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    public static void readFromFile() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(path)) {
            Object obj = jsonParser.parse(reader);
            JSONArray playerList = (JSONArray) obj;
            System.out.println(playerList);
            playerList.forEach(emp -> parseEmployeeObject((JSONObject) emp));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile() {
        File toDelete = new File(path);
        toDelete.delete();
    }

    public void checkJsonDirectory() throws Exception {
        File dir = new File(path);
        if (dir.exists()) {
            readFromFile();
        } else {
            new File("d:/aa").mkdirs();
        }
    }

    public static void moveDataToFile() throws Exception {
        JsonController.deleteFile();
        JsonController.setUserInformationToJson();
    }

    private static void parseEmployeeObject(JSONObject user) {
        JSONObject playerObject = (JSONObject) user.get("user");
        String username = (String) playerObject.get("username");
        String password = (String) playerObject.get("password");
        long highscore = (long) playerObject.get("highscore");
        String difficulty = (String) playerObject.get("difficulty");
        String avatarUrl = (String) playerObject.get("avatar");
        User user1 = new User(username,password,highscore,difficulty,avatarUrl);
        user1.addUser();
    }

}
