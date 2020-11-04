package oleg;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ParseGSON {
    static String json = "{\n" +
            "    \"pageInfo\": {\n" +
            "            \"pageName\": \"Homepage\",\n" +
            "            \"logo\": \"https://www.example.com/logo.jpg\"\n" +
            "    },\n" +
            "    \"posts\": [\n" +
            "            {\n" +
            "                \"post_id\": \"0123456789\",\n" +
            "                \"actor_id\": \"1001\",\n" +
            "                \"author_name\": \"Jane Doe\",\n" +
            "                \"post_title\": \"How to parse JSON in Java\",\n" +
            "                \"comments\": [],\n" +
            "                \"time_of_post\": \"1234567890\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"post_id\": \"789\",\n" +
            "                \"actor_id\": \"1101\",\n" +
            "                \"author_name\": \"Oleg Doe\",\n" +
            "                \"post_title\": \"How to parse JSON\",\n" +
            "                \"comments\": [],\n" +
            "                \"time_of_post\": \"1234567890\"\n" +
            "            }\n" +
            "    ]\n" +
            "}";
    public static void main(String[] args) {

//reader is of type java.io.Reader
//        JsonObject jsonObject = JsonParser.parseReader​(reader).getAsJsonObject();

//jsonReader is of type com.google.gson.stream.JsonReader
//        JsonObject jsonObject = JsonParser.parseReader​(jsonReader).getAsJsonObject();

        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        String pageName = jsonObject.getAsJsonObject("pageInfo").get("pageName").getAsString();
        System.out.println(pageName);

        JsonArray arr = jsonObject.getAsJsonArray("posts");
        System.out.printf(" Length of JSON posts %d\n",arr.size());
        for (int i = 0; i < arr.size(); i++) {
            String post_id = arr.get(i).getAsJsonObject().get("post_id").getAsString();
            System.out.println(post_id);
            }
        System.out.println("jo.toString()");
        for (JsonElement jo: arr) {
            System.out.println(jo.toString());
            System.out.println(jo.getAsJsonObject().get("author_name").toString());
        }

    }
}
