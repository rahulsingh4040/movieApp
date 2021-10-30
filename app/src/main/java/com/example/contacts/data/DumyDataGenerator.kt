package com.example.contacts.data

import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import java.io.*
import java.lang.StringBuilder

class DumyDataGenerator (path: String){

    companion object {

        var movieList = arrayListOf<MovieEntity>()

        /*fun getMovies() {
            val jsonArray = JSONArray(loadJSONFromAsset())
            for(i in 0..jsonArray.length()) {
                var jsonObject = JSONObject(jsonArray[i])
                var movieEntity = MovieEntity(
                    jsonObject. ("original_title").toString(),
                jsonObject,
                jsonObject.get("overview").toString(),
                jsonObject.get("popularity").toString(),
                jsonObject.get("vote_average").toString()
                )
                movieList.add(movieEntity)
            }
            Log.d("RAHUL", movieEntity.toString())
        }

        fun loadJSONFromAsset(): String {
            val file = File("E://Contacts//app//src//main//res//raw", "data.json")
            val fileReader = FileReader(file)
            val bufferedReader = BufferedReader(fileReader)
            val stringBuilder = StringBuilder()
            var line = bufferedReader.readLine()
            while (line != null) {
                stringBuilder.append(line).append("\n")
                line = bufferedReader.readLine()
            }
            bufferedReader.close()
            return stringBuilder.toString()
        }*/

        
        // Needed to pick data from JSON and network by coroutines on background thread but due to time contraints not able to do so..Hence, generating dummy data

        fun getMovies() : List<MovieEntity> {
            movieList.add(MovieEntity("Dune", "2021-09-15", "Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, must travel to the most dangerous planet in the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet's exclusive supply of the most precious resource in existence-a commodity capable of unlocking humanity's greatest potential-only those who can conquer their fear will survive."
                , "5531.157", "8"))

            movieList.add(MovieEntity("Venom: Let There Be Carnage", "2021-09-30", "After finding a host body in investigative reporter Eddie Brock, the alien symbiote must face a new enemy, Carnage, the alter ego of serial killer Cletus Kasady.",
            "5783.658", "6.9"))
            return movieList
        }
    }
}