import java.util.Scanner

fun main(args: Array<String>) {

    println("Введите тип карты")
    val scanner = Scanner(System.`in`)
    val type = scanner.nextLine()
    println("Введите сумму предыдущих переводов в этом месяце")
    val month = scanner.nextInt()
    println("Введите сумму совершаемого перевода")
    val currentPerevod = scanner.nextInt()
    val commission = commis(type, month, currentPerevod)
    println("Перевод с комиссией: $commission")
}

fun commis(Type: String, ThisMonth: Int, Perevod: Int): Double {
    val month = 600000
    val day = 150000
    val vkPay1Time = 15000
    val vkpayMonth = 40000

    return when (Type) {
        "MasterCard", "Maestro" -> {
            if (ThisMonth < month && Perevod < day) {
                MasterAndMaestro(Perevod)
            } else 0.0
        }
        "Visa", "Мир" -> {
            if (ThisMonth < month && Perevod < day) {
                VisaAndMir(Perevod)
            } else 0.0
        }
        "VK Pay" -> {
            if (Perevod < vkPay1Time && ThisMonth<vkpayMonth) {
                VkPay(Perevod)
            } else 0.0
        }
        else -> {
            println("Неверный тип карты")
            return -1.0
        }
    }
}

fun MasterAndMaestro(Perevod: Int): Double {
    return if (Perevod < 75000) {
        Perevod + (Perevod * 0.006) + 20
    } else 0.0
}

fun VisaAndMir(Perevod: Int): Double {
    return if (Perevod > 35) {
        Perevod + (Perevod * 0.075)
    } else 0.0
}

fun VkPay(Perevod: Int): Double {
    return Perevod.toDouble()
}
