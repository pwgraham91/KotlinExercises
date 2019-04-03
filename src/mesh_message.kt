// https://www.interviewcake.com/question/python/mesh-message

val network = hashMapOf(
    "Min" to arrayListOf("William", "Jayden", "Omar"),
    "William" to arrayListOf("Min", "Noam"),
    "Jayden" to arrayListOf("Min", "Amelia", "Ren", "Noam"),
    "Ren" to arrayListOf("Jayden", "Omar"),
    "Amelia" to arrayListOf("Jayden", "Adam", "Omar"),
    "Adam" to arrayListOf("Amelia", "Miguel", "Sofia", "Lucas"),
    "Miguel" to arrayListOf("Amelia", "Adam", "Liam", "Nathan"),
    "Noam" to arrayListOf("Nathan", "Jayden", "William"),
    "Omar" to arrayListOf("Ren", "Min", "Scott"),
    "Nathan" to arrayListOf("Noam", "Miguel"),
    "Scott" to arrayListOf("Omar"),
    "Sofia" to arrayListOf("Adam"),
    "Lucas" to arrayListOf("Adam"),
    "Liam" to arrayListOf("Miguel")
)

fun routeIteratively(originator: String, receiver: String): List<String>? {
    if (originator == receiver) return arrayListOf(originator)

    val seenCarriers = mutableSetOf(originator)
    val checkRoutes = mutableListOf(
        mutableListOf(originator)
    )

    while (checkRoutes.size > 0) {
        val currentRoute = checkRoutes.removeAt(0)
        val currentPhone = currentRoute.last()
        val phoneConnections = network[currentPhone]

        if (phoneConnections != null) {
            for (phone: String in phoneConnections) {
                if (phone == receiver) {
                    currentRoute.add(phone)
                    return currentRoute.toList()
                }

                if (!seenCarriers.contains(phone)) {
                    val newRoute = currentRoute.toMutableList()
                    newRoute.add(phone)
                    seenCarriers.add(phone)
                    checkRoutes.add(newRoute)
                }
            }
        }
    }
    return null

}

fun main(args: Array<String>) {
    // when asserting, make sure to add -ea to VM options
    assert(routeIteratively("Jayden", "Adam") == arrayListOf("Jayden", "Amelia", "Adam"))
    assert(routeIteratively("Jayden", "No One") == null)
    assert(routeIteratively("Jayden", "Jayden") == arrayListOf("Jayden"))
    assert(routeIteratively("Adam", "William") == arrayListOf("Adam", "Amelia", "Jayden", "Min", "William"))
    assert(routeIteratively("Miguel", "Jayden") == arrayListOf("Miguel", "Amelia", "Jayden"))
    assert(routeIteratively("Omar", "Sofia") == arrayListOf("Omar", "Ren", "Jayden", "Amelia", "Adam", "Sofia"))
}
