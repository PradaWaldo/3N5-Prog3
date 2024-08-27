package org.pradavelasque

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements



fun main() {
    val doc: Document = Jsoup.connect("https://en.wikipedia.org/").get()
    log(doc.title())
    var titre: String = ""
    val newsHeadlines: Elements = doc.select("#mp-itn b a")
    for (headline in newsHeadlines) {
//
        titre = headline.attr("title")
        println(titre)
    }

}
fun log(title: String){

}
