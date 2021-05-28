import fileReader.CSVFileReader
import teamGenerator.TeamGenerator

fun main(args: Array<String>) {
    println("Welcome to the Team generator!")
    println("Reading the CSV file...")
    var csvFR = CSVFileReader()
    val pokemon = csvFR.csvFileReader()

    print("Enter the Base Stat Limit: ")
    val limit = readLine()
    print("Enter the threshold you would like calculate against: ")
    val threshold = readLine()

    val tg = TeamGenerator()
    val allGeneratedTeams = limit?.let { threshold?.let { it1 -> tg.generateAllTeamCombination(pokemon, it.toInt(), it1.toInt()) } }

    if (allGeneratedTeams != null) {
        allGeneratedTeams.sortBy { it.totalStat }
        allGeneratedTeams.forEach {println(it.pokemon + " " + it.totalStat)}
    }
}