package fileReader

import Model.Pokemon
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.BufferedReader
import java.io.FileReader

private val NAME = 0
private val BASESTAT = 1
private val TYPE = 2

class CSVFileReader {

    fun csvFileReader(): List<Pokemon>{
        var fileReader: BufferedReader? = null
        val availablePokemon = arrayListOf<Pokemon>()

        try {
            fileReader = BufferedReader(FileReader("/Users/jeff/IdeaProjects/OptimalTeamFinder/src/main/resources/currentTeam.csv"))

            val csvParser = CSVParser(fileReader, CSVFormat.DEFAULT)

            for(record in csvParser) {
//                val pokemon = Pokemon(
//                    record[NAME],
//                    Integer.parseInt(record[BASESTAT]),
//                    record[TYPE])
//                availablePokemon.add(pokemon)
            }

//            // Print the pokemon to console.
//            for(pokemon in availablePokemon) {
//                println(pokemon.toString())
//            }
        } catch (e: Exception){
            // Handle the exception scenario
            println("FILEREAD ERROR")
            e.printStackTrace()
        } finally {
            try {
                fileReader!!.close()
            } catch(e: Exception) {
                println("Close file Error")
                e.printStackTrace()
            }
        }

        return availablePokemon
    }
}