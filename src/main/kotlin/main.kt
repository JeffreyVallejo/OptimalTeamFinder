import Firebase.FirebaseInitialize
import teamGenerator.AddPokemonDriver.Companion.addPokemon
import teamGenerator.GenerateTeamDriver.Companion.generateTeamDriver

fun main(args: Array<String>) {
    println("Welcome to the Team generator!")

    var userInput = "N"
    FirebaseInitialize.intitialize()
    while (userInput.toLowerCase() != "exit") {
        println("Menu: \n 1) Add a Pokemon to PC. \n 2) Generate a team. \n or type 'exit' to close the program.")
        print("-> ")
        userInput = readLine().toString()

        when(userInput) {
            "1" -> addPokemon()
            "2" -> generateTeamDriver()
            "exit" -> break
            else -> {
                println("The input $userInput was incorrect.")
            }
        }
    }

    //FirebaseHelper.getAllPokemonForLocation("Route 3", "sword")

}