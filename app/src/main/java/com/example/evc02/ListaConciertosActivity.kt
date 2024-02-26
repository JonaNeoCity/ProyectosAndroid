package com.example.evc02

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evc02.databinding.ActivityListarConciertosBinding

class ListaConciertosActivity : AppCompatActivity() {

    private lateinit var binding : ActivityListarConciertosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListarConciertosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvListaConciertos.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvListaConciertos.adapter = AdapterLista(obtenerConciertos())
    }

    private fun obtenerConciertos(): List<List<String>> {
        val listaConciertos = ArrayList<List<String>>()
        listaConciertos.add(listOf("The Rolling Stones – Rio de Janeiro, Brasil", "Sus satánicas majestades congregaron a 2 millones de personas fue transmitido en Brasil y por satélite e internet para todo el mundo.", "18 de febrero de 2006"))
        listaConciertos.add(listOf("Monsters of Rock (AC/DC, Metallica)", "El primer concierto de música occidental en Moscú. El espectáculo atrajo una participación de 1.6 millones de personas.", "28 de setiembre de 1991"))
        listaConciertos.add(listOf("Rod Stewart – Río de Janeiro, Brasil", "En la noche de fin de año de 1994 en la playa de Copacabana, el cantante Rod Stewart protagonizó el mayor concierto al aire libre de la historia. Esto fue gracias a que la entrada al mismo era gratuita y por ser una noche tan señalada. El cantante logró congregar a 3 millones y medio de personas en un concierto que marcaría un hito en la ciudad de Río de Janeiro.", "31 de diciembre de 1994"))
        listaConciertos.add(listOf("Queen en Wembley, Londres", "El evento musical pertenecía a la gira Magic Tour, la última del grupo con Freddie Mercury como vocalista. " +
                "La banda tocó un total de 28 canciones, entre ellas ‘We Are The Champions’, ‘I Want To Break Free’, ‘We Will Rock You’ y ‘Radio Ga Ga’, sobre un inmenso escenario que el artista dominaba y parecía no tenerle miedo.", "12/07/1986"))
        listaConciertos.add(listOf("Michael Jackson en Bucarest", "Asistieron 70.000 personas y, durante dos horas, interpretó temas como ‘Thriller’, ‘Billie Jean’ o ‘Smooth Criminal’. Aunque, sin duda, uno de los momentos más épicos fue cuando salió del escenario volando para poner fin al show. " +
                "Los asistentes difícilmente podrán borrar esa imagen de su memoria.", "1 de octubre de 1992"))
        listaConciertos.add(listOf("Woodstock", "Este concierto reunió a más de 400.000 personas, entre ellas Bob Dylan, Joe Cocker, The Who, Jimi Hendrix y Janis Joplin.", "25/07/1999"))
        listaConciertos.add(listOf("Madonna en Barcelona", "El concierto duró una hora y media y la cantante incorporó como temas centrales el sexo y el catolicismo. " +
                "El vestuario también fue una parte fundamental en el espectáculo. Jean Paul Gaultier diseñó unos sujetadores de cono, que se convirtieron en un icono cultural. " +
                "Por todo ello, los conciertos de esta gira alcanzaron categoría de ‘obra de culto’.", "1 de agosto de 1990"))
        listaConciertos.add(listOf("The Beatles en Apple Corps, Londres", "Los componentes de The Beatles, de manera totalmente inesperada, se subieron a la azotea de su estudio, que se encontraba en el edificio de la empresa Apple Corps, ubicado en el número 3 de la calle Saville Row de Londres. " +
                "Una vez en lo más alto, comenzaron a tocar. El concierto duró 42 minutos. Interpretaron canciones como ‘Get Back’, ‘Don’t Let Me Down’, ‘I’ve Got a Feeling’, ‘One After 909’ y ‘Dig a Pony’. " +
                "Querían que la actuación durara más tiempo pero la tuvieron que parar debido a las quejas por parte de los vecinos.", "29 de agosto de 1966"))
        listaConciertos.add(listOf("Prince, Nueva York", "Todos conocemos al genio de Minneapolis por su extravagante puesta en escena y su peculiar vestuario sobre el escenario, haciendo que sus conciertos sean únicos. Los asistentes pudieron disfrutar de temas como ‘Purple Rain’, ‘Let’s Go Crazy’, ‘1999’ o ‘I Would Die 4 U’.", "30 de marzo de 1985"))
        listaConciertos.add(listOf("The Who en Isle Of Wight Festival", "El cuarteto británico, recién llegado de su gira promoción de “Tommy”, que había resultado todo un éxito, congregó a nada menos que 600.000 personas. Como anécdota curiosa: durante el concierto había carteles recomendando mantenerse al menos a 15 metros de distancia de los altavoces. " +
                "¿Te haces una idea de la potencia del sonido del festival?", "29 de agosto de 1970"))
        return listaConciertos
    }
}